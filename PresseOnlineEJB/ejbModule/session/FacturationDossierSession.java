package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.FacturationDossier;
import session.client.FacturationDossierSessionRemote;

/**
 * Session Bean implementation class FacturationDossierSession
 */
@Stateless
public class FacturationDossierSession extends AbstractSession<FacturationDossier> implements FacturationDossierSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FacturationDossierSession() {
        super(FacturationDossier.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
