package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Commentaire;

/**
 * Session Bean implementation class CommentaireSession
 */
@Stateless
public class CommentaireSession extends AbstractSession<Commentaire> implements CommentaireSessionRemote {

    /**
     * Default constructor. 
     */
    public CommentaireSession() {
        super(Commentaire.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
