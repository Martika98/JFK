import sys
from antlr4 import *
from MyGrammerLexer import MyGrammerLexer
from MyGrammerParser import MyGrammerParser
from MyGrammerVisitor import MyGrammerVisitor


def get_username():
    from pwd import getpwuid
    from os import getuid
    return getpwuid(getuid())[ 0 ]


class MyVisitor(MyGrammerVisitor):

    variables = {
        'zmienna': 4,
    }

    def visitFunctExpr(self, ctx):
        type = ctx.getText()
        id = None
        arg = None

        try:
            id, _ = self.visit(ctx.id_())
        except (AttributeError, TypeError):
            pass

        try:
            _, arg = self.visit(ctx.arg)
        except (AttributeError, TypeError):
            pass
        if 'write' in type:
            if id is not None:
                print('Error, write function doesnt return any value')
            else:
                print(arg)
        elif 'read' in type:
            if arg is not None:
                print(f"Error, function read() doesn't take any arguments")
            else:
                value = input()
                if id is not None:
                    self.variables[id]=value
        return 0

    def visitTableBody(self, ctx):
        a = []
        _, first_val = self.visit(ctx.val)
        a.append(first_val)
        generator = ctx.table_content()
        while generator.val is not None:
            _, val = self.visit(generator.val)
            a.append(val)
            generator = generator.table_content()

        print(f"ostatecznie tablica: {a}")
        return a

    def visitInfixExpr(self, ctx):
        _, l = self.visit(ctx.left)
        _, r = self.visit(ctx.right)

        op = ctx.op.text


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
        return None, int(value)

    def visitRealVal(self, ctx):
        value = ctx.getText()
        return None, float(value)

    def visitIdVal(self, ctx):
        key = ctx.getText()
        value = None
        if key in self.variables:
            value = self.variables[key]
            print(value)
        return key, value

    def visitStrVal(self, ctx):
        text = ctx.getText()
        value = text.replace('"', '')
        key = None
        return key, value

    def visitAssignComm(self, ctx):
        id_, _ = self.visit(ctx.id_())
        try:
            id_val, val = self.visit(ctx.expr())
        except Exception as e:
            print(f"Error, unable to assign value")
            return 0
        if val is not None:
            self.variables[id_] = val
        else:
            print(f"Error, {id_val} is not declared")
        return 0

    def visitAssignTableComm(self, ctx):
        id_, _ = self.visit(ctx.id_())
        if type(id_) is not str:
            print('Error, id type is not string')
            return
        else:
            val = self.visit(ctx.table())
            self.variables[id_] = val
        return 0

    def visitTableChangeComm(self, ctx):
        id_, value = self.visit(ctx.id_())
        _, i = self.visit(ctx.i)
        _, new_value = self.visit(ctx.val)
        try:
            self.variables[id_][i] = new_value
        except Exception as e:
            print(f"Error, {e}")
        return 0

    def visitTableValVal(self, ctx):
        id_, _ = self.visit(ctx.id_())
        _, i = self.visit(ctx.i)
        try:
            value = self.variables[id_][i]
        except TypeError:
            print(f"Error, {id_} is not subscriptable")
            return 0
        except KeyError:
            print(f"Error, {id_} is not defined")
            return 0
        except IndexError:
            print(f"Error, {i}, index is out of range")
            return 0
        return id_, value

    def visitStartComm(self, ctx):
        print(f"Bonjour {get_username()}")

    def visitEndComm(self, ctx):
        print(f"Au revoir {get_username()}")
        sys.exit(0)

if __name__ == "__main__":
    while 1:
        data =  InputStream(input(">>> "))
        # lexer
        lexer = MyGrammerLexer(data)
        stream = CommonTokenStream(lexer)
        # parser
        parser = MyGrammerParser(stream)
        tree = parser.commandx()
        # evaluator
        visitor = MyVisitor()
        output = visitor.visit(tree)
