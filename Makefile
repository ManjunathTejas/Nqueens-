# A simple Makefile
Nqueens2: Nqueens2.class
	echo Main-class: Nqueens2 > Manifest
	jar cvfm Nqueens2.jar Manifest Nqueens2.class
	rm Manifest

Nqueens2.class: Nqueens2.java
	javac -Xlint Nqueens2.java

clean:
	rm -f Nqueens2.jar Nqueens2.class