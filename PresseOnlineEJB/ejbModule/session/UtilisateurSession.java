package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import session.client.UtilisateurSessionRemote;
import model.Article;
import model.Utilisateur;

/**
 * Session Bean implementation class UtilisateurSession
 */
@Stateless
public class UtilisateurSession extends AbstractSession<Utilisateur> implements UtilisateurSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UtilisateurSession() {
        super(Utilisateur.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void subscribe(Utilisateur u) {
		u.setUtilisateurAbonne(true);
		update(u);
	}

	@Override
	public void unsubscribe(Utilisateur u) {
		u.setUtilisateurAbonne(false);
		update(u);
	}

	@Override
	public Utilisateur findByLogin(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
