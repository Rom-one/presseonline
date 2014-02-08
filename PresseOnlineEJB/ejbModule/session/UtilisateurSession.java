package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Utilisateur;

/**
 * Session Bean implementation class UtilisateurSession
 */
@Stateless
public class UtilisateurSession extends AbstractSession<Utilisateur> implements UtilisateurSessionRemote {

    /**
     * Default constructor. 
     */
    public UtilisateurSession() {
        super(Utilisateur.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
