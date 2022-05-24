
import java.util.HashSet;
import java.util.Stack;

public class LLVMActions extends DemoBaseListener {

    HashSet<String> variables = new HashSet<String>();
    String value;

    @Override 
    public void exitProg(DemoParser.ProgContext ctx) { 
       System.out.println( LLVMGenerator.generate() );
    }

    @Override
    public void exitAssign(DemoParser.AssignContext ctx) { 
       String ID = ctx.ID().getText();
       String INT = ctx.INT().getText();
       if( ! variables.contains(ID) ) {
          variables.add(ID);
          LLVMGenerator.declare(ID);          
       } 
       LLVMGenerator.assign(ID, INT);
    }

    @Override 
    public void exitValue(DemoParser.ValueContext ctx) { 
       if( ctx.ID() != null ){
         String ID = ctx.ID().getText();     
         if( variables.contains(ID) ) {
            LLVMGenerator.load( ID );
            value = "%"+(LLVMGenerator.tmp-1); 
         } else {
            error(ctx.getStart().getLine(), "unknown variable "+ID);         
         }
       } 
       if( ctx.INT() != null ){
         value = ctx.INT().getText();       
       } 
    }

    @Override
    public void exitRepetitions(DemoParser.RepetitionsContext ctx) { 
       LLVMGenerator.repeatstart(value);
    }

    @Override
    public void exitBlock(DemoParser.BlockContext ctx) {
       if( ctx.getParent() instanceof DemoParser.RepeatContext ){
          LLVMGenerator.repeatend();
       }
    }
   
    @Override
    public void exitWrite(DemoParser.WriteContext ctx) {
       LLVMGenerator.printf(value);
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
