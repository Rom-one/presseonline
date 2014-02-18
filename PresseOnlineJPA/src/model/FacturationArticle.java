package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the facturation_article database table.
 * 
 */
@Entity
@Table(name="facturation_article")
@NamedQuery(name="FacturationArticle.findAll", query="SELECT f FROM FacturationArticle f")
public class FacturationArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FacturationArticlePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="facturation_article_date")
	private Date facturationArticleDate;

	@Column(name="facturation_article_titre")
	private String facturationArticleTitre;

	@Column(name="facturation_article_total")
	private double facturationArticleTotal;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

	public FacturationArticle() {
	}
	
	

	public FacturationArticlePK getId() {
		return this.id;
	}

	public void setId(FacturationArticlePK id) {
		this.id = id;
	}

	public Date getFacturationArticleDate() {
		return this.facturationArticleDate;
	}

	public void setFacturationArticleDate(Date facturationArticleDate) {
		this.facturationArticleDate = facturationArticleDate;
	}

	public String getFacturationArticleTitre() {
		return this.facturationArticleTitre;
	}

	public void setFacturationArticleTitre(String facturationArticleTitre) {
		this.facturationArticleTitre = facturationArticleTitre;
	}

	public double getFacturationArticleTotal() {
		return this.facturationArticleTotal;
	}

	public void setFacturationArticleTotal(double facturationArticleTotal) {
		this.facturationArticleTotal = facturationArticleTotal;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}