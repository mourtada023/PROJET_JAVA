# Tp4 Mamadou Diallo 

## objectif:
Le but de ce tp est d’apprendre à écrire et à générer une documentation « javadoc », d’apprendre à coder une classe en s’appuyant sur des tests de se familiariser avec l’écriture de tests par l’étude de tests fournis.

## Générer et consulter la documentation :
Pour pouvoir générer et consulter la documentation des classes, placer vous danns le dossier tp4/
_Génération docs_

`javadoc src/*.java -sourcepath src -d docs`

NB : L’option « -sourcepath src » indique que les fichiers source se trouvent dans le dossier src/.
L’option « -d docs » permet de placer les fichiers de doumentation générés dans un dossier docs/ qui est créé
s’il n’existe pas (« d » comme destination).
_Consultation_

Dans le dossier *src* se trouve les fichers compiler coorespondant a chaque fichier ( Hotel ou Room), entrer dans l'un d'entre eux et doublr cliquer sur l'un des fichier coorespondant à la classe suivit du `.html` ou simplement l'ouvrire dans un nagivateur afin de visualiser les differentes documentations de chaque méthode et d'en comprendre l'usage

## Compiler les classes du projet : 
Afin de pouvoir vérifier la veracité du code, on doit compiler les testes au préalable avec la commande suivante en se plaçant toujours dans le fichier tp4


`javac src/*.java -sourcepath src -d classes`

On compile là tous les fichier java en les mettant dans un fichier classes



## compiler et exécuter les tests : 
Toujours en se plaçant dans le fichier tp4, on execute la commaned suivante avec le code
_Compilation_
`javac -classpath test4poo.jar test/*.java`
NB : L’option -classpath permet de prendre en compte l’archive test4poo.jar qui est nécessaire pour les tests.
_Execution_

Pour executer les tests et de verifier la veracité du code on execute la comande 

`java -jar test4poo.jar HotelTest`

Si tout se passe bien, la barre *verte* s'affiche comme voulu.



## Exécuter le programme (le ou les main inclus), en donnant des exemples
Avec la première compilation qui nous a permis de compiler  tous les fichier (`javac src/*.java -sourcepath src -d classes`), on pourra executer le main avec `java -classpath classes HotelMain 42`  42 ici est un  exemple.


On peut voir afficher : 

Le nombre de chambre : 100
La chambre dont le numéro a été passé en argument  :Room 42
Affiche la chambre à louer : Room 42
Afficher le nombre de chambre libre dans l'hotel :99
Afficher à nouveau le nombre de chambre libre dans l'hotel :100

