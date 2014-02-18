package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import session.client.DossierSessionRemote;
import model.Article;
import model.Dossier;

/**
 * Session Bean implementation class DossierSession
 */
@Stateless
public class DossierSession extends AbstractSession<Dossier> implements DossierSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DossierSession() {
        super(Dossier.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void publish(Dossier d) {
		// TODO Auto-generated method stub
		
	}
}
