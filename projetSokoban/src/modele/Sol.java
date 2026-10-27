package modele;

/**
 * Un sol ordinaire : franchissable , peut accuellir joueur ou caisse.
 */
public class Sol extends Element{
    /** Constructeur par défaut. */
    public Sol() {}
    
    public boolean estFranchissable() {
        return true;
    }


    public char toChar() {
        return ' ';
    }
}
