# Bartosz.Sawicki@ee.pw.edu.pl
# 2014-2018

ANTLR=../antlr-4.2.2-complete.jar

all: generate compile test

generate:
	java -jar $(ANTLR) -o output Demo.g4

compile:
	javac -cp $(ANTLR):output:. Main.java

test:
	java -cp $(ANTLR):output:. Main test.x > test.ll
	lli test.ll

clean:
	rm test.ll
	rm *.class
	rm -rf output

