package modele;
/**
 * Une destination : emplacement où une caisse doit être déposée.
 * Représentée par '.' dans les fichiers de carte.
 */
public class Destination  extends Element {

    /**
     * La methode qui verifie la destination
     * @return ture est franchissabble false si non
     */
    public boolean estFranchissable() {
        return true;
    }

    /**
     * La methode qui symbolise les élements
     * @return le symbole de destination
     */
    public char toChar() {
        return '.';
    }
    
}
