package vueTexte;

import modele.*;

import java.util.*;


/**
 * Vue en mode texte du jeu Sokoban.
 * Gère :
 * les interaction clavier avec le joueur (z/q/s/d ou z/q/s/d)
 * le déroulement complet d'une partie 
 */
public class ModeTexte {

    private Carte carte;

    /** Association touche -> direction */
    private Map<Character , Direction> touches;
    
    /**
     * Constructeur 
     * @param carte le modèle de jeu à utiliser.
     */

    public ModeTexte(Carte carte) {
        this.carte = carte;

        // Mapping clavier: z=haut, s=bas, q=gauche, d=droite
        touches = new HashMap<>();
        touches.put('z', Direction.HAUT);
        touches.put('s', Direction.BAS);
        touches.put('q', Direction.GAUCHE);
        touches.put('d', Direction.DROITE);
    }

    /**
     * Demande au joueur d'appuyer sur une touche valide et retourne la direction associée.
     */
    /**
     * Demande au jouer d'appuyer sur une touche valide et retourne  la  direction  associée.
     * 
     * @return la direction associée.
     */
    private Character lireTouche() {
        while (true) {
            System.out.println("z=haut  s=bas  q=gauche  d=droite a=undo e=restart x=quitter\n");
            char c = Outil.lireCaractere();
            if (touches.containsKey(c) || c=='a' || c== 'e' || c== 'x') {
                return c;
            }
            System.out.println("Touche inconnue, veuillez réessayer.");
        }
    }

    /**
     * Affiche l'état courant de la carte avec le compteeur.
     */
    private void afficher() {
        System.out.println("\n" + carte.toString());
        System.out.println("Mouvements :" + carte.getNbMouvements());
    }

    /**
     * Lance et gère une partie complète en mode texte.
     * @return  true si gagné, false si le joueur a quitté
     */

   
    public boolean jouer() {
        System.out.println("=== SOKOBAN - Mode texte ===");
        System.out.println("z=haut  s=bas  q=gauche  d=droite a=undo e=restart x=quitter\n");

        while (!carte.finDePartie()) {
            afficher();
            char c = lireTouche();

            if (c == 'x') {
                System.out.println("Partie abandonnée.");
                    return false;
            } else if (c == 'a') {
                carte.undo();
                System.out.println("[Undo]");
            } else if (c == 'e') {
                carte.restart();
                System.out.println("[Restart]");
            } else {
                Direction dir = touches.get(c);
                if (!carte.deplacer(dir))
                    System.out.println("Mouvement impossible !");
            }
        }

        afficher();
        // Affichage de la carte finale gagnée
        System.out.println(carte.toString());
        System.out.println("*** Félicitations, vous avez gagné en " + carte.getNbMouvements() +" mouvements ! ***");
        return true;
    }
}