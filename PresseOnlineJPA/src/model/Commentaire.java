package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="commentaire_id")
	private int commentaireId;

	@Column(name="article_id")
	private int articleId;

	@Lob
	@Column(name="commentaire_contenu")
	private String commentaireContenu;

	@Temporal(TemporalType.DATE)
	@Column(name="commentaire_date")
	private Date commentaireDate;

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

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
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

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}