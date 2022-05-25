
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

enum VarType{ INT, REAL, STRING, FUNCTION, UNKNOWN }

class Value{
    public String name;
    public VarType type;
    public Value( String name, VarType type ){
        this.name = name;
        this.type = type;
    }
}

public class LLVMActions extends TurBaseListener {

    String filename;

    HashMap<String, VarType> globalnames = new HashMap<String, VarType>();
    HashMap<String, VarType> localnames = new HashMap<String, VarType>();
    HashSet<String> functions = new HashSet<String>();
    Stack<Value> stack = new Stack<Value>();

    String value, function;
    Boolean global;

    public LLVMActions(String arg) {
        this.filename = arg.substring(0, arg.lastIndexOf('.'));
    }

    @Override
    public void exitIf(TurParser.IfContext ctx) {
    }

    @Override
    public void enterBlockif(TurParser.BlockifContext ctx) {
        System.out.println( "Entering if block");
        LLVMGenerator.ifstart();
        global = false;
    }

    @Override
    public void exitBlockif(TurParser.BlockifContext ctx) {
        System.out.println( "Exiting if block");
        LLVMGenerator.ifend();
        localnames = new HashMap<String, VarType>();
        global = true;
    }

    @Override
    public void exitEquality(TurParser.EqualityContext ctx) {
        System.out.println( "Found equality: " + ctx.ID().getText() + " == " + ctx.INT().getText());
        String ID = ctx.ID().getText();
        String INT = ctx.INT().getText();
        if( globalnames.containsKey(ID) ) {
            LLVMGenerator.icmp("@"+ID, INT );
        } else if( localnames.containsKey(ID) ) {
            LLVMGenerator.icmp("%"+ID, INT );
        }else {
            ctx.getStart().getLine();
            System.err.println("Line " + ctx.getStart().getLine() + ", unknown variable: " + ID);
        }
    }

    @Override
    public void exitNonequality(TurParser.NonequalityContext ctx) {
        System.out.println( "Found inequality: " + ctx.ID().getText() + " != " + ctx.INT().getText());
        String ID = ctx.ID().getText();
        String INT = ctx.INT().getText();
        if( globalnames.containsKey(ID) ) {
            LLVMGenerator.incmp("@"+ID, INT );
        } else if( localnames.containsKey(ID) ) {
            LLVMGenerator.icmp("%"+ID, INT );
        } else {
            ctx.getStart().getLine();
            System.err.println("Line " + ctx.getStart().getLine() + ", unknown variable: " + ID);
        }
    }

    @Override
    public void exitFparam(TurParser.FparamContext ctx) {
        System.out.println( "Hello! It's function parameter: " + ctx.ID().getText());
        String ID = ctx.ID().getText();
        functions.add(ID);
        function = ID;
        LLVMGenerator.functionstart(ID);
    }

    @Override
    public void enterFblock(TurParser.FblockContext ctx) {
        System.out.println( "Entering function");
        global = false;
    }

    @Override
    public void exitFblock(TurParser.FblockContext ctx) {
        System.out.println( "Exiting function");
        if( ! localnames.containsKey(function) ){
            //LLVMGenerator.assign("@"+function, "0", VarType.FUNCTION);
        }
        //LLVMGenerator.load_i32( "@"+function );
        LLVMGenerator.functionend();
        localnames = new HashMap<String, VarType>();
        global = true;
    }

    @Override
    public void exitCall(TurParser.CallContext ctx) {
        if( functions.contains(function) ){
            System.out.println( "Calling void function: " + ctx.ID().getText());
            LLVMGenerator.call(ctx.ID().getText());
        }
        else
        {
            error(ctx.getStart().getLine(), "Function " + ctx.ID().getText() + " not declared");
        }

    }

