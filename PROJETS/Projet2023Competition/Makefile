DOC = javadoc
JAVAC = javac
MAKE = make
JAVA = java
CLASSES = src/*/*.java
 



doc :
	$(DOC) -d javadoc -sourcepath src -d docs -subpackages competition competitor match -sourcepath src/
cls :
	$(JAVAC) $(CLASSES) -d classes
	

master.jar : 
	$(MAKE) cls
	$(MAKE) MASTER

testing : 
	$(MAKE) JCTEST 
	$(MAKE) TEST
	
	
clean :
	rm -rf classes/*
	rm -rf jar/*.jar
	rm -rf classesTest/*
	

master.jar:
	jar cvfe master.jar competition.MasterMain -C classes competition -C classes match -C classes competitor -C classes select  -C classes util 
	


CompetitionMain.jar:
	jar cvfe monArchive.jar competition.CompetitionMain -C classes competition -C classes match -C classes competitor -C classes util
JCTEST:
	$(JAVAC) javac -cp junit-platform-console-standalone-1.8.1.jar test/*/*.java -sourcepath src/ -d classesTest

TEST:
	$(JAVA) java -jar junit-platform-console-standalone-1.8.1.jar -cp classesTest/ --disable-banner --scan-classpath
