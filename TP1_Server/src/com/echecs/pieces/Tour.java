package com.echecs.pieces;

import com.echecs.Position;
import com.echecs.util.EchecsUtil;

public class Tour extends Piece {

	public Tour(char couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		int ligne1 = EchecsUtil.indiceLigne(pos1.getLigne());
        int colonne1 = EchecsUtil.indiceColonne(pos1.getColonne());
        int ligne2 = EchecsUtil.indiceLigne(pos2.getLigne());
        int colonne2 = EchecsUtil.indiceColonne(pos2.getColonne());

        // Vérification du déplacement de la tour
        if (ligne1 == ligne2 || colonne1 == colonne2) {
            return !estObstacle(ligne1, colonne1, ligne2, colonne2, echiquier);
        }
        return false; // Mouvement invalide pour une tour
    }

    private boolean estObstacle(int ligne1, int colonne1, int ligne2, int colonne2, Piece[][] echiquier) {
        // Vérification des obstacles sur la ligne ou la colonne
        if (ligne1 == ligne2) {
            int start = Math.min(colonne1, colonne2);
            int end = Math.max(colonne1, colonne2);
            for (int j = start + 1; j < end; j++) {
                if (echiquier[ligne1][j] != null) {
                    return true; // Il y a un obstacle
                }
            }
        } else {
            int start = Math.min(ligne1, ligne2);
            int end = Math.max(ligne1, ligne2);
            for (int i = start + 1; i < end; i++) {
                if (echiquier[i][colonne1] != null) {
                    return true; // Il y a un obstacle
                }
            }
        }
        return false; // Pas d'obstacle
    }
	}
	


