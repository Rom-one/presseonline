package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@Table(name="commentaire")
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="commentaire_id", unique=true, nullable=false)
	private int commentaireId;

	@Lob
	@Column(name="commentaire_contenu")
	private String commentaireContenu;

	@Temporal(TemporalType.DATE)
	@Column(name="commentaire_date")
	private Date commentaireDate;

	//bi-directional many-to-many association to Article
	@ManyToMany(mappedBy="commentaires")
	private List<Article> articles;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

	public Commentaire() {
	}

	public int getCommentaireId() {
		return this.commentaireId;
	}

	public void setCommentaireId(int commentaireId) {
		this.commentaireId = commentaireId;
	}

	public String getCommentaireContenu() {
		return this.commentaireContenu;
	}

	public void setCommentaireContenu(String commentaireContenu) {
		this.commentaireContenu = commentaireContenu;
	}

	public Date getCommentaireDate() {
		return this.commentaireDate;
	}

	public void setCommentaireDate(Date commentaireDate) {
		this.commentaireDate = commentaireDate;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}