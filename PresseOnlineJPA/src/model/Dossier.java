package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the dossier database table.
 * 
 */
@Entity
@Table(name="dossier")
@NamedQuery(name="Dossier.findAll", query="SELECT d FROM Dossier d")
public class Dossier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dossier_id", unique=true, nullable=false)
	private int dossierId;

	@Column(name="dossier_prix", precision=10, scale=2)
	private BigDecimal dossierPrix;

	@Column(name="dossier_titre", nullable=false, length=100)
	private String dossierTitre;

	//bi-directional many-to-many association to Article
	@ManyToMany
	@JoinTable(
		name="dossier_article"
		, joinColumns={
			@JoinColumn(name="dossier_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="article_id", nullable=false)
			}
		)
	private List<Article> articles;

	//bi-directional many-to-one association to FacturationDossier
	@OneToMany(mappedBy="dossier")
	private List<FacturationDossier> facturationDossiers;

	public Dossier() {
	}

	public int getDossierId() {
		return this.dossierId;
	}

	public void setDossierId(int dossierId) {
		this.dossierId = dossierId;
	}

	public BigDecimal getDossierPrix() {
		return this.dossierPrix;
	}

	public void setDossierPrix(BigDecimal dossierPrix) {
		this.dossierPrix = dossierPrix;
	}

	public String getDossierTitre() {
		return this.dossierTitre;
	}

	public void setDossierTitre(String dossierTitre) {
		this.dossierTitre = dossierTitre;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<FacturationDossier> getFacturationDossiers() {
		return this.facturationDossiers;
	}

	public void setFacturationDossiers(List<FacturationDossier> facturationDossiers) {
		this.facturationDossiers = facturationDossiers;
	}

	public FacturationDossier addFacturationDossier(FacturationDossier facturationDossier) {
		getFacturationDossiers().add(facturationDossier);
		facturationDossier.setDossier(this);

		return facturationDossier;
	}

	public FacturationDossier removeFacturationDossier(FacturationDossier facturationDossier) {
		getFacturationDossiers().remove(facturationDossier);
		facturationDossier.setDossier(null);

		return facturationDossier;
	}

}