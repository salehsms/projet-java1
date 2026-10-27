package VueGraphique;


import modele.Carte;
import modele.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Fenêtre principale du Sokoban graphique.
 * Etapes couvertes: 19 jusqu'au 25 étape.
 */

public class Sokoban extends JFrame implements KeyListener {

    private static final String[] NIVEAUX = {
        "map/map1.txt",
        "map/map2.txt",
        "map/map3.txt"
    };

    private int niveauCourant = 0;

    // pour le modéle et vue
    private Carte carte;
    private VueSokoban vue;

    private JLabel labelStatut;
    private JLabel labelMouvements;
    private JButton btnUndo ;
    private JButton btnRestart;

    private JComboBox<String> comboNiveau ;
    /** Construit et affiche la fenêtre principale du jeu.*/

    public Sokoban() {
        super("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        chargerNiveau(niveauCourant);
        construireUI();

        addKeyListener(this);
        setFocusable(true);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);


    }

    /**
     * Construction de l'interface
     */
    private void construireUI() {
        setLayout(new BorderLayout());

        // Panneau de jeu
        vue = new VueSokoban(carte);
        add(vue , BorderLayout.CENTER);

        // Barre d'outils nord
        JPanel barreOutils = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        barreOutils.setBackground(new Color(40,40,60));

        // Sélecteur de niveau

        String[] nomNiveau = {
            "Niveau 1",
            "Niveau 2",
            "Niveau 3"
        };

        comboNiveau = new JComboBox<>(nomNiveau);
        comboNiveau.setSelectedIndex(niveauCourant);
        comboNiveau.setFocusable(false);
        comboNiveau.addActionListener(e-> {
            int index = comboNiveau.getSelectedIndex();
            if(index != niveauCourant) {
                niveauCourant = index;
                chargerNiveau(niveauCourant);
                vue.setCarte(carte);
                mettreAJourStatus();
                labelStatut.setText("En jeu");
                labelStatut.setForeground(Color.LIGHT_GRAY);
                redimensionnerFenetre();
                requestFocusInWindow();
            }
        });

        btnUndo = creeButton("Undo (U)", new Color(80, 120, 180));
        btnUndo.addActionListener(e -> { undo(); requestFocusInWindow(); });

        btnRestart = creeButton("Restart (R)", new Color(180, 100, 60));
        btnRestart.addActionListener(e -> { restart(); requestFocusInWindow(); });

        barreOutils.add(labelBlanc("Niveau :"));
        barreOutils.add(comboNiveau);
        barreOutils.add(Box.createHorizontalStrut(20));
        barreOutils.add(btnUndo);
        barreOutils.add(btnRestart);
        add(barreOutils, BorderLayout.NORTH);

        // ── Barre de statut (sud)
        JPanel barreStatut = new JPanel(new BorderLayout());
        barreStatut.setBackground(new Color(30, 30, 50));
        barreStatut.setBorder(BorderFactory.createEmptyBorder(3, 8, 3, 8));

        labelStatut    = new JLabel("En jeu");
        labelMouvements = new JLabel("Mouvements : 0");
        labelStatut.setForeground(Color.LIGHT_GRAY);
        labelMouvements.setForeground(Color.LIGHT_GRAY);

        barreStatut.add(labelStatut,     BorderLayout.WEST);
        barreStatut.add(labelMouvements, BorderLayout.EAST);
        add(barreStatut, BorderLayout.SOUTH);




    }
    /**
     * Création du bouton 
     * @param texte la texte du bouton 
     * @param couleur la couleur choisie
     * @return le bouton crée
     */

