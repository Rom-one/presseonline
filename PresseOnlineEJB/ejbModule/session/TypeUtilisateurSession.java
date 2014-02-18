package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import model.TypeUtilisateur;
import session.client.TypeUtilisateurSessionRemote;

/**
 * Session Bean implementation class TypeUtilisateurSession
 */
@Stateless
public class TypeUtilisateurSession extends AbstractSession<TypeUtilisateur> implements TypeUtilisateurSessionRemote {

	@PersistenceContext(unitName="PresseOnlineJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TypeUtilisateurSession() {
    	super(TypeUtilisateur.class);
    }
    	
    @Override
	protected EntityManager getEntityManager() {
		return em;
    }

}

