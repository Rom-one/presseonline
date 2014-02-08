package session;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Utilisateur;

/**
 * Session Bean implementation class AuthentificationSession
 */
@Stateful
@LocalBean
public class AuthentificationSession implements AuthentificationSessionRemote {

	@EJB
	private UtilisateurSession utilisateurSession;
	
    /**
     * Default constructor. 
     */
    public AuthentificationSession() {
        
    }

}