    private JButton creeButton(String texte , Color couleur) {
        JButton b = new JButton(texte);
        b.setBackground(couleur);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFocusable(false);  
        b.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));


        return b;
    }

    private JLabel labelBlanc(String texte) {
        JLabel l = new JLabel(texte);
        l.setForeground(Color.LIGHT_GRAY);

        return l;

    }

    // Chargement d'un niveau étape 25.

    private void chargerNiveau(int index) {
        carte = new Carte(NIVEAUX[index]);
        setTitle("Sokoban - " + nomNiveau(index));
    }


    private String nomNiveau(int index) {
        return "Niveau "+ (index+1);
    }

    // Actions de jeu

    private void undo() {
        carte.undo();
        vue.mettreAJour();
        mettreAJourStatus();
    }


    private void restart() {
        carte.restart();
        vue.mettreAJour();
        mettreAJourStatus();
        labelStatut.setText("Niveau redémarré");
        labelStatut.setForeground(Color.ORANGE);

    }

    private void mettreAJourStatus() {
        labelMouvements.setText("Mouvements : "+ carte.getNbMouvements());
        btnUndo.setEnabled(carte.isUndoDisponible());
    }

    // Fin de partie et passage au niveau suivant étape 25

    private void verifierFinDePartie() {
        if(! carte.finDePartie()) {
            return;
        }
        labelStatut.setText("Gagné en "+ carte.getNbMouvements() + " mouvements !");
        labelStatut.setForeground(new Color(80,220, 80));
        vue.mettreAJour();

        // Passer au niveau suivant aprés une courte pause
        int suivant = niveauCourant +1;
        if(suivant < NIVEAUX.length) {
            Timer timer = new Timer(1800, e -> {
                niveauCourant = suivant;
                chargerNiveau(niveauCourant);
                vue.setCarte(carte);
                comboNiveau.setSelectedIndex(niveauCourant);
                mettreAJourStatus();
                labelStatut.setText("Niveau " + (niveauCourant + 1) + " – En jeu");
                labelStatut.setForeground(Color.LIGHT_GRAY);
                pack();
                setLocationRelativeTo(null);
                requestFocusInWindow();
            });
            timer.setRepeats(false);
            timer.start();
            
        }else {
            // Tous les niveaux terminés
            Timer timer = new Timer(1000, e ->
                JOptionPane.showMessageDialog(this,
                    "Félicitations ! Vous avez terminé tous les niveaux !",
                    "Sokoban – Victoire !",
                    JOptionPane.INFORMATION_MESSAGE)
            );
            timer.setRepeats(false);
            timer.start();
        

        }
    }

    // Gestion des touches étapes 20,23,24

    public void keyPressed(KeyEvent e) {
        Direction dir = null;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dir = Direction.HAUT;
                break;

            case KeyEvent.VK_DOWN:
                dir = Direction.BAS;
                break;

            case KeyEvent.VK_LEFT:
                dir = Direction.GAUCHE;
                break;

            case KeyEvent.VK_RIGHT:
                dir = Direction.DROITE;
                
                break;
            case KeyEvent.VK_U:
                undo();
                return;

            case KeyEvent.VK_R:
                restart();
                
                return;
        
            default:
                return;
        }

        if(dir != null && !carte.finDePartie()) {
            boolean bouge = carte.deplacer(dir);
            if(bouge) {
                vue.mettreAJour();
                mettreAJourStatus();
                labelStatut.setText("En jeu");
                labelStatut.setForeground(Color.LIGHT_GRAY);
                verifierFinDePartie();
            }
        }
    }

    /**
     * Adapte la taille de la fenêtre exactement à la nouvelle carte,
     * puis la recentre à l'écran.
     * Doit être appelé sur l'EDT (Event Dispatch Thread).
     */
    private void redimensionnerFenetre() {
        // Forcer le panneau à recalculer sa taille préférée
        int largeur = carte.getNbColonnes() * VueSokoban.TAILLE_CASE;
        int hauteur = carte.getNbLignes()   * VueSokoban.TAILLE_CASE;
        vue.setPreferredSize(new Dimension(largeur, hauteur));
        vue.revalidate();

        // pack() recalcule la taille totale de la JFrame
        // (panneau de jeu + barre d'outils + barre de statut)
        pack();

        // Recentrer la fenêtre sur l'écran
        setLocationRelativeTo(null);
    }

    @Override
     public void keyReleased(KeyEvent e) {}

    @Override 
    public void keyTyped(KeyEvent e) {}

    /** Point d'entrée principal de la version graphique. */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sokoban::new);
        
    }
    
}
