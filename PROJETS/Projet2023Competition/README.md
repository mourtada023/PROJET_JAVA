# L3 MIAGE | Projet de COO


---
# Participants

- [Gabriella Divine ISHIMWE](mailto:gabriella.ishimwe.etu@univ-lille.fr)
- [Mamadou DIALLO](mailto:mamadou.diallo5.etu@univ-lille.fr)

---
# Sujet et délais

### [Le sujet](https://www.fil.univ-lille.fr/~quinton/coo/projet/competitions.pdf)

| Livrable   | Travail à réaliser                            | Échéance   |
|:-----------|:----------------------------------------------|:-----------|
| Livrable 1 | Conception de la version 1 de l'application   | 09/10/2022 |
| Livrable 2 | Conception de la version 2 de l'application   | 13/11/2022 |
| Livrable 3 | Conception de la version 3 de l'application   | 13/12/2022 |


# Sommaire
Journal de bord (Semaine) : [1](#semaine-1) [2](#semaine-2) [3](#semaine-3) [4](#semaine-4) [5](#semaine-5) 

---
# Rubrique HowTo

### Récupération des sources du projet 
Depuis votre terminal, veuillez exécuter la commande suivante :
- `git clone [mettre ici le lien du dépôt]`


**Ensuite, Veuillez exécuter les commandes suivantes dans un terminal à partir du dossier racine du projet :**

### Compilation des fichiers sources

Pour compiler tous les fichiers, on peut executer la commande :
- `javac -sourcepath src -d classes src/*/*.java`

ou avec le makefile `make cls`.

**NOTE :** Pour compiler un fichier précis, vous pouvez remplacer `*` par un **nom de fichier** se trouvant dans le dossier **src**.

### Exécution du programme
* Pour la classe CompetitionMain, qui permet d'executer league ou tournement : 
- `java -classpath classes mainCompetitions/CompetitionMain`

Puis apparait une interface permettant de la faire le choix entre **1 : League** et **2 : Tournement**.

* Pour la classe MasterMain:

`java -classpath classes mainCompetitions/MasterMain`

qui va permettre de lancer à la fois les phases de pools et de selectionner les meilleurs de chaques pools puis de leur faire competir un tourois afin de trouver le vainqueur.
 
### Création de l'archive exécutable

* Pour la classe CompetitionMain, qui permet d'executer league ou tournement : 

- `jar cvfe monArchive.jar mainCompetitions.CompetitionMain -C classes competition -C classes match -C classes competitor -C classes util`


* Pour la classe MasterMain:

- `jar cvfe master.jar mainCompetitions.MasterMain -C classes competition -C classes match -C classes competitor -C classes select  -C classes util`

### Exécutions du jar
- `java -jar CompetitionMain.jar`

- `java -jar master.jar`



### Compilation des tests
- `javac -cp junit-platform-console-standalone-1.8.1.jar test/*/*.java -sourcepath src/ -d classesTest`

**NOTE :** Pour compiler un fichier précis, vous pouvez remplacer `*` par un **nom de fichier** se trouvant dans le dossier **test**.

### Execution des tests
- `java -jar junit-platform-console-standalone-1.8.1.jar -cp classesTest/ --disable-banner --scan-classpath`

**NOTE :** Pour exécuter d'autres tests, vous pouvez remplacer LeagueTest par un autre nom de fichier de test situé dans le dossier **test**.

### Génération de la documentation
Le dossier doc/ se trouvera à la racine du projet.
- `javadoc -sourcepath src -d docs -subpackages competition competitor match`

ou avec `make doc`.

---
# Livrables

## Livrable 1

![livrable1](https://zupimages.net/up/22/40/m2vo.png)

---
# Journal de bord

## Semaine 1
Lecture, compréhension du sujet et discussion sur nos différents choix de conception.

### Objectifs à venir :
- [x] Relire les leçons sur les tests, Mock.
- [x] Relire les cours de programmation orientée objet.

---
## Semaine 2
- [x] Creation d'un premier diagramme UML en vue d'une génération du squelette du projet. Le diagramme pourra évoluer en fonction des besoins de conception. **Patricia, Gabriella**

### Objectifs à faire pour la prochaine semaine :
- [x] Faire les tests des classes Match et League **Patricia**
- [x] Faire les tests de la classe Tournament **Gabriella**

---
## Semaine 3

### Objectifs à faire pour les 2 prochaines semaines :
- [x] Coder les classes Competition, Match, Competitor, CompetitionMain **Patricia**
- [x] Reprendre les tests de Tournament **Gabriella**

---
## Semaine 4
- [x] Coder les classes League et Tournament, TournamentTest **Patricia**

---
## Semaine 5
- [x] Vérifier que tout le code fonctionne, que les tests sont tous validés(avec une bonne couverture), que les principes de conception et l'application des design patterns sont respectés. **Patricia**


### [Premier Livrable](#livrable-1)

### Explication des choix de conception :


- Des difficultés pour comprendre ce que représente un match. Pour respecter le principe OCP, Match est une classe abstraite, afin de pouvoir définir plus tard de nouveaux types de matchs.
- Dans ma première conception, un joueur était défini par son nom et son nombre de points. Problème : comment faire si le compétiteur participe à plus d'une compétition? Solution retenue : on crée une table de hachage qui répertorie le nombre de points de chaque joueur. Les points seront gérés par la compétition.
- La méthode play(List<Competitor>) de la classe Tournament a d'abord été faite récursivement. Je crée une liste de joueurs qui va contenir les gagnants de chaque tour. Je leur fais jouer un premier tour. Puis récursivement, j'invoque la méthode play(List<Competitor>) sur la liste de gagnants du tour précédent. Cette version fonctionnait mais était longue et comportait une cascade de "if".
Ensuite j'ai fait une nouvelle version avec une boucle "Tant que" qui remplaçait les conditions précédedentes. Celle-ci était plus lisible mais toujours longue.
La version finale respecte les principes de responsabilité unique et KISS. J'ai délégué certains comportements à d'autres méthodes. Ce qui rend le code plus compréhensible, facilement extensible.
- Pour les classes de tests, j'ai fait des Mock(MockLeague, MockTournament et MockMatch). Ensuite j'ai fait les tests des classes correspondantes, soit les tests des sous-classes de Competition. Cependant, le code de MockLeague et MockTournament est le même à un détail près. Ce qui fait une répétition de code et ne respecte pas le principe DRY. J'ai ensuite essayé de factoriser mon code en faisant un MockCompetition. Mais c'était difficile après de trouver les liens d'héritages entre les classes de tests ainsi que ce qu'il fallait tester. Dans les versions suivantes, avec la pratique, il n'y aura plus cette répétition de code.


- Au début difficulté à faire les tests de Tournament en utilisant un mock. Donc j'ai d'abord fait sans. Mais j'ai vu que les tests n'étaient pas correctement faits et ont par la suite été corrigés en utilisant un mock


- Au prealable souci d'execution des tests pour probleme de configuration, et incomprehension du rôle le la classe Match.






### [Deuxième Livrable](#livrable-2)

UML initial
![main](https://zupimages.net/up/22/46/djox.png)

UML final

![livrable2](https://zupimages.net/up/22/40/m2vo.png)

### Explication des choix de conception :

La version 2 du projet consistait à ajouter un autre type de competition Master.

3 nouvelles classes on été ajoutée : 

- GroupeStage nous a permit de definir comment mettre en place les differents groupes de la phase poule grace à sa methode generatedLeagues

- Création de l'interface Selection nous permet la mise en place de differents types de selection des competiteurs qui passeront les phases de poules. Une classe FirstSelection a été mise en place comme exemple d'une selection du competiteur avec le plus grand nomnbre de points.

- La classe Master qui est la nouvelle competiton demandée


Pour la conception, il fallait réfléchir à la manière de sélectionner les compétiteurs nous avons adopter pour faire des stratégies.
L'idée est de faire une interface avec une méthode qui s'occupe de la sélection et que l'on puisse en créer comme on souhaite par la suite.
Pour l'algorithme de la méthode play de Master il faut d'abord lancer la première phase (phase de poule) puis sélectionner et enfin la seconde phase (tournoi). Pour la première phase on a pris un design pattern , la template method, celui-ci consiste à séparer certaines étapes d'un algorithme en sous classe afin de redéfinir si on le souhaite l'étape sans changer l'algorithme principale c'est de là que vient la classe GroupStage.
La partie la plus compliquée était les tests car il fallait vérifier l'appel de la méthode play au sein des leagues dans groupstage et de tournoi,de l'appel de à la méthode select dans select.
On a dû redéfinir play en réécrivant de nouvelles méthodes pour vérifier ces appels (playTournament/playGroupStage/select) ce qui a amené de nouvelles vérifications pour le test de Master.

### Bilan du livrable 2 :

**Difficultés :**

Difficultés techniques : 

le choix de conception  pour la mise en place d'un diagramme uml nous a pris beaucoup de temps que prévu. 

la mise en place des bonnes pratiques de developpement (design pattern, solid,tdd..) a été difficile car ayant quelques notions non encore bien maitrisée par le binome, on a pris du temps pour relire le cours  et notre code.
Difficultés organisationnelles : 

la configuration de l'équipe ayant changé, on est passé d'un trinome à un binome, on a du changé notre organisation et un temps d'adaptation était necessaire. 


**Point Positif :**

On a essayé de refactoriser au plus notre code.


### [Troisième  Livrable](#livrable-3)


![livrable2](https://zupimages.net/up/22/49/eh0v.png)


### Explication des choix de conception :

La version 3 du projet consistait à ajouter des observateurs journaliste et bookmaker en s'inspirant du **design pattern observer**.


**Observable :**

Dans notre conception l'observable est un match. Ainsi on a enrichi notre classe abstract Match avec la liste des observateur, ainsi que la methode observate qui se charge d'executé la methode des observateur pour suivre un match(followMatch)


**Observer :**

Dans notre conception les observateurs sont les journalistes et bookmaker. Ainsi une interface matchobserver a été crée avec une methode pour suivre un match(followMatch). 2 classes implemente cette interface une classe journalist et bookmaker



### Bilan du livrable 3 :

**Difficultés :** On a eu juste quelques souci, au niveau de la compilation des test, on arrivait  a les compiler et executer dans eclipse mais pas avec les ligne de commande . ce problème nous vraiment pris beaucoup de temps à regler vers la fin du projet. Nous avons finalement pu corriger l'erreur en installant une autre version de JUnit.


**Point Positif :** A travers cette dernière  on a reuni a nous familiariser avec le disign patter *observer* qui nous a permis de creer les journalise et les bookmaker afin qu'ils puissent commenter les matchs.

### Bilan Final  :

Pour la conception on a adopté le **TDD** (Test-Driven Development) c'est à dire on écrivait d'abord les tests afin de guider l'écriture du code source. Lorsqu'il fallait ajouter de nouvelles méthodes on ajouter aussi des tests.

Ce projet nous a rééllement aidé et guidé à utiliser les notions vues en cours et à se familiariser avec celles-ci. Nous avons appris à utiliser différents design pattern adaptés à chaque cas et différents principes abordés dans le cours.








Dans ce projet on a principalement trois packages:

Le package Match qui contient les classe qui sera implémenter par tous les objets Match afin que deux competitor puissent s'affronter.
	
Le package Competitor qui contient une classe qui répresente l'ensemble des competiteur d'une compétition.
	
Le package Competition qui contient une classe abstraite Competition et qui vas servir pour les classes  Tournament , League et de Master.
	
Le package util est présent contenant la classe MapUtil avec la methode sortByDescendingValue qui permettra de faire le classement .
	
Le package select contient tous les models de selection possible qu'on pourra applique au Master.
	
Le package observer qui contient l'interface MatchObserver et les Observateurs (Journaliste et Bookmeker).

Le package exception qui contient la classe d'exception possible.

Et enfin Le package mainCompetitions qui contient la Classe CompetitionMain qui nous permet de jouer a un tournoi ou a une competition et la classe MasterMain qui va nous permet de faire jouer les phases de groupes des équipes en lice et de faire une selection en untilisant le disign pattern *strategie* puis de leur faire jour une competion afin d'avoir un vainqueur a la fin, et que les journaliste et les bookmakers puisse commenter les matchs.






