package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="article_id")
	private int articleId;

	@Lob
	@Column(name="article_contenu")
	private String articleContenu;

	@Temporal(TemporalType.DATE)
	@Column(name="article_date")
	private Date articleDate;

	@Column(name="article_prix")
	private double articlePrix;

	@Column(name="article_publie")
	private boolean articlePublie;

	@Column(name="article_titre")
	private String articleTitre;

	//bi-directional many-to-many association to Dossier
	@ManyToMany(mappedBy="articles")
	private List<Dossier> dossiers;

	//bi-directional many-to-one association to FacturationArticle
	@OneToMany(mappedBy="article")
	private List<FacturationArticle> facturationArticles;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="article")
	private List<Note> notes;

	public Article() {
	}

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleContenu() {
		return this.articleContenu;
	}

	public void setArticleContenu(String articleContenu) {
		this.articleContenu = articleContenu;
	}

	public Date getArticleDate() {
		return this.articleDate;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	public double getArticlePrix() {
		return this.articlePrix;
	}

	public void setArticlePrix(double articlePrix) {
		this.articlePrix = articlePrix;
	}

	public boolean getArticlePublie() {
		return this.articlePublie;
	}

	public void setArticlePublie(boolean articlePublie) {
		this.articlePublie = articlePublie;
	}

	public String getArticleTitre() {
		return this.articleTitre;
	}

	public void setArticleTitre(String articleTitre) {
		this.articleTitre = articleTitre;
	}

	public List<Dossier> getDossiers() {
		return this.dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	public List<FacturationArticle> getFacturationArticles() {
		return this.facturationArticles;
	}

	public void setFacturationArticles(List<FacturationArticle> facturationArticles) {
		this.facturationArticles = facturationArticles;
	}

	public FacturationArticle addFacturationArticle(FacturationArticle facturationArticle) {
		getFacturationArticles().add(facturationArticle);
		facturationArticle.setArticle(this);

		return facturationArticle;
	}

	public FacturationArticle removeFacturationArticle(FacturationArticle facturationArticle) {
		getFacturationArticles().remove(facturationArticle);
		facturationArticle.setArticle(null);

		return facturationArticle;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setArticle(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setArticle(null);

		return note;
	}

}