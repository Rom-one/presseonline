package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Dossier;

/**
 * Session Bean implementation class DossierSession
 */
@Stateless
public class DossierSession extends AbstractSession<Dossier> implements DossierSessionRemote {

    /**
     * Default constructor. 
     */
    public DossierSession() {
        super(Dossier.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
