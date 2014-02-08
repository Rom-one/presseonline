package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name="article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id", unique=true, nullable=false)
	private int articleId;

	@Lob
	@Column(name="article_contenu", nullable=false)
	private String articleContenu;

	@Temporal(TemporalType.DATE)
	@Column(name="article_date", nullable=false)
	private Date articleDate;

	@Column(name="article_prix", precision=10, scale=2)
	private BigDecimal articlePrix;

	@Column(name="article_titre", nullable=false, length=100)
	private String articleTitre;

	//bi-directional many-to-many association to Commentaire
	@ManyToMany
	@JoinTable(
		name="article_commentaire"
		, joinColumns={
			@JoinColumn(name="article_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="commentaire_id", nullable=false)
			}
		)
	private List<Commentaire> commentaires;

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

	public BigDecimal getArticlePrix() {
		return this.articlePrix;
	}

	public void setArticlePrix(BigDecimal articlePrix) {
		this.articlePrix = articlePrix;
	}

	public String getArticleTitre() {
		return this.articleTitre;
	}

	public void setArticleTitre(String articleTitre) {
		this.articleTitre = articleTitre;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
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