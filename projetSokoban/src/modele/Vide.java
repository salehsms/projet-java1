package modele;

/**
 * Vide représente par '/' dans les fichiers de carte.
 * Infranchissable : hors du périmetre jouble.
 */
public class Vide extends Element {

    /** Constructeur par défaut. */
    public Vide() {}


    public boolean estFranchissable() {
        return false;
    }


    public char toChar() {
        return '/';
    }


    
}
