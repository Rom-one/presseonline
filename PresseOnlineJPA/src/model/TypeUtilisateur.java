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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="type_utilisateur_id", unique=true, nullable=false)
	private int typeUtilisateurId;

	@Column(name="type_utilisateur_label", nullable=false, length=50)
	private String typeUtilisateurLabel;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="typeUtilisateurs")
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

}