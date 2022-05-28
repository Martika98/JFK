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
%3 = load i32, i32* %t
%4 = icmp eq i32 %3, 1
store i32 2, i32* %t
br i1 %4, label %true2, label %false2
true2:
br label %false2
false2:
br i1 %4, label %true3, label %false3
true3:
br label %false3
false3:
%5 = load i32, i32* %t
%6 = icmp eq i32 %5, 2
store i32 3, i32* %t
br i1 %6, label %true4, label %false4
true4:
br label %false4
false4:
ret i32 0 }
