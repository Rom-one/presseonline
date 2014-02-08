package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the facturation_dossier database table.
 * 
 */
@Embeddable
public class FacturationDossierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="dossier_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int dossierId;

	@Column(name="utilisateur_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int utilisateurId;

	public FacturationDossierPK() {
	}
	public int getDossierId() {
		return this.dossierId;
	}
	public void setDossierId(int dossierId) {
		this.dossierId = dossierId;
	}
	public int getUtilisateurId() {
		return this.utilisateurId;
	}
	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FacturationDossierPK)) {
			return false;
		}
		FacturationDossierPK castOther = (FacturationDossierPK)other;
		return 
			(this.dossierId == castOther.dossierId)
			&& (this.utilisateurId == castOther.utilisateurId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dossierId;
		hash = hash * prime + this.utilisateurId;
		
		return hash;
	}
}