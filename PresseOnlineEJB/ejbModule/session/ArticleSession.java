package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Article;

/**
 * Session Bean implementation class ArticleSession
 */
@Stateless
public class ArticleSession extends AbstractSession<Article> implements ArticleSessionRemote {

    /**
     * Default constructor. 
     */
    public ArticleSession() {
        super(Article.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
