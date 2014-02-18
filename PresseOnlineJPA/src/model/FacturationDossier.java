package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the facturation_dossier database table.
 * 
 */
@Entity
@Table(name="facturation_dossier")
@NamedQuery(name="FacturationDossier.findAll", query="SELECT f FROM FacturationDossier f")
public class FacturationDossier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FacturationDossierPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="facturation_dossier_date")
	private Date facturationDossierDate;

	@Column(name="facturation_dossier_titre")
	private String facturationDossierTitre;

	@Column(name="facturation_dossier_total")
	private double facturationDossierTotal;

	//bi-directional many-to-one association to Dossier
	@ManyToOne
	@JoinColumn(name="dossier_id")
	private Dossier dossier;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

	public FacturationDossier() {
	}

	public FacturationDossierPK getId() {
		return this.id;
	}

	public void setId(FacturationDossierPK id) {
		this.id = id;
	}

	public Date getFacturationDossierDate() {
		return this.facturationDossierDate;
	}

	public void setFacturationDossierDate(Date facturationDossierDate) {
		this.facturationDossierDate = facturationDossierDate;
	}

	public String getFacturationDossierTitre() {
		return this.facturationDossierTitre;
	}

	public void setFacturationDossierTitre(String facturationDossierTitre) {
		this.facturationDossierTitre = facturationDossierTitre;
	}

	public double getFacturationDossierTotal() {
		return this.facturationDossierTotal;
	}

	public void setFacturationDossierTotal(double facturationDossierTotal) {
		this.facturationDossierTotal = facturationDossierTotal;
	}

	public Dossier getDossier() {
		return this.dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}