    @Override
    public void exitRepetitions(TurParser.RepetitionsContext ctx) {
        if( ctx.ID() != null ){
            String ID = ctx.ID().getText();
            if( localnames.containsKey(ID) ) {
                System.out.println( "Pushing local variable: " + ctx.ID().getText() + " (type:" + localnames.get(ID) + ")" );
                if(localnames.get(ID) == VarType.INT)
                {
                    System.out.println( "Looping " + ctx.ID().getText() + " times");
                    LLVMGenerator.load_i32( "@" + ID );
                }
                else if(localnames.get(ID) == VarType.REAL) {
                    error(ctx.getStart().getLine(), "Variable " + ID + "is type real (not suitable for loops)");
                }
                value = "%"+(LLVMGenerator.reg-1);
            } else if( globalnames.containsKey(ID) ) {
                System.out.println( "Pushing global variable: " + ctx.ID().getText() + " (type:" + globalnames.get(ID) + ")" );
                if(globalnames.get(ID) == VarType.INT)
                {
                    System.out.println( "Looping " + ctx.ID().getText() + " times");
                    LLVMGenerator.load_i32( "@" + ID );
                }
                else if(globalnames.get(ID) == VarType.REAL) {
                    error(ctx.getStart().getLine(), "Variable " + ID + "is type real (not suitable for loops)");
                }
                value = "%"+(LLVMGenerator.reg-1);
            }
            else {
                error(ctx.getStart().getLine(), "Unknown " + ID + " (possibly not declared in this scope)");
            }
        }
        if( ctx.INT() != null ){
            System.out.println( "Pushing int value: " + ctx.INT().getText() );
            System.out.println( "Looping " + ctx.INT().getText() + " times");
            value = ctx.INT().getText();
        }
        LLVMGenerator.repeatstart(value);
    }

    @Override
    public void enterBlock(TurParser.BlockContext ctx) {
        if( ctx.getParent() instanceof TurParser.RepeatContext ){
            System.out.println( "Entering loop block");
        }
        if (ctx.getParent() instanceof TurParser.FblockContext)
        {
            System.out.println( "Entering if block");
        }
    }

    @Override
    public void exitBlock(TurParser.BlockContext ctx) {
        if( ctx.getParent() instanceof TurParser.RepeatContext ){
            System.out.println( "Exiting loop block");
            LLVMGenerator.repeatend();
        }
        if (ctx.getParent() instanceof TurParser.FblockContext)
        {
            System.out.println( "Exiting if block");
        }
    }

    @Override
    public void exitAssign(TurParser.AssignContext ctx) {
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        if( localnames.containsKey(ID) ) {
            System.out.println( "Assigning global variable: " + ctx.ID().getText() + " (type:" + localnames.get(ID) + ")" );
            if(localnames.get(ID) == VarType.INT)
            {
                LLVMGenerator.assign("%"+ID, v.name, VarType.INT);
            }
            else if(localnames.get(ID) == VarType.REAL) {
                LLVMGenerator.assign("%"+ID, v.name, VarType.REAL);
            }
            value = "%"+(LLVMGenerator.reg-1);
        } else if( globalnames.containsKey(ID) ) {
            System.out.println( "Assigning local variable: " + ctx.ID().getText() + " (type:" + globalnames.get(ID) + ")" );
            if(globalnames.get(ID) == VarType.INT)
            {
                LLVMGenerator.assign("@"+ID, v.name, VarType.INT);
            }
            else if(globalnames.get(ID) == VarType.REAL) {
                LLVMGenerator.assign("@"+ID, v.name, VarType.REAL);
            }
            value = "@"+(LLVMGenerator.reg-1);
        }
    }

