# Enoncé de l'exercice
Dans le langage de programmation de votre choix, implémentez de manière efficace une classe ThreeStack qui implémente 3 piles FILO avec comme seule structure de données un tableau de chaînes de caractères (nous attendons particulièrement les méthodes push(stackname, object) et pop(stackname)).

- Voici un exemple d'utilisation en pseudo code :

var threeStack = new ThreeStack();

threeStack.push(1, "{name:"object1"}");
threeStack.push(1, "{name:"object2"}");
threeStack.push(2, "{name:"object3"}");
threeStack.push(2, "{name:"object4"}");
threeStack.push(2, "{name:"object5"}");
threeStack.push(3, "{name:"object6"}");
threeStack.push(3, "{name:"object7"}");


print(threeStack.pop(2)); // display {name:"object5"}
print(threeStack.pop(2)); // display {name:"object4"}
print(threeStack.pop(1)); // display {name:"object2"}
print(threeStack.pop(1)); // display {name:"object1"}
print(threeStack.pop(3)); // display {name:"object7"}
print(threeStack.pop(1)); // throw Exception
print(threeStack.pop(4)); // throw Exception


A fin de voir le resultat du code, vous pouvez utuliser l'IDE eclipse, ouvrir le fichier **mainThreeStack** et l'executer.