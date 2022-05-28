import sys
from antlr4 import *
from MyGrammerLexer import MyGrammerLexer
from MyGrammerParser import MyGrammerParser
from MyGrammerVisitor import MyGrammerVisitor
from generator import Generator


def get_username():
    from pwd import getpwuid
    from os import getuid
    return getpwuid(getuid())[ 0 ]


class MyVisitor(MyGrammerVisitor):

    variables = {
        'zmienna': 4,
    }
    generator = Generator()
    result = generator.generate()
    stack = []

    def visitExprComm(self, ctx):
        a = self.visitChildren(ctx)
        return a

    def visitExprComm(self, ctx):
        a = self.visitChildren(ctx)
        return a
    
    def visitLoop(self, ctx):
    	print('visit loop')
    	return
    
    def visitIf(self, ctx):
        print('visit if')
        a = self.visitChildren(ctx)
        self.generator.if_start()
        self.generator.if_end()
        return

    def visitEqual(self, ctx):
        print('visit equal')
        id_, _ = self.visit(ctx.id_())
        val, _ = self.visit(ctx.if_val())
        self.generator.icmp_eq(id_, val)
        return 0
    
    def visitNotEqual(self, ctx):
        print('visit not equal')
        id_, _ = self.visit(ctx.id_())
        val, _ = self.visit(ctx.if_val())
        self.generator.icmp_ne(id_, val)
        return 0

    def visitFunctExpr(self, ctx):
        type_ = ctx.getText()
        id_ = None
        arg = None

        try:
            id_, _ = self.visit(ctx.id_())
        except (AttributeError, TypeError):
            pass

        try:
            _, arg = self.visit(ctx.arg)

        except (AttributeError, TypeError):
            pass
        if 'write' in type_:
            if id_ is not None:
                print('Error, write function doesnt return any value')
            else:
                #print(arg)
                
                val, type_val = self.stack.pop()
                #print(str(id_) + " " + str(val) + " " + str(type_val) + " " + str(arg))
                print(self.stack)
                if type_val is int:
                    self.generator.printf_i32(val)
                elif type_val is float:
                    self.generator.printf_double(val)
                elif type_val is str:
                    self.generator.printf_string(val)
                else:
                    print('Error, no argument specified in write function')
        elif 'read' in type_:
            #print("read open" + str(id_) + " " + str(val) + " " + str(type_val) + " " + str(arg))
            if id_ is None:
                print(f"Error, function read() doesn't take any arguments")
            else:
                value = input()
                print("readks " + value)
                if id_ is not None:
                    self.variables[id_]=value
                    old_value = self.variables[id_]
                    if old_value is None:
                        self.generator.declare(id_, type(id_))
                    self.generator.assign(id_, value, type(value))
                    print(self.variables)
        return 0

    def visitTableBody(self, ctx):
        a = []
        stack_list = []
        _, first_val = self.visit(ctx.val)
        list_element = self.stack.pop()
        stack_list.append(list_element[0])
        a.append(first_val)
        generator = ctx.table_content()
        while generator.val is not None:
            #sprawdzić czy wszystkie list element elementy mają ten sam typ int lub float
            _, val = self.visit(generator.val)
            list_element = self.stack.pop()
            stack_list.append(list_element[0])
            a.append(val)
            print(a)
            generator = generator.table_content()
            print(generator.val)
        print(f"ostatecznie tablica: {a}")
        self.stack.append((stack_list, list_element[1]))
        return a

    def visitInfixExpr(self, ctx):
        print("WCHODZE DO LICZENIA!!!!!!!!")
        _, l = self.visit(ctx.left)
        _, r = self.visit(ctx.right)

        op = ctx.op.text

        val1, type_val1 = self.stack.pop()
        val2, type_val2 = self.stack.pop()
        print(f"typ pierwszego {type_val1} wartość {val1}")
        print(f"typ drugiego {type_val2} wartość {val2}")
        if type_val2 != type_val1:
            print("Error, variable type not acceptable")
            return(0)
        else:
            if type_val2 is int:
                if op == '+':
                    self.generator.add_int(val1, val2)
                elif op == '-':
                    self.generator.sub_int(val1, val2)
                elif op == '*':
                    self.generator.multi_int(val1, val2)
                elif op == '/':
                    self.generator.div_int(val1, val2)
                self.stack.append(("%" + str(self.generator.reg - 1), type_val2))
            elif type_val2 is float:
                if op == '+':
                    self.generator.add_float(val1, val2)
                elif op == '-':
                    self.generator.sub_float(val1, val2)
                elif op == '*':
                    self.generator.multi_float(val1, val2)
                elif op == '/':
                    self.generator.div_float(val1, val2)
                self.stack.append(("%" + str(self.generator.reg - 1), type_val2))

        print("WYCHODZE Z LICZENI!!!!!!!!1")

        if type(l) is str and type(r) is str:
            if op == '+':
                pass
            else:
                print(f"Forbidden operation string {op} string")
                return
        elif type(l) is str or type(r) is str:
            if (type(l) is int or type(r) is int) and op == '*':
                pass
            else:
                print(f"Forbidden operation {type(l)} {op} {type(r)}")
                return 0



        operation =  {
        '+': lambda: l + r,
        '-': lambda: l - r,
        '*': lambda: l * r,
        '/': lambda: l / r,
        }
        print(operation.get(op, lambda: None)())
        return _, operation.get(op, lambda: None)()

    def visitValExpr(self, ctx):
        a = self.visitChildren(ctx)
        return a

    def visitIntVal(self, ctx):
        value = ctx.getText()
        self.stack.append((value, int))
        return None, int(value)
        
    def visitRealVal(self, ctx):
        value = ctx.getText()
        self.stack.append((value, float))
        return None, float(value)

    def visitIdVal(self, ctx):
        key = ctx.getText()
        value = None
        if key in self.variables:
            value = self.variables[key]
            #print(value)
        self.stack.append(('%'+key, type(value)))
        return key, value
    
    def visitIfVal(self, ctx):
        key = ctx.getText()
        value = None
        if key in self.variables:
            value = self.variables[key]
            #print(value)
        self.stack.append(('%'+key, type(value)))
        return key, value
            
    def visitNumbers(self, ctx):
        print('visit numbers')
        
        key = ctx.getText()
        value = None
        #if key in self.variables:
         #   value = self.variables[key]
            #print(value)
        #self.stack.append(('%'+key, type(value)))
        return key, value

    def visitStrVal(self, ctx):
        text = ctx.getText()
        value = text.replace('"', '')
        key = None
        #print(value)
        self.stack.append((value, str))
        return key, value

    def visitAssignComm(self, ctx):
        print('Assign')
        id_, old_value = self.visit(ctx.id_())
        val = None
        try:
            id_val, val = self.visit(ctx.expr())
        except Exception as e:
            print(f"Error, unable to assign value, {e}")
            return 0
        if val is not None:
            self.variables[id_] = val
            value_stack, type_stack = self.stack.pop()
            if old_value is None:
                if type_stack is str:
                    self.generator.declare_str(id_, len(val))
                else:
                    self.generator.declare(id_, type(val))
            if type_stack is str:
                self.generator.assign_str(id_, len(val), val)
            else:
                self.generator.assign(id_, value_stack, type(val))
        else:
            print(f"Error, {id_val} is not declared")
        return 0

    def visitAssignTableComm(self, ctx):
        id_, old_value = self.visit(ctx.id_())
        if type(id_) is not str:
            print('Error, id type is not string')
            return
        else:
            val = self.visit(ctx.table())
            self.variables[id_] = val
            value_stack, type_stack = self.stack.pop()
            if old_value is None:
                self.generator.table_declare(id_, len(val), type_stack)
            self.generator.table_assign(id_, len(val), type_stack, val)

        return 0

    def visitTableChangeComm(self, ctx):
        id_, value = self.visit(ctx.id_())
        _, i = self.visit(ctx.i)
        _, new_value = self.visit(ctx.val)
        try:
            self.variables[id_][i] = new_value
            # JAK ZROBIĆ TABLICĘ W GENERATORZE
        except Exception as e:
            print(f"Error, {e}")
        return 0

    def visitTableValVal(self, ctx):
        id_, val = self.visit(ctx.id_())
        _, i = self.visit(ctx.i)
        try:
            value = self.variables[id_][i]
            #JAK ZROBIC TABLICE W GENERATORZE
            # if val is not None:
            #     self.generator.declare(id_, type(id_))
            # self.generator.assign(id_,value,type(id_))
        except TypeError:
            print(f"Error, {id_} is not subscriptable")
            return 0
        except KeyError:
            print(f"Error, {id_} is not defined")
            return 0
        except IndexError:
            print(f"Error, {i}, index is out of range")
            return 0
        print(value)
        return id_, value

    def visitStartComm(self, ctx):
        print(f"Bonjour {get_username()}")

    def visitEndComm(self, ctx):
        print(f"Au revoir {get_username()}")
        sys.exit(0)

if __name__ == "__main__":
    #while 1:
        #data =  InputStream(input(">>> "))
        data = FileStream('note.txt')
        # lexer
        lexer = MyGrammerLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = MyGrammerParser(stream)
        tree = parser.commandx()
        # evaluator
        visitor = MyVisitor()
        output = visitor.visit(tree)
           
        # print(f"\n"
        #       f"{visitor.generator.header_text}\n"
        #       f"main_text:\n"
        #       f"{visitor.generator.main_text}")

        print(f".ll file: content:\n,"
              f"{visitor.generator.generate()}")

        with open('note.ll', 'w') as file:
            file.write(visitor.generator.generate())
