package com.echecs.pieces;

import com.echecs.Position;

public class Cavalier extends Piece{

	public Cavalier(char couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		// TODO Auto-generated method stub
		// Vérification du déplacement du Cavalier
        int diffLignes = Math.abs(pos2.getLigne() - pos1.getLigne());
        int diffColonnes = Math.abs(pos2.getColonne() - pos1.getColonne());

        // Le Cavalier se déplace en L : soit diffLignes vaut 2 et diffColonnes vaut 1, soit l'inverse
        return (diffLignes == 2 && diffColonnes == 1) || (diffLignes == 1 && diffColonnes == 2);
    
	}

}
