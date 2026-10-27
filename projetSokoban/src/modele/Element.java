package modele;

/**
 * Classe abstraite représentant un élément fixe d'une carte Sokoban.
 * Un élément peut potentiellement accueillir un joueur ou une caisse (s'il est un sol ou destination).
 */
public abstract class Element {

    protected boolean aJoueur;
    protected boolean aCaisse;

    /**
     * Constructeur par defaut. Initialise sans joueur ni caisse.
     */
    public Element() {
        this.aJoueur = false;
        this.aCaisse = false;
    }
    /**
     * 
     * @return true si un joueur est sur cet element.
     */

    public boolean aJoueur() {
        return aJoueur;
    }
    /**
     * 
     * @return true si une caisse est sur cet élément.
     */

    public boolean aCaisse() {
        return aCaisse;
    }
    /**
     * 
     * @param aJoueur true pour placer un joueur sur cet élément. 
     */

    public void setJoueur(boolean aJoueur) {
        this.aJoueur = aJoueur;
    }
    /**
     * 
     * @param aCaisse true pour placer une caisse sur cet élément.
     */

    public void setCaisse(boolean aCaisse) {
        this.aCaisse = aCaisse;
    }

    /**
     * Indique si cet élément est franchissable (sol ou destination).
     */
    public abstract boolean estFranchissable();

    /**
     * Retourne le caractère associé à cet élément pour l'affichage texte.
     */
    public abstract char toChar();

    @Override
    public String toString() {
        if (aJoueur && aCaisse) return String.valueOf(toChar()); // ne devrait pas arriver
        if (aJoueur) {
            // '+' si joueur sur destination, '@' sinon
            if (this instanceof Destination) return "+";
            return "@";
        }
        if (aCaisse) {
            // '*' si caisse sur destination, '$' sinon
            if (this instanceof Destination) return "*";
            return "$";
        }
        return String.valueOf(toChar());
    }
}