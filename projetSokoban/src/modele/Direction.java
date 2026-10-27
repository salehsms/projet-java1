
package modele;


public enum Direction {


    HAUT(0,-1),
    BAS(0,1),
    GAUCHE(-1,0),
    DROITE(1,0);

    private final int dx ;
    private final int dy ;

    /**
     * Constructeurs du Direction 
     * @param dx l'abscisse x
     * @param dy  l'ordonée y
     */
    Direction(int dx ,int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * Retourne l'abscisse de cordonné x
     * @return abscise x
     */
    public int getDx() {
        return dx;
    }

    /**
     * Retourne l'ordonne de cordonné y
     * @return ordone y
     */

    public int getDy() {
        return dy;
    }

    
}
