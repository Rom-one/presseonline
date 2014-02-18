package session;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import session.client.AuthentificationSessionRemote;
import model.Utilisateur;

/**
 * Session Bean implementation class AuthentificationSession
 */
@Stateful
@LocalBean
public class AuthentificationSession implements AuthentificationSessionRemote {

	@EJB
	private UtilisateurSession utilisateurSession;
	
	private Utilisateur utilisateurCourant = null;
	
    /**
     * Default constructor. 
     */
    public AuthentificationSession() {
        
    }
    
	public Utilisateur getUtilisateurCourant() {
		return utilisateurCourant;
	}

	public void setUtilisateurCourant(Utilisateur utilisateurCourant) {
		this.utilisateurCourant = utilisateurCourant;
	}

	@Override
	public void login(String id, String mdp) {
		utilisateurCourant = utilisateurSession.find(null);
	}

	@Override
	public void logout() {
		utilisateurCourant = null;
	}

}
