# Depot de TP7  

*** SALEH Mahamat Saleh**

## Avancement du tp 
Depuis j'avais commencé par l'arragement du dossier 
 
 ```
    -src/
        -modele
            -contient toutes les clases 
    -images
    -map
    -vuetext
        -SokobanTexte.java : classe principale qui contient la methode main
    -vueGraphique


 ```

 J'avais modilisé dans le mode texte, les # sont les murs representant `classe Mur `, les / du vide, @ est le robot represente `classe robot `, $ les caisses representent `classe caise `, (. les destinations ) par une classe `sol peut etre vide ou .`,
* une caisse sur une destination, + le robot sur une destination.


J'avais modélisé la case par une classe abtract `case.java`
Et aussi une autre abstract `ElemetMobille` permette de deplacer et donner sa fomer des ses classes qui les heritent (`robot et caises`) mais je pense que je dois amelioré car n'est pas encore très claire .

**Je me suis arrêté à l'etape 5 et 6 ****

# Générer la documentation pour tous les packages
```bash

javadoc -d doc -sourcepath src -subpackages modele:vueTexte:VueGraphique -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
```

## Compilation

Depuis la racine du projet (`sokoban/`) :

```bash

javac -d bin -sourcepath src src/modele/*.java src/vueTexte/*.java src/VueGraphique/*.java
```

## Lancement

### Mode texte

```bash
java -cp bin vueTexte.SokobanTexte
```

Commandes : `z`=haut · `s`=bas · `q`=gauche · `d`=droite · `a`=undo · `e`=restart · `x`=quitter

### Mode graphique

```bash
java -cp bin VueGraphique.Sokoban
```

Commandes : flèches directionnelles · `U`=undo · `R`=restart

## Création des JARs (dépôt final)

```bash
# JAR graphique
jar cfe sokobanSalehMahamatSaleh.jar VueGraphique.Sokoban -C bin . -C . map -C . images

# JAR texte
jar cfe sokobanTexteSalehMahamatSaleh.jar vueTexte.SokobanTexte -C bin . -C . map

# Lancement
java -jar sokobanSalehMahamatSaleh.jar

java -jar sokobanTexteSalehMahamatSaleh.jar