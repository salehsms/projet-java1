package vueTexte;

import modele.Carte;

/**
 * Point d'entrée principal du sokoban en mode texte
 * Pour tester avec map1.txt écrite à la main (etape 5 ), déconnentez ce bloc 
 * correspondant pour charger depuis un fichier (etape 9+), utilisez le 
 * constructeur Carte(String nomFichier).
 */
public class SokobanTexte {
    private static final String[] NIVEAUX = {
        "map/map1.txt",
        "map/map2.txt",
        "map/map3.txt"
    };

    public static void main(String[] args) {
        // Etape 5: carte map1 écrite à la main(liste de chaines)
        
//        List<String> lignes = new ArrayList<>(); 
//        lignes.add("//####///");
//        lignes.add("###  ####");
//        lignes.add("#     $ #");
//        lignes.add("# #  #$ #");
//        lignes.add("# . .#@ #");
//        lignes.add("#########");
//        Carte carte = new Carte(lignes);

        // Etape 9+ : chargement dépuis un fichier
        // Ajustez le chemin du fichier.txt
        int debut = 0;
        if(args.length > 0) {
            try {
                debut = Integer.parseInt(args[0]) -1;
            }catch(NumberFormatException e) {

            }
        }
        for(int i=debut ; i < NIVEAUX.length ; i++) {
            System.out.println("\n==============================");
            System.out.println("  Niveau " + (i+1) + " : " + NIVEAUX[i]);
            System.out.println("==============================");
            Carte carte = new Carte(NIVEAUX[i]);
            ModeTexte mode = new ModeTexte(carte);
            boolean gagne = mode.jouer();

            if(!gagne) {
                break;
            }
            if(i < NIVEAUX.length -1) {
                System.out.println("\nPassage au niveau suivant...");
            }else {
                System.out.println("\nBravo ! Tous les niveau sont terminés !");
            }
        }
        
        

    }
}