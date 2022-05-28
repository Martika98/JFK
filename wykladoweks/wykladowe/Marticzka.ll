declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%t = alloca i32
store i32 1, i32* %t
%1 = load i32, i32* %t
%2 = icmp eq i32 %1, 1
ret i32 0 }
