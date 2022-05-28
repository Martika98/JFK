class Generator:
    header_text = ''
    main_text = ''
    reg = 1
    br = 1
    brstack = []

    def what_type(self, type):
        #print(type)
        if type is int:
            return "i32"
        elif type is float:
            return "double"
        elif type is str:
            return "str"

    def assign(self, id, value, type):
        #print(f"to jest twoje id {id}")
        self.main_text += f"store {self.what_type(type)} {value}, {self.what_type(type)}* %{id}\n"

    def declare(self, id, type):
        self.main_text += f"%{id} = alloca {self.what_type(type)}\n"

    def declare_str(self, id, leng):
        self.main_text += f"%{id} = alloca [{leng+1} x i8]\n"

    def assign_str(self,id, leng, value):
        self.header_text += '@__const.main.'+id+' = private unnamed_addr constant ['+str(leng+1)+' x i8] c"'+value+'\\00"\n'
        self.main_text += f"%{self.reg} = bitcast [{leng+1} x i8]* %{id} to i8*\n"
        self.main_text += f"call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %{self.reg}, i8* align 1 getelementptr inbounds ([{leng+1} x i8], [{leng+1} x i8]* @__const.main.{id}, i32 0, i32 0), i64 {leng+1}, i1 false)\n"
        self.reg += 1

    def table_declare(self, id, leng, type):
        self.main_text += f"%{id} = alloca [{leng} x {self.what_type(type)}]\n"

    def add_int(self, val1, val2):
        self.main_text += f"%{self.reg} = add i32 {val1}, {val2}\n"
        self.reg += 1

    def sub_int(self, val1, val2):
        self.main_text += "%" + str(self.reg) + " = load i32, i32* " + val1 + "\n"
        reg1 = self.reg
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = load i32, i32* " + val2 + "\n"
        reg2 = self.reg
        self.reg += 1
        self.main_text += f"%{self.reg} = sub nsw i32 %{reg1}, %{reg2}\n"
        self.reg += 1
         
    def multi_int(self, val1, val2):
        self.main_text += f"%{self.reg} = mul i32 {val1}, {val2}\n"
        self.reg += 1

    def div_int(self, val1, val2):
        self.main_text += f"%{self.reg} = sdiv i32 {val1}, {val2}\n"
        self.reg += 1

    def add_float(self, val1, val2):
        self.main_text += f"%{self.reg} = fadd double {val1}, {val2}\n"
        self.reg += 1

    #def sub_float(self, val1, val2):
     #   self.main_text += f"%{self.reg} = fsub nsw double {val1}, {val2}\n"
      #  self.reg += 1
  
    def sub_float(self, val1, val2):
        self.main_text += "%" + str(self.reg) + " = load double, double* " + val1 + "\n"
        reg1 = self.reg 
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = load double, double* " + val2 + "\n"
        reg2 = self.reg 
        self.reg += 1
        self.main_text += f"%{self.reg} = fsub double %{reg1}, %{reg2}\n"
        self.reg += 1
          
    def multi_float(self, val1, val2):
        self.main_text += f"%{self.reg} = fmul double {val1}, {val2}\n"
        self.reg += 1

    def div_float(self, val1, val2):
        self.main_text += f"%{self.reg} = fdiv double {val1}, {val2}\n"
        self.reg += 1

    def table_assign(self, id_, leng, type, value_list):
        table_values = ''
        self.header_text += "@__const.main."+id_+" = private unnamed_addr constant ["+str(leng)+" x "+ self.what_type(type) +"] ["
        for i in range(leng):
            if i == leng-1:
                table_values += self.what_type(type) + " " + str(value_list[i]) + "]\n"
                break
            table_values += self.what_type(type) + " " + str(value_list[i]) + ", "
        self.header_text += table_values
        self.main_text += f"store [{leng} x {self.what_type(type)}]\n"

    def printf_i32(self, id_):
        self.main_text += "%" + str(self.reg) + " = load i32, i32* %" + id_ + "\n"
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %" + str(self.reg - 1) + ")\n"
        self.reg += 1

    def printf_double(self, id_):
        self.main_text += "%" + str(self.reg) + " = load double, double* %" + id_ + "\n"
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + str(self.reg - 1) + ")\n"
        self.reg += 1
        
    def printf_string(self, id_):
        leng = len(id_) + 1            
        self.main_text += "%" + str(self.reg) + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + str(leng) + "] x i8], [" + str(leng) + "] x i8]* @.str, i64 0, i64 0))\n"
        self.reg += 1

 #   def if_declare(self, id_):
  #      self.main_text += ";;;ifstart\n"
   #     self.br += 1
    #    self.main_text += "br i1 %" + str(self.reg - 1) + ", label %true" + str(self.reg) + ", label %false" + str(self.reg) + "\n"
     #   self.main_text += "true" + str(self.br) + ":\n"
      #  self.bufferstack.append(self.br)
	
    def icmp_eq(self, id, value):
        self.main_text += "%" + str(self.reg) + " = load i32, i32* %" + str(id) + "\n";
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = icmp eq i32 %" + str((self.reg-1)) + ", " + str(value) + "\n";
        self.reg += 1
    
    def icmp_ne(self, id, value):
        self.main_text += "%" + str(self.reg) + " = load i32, i32* %" + str(id) + "\n";
        self.reg += 1
        self.main_text += "%" + str(self.reg) + " = icmp ne i32 %" + str((self.reg-1)) + ", " + str(value) + "\n";
        self.reg += 1

    def if_start(self):
        self.br += 1
        self.main_text += "br i1 %"+str(self.reg-1)+", label %true"+str(self.br)+", label %false"+str(self.br)+"\n";
        self.main_text += "true"+str(self.br)+":\n";
        self.brstack.append(self.br);

    def if_end(self):
        b = self.brstack.pop();
        self.main_text += "br label %false"+str(b)+"\n";
        self.main_text += "false"+str(b)+":\n";    
    
  #  def if(self, id, value, type):
  #      self.main_text += f"%{self.reg} = icmp eq {self.what_type(type)} {id}, {value}\n"
  #      self.reg += 1
    
    def generate(self):
        txt = ''
        txt += "declare i32 @printf(i8*, ...)\n"
        txt += "declare i32 @__isoc99_scanf(i8*, ...)\n"
        txt += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n"
        txt += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n"
        txt += "@strs = constant [3 x i8] c\"%d\\00\"\n"
        txt += self.header_text
        txt += "define i32 @main() nounwind{\n"
        txt += self.main_text
        txt += "ret i32 0 }\n"
        return txt
        
    def gen(self,):
        txt = ''
        txt += "declare i32 @printf(i8*, ...)\n"
        txt += "declare i32 @__isoc99_scanf(i8*, ...)\n"
        txt += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n"
        txt += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n"
        txt += "@strs = constant [3 x i8] c\"%d\\00\"\n"
        txt +=  self.header_text
        txt += "define i32 @main() nounwind{\n"
        txt += self.main_text
        txt += "ret i32 0 }\n"
        return txt

