package modele;

import java.util.*;

/**
 * La carte d'un niveau Sokoban.
 *
 * Contient la grille d'éléments fixes (murs, sol, destinations, vide),
 * le robot et les caisses (stockés sur les éléments de la grille).
 * Mémorise aussi les coordonnées des destinations pour tester la fin de partie.
 */
public class Carte {

    private Element[][] grille;
    private int nbLignes;
    private int nbColonnes;
    private Robot robot;

    // Lignes brutes conservées pour restart donc il s'agit étape 24.
    private List<String> lignesOriginales ;

    // Coordonnées des destinations (pour finDePartie)
    private List<int[]> destinations; 
    // Compteur de mouvement valides etape 22.
    private int nbMouvements;
    // Undo : snapshot de l'état avant le dernier mouvement 
    private boolean [][] snapshotCaisses;
    private boolean [][] snapshotJoueur ;
    private int snapshotRobotCol;
    private int snapshotRobotLig;
    private Direction snapshotRobotDir;
    private boolean undoDisponible;


    /**
     * Construction à partir d'une liste de chaînes
     * @param lignesTexte  liste de chaînes
     */

    public Carte(List<String> lignesTexte) {
        this.lignesOriginales = new ArrayList<>(lignesTexte);
        construire(lignesTexte);
    }

    /**
     * Construction à partir d'un nom de fichier (étape 9)
     * @param nomFichier le fichier peut etre map1.txt , map2.txt ou map3.txt
     */

    public Carte(String nomFichier) {
        Lecture lecture = new Lecture(nomFichier);
        this.lignesOriginales = new ArrayList<>(lecture.getLignes());
        construire(lignesOriginales);
    }


    /**
     * Méthode interne de construction de la grille
     * @param lignesTexte liste de la ligne la plus longue (sécurité).
     */

    private void construire(List<String> lignesTexte) {
        nbLignes = lignesTexte.size();
        // Largeur = longueur de la ligne la plus longue (sécurité)
        int maxCol = 0;
        for (String l : lignesTexte) {
            if (l.length() > maxCol) maxCol = l.length();
        }
        nbColonnes = maxCol;

        grille = new Element[nbLignes][nbColonnes];
        destinations = new ArrayList<>();
        nbMouvements = 0;
        undoDisponible = false;

        for (int lig = 0; lig < nbLignes; lig++) {
            String ligne = lignesTexte.get(lig);
            for (int col = 0; col < nbColonnes; col++) {
                char c = col < ligne.length() ? ligne.charAt(col) : '/';
                grille[lig][col] = creerElement(c, col, lig);
            }
        }
    }

    /**
     * Crée l'élément correspondant au caractère lu dans le fichier de carte.
     * Positionne le robot et les caisses directement sur la grille.
     * @param c caractère lu dans le fichier de carte
     * @param col colonne de la Positionne sur la carte
     * @param lig ligne de la Positionne sur la carte
     * @return l'element correspondant au caractere lu 
     */
    private Element creerElement(char c, int col, int lig) {
        switch (c) {
            case '#': return new Mur();
            case '/': return new Vide();
            case ' ': return new Sol();
            case '.': {
                destinations.add(new int[]{col, lig});
                return new Destination();
            }
            case '$': {
                Sol sol = new Sol();
                sol.setCaisse(true);
                return sol;
            }
            case '@': {
                Sol sol = new Sol();
                robot = new Robot(col, lig);
                sol.setJoueur(true);
                return sol;
            }
            case '*': {
                // caisse sur destination
                
                destinations.add(new int[]{col, lig});
                Destination d = new Destination();
                d.setCaisse(true);
                return d;
            }
            case '+': {
                // robot sur destination
                
                destinations.add(new int[]{col, lig});
                Destination d = new Destination();
                d.setJoueur(true);
                robot = new Robot(col, lig);
                return d;
            }
            default: return new Vide();
        }
    }

    // Déplacement du robot étape 14

