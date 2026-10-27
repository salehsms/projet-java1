package VueGraphique;
import javax.swing.*;
import java.util.*;
import java.awt.*;

import modele.Robot;
import modele.Element;
import modele.Direction;
import modele.Destination;
import modele.Carte;


/**
 * Panneau Swing qui affiche graphiquement une carte Sokoban.
 * 
 * Etapes couvertes: 19 et 21.
 */
public class VueSokoban extends JPanel {


    /** Taille en pixels d'une case de la grille. */
    public static final int TAILLE_CASE = 48; // pixels par case


    private Carte carte ;

    // Images des élement fixes

    private Image imgMur ;
    private Image imgSol;
    private Image imgDestination;
    private Image imgVide; // Case transparente

    // Images du robot selon la direction  étape 21

    private Map<Direction ,Image> ImagesRobot;

    // Images des caisses

    private Image imgCaisse;// caisse sur sol
    private Image imgCaisseOK; // caisse sur destination 
    /**
     * Constructeur 
     * @param carte Le modele du jeu  à afficher.
     */

    public VueSokoban( Carte carte) { 
        this.carte = carte;
        chargerImages();

        setPreferredSize(new Dimension(
            carte.getNbColonnes()*TAILLE_CASE,
            carte.getNbLignes()*TAILLE_CASE
        ));
        setBackground(Color.BLACK);
        
    }

    // Chargement des images

    private void chargerImages() {
        imgMur = charger("images/img/mur.gif");
        imgSol = charger("images/img/sol.gif");
        imgDestination = charger("images/img/but.gif");


        imgCaisse = charger("images/img/caisse1.gif");
        imgCaisseOK = charger("images/img/caisse2.gif");

        ImagesRobot = new HashMap<>();
        ImagesRobot.put(Direction.HAUT, charger("images/img/Haut.gif"));
        ImagesRobot.put(Direction.BAS, charger("images/img/Bas.gif"));
        ImagesRobot.put(Direction.GAUCHE, charger("images/img/Gauche.gif"));
        ImagesRobot.put(Direction.DROITE, charger("images/img/Droite.gif"));
    }

    /**
     * Charge un image depuis le chemin donné 
     * @param chemin le chemin donné relatif au répertoire de lancement
     * @return image chrgée 
     */

    private Image charger(String chemin) {
        ImageIcon icon = new ImageIcon(chemin);
        if(icon.getIconWidth() <= 0) {
            // essai depuis le classpath
            java.net.URL url = getClass().getClassLoader().getResource(chemin);
            if(url != null) {
                icon = new ImageIcon(url);
            }
        }
        return icon.getImage();


    }

    // Dessin 
    @Override 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Robot robot = carte.getRobot();

        for(int lig = 0 ; lig < carte.getNbLignes(); lig++) {
            for(int col=0 ; col < carte.getNbColonnes(); col++) {
                int px = col*TAILLE_CASE;
                int py = lig*TAILLE_CASE;

                Element e = carte.getElement(col, lig);

                // 1. Fond de la case
                Image fond = imageFond(e);
                if(fond != null) {
                    g.drawImage(fond, px, py,TAILLE_CASE, TAILLE_CASE, this);
                }
                // Occupant
                if(e.aJoueur()) {
                    Direction dir = robot.getDirection();
                    Image imgRobot = ImagesRobot.getOrDefault(dir, ImagesRobot.get(Direction.BAS));
                    if (imgRobot != null){
                        g.drawImage(imgRobot, px, py, TAILLE_CASE, TAILLE_CASE, this);
                    }
                } else if (e.aCaisse()) {
                    // Caisse : verte si sur destination
                    Image imgC = (e instanceof Destination) ? imgCaisseOK : imgCaisse;
                
                    if (imgC != null){
                        g.drawImage(imgC, px, py, TAILLE_CASE, TAILLE_CASE, this);
                    }
                }

            }
        }


    }

    /**
     * 
     */

    private Image imageFond(Element e) {
        if(e instanceof modele.Mur) {
            return imgMur;
        }
        if(e instanceof Destination) {
            return imgDestination;
        }
        if(e instanceof modele.Sol) {
            return imgSol;
        }
        return null;

    }

    // Mise à jour 
    /**
     * Met à jour l'affichage après un changement dans le modéle.
     */

    public void mettreAJour() {
        repaint();
    }

    /**
     * 
     * @param carte le nouveau modèle à afficher
     */

    public void setCarte(Carte carte) {
        this.carte = carte;
        setPreferredSize( new Dimension(
            carte.getNbColonnes()*TAILLE_CASE,
            carte.getNbLignes()*TAILLE_CASE

        ));
        revalidate();
        repaint();
    }
    
}
