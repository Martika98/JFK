declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%t = alloca i32
store i32 1, i32* %t
%1 = load i32, i32* %t
%2 = icmp ne i32 %1, 2
br i1 %2, label %true2, label %false2
true2:
br label %false2
false2:
%3 = load i32, i32* %t
%4 = icmp eq i32 %3, 1
br i1 %4, label %true3, label %false3
true3:
br label %false3
false3:
ret i32 0 }
