import java.util.Stack;

class LLVMGenerator{

   static String header_text = "";
   static String main_text = "";
   static int main_tmp = 1;
   static String buffer = "";
   static int reg = 1;
   static int br = 0;

   static int string_count = 0;

   static Stack<Integer> brstack = new Stack<Integer>();

   static void functionstart(String id){
      buffer += ";;;functionstart\n";
      main_text += buffer;
      main_tmp = reg;
      buffer = "define i32 @"+id+"() nounwind {\n";
      reg = 1;
   }

   static void functionend(){
      buffer += ";;;functionend\n";
      buffer += "ret i32 %"+(reg-1)+"\n";
      buffer += "}\n";
      header_text += buffer;
      buffer = "";
      reg = main_tmp;
   }

   static void icmp(String id, String value){
      buffer += ";;;icmp\n";
      buffer += "%"+reg+" = load i32, i32* "+id+"\n";
      reg++;
      buffer += "%"+reg+" = icmp eq i32 %"+(reg-1)+", "+value+"\n";
      reg++;
   }

   static void incmp(String id, String value){
      buffer += ";;;incmp\n";
      buffer += "%"+reg+" = load i32, i32* "+id+"\n";
      reg++;
      buffer += "%"+reg+" = icmp ne i32 %"+(reg-1)+", "+value+"\n";
      reg++;
   }

   static void ifstart(){
      buffer += ";;;ifstart\n";
      br++;
      buffer += "br i1 %"+(reg-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
      brstack.push(br);
   }

   static void ifend(){
      buffer += ";;;ifend\n";
      int b = brstack.pop();
      buffer += "br label %false"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void repeatstart(String repetitions){
      buffer += ";;;repeatstart\n";
      declare(Integer.toString(reg), false, VarType.INT);
      int counter = reg;
      reg++;
      assign("%"+Integer.toString(counter), "0", VarType.INT);
      br++;
      buffer += "br label %cond"+br+"\n";
      buffer += "cond"+br+":\n";

      load_i32("%" + counter);
      add_i32("%"+(reg-1), "1");
      assign("%"+Integer.toString(counter), "%"+(reg-1), VarType.INT);

      buffer += "%"+reg+" = icmp slt i32 %"+(reg-2)+", "+repetitions+"\n";
      reg++;

      buffer += "br i1 %"+(reg-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
      brstack.push(br);
   }

   static void repeatend(){
      buffer += ";;;repeatend\n";
      int b = brstack.pop();
      buffer += "br label %cond"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void printf_i32(String id){
      buffer += ";;;printf_i32\n";
      buffer += "%"+reg+" = load i32, i32* "+id+"\n";
      reg++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %"+(reg-1)+")\n";
      reg++;
   }

   static void printf_double(String id){
      buffer += ";;;printf_double\n";
      buffer += "%"+reg+" = load double, double* "+id+"\n";
      reg++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %"+(reg-1)+")\n";
      reg++;
   }

   static void printf_string(String string)
   {
      string = string + "\\0A\\00";
      header_text += "@.str." + string_count + " = private unnamed_addr constant [" + (string.length()-4) + " x i8] c\"" + string + "\", align 1\n";
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + (string.length()-4) + "x i8], [" + (string.length()-4) + " x i8]* @.str." + string_count + ", i64 0, i64 0))\n";
      string_count++;
      reg++;
   }

   static void declare(String id, Boolean global, VarType type)
   {
      buffer += ";;;declare\n";
      if( global ){
         if(type == VarType.INT){
            header_text += "@"+id+" = global i32 0\n";
         } else if (type == VarType.REAL) {
            header_text += "@"+id+" = global double 0\n";
         }
      } else {
         if(type == VarType.INT){
            buffer += "%"+id+" = alloca i32\n";
         } else if (type == VarType.REAL) {
            buffer += "%"+id+" = alloca double\n";
         }
      }
   }

   static void assign(String id, String value, VarType type)
   {
      buffer += ";;;assign\n";
      if(type == VarType.INT){
         buffer += "store i32 "+value+", i32* "+id+"\n";
      } else if (type == VarType.REAL) {
         buffer += "store double "+value+", double* "+id+"\n";
      }
      else if (type == VarType.FUNCTION) {
         buffer += "store i32 "+value+", i32* "+id+"\n";
      }
   }

   static void load_i32(String id){
      buffer += ";;;load_i32\n";
      buffer += "%"+reg+" = load i32, i32* "+id+"\n";
      reg++;
   }

   static void load_double(String id){
      buffer += ";;;load_double\n";
      buffer += "%"+reg+" = load double, double* "+id+"\n";
      reg++;
   }

   static void add_i32(String val1, String val2){
      buffer += ";;;add_i32\n";
      buffer += "%"+reg+" = add i32 "+val1+", "+val2+"\n";
      reg++;
   }

   static void add_double(String val1, String val2){
      buffer += ";;;add_double\n";
      buffer += "%"+reg+" = fadd double "+val1+", "+val2+"\n";
      reg++;
   }

   static void sub_i32(String val1, String val2){
      buffer += ";;;sub_i32\n";
      buffer += "%"+reg+" = sub i32 "+val2+", "+val1+"\n";
      reg++;
   }

   static void sub_double(String val1, String val2){
      buffer += ";;;sub_double\n";
      buffer += "%"+reg+" = fsub double "+val2+", "+val1+"\n";
      reg++;
   }

   static void mult_i32(String val1, String val2){
      buffer += ";;;mult_i32\n";
      buffer += "%"+reg+" = mul i32 "+val1+", "+val2+"\n";
      reg++;
   }

   static void mult_double(String val1, String val2){
      buffer += ";;;mult_double\n";
      buffer += "%"+reg+" = fmul double "+val1+", "+val2+"\n";
      reg++;
   }

   static void div_i32(String val1, String val2){
      buffer += ";;;div_i32\n";
      buffer += "%"+reg+" = sdiv i32 "+val2+", "+val1+"\n";
      reg++;
   }

   static void div_double(String val1, String val2){
      buffer += ";;;div_double\n";
      buffer += "%"+reg+" = fdiv double "+val2+", "+val1+"\n";
      reg++;
   }

   static void sitofp(String id){
      buffer += ";;;sitofp\n";
      buffer += "%"+reg+" = sitofp i32 "+id+" to double\n";
      reg++;
   }

   static void fptosi(String id){
      buffer += ";;;fptosi\n";
      buffer += "%"+reg+" = fptosi double "+id+" to i32\n";
      reg++;
   }

   static void read_int(String id){
      buffer += ";;;read_int\n";
      buffer += "%"+reg+" = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i32 0, i32 0), i32* "+id+")\n";
      reg++;
   }
   static void read_double(String id){
      buffer += ";;;read_double\n";
      buffer += "%"+reg+" = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strsd, i64 0, i64 0), double* "+id+")\n";
      reg++;
   }

   static void call(String id){
      buffer += ";;;call\n";
      buffer += "%"+reg+" = call i32 @"+id+"()\n";
      reg++;
   }

   static void close_main(){
      buffer += ";;;close_main\n";
      main_text += buffer;
   }


   static String generate(){
      String text = "";
      text += "declare i32 @printf(i8*, ...)\n";
      text += "declare i32 @__isoc99_scanf(i8*, ...)\n";
      text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
      text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
      text += "@strsi = constant [3 x i8] c\"%d\\00\"\n";
      text += "@strsd = private unnamed_addr constant [4 x i8] c\"%lf\\00\", align 1\n";
      text += header_text;
      text += "define i32 @main() nounwind{\n";
      text += main_text;
      text += "ret i32 0 }\n";
      return text;
   }

}
