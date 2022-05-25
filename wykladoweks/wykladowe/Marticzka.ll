declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%t = alloca double
store double 5.4, double* %t
%r = alloca double
store double 4.0, double* %r
%1 = mul i32 9, 8
%k = alloca i32
store i32 %1, i32* %k
%2 = fdiv double %r, %t
%j = alloca double
store double %2, double* %j
%3 = load double, double* %%j
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %3)
ret i32 0 }
