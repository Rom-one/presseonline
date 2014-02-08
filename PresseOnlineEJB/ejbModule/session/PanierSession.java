package session;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class PanierSession
 */
@Stateful
@LocalBean
public class PanierSession implements PanierSessionRemote {

	@EJB
	private ArticleSession articleSession;
	@EJB
	private DossierSession dossierSession;
	@EJB
	private UtilisateurSession utilisateurSession;
	
    /**
     * Default constructor. 
     */
    public PanierSession() {
        // TODO Auto-generated constructor stub
    }

}
