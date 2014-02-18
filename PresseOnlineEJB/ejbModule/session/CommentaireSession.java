package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import session.client.CommentaireSessionRemote;
import model.Commentaire;

/**
 * Session Bean implementation class CommentaireSession
 */
@Stateless
public class CommentaireSession extends AbstractSession<Commentaire> implements CommentaireSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CommentaireSession() {
        super(Commentaire.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	
}
