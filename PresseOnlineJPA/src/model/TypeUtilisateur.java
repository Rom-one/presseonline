package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_utilisateur database table.
 * 
 */
@Entity
@Table(name="type_utilisateur")
@NamedQuery(name="TypeUtilisateur.findAll", query="SELECT t FROM TypeUtilisateur t")
public class TypeUtilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="type_utilisateur_id")
	private int typeUtilisateurId;

	@Column(name="type_utilisateur_label")
	private String typeUtilisateurLabel;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="typeUtilisateur")
	private List<Utilisateur> utilisateurs;

	public TypeUtilisateur() {
	}

	public int getTypeUtilisateurId() {
		return this.typeUtilisateurId;
	}

	public void setTypeUtilisateurId(int typeUtilisateurId) {
		this.typeUtilisateurId = typeUtilisateurId;
	}

	public String getTypeUtilisateurLabel() {
		return this.typeUtilisateurLabel;
	}

	public void setTypeUtilisateurLabel(String typeUtilisateurLabel) {
		this.typeUtilisateurLabel = typeUtilisateurLabel;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setTypeUtilisateur(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setTypeUtilisateur(null);

		return utilisateur;
	}

}