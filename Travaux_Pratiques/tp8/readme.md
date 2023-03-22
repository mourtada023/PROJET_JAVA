# Authors
** DIALLO Mamadou**


# Titre de projet
*Gooose Game <-> Jeu d'oie*


# But du projet
Au cours de ce projet, nous pourrons définir des packages, exécuter et exécuter un programme, générer sa documentation, créer et exécuter des méthodes de test et enfin créer un fichier jar exécutable.
Pour cela, nous avons besoin de quelques classes Java :
Forfait en jeu :
* Jeu : Le jeu de classe est décrit par un _tableau_ et une _liste de joueurs_
* Joueur : définit un joueur dans le jeu. Le joueur est décrit par son _nom_ et la _cell_ qu'il occupait
* MainGame : la classe principale.



Dans le sous-package game.cells :
* Cellule : Classe Cell qui définit une cellule normale et il ne peut y avoir qu'un seul joueur par cellule
* DepartCell : Classe StartCell qui définit la _cellule de départ_ et son effet. Il étend la classe Cell
* GooseCell : Classe GooseCell qui définit une _goose cell_ et son effet. Il étend la classe Cell
* TeleportCell : Classe TeleportCell qui définit une _cellule de téléportation_ et son effet. Il étend la classe Cell
* TrapCell : Classe TrapCell qui définit un _trap cell_ et son effet. Il étend la classe Cell. Le joueur ne peut quitter la cellule que lorsqu'un autre joueur atteint cette cellule
* WaitingCell : Classe WaitCell qui définit une _cellule d'attente_ et son effet. Il étend la Cell Class. Le joueur ne peut quitter la cellule que lorsqu'un autre joueur atteint cette cellule ou attend un nombre de tours donné (ici 2).
Dans le sous-package game.boards :
* Board : Class Board qui est _abstrait_ est décrit par un _nombre de cellules_ et une _liste de cellules_.
* ClassicalBoard : Classe ClassicalBoard _étend la classe Board_



# Instructions d'utilisation
Voici quelques instructions utiles :

Ouvrez votre terminal et déplacez-vous dans le dossier où vous souhaitez stocker le projet et exécutez cette commande : `$ git pull` pour récupérer le projet après _clonage_ du projet sur votre ordinateur.

* Forfait de jeu
1.
   * Pour obtenir la doc java du package du jeu, déplacez-vous dans le dossier src (`$ cd src`) et exécutez la commande : `$ javadoc goosegame -d ../docs`
   * Pour obtenir le sous-package java doc of cells, déplacez-vous dans le dossier src (`$ cd src`) et exécutez la commande : `$ javadoc goosegame.cells -d ../docs`
   * Pour obtenir le sous-package java doc of boards, placez-vous dans le dossier src (`$ cd src`) et exécutez la commande : `$ javadoc goosegame.boards -d ../docs`
Pour voir la doc Java, allez dans le dossier _docs_ et ouvrez le fichier _index.html_ dans un navigateur.



2.
  * Pour exécuter toutes les classes de game packag, déplacez-vous dans le dossier _src_ et exécutez la commande suivante : `$ javac goosegame/*.java -d ../classes`
  * Pour exécuter toutes les classes à partir du sous-package cells, déplacez-vous dans le dossier _src_ et exécutez la commande suivante : `$ javac goosegame/cells/*.java -d ../classes`
  * Pour exécuter toutes les classes du sous-package boards, déplacez-vous dans le dossier _src_ et exécutez la commande suivante : `$ javac goosegame/boards/*.java -d ../classes`

3. Pour lancer et exécuter des méthodes de test, vous devez vous déplacer à la racine du projet (vous devez être dans _../tp8>_) et exécuter les lignes de commande suivantes :
NB : vous devez d'abord compiler les classes ( voir _2._ )
1. `$ javac -classpath test4poo.jar test/goosegame/*.java -d classes`
2. `$ java -jar test4poo.jar goosegame.CellTest`
3. `$ java -jar test4poo.jar goosegame.StartCellTest`
4. `$ java -jar test4poo.jar goosegame.GooseCellTest`
5. `$ java -jar test4poo.jar goosegame.WaitCellTest`
Tous les tests réussis si la barre est verte.

4. Pour exécuter le programme, il y a 2 façons de procéder
* Sans fichier jar exécutable
1. Tout d'abord, lancez la classe principale à partir de la racine du paquet (_../tp8/src>_) et exécutez cette ligne de commande : `$ javac game/MainGame.java -d ../classes`
2. Maintenant, déplacez-vous dans le dossier _classes_ et exécutez le programme avec la commande : `$ java game.MainGame`
* Avec fichier(s) jar exécutable(s)
1. Tout d'abord, nous devons créer une archive. Pour cela, placez-vous dans le dossier _classes_ et exécutez cette commande :
`$ jar cvf ../gooseGame.jar jeu goosegame/boards goosegame/cells`
2. Ensuite, pour générer le fichier jar exécutable, déplacez-vous dans le dossier classes et exécutez la commande suivante :
`$ jar cvfm ../gooseGame.jar ../manifest-goose game goosegame/boards goosegame/cells `
NB : Un fichier manifeste définissait une classe (ici MainGame) comme classe principale de l'archive
3. Enfin, lorsque l'archive est créée, allez dans le source du projet (_.../tp8>_) et exécutez la commande suivante : `$ java -jar gooseGame.jar`