    @Override
    public void exitDeclare(TurParser.DeclareContext ctx) {
        Value v1;
        String ID;
        VarType type;
        if(stack.isEmpty())
            v1 = new Value(String.valueOf(0), VarType.INT);
        else
            v1 = stack.pop();
        if(global) {
            ID = ctx.declarationExpression().ID().getText();
            type = VarType.valueOf(ctx.declarationExpression().typeSpecifier().getText().toUpperCase(Locale.ROOT));
            System.out.println("Declaring global variable type: " + type + ", name: " + ID);
            globalnames.put(ID, type);
            if(Objects.equals(ctx.declarationExpression().typeSpecifier().getText(), "int"))
            {
                LLVMGenerator.declare(ID, true, VarType.INT);
                LLVMGenerator.assign("@"+ID, String.valueOf(v1.name), VarType.INT);
            }
            if(Objects.equals(ctx.declarationExpression().typeSpecifier().getText(), "real"))
            {
                v1.name = "0.0";
                LLVMGenerator.declare(ID, true, VarType.REAL);
                LLVMGenerator.assign("@"+ID, String.valueOf(v1.name), VarType.REAL);
            }
        }
        else
        {
            ID = ctx.declarationExpression().ID().getText();
            type = VarType.valueOf(ctx.declarationExpression().typeSpecifier().getText().toUpperCase(Locale.ROOT));
            System.out.println("Declaring local variable type: " + type + ", name: " + ID);
            localnames.put(ID, type);
            if(Objects.equals(ctx.declarationExpression().typeSpecifier().getText(), "int"))
            {
                LLVMGenerator.declare(ID, false, VarType.INT);
                LLVMGenerator.assign("%"+ID, String.valueOf(v1.name), VarType.INT);
            }
            if(Objects.equals(ctx.declarationExpression().typeSpecifier().getText(), "real"))
            {
                v1.name = "0.0";
                LLVMGenerator.declare(ID, false, VarType.REAL);
                LLVMGenerator.assign("%"+ID, String.valueOf(v1.name), VarType.REAL);
            }
        }
    }

    @Override
    public void exitValue(TurParser.ValueContext ctx) {
        if( ctx.ID() != null ){
            String ID = ctx.ID().getText();
            if( localnames.containsKey(ID) ) {
                System.out.println( "Pushing local variable: " + ctx.ID().getText() + " (type:" + localnames.get(ID) + ")" );
                if(localnames.get(ID) == VarType.INT)
                {
                    stack.push( new Value("%"+(LLVMGenerator.reg), VarType.INT) );
                    LLVMGenerator.load_i32( "%" + ID );
                }
                else if(localnames.get(ID) == VarType.REAL) {
                    stack.push( new Value("%"+(LLVMGenerator.reg), VarType.REAL) );
                    LLVMGenerator.load_double("%" + ID);
                }
                value = "%"+(LLVMGenerator.reg-1);
            } else if( globalnames.containsKey(ID) ) {
                System.out.println( "Pushing global variable: " + ctx.ID().getText() + " (type:" + globalnames.get(ID) + ")" );
                if(globalnames.get(ID) == VarType.INT)
                {
                    stack.push( new Value("%"+(LLVMGenerator.reg), VarType.INT) );
                    LLVMGenerator.load_i32( "@" + ID );
                }
                else if(globalnames.get(ID) == VarType.REAL) {
                    stack.push( new Value("%"+(LLVMGenerator.reg), VarType.REAL) );
                    LLVMGenerator.load_double("@" + ID);
                }
                value = "@"+(LLVMGenerator.reg-1);
            } else if( functions.contains(ID) ) {
                System.out.println( "Calling function: " + ctx.ID().getText());
                stack.push( new Value("@"+(LLVMGenerator.reg), VarType.FUNCTION) );
                LLVMGenerator.call(ID);
            }
            else {
                error(ctx.getStart().getLine(), "Unknown " + ID + ": (possibly not declared in this scope)");
            }
        }
        if( ctx.REAL() != null ){
            System.out.println( "Pushing real value: " + ctx.REAL().getText() );
            value = ctx.REAL().getText();
            stack.push( new Value(ctx.REAL().getText(), VarType.REAL) );
        }
        if( ctx.INT() != null ){
            System.out.println( "Pushing int value: " + ctx.INT().getText() );
            value = ctx.INT().getText();
            stack.push( new Value(ctx.INT().getText(), VarType.INT) );
        }
    }

