
import java.util.HashSet;
import java.util.Stack;

public class LLVMActions extends DemoBaseListener {

    HashSet<String> globalnames = new HashSet<String>();
    HashSet<String> functions = new HashSet<String>();
    HashSet<String> localnames = new HashSet<String>(); 
    String value, function;
    Boolean global;

    @Override 
    public void enterProg(DemoParser.ProgContext ctx) { 
       global = true;
    }

    @Override 
    public void exitProg(DemoParser.ProgContext ctx) { 
       LLVMGenerator.close_main();
       System.out.println( LLVMGenerator.generate() );
    }

    @Override 
    public void exitFparam(DemoParser.FparamContext ctx) {
       String ID = ctx.ID().getText();
       functions.add(ID); 
       function = ID;
       LLVMGenerator.functionstart(ID);
    }

    @Override
    public void enterFblock(DemoParser.FblockContext ctx) {
       global = false;
    }

    @Override
    public void exitFblock(DemoParser.FblockContext ctx) {
       if( ! localnames.contains(function) ){
          LLVMGenerator.assign(set_variable(function), "0");
       }
       LLVMGenerator.load( "%"+function );
       LLVMGenerator.functionend();
       localnames = new HashSet<String>();
       global = true;
    }

    @Override
    public void exitAssign(DemoParser.AssignContext ctx) { 
       String ID = ctx.ID().getText();
       LLVMGenerator.assign(set_variable(ID), value);
    }

    @Override 
    public void exitValue(DemoParser.ValueContext ctx) { 
       if( ctx.ID() != null ){
         String ID = ctx.ID().getText();     

         if( localnames.contains(ID) ) {
            LLVMGenerator.load( "%"+ID );
         } else if( globalnames.contains(ID) ) {
            LLVMGenerator.load( "@"+ID );
         } else if( functions.contains(ID) ) {
            LLVMGenerator.call(ID);
         } else {
            error(ctx.getStart().getLine(), "Unknown "+ID+ ": local > global > function");
         }
         value = "%"+(LLVMGenerator.tmp-1); 
       } 

       if( ctx.INT() != null ){
         value = ctx.INT().getText();       
       } 
    }



    @Override
    public void exitWrite(DemoParser.WriteContext ctx) {
       LLVMGenerator.printf(value);
    } 

    @Override
    public void exitCall(DemoParser.CallContext ctx) {
       LLVMGenerator.call(ctx.ID().getText());
    } 


    @Override
    public void exitRead(DemoParser.ReadContext ctx) {
       String ID = ctx.ID().getText();
       LLVMGenerator.scanf( set_variable(ID) );
    } 
  
    public String set_variable(String ID){
       String id;
       if( global ){
          if( ! globalnames.contains(ID) ) {
             globalnames.add(ID);
             LLVMGenerator.declare(ID, true);          
          }
          id = "@"+ID; 
       } else {
          if( ! localnames.contains(ID) ) {
             localnames.add(ID);
             LLVMGenerator.declare(ID, false);
          }
          id = "%"+ID; 
       }
       return id;
    }

    void error(int line, String msg){
       System.err.println("Error! Line "+line+", "+msg);
       System.exit(1);
   } 

}
