
import java.util.HashSet;
import java.util.Stack;

public class LLVMActions extends DemoBaseListener {

    HashSet<String> variables = new HashSet<String>();
    Stack<String> stack = new Stack<String>();

    @Override
    public void exitAssign(DemoParser.AssignContext ctx) { 
       String ID = ctx.ID().getText();
       if( ! variables.contains(ID) ) {
          variables.add(ID);
          LLVMGenerator.declare(ID);          
       } 
       LLVMGenerator.assign(ID, stack.pop());
    }

    @Override 
    public void exitProg(DemoParser.ProgContext ctx) { 
       System.out.println( LLVMGenerator.generate() );
    }

    @Override 
    public void exitValue(DemoParser.ValueContext ctx) { 
       if( ctx.ID() != null ){
         String ID = ctx.ID().getText();     
         if( variables.contains(ID) ) {
            LLVMGenerator.load( ID );
            stack.push( "%"+(LLVMGenerator.reg-1) ); 
         } else {
            error(ctx.getStart().getLine(), "unknown variable "+ID);         
         }
       } 
       if( ctx.INT() != null ){
         stack.push( ctx.INT().getText() );       
       } 
    }

    @Override 
    public void exitAdd(DemoParser.AddContext ctx) { 
       LLVMGenerator.add(stack.pop(), stack.pop() ); 
       stack.push( "%"+(LLVMGenerator.reg-1) ); 
    }

    @Override 
    public void exitSingle(DemoParser.SingleContext ctx) { 
    }

    @Override
    public void exitWrite(DemoParser.WriteContext ctx) {
       String ID = ctx.ID().getText();
       if( variables.contains(ID) ) {
          LLVMGenerator.printf( ID );
       } else {
          error(ctx.getStart().getLine(), "unknown variable "+ID);
       }
    } 

    @Override
    public void exitRead(DemoParser.ReadContext ctx) {
       String ID = ctx.ID().getText();
       if( ! variables.contains(ID) ) {
          variables.add(ID);
          LLVMGenerator.declare(ID);          
       } 
       LLVMGenerator.scanf(ID);
    } 

   void error(int line, String msg){
       System.err.println("Error, line "+line+", "+msg);
       System.exit(1);
   } 
       
}
