package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import session.client.ArticleSessionRemote;
import model.Article;

/**
 * Session Bean implementation class ArticleSession
 */
@Stateless
public class ArticleSession extends AbstractSession<Article> implements ArticleSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ArticleSession() {
        super(Article.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void publish(Article a) {
		// TODO Auto-generated method stub
		
	}

	


}
