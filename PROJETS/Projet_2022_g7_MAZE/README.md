# l2s4-projet-2022
# Equipe

- Mohamed El Amine HADJEMI
- Alycia BELKACEM
- Mamadou DIALLO
- Wafa TRARI

# Livrables

## Livrable 1

### Atteinte des objectifs
- Les deux algorithmes permettant de construire des labyrinthes parfaits
- Le code et les tests de la classe Maze et Cell
- Compilation et exécution des classes et du main
### Difficultés restant à résoudre
- L'algorithme distance

## Livrable 2

### Atteinte des objectifs
- Le code de la classe figure et ses sous classes
- Le code de la classe objet et ses sous classes
- Compilation et exécution des classes et du main
- L'algorithme distance (renvoie la distance qu'il y a entre une cellule et une autre)
### Difficultés restant à résoudre
- Y a encore quelques modifications à faire pour la classe figure mais pour ça on doit commencer la modelisation des actions.

## Livrable 3

### Atteinte des objectifs
- Le code de des classes pour les actions et les tests
- Mise à jour de la modelisation des personnages et des objets
- Compilation et exécution des classes et du main
### Difficultés restant à résoudre
-
## Livrable 4

### Atteinte des objectifs
- On a terminé toutes les modelisations
- Lors de l'execution du main un labyrinthe est cree et on peut commencer à jouer (toutes les actions s'executent)
- Pour executer le jeu utiliser une de ces deux commandes en se positionnant dans le dossier l2s4-projet-2022-g7 :  
  1 - Pour la premiere commade faut d'abord compiler les classes grace au makefile :
```
$ make
```
      puis :
```
$ java -classpath classes src/Main.java
```
  2 - deuxième commande en exécutant le fichier exécutable(jar)
```
$ java -jar jar/jeu.jar
```

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
- On a discuter du sujet.
- On a crée et coder la classe Cell.
- On a ajouté des commentaires à la classe Cell.
- On a créer aussi la classe Maze et discuté des différents algorithmes à implémenter.

## Semaine 2
- On a commencer à coder différents algorithmes de la classe Maze.
- On a fini de coder le premier algorithme pour la construction du labyrinthe.
- On a crée la classe MazeMain pour vérifier que notre algorithme fonctionne et nous donne un labyrinthe parfait.

## Semaine 3
- On a commencé à coder le deuxième algorithme de construction du labyrinthe.
- On a modifié differents algorithmes de la classe Maze.
- On a vérifier dans la classe MazeMain que notre deuxième algorithme de construction fonctionne bien.
- On a ajouter des commentaires à la classe Maze.
- On a fini de coder le deuxième algorithme de construction du labyrinthe dans la classe Maze2 (sidewinder).
- On a fait les tests et veririfier qu'ils s'executent.



## Semaine 4
- On a discuté de la modélisation des personnages
- On a crée la classe figure et ses sous classe (on a utilisé l'héritage).
- On a discuté de la modélisation des objets

## Semaine 5
- On a commencé la modelisation des objets
- On a crée la classe objet et ses sous classe (on a utilisé l'héritage).
- Toutes les classes compilent

## Semaine 6
- On a modifié la classe Maze et rajouté l'algorithme getObjectif() qui selectionne la case objectif.
- On a crée la classe MazeDynamique qui génère un labyrinthe qui indique la position du Héro avec une croix (x) on peut visualiser le résultat en éxécutant le main.

## Semaine 7
- On a commencé à réflechir à la modélisation des actions
- On a créer la classe Play et coder les actions qui peuvent être éffectuées par les personnages.

## Semaine 8
- On a ajouté des actions à la classe Play  
- On a modifié la modelisation des personnages et des objets

## Semaine 9
- on a fait les tests de la classe play et on les a compile et execute
- On a modifié le main maintenant en l'executant on choisit l'algorithme avec lequel on va generer le labyrinthe puis on peut faire deplacer le héro et visualiser son deplacement.

## Semaine 10
- On a revu toute la modelisation des actions
- On a modifié le main en ajoutant les actions

## Semaine 11
- On a compile et execute les tests et les classes de la modelisation des actions

## Semaine 12
- On a fait le diagramme UML des trois livrables
- on a fait le makefile
- on a creer le fichier executable (jeu.jar)
