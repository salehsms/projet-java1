package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Lit un fichier de carte Sokoban et expose son contenu sous forme de liste de chaînes.
 */
public class Lecture {

    private List<String> lignes;
    private int nbLignes;
    private int tailleLigne;
    /**
     * Constructeur de la classe Lecture 
     * @param nomFichier  nom du fichier
     */

    public Lecture(String nomFichier) {
        lignes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + nomFichier);
            e.printStackTrace();
        }
        nbLignes = lignes.size();
        tailleLigne = nbLignes > 0 ? lignes.get(0).length() : 0;
    }
    /**
     * Accesseurs de lignes du fichier
     * @return la ligne à retourner
     */

    public List<String> getLignes() {
        return lignes;
    }
    /**
     * Accesseurs du nombre de ligne du fichier
     * @return le nombre de  ligne à retourner
     */

    public int getNbLignes() {
        return nbLignes;
    }
    /**
     * Accesseurs du taille de ligne
     * @return la ligne du taille
     */

    public int getTailleLigne() {
        return tailleLigne;
    }
}