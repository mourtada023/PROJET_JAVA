# Tp5 Mamadou Diallo et Mohamed Camara

Dans ce ReadMe vous trouvrez : 
- [x] les noms des membres du binômes
- [x] un paragraphe présentant le TP et ses objectifs
- [x] un paragraphe précisant comment générer et consulter la documentation
- [x] un paragraphe précisant comment compiler les classes du projet
- [x] un paragraphe précisant comment compiler et exécuter les tests
- [x] un paragraphe précisant comment exécuter le programme (le ou les main inclus), en donnant des exemples,

## objectif:

Le but de ce Tp est d'avoir une vue d'ensemble sur les paquetages, la compilation, l'execution, la documentation, les archives et surtout pouvoir coder les tests à partir du code java fournis.

## Générer et consulter la documentation :
Pour pouvoir générer et consulter la documentation des classes, placer vous danns le dossier tp5/
*Génération docs

`javadoc -sourcepath src -d docs factory factory.util`

NB : L’option « -sourcepath src » indique que les fichiers source se trouvent dans le dossier factory/.
L’option « -d docs » permet de placer les fichiers de doumentation générés dans un dossier docs/ qui est créé
s’il n’existe pas (« d » comme destination).
Avec les paquetage, on retrouve la struture arboressante comme definis dans le src/.


- Consultation

Dans le dossier *tp5/docs* se trouve les fichers compiler coorespondant a chaque fichier en fonction des paquetages, entrer dans l'un d'entre eux et double cliquer sur l'un des fichier coorespondant à la classe suivit du `.html` ou simplement l'ouvrire dans un nagivateur afin de visualiser les differentes documentations de chaque méthode et d'en comprendre l'usage.

## Compiler les classes du projet : 
Afin de pouvoir vérifier la veracité du code, on doit compiler les classes au préalable avec la commande suivante en se plaçant toujours dans le fichier tp5.


`javac -sourcepath src -d classes src/factory/*.java`

On compile là tous les fichier java en les mettant dans un fichier classes



## compiler et exécuter les tests : 
Toujours en se plaçant dans le fichier tp5, on execute la commande suivante 

*Compilation
`javac -classpath test4poo.jar test/*.java`
NB : L’option -classpath permet de prendre en compte l’archive test4poo.jar qui est nécessaire pour les tests.

- Execution

Pour executer les tests et de verifier la veracité du code on execute la comande toujours en se plaçant dans *tp5*.

`java -jar test4poo.jar RobotTest`

Si tout se passe bien, la barre *verte* s'affiche comme voulu.



# Gestion d’archives
## Création d’archive exécutable : 
  * Une archive exécutable est une archive dans laquelle on va préciser
  la classe dont on veut exécuter la méthode main lors de la création de l’archive.
Comme ceci :


- Creation
`jar cvfe factory.jar factory.RobotMain -C classes factory`
  * Il est possible de consulter le contenu de cette archive en exécutant.

**Consultation**

`jar tvf factory.jar`

Vous devez retrouver tous les fichiers du dossier factory/ ajoutés.
Vous pouvez constater en plus l’ajout d’un fichier META-INF/MANIFEST.MF présent dans cette archive. Ce
fichier s’appelle le manifeste de l’archive. Si vous le consultez, vous constaterez qu’il contient, entre autres,
l’information précisant la Main-Class de l’archive.

**Execution**

Le caractère *exécutable* de cette archive se vérifie lorsque l’on exécute la commande suivante:
`java -jar factory.jar`

NB : Vous pouvez constater que la méthode main de la classe factory.RobotMain a été exécutée, comme précisé
dans le manifeste de l’archive.



## Exécuter le programme (le ou les main inclus), en donnant des exemples
Avec la première compilation qui nous a permis de compiler  tous les fichier (`javadoc -sourcepath src -d docs factory factory.util`), on pourra executer le main avec `java -classpath classes factory.RobotMain` 


On peut voir afficher : 

beginning of main from robot.Robot
the conveyer belt carries 2 box(es)
  - a box of weight 10
  - a box of weight 15
end of main from robot.Robot

