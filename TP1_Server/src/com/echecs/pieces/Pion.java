package com.echecs.pieces;

import com.echecs.Position;
import com.echecs.util.EchecsUtil;

public class Pion extends Piece {
	 public Pion(char couleur) {
	        super(couleur);
	    }

	    

		@Override
		public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
			int ligne1 = EchecsUtil.indiceLigne(pos1.getLigne());
	        int colonne1 = EchecsUtil.indiceColonne(pos1.getColonne());
	        int ligne2 = EchecsUtil.indiceLigne(pos2.getLigne());
	        int colonne2 = EchecsUtil.indiceColonne(pos2.getColonne());

	        int direction = (getCouleur() == 'b') ? 1 : -1;

	        // On vérifie le déplacement du pion
	        // Si le déplacement est en avant d'une case
	        if (colonne1 == colonne2 && ligne2 - ligne1 == direction) {
	            if (echiquier[ligne2][colonne2] == null) {
	                return true; 
	            } else {
	                return false; 
	            }
	        } else if (Math.abs(colonne2 - colonne1) == 1 && ligne2 - ligne1 == direction) {
	            // Si le déplacement est en diagonale pour capturer une pièce
	            if (echiquier[ligne2][colonne2] != null && echiquier[ligne2][colonne2].getCouleur() != getCouleur()) {
	                return true; 
	            }
	        }
	        return false; 
	    }
		}

