package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="utilisateur_id")
	private int utilisateurId;

	@Column(name="utilisateur_abonne")
	private boolean utilisateurAbonne;

	@Column(name="utilisateur_fullname")
	private String utilisateurFullname;

	@Column(name="utilisateur_login")
	private String utilisateurLogin;

	@Column(name="utilisateur_mail")
	private String utilisateurMail;

	@Column(name="utilisateur_password")
	private String utilisateurPassword;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="utilisateur")
	private List<Commentaire> commentaires;

	//bi-directional many-to-one association to FacturationArticle
	@OneToMany(mappedBy="utilisateur")
	private List<FacturationArticle> facturationArticles;

	//bi-directional many-to-one association to FacturationDossier
	@OneToMany(mappedBy="utilisateur")
	private List<FacturationDossier> facturationDossiers;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="utilisateur")
	private List<Note> notes;

	//bi-directional many-to-one association to TypeUtilisateur
	@ManyToOne
	@JoinColumn(name="type_utilisateur_id")
	private TypeUtilisateur typeUtilisateur;

	public Utilisateur() {
	}

	public int getUtilisateurId() {
		return this.utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public boolean getUtilisateurAbonne() {
		return this.utilisateurAbonne;
	}

	public void setUtilisateurAbonne(boolean utilisateurAbonne) {
		this.utilisateurAbonne = utilisateurAbonne;
	}

	public String getUtilisateurFullname() {
		return this.utilisateurFullname;
	}

	public void setUtilisateurFullname(String utilisateurFullname) {
		this.utilisateurFullname = utilisateurFullname;
	}

	public String getUtilisateurLogin() {
		return this.utilisateurLogin;
	}

	public void setUtilisateurLogin(String utilisateurLogin) {
		this.utilisateurLogin = utilisateurLogin;
	}

	public String getUtilisateurMail() {
		return this.utilisateurMail;
	}

	public void setUtilisateurMail(String utilisateurMail) {
		this.utilisateurMail = utilisateurMail;
	}

	public String getUtilisateurPassword() {
		return this.utilisateurPassword;
	}

	public void setUtilisateurPassword(String utilisateurPassword) {
		this.utilisateurPassword = utilisateurPassword;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setUtilisateur(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setUtilisateur(null);

		return commentaire;
	}

	public List<FacturationArticle> getFacturationArticles() {
		return this.facturationArticles;
	}

	public void setFacturationArticles(List<FacturationArticle> facturationArticles) {
		this.facturationArticles = facturationArticles;
	}

	public FacturationArticle addFacturationArticle(FacturationArticle facturationArticle) {
		getFacturationArticles().add(facturationArticle);
		facturationArticle.setUtilisateur(this);

		return facturationArticle;
	}

	public FacturationArticle removeFacturationArticle(FacturationArticle facturationArticle) {
		getFacturationArticles().remove(facturationArticle);
		facturationArticle.setUtilisateur(null);

		return facturationArticle;
	}

	public List<FacturationDossier> getFacturationDossiers() {
		return this.facturationDossiers;
	}

	public void setFacturationDossiers(List<FacturationDossier> facturationDossiers) {
		this.facturationDossiers = facturationDossiers;
	}

	public FacturationDossier addFacturationDossier(FacturationDossier facturationDossier) {
		getFacturationDossiers().add(facturationDossier);
		facturationDossier.setUtilisateur(this);

		return facturationDossier;
	}

	public FacturationDossier removeFacturationDossier(FacturationDossier facturationDossier) {
		getFacturationDossiers().remove(facturationDossier);
		facturationDossier.setUtilisateur(null);

		return facturationDossier;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setUtilisateur(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setUtilisateur(null);

		return note;
	}

	public TypeUtilisateur getTypeUtilisateur() {
		return this.typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

}