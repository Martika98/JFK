# Bartosz.Sawicki@ee.pw.edu.pl
# 2014-2018

ANTLR= /usr/local/lib/antlr-4.9.2-complete.jar


all: generate compile test

generate:
	java -jar $(ANTLR) -o output Demo.g4

compile:
	javac -cp $(ANTLR):output:. Main.java

test:
	java -cp $(ANTLR):output:. Main test.x > test.ll
	lli test.ll

clean:
	rm -f test.ll
	rm -f *.class
	rm -rf output

