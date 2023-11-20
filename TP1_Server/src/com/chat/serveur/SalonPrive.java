package com.chat.serveur;

import com.echecs.PartieEchecs;

public class SalonPrive {
    private PartieEchecs partieEchecs;
	String aliasHote,aliasInvite;

    public SalonPrive(String aliasHote, String aliasInvite) {
        this.aliasHote = aliasHote;
        this.aliasInvite = aliasInvite;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SalonPrive sp = (SalonPrive) obj;
        return aliasInvite.equals(sp.aliasInvite) && aliasHote.equals(sp.aliasHote);
    }

	public PartieEchecs getPartieEchecs() {
		return partieEchecs;
	}

	public void setPartieEchecs(PartieEchecs partieEchecs) {
		this.partieEchecs = partieEchecs;
	}

}
