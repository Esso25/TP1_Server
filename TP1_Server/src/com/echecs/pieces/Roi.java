package com.echecs.pieces;

import com.echecs.Position;
import com.echecs.util.EchecsUtil;

public class Roi extends Piece{

	public Roi(char couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		// TODO Auto-generated method stub
		byte ligneDepart = EchecsUtil.indiceLigne(pos1.getLigne());
	    byte colonneDepart = EchecsUtil.indiceColonne(pos1.getColonne());
	    byte ligneArrivee = EchecsUtil.indiceLigne(pos2.getLigne());
	    byte colonneArrivee = EchecsUtil.indiceColonne(pos2.getColonne());

	    // Vérifier le déplacement autorisé du roi (d'une seule case dans toutes les directions)
	    return (Math.abs(ligneArrivee - ligneDepart) <= 1 && Math.abs(colonneArrivee - colonneDepart) <= 1);
		
	}

}
