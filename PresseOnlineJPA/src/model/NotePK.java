package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the note database table.
 * 
 */
@Embeddable
public class NotePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="utilisateur_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int utilisateurId;

	@Column(name="article_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int articleId;

	public NotePK() {
	}
	public int getUtilisateurId() {
		return this.utilisateurId;
	}
	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	public int getArticleId() {
		return this.articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotePK)) {
			return false;
		}
		NotePK castOther = (NotePK)other;
		return 
			(this.utilisateurId == castOther.utilisateurId)
			&& (this.articleId == castOther.articleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.utilisateurId;
		hash = hash * prime + this.articleId;
		
		return hash;
	}
}