declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%1 = add i32 1, 3
%2 = fptosi double 2.9 to i32
%3 = mul i32 %2, %1
%x = alloca i32
store i32 %3, i32* %x
%4 = sitofp i32 3 to double
%z = alloca double
store double %4, double* %z
%5 = load i32, i32* %x
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
%7 = load double, double* %z
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %7)
ret i32 0 }

