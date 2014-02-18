package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.FacturationArticle;
import session.client.FacturationArticleSessionRemote;

/**
 * Session Bean implementation class FacturationArticleSession
 */
@Stateless
public class FacturationArticleSession extends AbstractSession<FacturationArticle> implements FacturationArticleSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FacturationArticleSession() {
        super(FacturationArticle.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
