all: compile

compile: 
#classes :
	javac -sourcepath src -d classes src/cell/*.java
	javac -sourcepath src -d classes src/maze/*.java
	javac -sourcepath src -d classes src/objet/*.java
	javac -sourcepath src -d classes src/figure/*.java
	javac -sourcepath src -d classes src/action/*.java
	javac -sourcepath src -d classes src/quete/*.java

#tests:
	javac -classpath test4poo.jar test/cell/*.java
	javac -classpath test4poo.jar test/maze/*.java
	javac -classpath test4poo.jar test/action/*.java
	javac -classpath test4poo.jar test/quete/*.java


game:
# execution du jeu
	java -classpath classes src/Main.java

jar:
	java -jar jeu.jar
		
doc:
	javadoc src/*/*.java -sourcepath src -d docs


clean:
	rm -r  classes 

.PHONY : all clean docs
