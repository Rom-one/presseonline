package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the facturation_article database table.
 * 
 */
@Embeddable
public class FacturationArticlePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="article_id", insertable=false, updatable=false)
	private int articleId;

	@Column(name="utilisateur_id", insertable=false, updatable=false)
	private int utilisateurId;

	public FacturationArticlePK() {
	}
	
	public FacturationArticlePK(int articleId, int utilisateurId) {
		this.articleId = articleId;
		this.utilisateurId = utilisateurId;
	}

	public int getArticleId() {
		return this.articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
		if (!(other instanceof FacturationArticlePK)) {
			return false;
		}
		FacturationArticlePK castOther = (FacturationArticlePK)other;
		return 
			(this.articleId == castOther.articleId)
			&& (this.utilisateurId == castOther.utilisateurId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.articleId;
		hash = hash * prime + this.utilisateurId;
		
		return hash;
	}
}