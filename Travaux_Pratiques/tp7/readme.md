# Tp7 Mamadou Diallo et Mohamed Camara

#### Sujet:
[Le sujet](https://www.fil.univ-lille1.fr/~routier/enseignement/licence/poo/tdtp/tp-agence.pdf)

## objectif:
Ce tp est composé de deux parties, la première nous a mermis de manipuler les collections et les tables de hachage et la seconde consiste en une première mise en œuvre simple de l’héritage.


## Générer et consulter la documentation :
Pour pouvoir générer et consulter la documentation des classes, placer vous danns le dossier tp7/
*Génération docs

  `javadoc -sourcepath src -d docs -subpackages rental`

NB : L’option « -sourcepath src » indique que les fichiers source se trouvent dans le dossier factory/.
L’option « -d docs » permet de placer les fichiers de doumentation générés dans un dossier docs/ qui est créé
s’il n’existe pas (« d » comme destination).
Avec les paquetage, on retrouve la struture arboressante comme definis dans le src/.



- Consultation

Dans le dossier *tp7/docs* se trouve les fichers compiler coorespondant a chaque fichier en fonction des paquetages, entrer dans l'un d'entre eux et double cliquer sur l'un des fichier coorespondant à la classe suivit du `.html` ou simplement l'ouvrire dans un nagivateur afin de visualiser les differentes documentations de chaque méthode et d'en comprendre l'usage.



## Compiler les classes du projet : 
Afin de pouvoir vérifier la veracité du code, on doit compiler les classes au préalable avec la commande suivante en se plaçant toujours dans le fichier tp7, on execute la commande suivante.


  `javac -sourcepath src -d classes src/rental/*.java`

On compile là tous les fichier *java* en les mettant dans un fichier **classes**.


## compiler et exécuter les tests : 
Toujours en se plaçant dans le fichier tp7, on execute la commande suivante afin de compiler tout les test : 

  `javac -classpath test4poo.jar test/rental/*.java`


NB : L’option -classpath permet de prendre en compte l’archive test4poo.jar qui est nécessaire pour les tests.

* Execution

Pour executer les tests et de verifier la veracité du code on execute les commande suivante toujours en se plaçant dans *tp7* pour chaque ficher test souhaiter : 

* Pour RentalAgencyTest :
  `java -jar test4poo.jar rental.RentalAgesetMessagencyTest`

* Pour AndFilterTest : 
  `java -jar test4poo.jar rental.AndFilterTest`

* Pour Cartest : 
  `java -jar test4poo.jar rental.CarTest`

* Pour MotorbikeTest : 
  `java -jar test4poo.jar rental.MotorbikeTest`


Si tout se passe bien, la barre *verte* devrait s'afficher comme voulu a chaque execution.

**Exécuter le programme** :


Avec la première compilation qui nous a permis de compiler  tous les fichier, on pourra executer les commandes pour la creation du fichier jar.
----------------------------------------------------------------------------------

# Gestion d’archives
## Création d’archive exécutable : 
  * Une archive exécutable est une archive dans laquelle on va préciser
  la classe dont on veut exécuter la méthode main lors de la création de l’archive.
Comme ceci :


**Creation**
  `jar cvfe rental.jar rental.MainAgency -C classes rental`


**Consultation**
  `jar tvf rental.jar`



Vous devez retrouver tous les fichiers du dossier rental/ ajoutés.
Vous pouvez constater en plus l’ajout d’un fichier META-INF/MANIFEST.MF présent dans cette archive. Ce
fichier s’appelle le manifeste de l’archive.
**Execution**

Le caractère *exécutable* de cette archive se vérifie lorsque l’on exécute la commande suivante:

  `java -jar rental.jar`

NB : Vous pouvez constater que la méthode main de la classe image.ImageMain a été exécutée;
Le resultat est identique avec la compilation des commandes si dessous.


---------------------------------------------------------------------------------------


## Exécuter le programme : 
Avec la première compilation qui nous a permis de compiler  tous les fichier, on pourra executer le main toujours en etant dans \tp7> avec la commande suivante: 


`java -classpath classes rental.MainAgency`


Et on verra s'afficher: 


----------------------------------------------------------------------------

Year :1920  brand :Timo price : 200.0 
Year :2001  brand :Renault price : 100.0 
Les voitures ajouter a la liste AGENCY sont  : 
[Year :1920  brand :Timo price : 200.0 , Year :2018  brand :Audi price : 500.0 , Year :2001  brand :Renault price : 100.0 ]

Les voitures ajouter a la liste suspiciousRentalAgency sont  : 
[Year :2013  brand :Toyota price : 100.0  cylindree : 150 cm3, Year :2001  brand :Renault price : 100.0 , Year :2014  brand :Audi price : 40.0 ]


Les vehicules loues dans AGENCY sont : 
Year :1920  brand :Timo price : 200.0 
Year :2018  brand :Audi price : 500.0 

Les vehicules loues dans suspiciousRentalAgency sont : 
Year :2013  brand :Toyota price : 100.0  cylindree : 150 cm3

Display of vehicle filters for agency 
Year :1920  brand :Timo price : 200.0 
Year :2001  brand :Renault price : 100.0 

Display of vehicle filters for suspiciousRentalAgency 
Year :2013  brand :Toyota price : 100.0  cylindree : 150 cm3
Year :2001  brand :Renault price : 100.0 
Year :2014  brand :Audi price : 40.0 

Mohamed rented the brand's car  Timo model Leon at 200.0 euros in the agency 
Mamadou rented the brand's car Audi model A1 at 500.0 euros in the agency 

Mohamed Did he rent a car in one of the agencies ? : true
Mamadou Did he rent a car in one of the agencies ? : true

the vehicle of brand Renault is it rented : false

 After application of the method returnVehicle which allows customer 1 to return the vehicle
Here is the list of cars rented in the agency  : [Year :2018  brand :Audi price : 500.0 ]


----------------------------------------------------------------------------


Qui est le même affichage avec le fichier archive crée.

