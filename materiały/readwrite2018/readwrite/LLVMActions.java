
import java.util.HashSet;

public class LLVMActions extends DemoBaseListener {

    HashSet<String> variables = new HashSet<String>();

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
    public void exitProg(DemoParser.ProgContext ctx) { 
       System.out.println( LLVMGenerator.generate() );
    }

    @Override
    public void exitWrite(DemoParser.WriteContext ctx) {
       String ID = ctx.ID().getText();
       if( variables.contains(ID) ) {
          LLVMGenerator.printf( ID );
       } else {
          ctx.getStart().getLine();
          System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
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


}