    @Override
    public void exitAdd(TurParser.AddContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        System.out.println( "Adding: " + v1.name + "(type:" + v1.type + ") and " + v2.name + "(type:" + v2.type + ")");
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.add_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.add_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), "add type mismatch");
        }
    }

    @Override
    public void exitSub(TurParser.SubContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        System.out.println( "Subtraction: " + v1.name + "(type:" + v1.type + ") and " + v2.name + "(type:" + v2.type + ")");
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.sub_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.sub_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), "subtract type mismatch");
        }
    }

    @Override
    public void exitMult(TurParser.MultContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        System.out.println( "Multiplication: " + v1.name + "(type:" + v1.type + ") and " + v2.name + "(type:" + v2.type + ")");
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.mult_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.mult_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), "mult type mismatch");
        }
    }

    @Override
    public void exitDiv(TurParser.DivContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        System.out.println( "Division: " + v1.name + "(type:" + v1.type + ") and " + v2.name + "(type:" + v2.type + ")");
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.div_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.div_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), "division type mismatch");
        }
    }

    @Override
    public void exitToint(TurParser.TointContext ctx) {
        Value v = stack.pop();
        LLVMGenerator.fptosi( v.name );
        stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
    }

    @Override
    public void exitToreal(TurParser.TorealContext ctx) {
        Value v = stack.pop();
        LLVMGenerator.sitofp( v.name );
        stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
    }

    @Override
    public void exitPrint(TurParser.PrintContext ctx) {
        if( ctx.value().ID() != null ){
            String ID = ctx.value().ID().getText();
            if( localnames.containsKey(ID) ) {
                System.out.println( "Printing local variable: " + ctx.value().ID().getText() + " (type:" + localnames.get(ID) + ")" );
                if(localnames.get(ID) == VarType.INT)
                {
                    LLVMGenerator.printf_i32("%"+ ID );
                }
                else if(localnames.get(ID) == VarType.REAL) {
                    LLVMGenerator.printf_double("%"+ ID );
                }
                else if(localnames.get(ID) == VarType.STRING) {
                    LLVMGenerator.printf_string(ID);
                }
                value = "%"+(LLVMGenerator.reg-1);
            } else if( globalnames.containsKey(ID) ) {
                System.out.println( "Printing global variable: " + ctx.value().ID().getText() + " (type:" + globalnames.get(ID) + ")" );
                if(globalnames.get(ID) == VarType.INT)
                {
                    LLVMGenerator.printf_i32("@"+ ID );
                }
                else if(globalnames.get(ID) == VarType.REAL) {
                    LLVMGenerator.printf_double("@"+ ID );
                }
                else if(localnames.get(ID) == VarType.STRING) {
                    LLVMGenerator.printf_string(ID);
                }
                value = "%"+(LLVMGenerator.reg-1);
            }
            else {
                error(ctx.getStart().getLine(), "Use of undeclared identifier: " + ID);
            }
        }
        if( ctx.value().REAL() != null ){
            System.out.println( "Printing real value: " + ctx.value().REAL().getText() );
            LLVMGenerator.printf_string(ctx.value().REAL().getText());
        }
        if( ctx.value().INT() != null ){
            System.out.println( "Printing int value: " + ctx.value().INT().getText() );
            LLVMGenerator.printf_string(ctx.value().INT().getText());
        }
        if( ctx.value().STRING() != null ){
            System.out.println( "Printing String value: " + ctx.value().STRING().getText() );
            String string = ctx.value().STRING().getText();
            string = string.substring(1,string.length()-1);
            LLVMGenerator.printf_string(string);
        }
    }


    @Override
    public void exitRead(TurParser.ReadContext ctx) {
        System.out.println( "Reading int" );
        String ID = ctx.ID().getText();
        if( localnames.containsKey(ID) ) {
            LLVMGenerator.read_int("%"+ID);
        }
        else if( globalnames.containsKey(ID) ) {
            LLVMGenerator.read_int("@"+ID);
        }
        else
        {
            error(ctx.getStart().getLine(), "unknown variable " + ID);
        }
    }

    @Override
    public void exitReadFloat(TurParser.ReadFloatContext ctx) {
        System.out.println( "Reading float" );
        String ID = ctx.ID().getText();
        if( localnames.containsKey(ID) ) {
            LLVMGenerator.read_double("%"+ID);
        }
        else if( globalnames.containsKey(ID) ) {
            LLVMGenerator.read_double("@"+ID);
        }
        else
        {
            error(ctx.getStart().getLine(), "unknown variable " + ID);
        }
    }

    @Override
    public void enterProg(TurParser.ProgContext ctx) {
        global = true;
    }

    @Override
    public void exitProg(TurParser.ProgContext ctx) {
        LLVMGenerator.close_main();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter((filename + ".ll"), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(LLVMGenerator.generate());
        writer.close();
    }

    void error(int line, String msg){
        System.err.println("Error, line "+line+", "+msg);
        System.exit(1);
    }

}
