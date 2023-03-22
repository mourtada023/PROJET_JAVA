all : cls doc guerre.jar agricole.jar

cls :
	javac src/game/*.java -d bin

doc : cls
	javadoc -d docs -subpackages game

guerre.jar : cls
	jar cvfm bin/jar/guerre.jar jar/manifest-war bin/game/*.class bin/game.war/*.class

agricole.jar : cls
	jar cvfm bin/jar/agricole.jar jar/manifest-agri bin/game/*.class bin/game.agri/*.class

clean :
	rm -rf bin/* 
	rm -rf jar/*.jar 
	rm -rf docs/*

.PHONY : all clean