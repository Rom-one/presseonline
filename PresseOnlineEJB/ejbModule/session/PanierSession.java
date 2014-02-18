package session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Named;

import model.Article;
import model.Dossier;
import model.FacturationArticle;
import model.FacturationDossier;
import model.PanierItem;
import session.client.PanierSessionRemote;

/**
 * Session Bean implementation class PanierSession
 */
@Stateful
@LocalBean
@Named(value="panierSession")
public class PanierSession implements PanierSessionRemote {

	@EJB
	private FacturationArticleSession facturationArticleSession;
	@EJB
	private FacturationDossierSession facturationDossierSession;
	@EJB
	private AuthentificationSession authentificationSession;
	
	private List<PanierItem> items;
	
    /**
     * Default constructor. 
     */
    public PanierSession() {
        this.items = new ArrayList<PanierItem>();
    }

	@Override
	public void addItem(PanierItem item) {
		items.add(item);
	}

	@Override
	public void deleteItem(PanierItem item) {
		items.remove(item);
	}

	@Override
	public List<PanierItem> listItems() {
		return items;
	}

	@Override
	public void proceed() {
		for(PanierItem item : items) {
			if(item.getClass().equals(Article.class)) {
				FacturationArticle f = new FacturationArticle();
				facturationArticleSession.create(f);
			}
			if(item.getClass().equals(Dossier.class)) {
				FacturationDossier f = new FacturationDossier();
				facturationDossierSession.create(f);
			}
		}
		items.clear();		
	}

}
