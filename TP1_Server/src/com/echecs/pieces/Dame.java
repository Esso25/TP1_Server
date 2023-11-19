package com.echecs.pieces;

import com.echecs.Position;
import com.echecs.util.EchecsUtil;

public class Dame extends Piece {

	public Dame(char couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		// TODO Auto-generated method stub
		byte ligneInitiale = EchecsUtil.indiceLigne(pos1.getLigne());
        byte colonneInitiale = EchecsUtil.indiceColonne(pos1.getColonne());
        byte ligneFinale = EchecsUtil.indiceLigne(pos2.getLigne());
        byte colonneFinale = EchecsUtil.indiceColonne(pos2.getColonne());

        // Vérifier si le déplacement est valide pour une dame
        if ((ligneInitiale == ligneFinale || colonneInitiale == colonneFinale) ||
            Math.abs(ligneFinale - ligneInitiale) == Math.abs(colonneFinale - colonneInitiale)) {

            // Vérification des obstacles
            if (!estObstacleSurTrajectoire(pos1, pos2, echiquier)) {
                // Vérification de la capture de pièce adverse ou déplacement simple
                Piece pieceFinale = echiquier[ligneFinale][colonneFinale];
                return (pieceFinale == null || pieceFinale.getCouleur() != getCouleur());
            }
        }
        return false;
	}
	
	private boolean estObstacleSurTrajectoire(Position pos1, Position pos2, Piece[][] echiquier) {
        // Récupérer les positions initiale et finale
        byte ligneInitiale = EchecsUtil.indiceLigne(pos1.getLigne());
        byte colonneInitiale = EchecsUtil.indiceColonne(pos1.getColonne());
        byte ligneFinale = EchecsUtil.indiceLigne(pos2.getLigne());
        byte colonneFinale = EchecsUtil.indiceColonne(pos2.getColonne());

        int diffLigne = (ligneFinale - ligneInitiale > 0) ? 1 : ((ligneFinale - ligneInitiale < 0) ? -1 : 0);
        int diffColonne = (colonneFinale - colonneInitiale > 0) ? 1 : ((colonneFinale - colonneInitiale < 0) ? -1 : 0);

        byte ligne = (byte) (ligneInitiale + diffLigne);
        char colonne = (char) (colonneInitiale + diffColonne);

        while (ligne != ligneFinale || colonne != colonneFinale) {
            if (echiquier[ligne][colonne] != null) {
                return true; 
            }
            ligne += diffLigne;
            colonne += diffColonne;
        }
        return false; 
    }

}
