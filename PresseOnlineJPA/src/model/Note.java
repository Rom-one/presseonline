package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotePK id;

	@Column(name="note_valeur")
	private short noteValeur;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

	public Note() {
	}

	public NotePK getId() {
		return this.id;
	}

	public void setId(NotePK id) {
		this.id = id;
	}

	public short getNoteValeur() {
		return this.noteValeur;
	}

	public void setNoteValeur(short noteValeur) {
		this.noteValeur = noteValeur;
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