    /**
     * Tente de déplacer le robot dans la direction donnée.
     * Gère le cas où une caisse est devant le robot.
     *@param dir la direction donnée
     * @return true si le déplacement a eu lieu, false sinon.
     */
    public boolean deplacer(Direction dir) {
        int rc = robot.getCol();
        int rl = robot.getLigne();

        int nc = rc + dir.getDx(); // case visée
        int nl = rl + dir.getDy();

        if (!estDansGrille(nc, nl)) {
            return false;
        }
        Element caseVisee = grille[nl][nc];

        if (!caseVisee.estFranchissable()) {
            return false;
        }
        // Snapshot avant modification undo
        sauvegarderEtat();

        if (caseVisee.aCaisse()) {
            // Il faut pousser la caisse
            int cc = nc + dir.getDx();
            int cl = nl + dir.getDy();
            if (!estDansGrille(cc, cl)){
                 return false;
            }
            Element caseCaisse = grille[cl][cc];
            if (!caseCaisse.estFranchissable() || caseCaisse.aCaisse()){
                undoDisponible = false;
                 return false;
            }
            // Déplacement de la caisse
            caseVisee.setCaisse(false);
            caseCaisse.setCaisse(true);
        }

        // Déplacement du robot
        grille[rl][rc].setJoueur(false);
        caseVisee.setJoueur(true);
        robot.setPosition(nc, nl);
        robot.setDirection(dir);
        nbMouvements ++ ;
        undoDisponible = true;

        return true;
    }
    /**
     * Methode qui permette de verifier l'etat du grille
     * @param col la colonne du grille
     * @param ligne ligne du grille
     * @return true s'il est dans la grille si non false.
     */

    private boolean estDansGrille(int col, int ligne) {
        return col >= 0 && col < nbColonnes && ligne >= 0 && ligne < nbLignes;
    }

    
    /**
     * La methode étape 23 Undo.
     */

    private void sauvegarderEtat() {
        snapshotCaisses = new boolean[nbLignes][nbColonnes];
        snapshotJoueur = new boolean[nbLignes][nbColonnes];

        for(int lig =0 ; lig < nbLignes; lig++) {
            for(int col=0 ; col< nbColonnes ; col++) {
                snapshotCaisses[lig][col] = grille[lig][col].aCaisse();
                snapshotJoueur[lig][col] = grille[lig][col].aJoueur();

            }

        }
        snapshotRobotCol = robot.getCol();
        snapshotRobotLig = robot.getLigne();
        snapshotRobotDir = robot.getDirection();
    }

    /** Annule le dernier mouvement c'est à dire un seul niveau d'undo. */
    public void undo() {
        if(!undoDisponible) {
            return ;
        }
        for(int lig =0 ; lig < nbLignes; lig++) {
            for(int col=0 ; col< nbColonnes ; col++) {
                grille[lig][col].setCaisse(snapshotCaisses[lig][col]);
                grille[lig][col].setJoueur(snapshotJoueur[lig][col]);

            }
        }
        robot.setPosition(snapshotRobotCol, snapshotRobotLig);
        robot.setDirection(snapshotRobotDir);
        if(nbMouvements > 0) {
            nbMouvements --;
            undoDisponible = false;
        }

    }

    /**
     * La methode verifie undo 
     * @return si undo est diponible
     * 
     */
    public boolean isUndoDisponible() {
        return undoDisponible;
    }

    // Restart étape 24
    /** Recharge entièrement la carte à son état initial. */
    public void restart() {
        construire(lignesOriginales);
    }

    // Fin de partie (étape 18)

    /**
     * La partie est gagnée quand chaque destination est couverte par une caisse.
     * @return true  destination est couverte par une caisse.
     */
    public boolean finDePartie() {
        for (int[] pos : destinations) {
            if (!grille[pos[1]][pos[0]].aCaisse()){
                return false;
            }
        }
        return true;
    }


    // Accesseurs utiles pour la vue

    /**
     * Accesseurs la ligne  du carte 
     * @return la ligne
     */
    public int getNbLignes(){
         return nbLignes;
    }
    /**
     * Accesseurs la valeur du colonne.
     * @return la valeur retournée
     */
    public int getNbColonnes(){
         return nbColonnes;
    }
    /**
     * Retourne l'élement en fonction de ligne et colonne
     * @param col la colonne
     * @param ligne la ligne
     * @return élement retourné
     */
    public Element getElement(int col, int ligne){
        return grille[ligne][col];
    }
    /**
     * Accesseurs le robot
     * @return  le robot 
     */
    public Robot getRobot(){ 
        return robot; 
    }
    /**
     * Accesseurs  du mouvement du robot
     * @return nombres des mouvements effectué par le robot.
     */
    public int getNbMouvements(){
        return nbMouvements;
    }

    /**
     * Affichage texte (étape 6)
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int lig = 0; lig < nbLignes; lig++) {
            for (int col = 0; col < nbColonnes; col++) {
                sb.append(grille[lig][col].toString());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}