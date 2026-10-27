package modele;

/**
 * Le robot (joueur) du jeu Sokoban.
 * Mémorise sa position (colonne, ligne) et la dernière direction prise
 * (utile pour choisir la bonne image dans la vue graphique).
 */
public class Robot {

    private int col;
    private int ligne;
    private Direction direction;
    /**
     * initialistion  du robot
     * @param col colonne initiale du robot.
     * @param ligne ligne initiale du robot.
     */

    public Robot(int col, int ligne) {
        this.col = col;
        this.ligne = ligne;
        this.direction = Direction.BAS; // orientation par défaut
    }

    /**
     * Accesseurs de colonne
     * @return la colonne
     */
    public int getCol() {
        return col;
    }

    /**
     * Accesseurs de ligne
     * @return la ligne retournée
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Accesseur de direction du robot
     * @return la direction à retourner
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Modifie la position en fonction de ligne et colonne du robot
     * @param col la colonne donnée
     * @param ligne la ligne donnée
     */

    public void setPosition(int col, int ligne) {
        this.col = col;
        this.ligne = ligne;
    }
    /**
     * Modifie la direction du robot
     * @param direction la direction attribuée au robot
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}