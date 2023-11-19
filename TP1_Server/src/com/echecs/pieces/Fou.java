package com.echecs.pieces;

import com.echecs.Position;
import com.echecs.util.EchecsUtil;

public class Fou extends Piece {

	public Fou(char couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		// TODO Auto-generated method stub
		int diffLignes = Math.abs(pos2.getLigne() - pos1.getLigne());
        int diffColonnes = Math.abs(pos2.getColonne() - pos1.getColonne());

        // Le Fou se déplace en diagonale : les différences entre les lignes et colonnes sont égales
        return diffLignes == diffColonnes && cheminLibre(pos1, pos2, echiquier);
	}
	private boolean cheminLibre(Position pos1, Position pos2, Piece[][] echiquier) {
        int dirLigne = (pos2.getLigne() > pos1.getLigne()) ? 1 : -1;
        int dirColonne = (pos2.getColonne() > pos1.getColonne()) ? 1 : -1;

        int i = pos1.getLigne() + dirLigne;
        int j = pos1.getColonne() + dirColonne;

        while (i != pos2.getLigne() || j != pos2.getColonne()) {
            if (echiquier[i - 1][EchecsUtil.indiceColonne((char) ('a' + j - 1))] != null) {
                // Si une pièce est présente sur le chemin, le déplacement n'est pas valide
                return false;
            }
            i += dirLigne;
            j += dirColonne;
        }
        return true;
    }

}
