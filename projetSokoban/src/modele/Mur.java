package modele;

/**
 * Un mur : infranchissable, répresenté par '#'.
 */


public class Mur extends Element  {

    /** Constructeur par défaut. */
    public Mur() {}
    
    public boolean estFranchissable() {
        return false;
    }


    public char toChar() {
        return '#';
    }
    
}
