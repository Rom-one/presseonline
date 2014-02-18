package presseonline.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PresseonlineSubscriber {
	
	private PresseonlineGWT mainPage;
	
	public PresseonlineSubscriber(PresseonlineGWT mainPage){
		this.mainPage = mainPage;
	}
	
	@SuppressWarnings("deprecation")
	public void addMenuForSubscriber() {
		Hyperlink buttonPersonalProfile = new Hyperlink("Profile personnel", "profilepersonnel");
		Hyperlink buttonFilesList = new Hyperlink("Liste des dossiers", "listedesdossiers");
		Hyperlink buttonArticlesList = new Hyperlink("Liste des articles", "listedesarticles");
		Hyperlink buttonSubscribing = new Hyperlink("Abonnements", "abonnements");
		Hyperlink buttonLastPurchase = new Hyperlink("Derniers achats", "derniersachat");
		Hyperlink buttonArticleBasket = new Hyperlink("Panier", "panier");
		Hyperlink buttonLogout = new Hyperlink("Log out", "logout");
		

		mainPage.getMenuPanel().clear();
		mainPage.getMenuPanel().add(buttonPersonalProfile);
		mainPage.getMenuPanel().add(buttonFilesList);
		mainPage.getMenuPanel().add(buttonArticlesList);
		mainPage.getMenuPanel().add(buttonSubscribing);
		mainPage.getMenuPanel().add(buttonLastPurchase);
		mainPage.getMenuPanel().add(buttonArticleBasket);
		mainPage.getMenuPanel().add(buttonLogout);
		
		buttonPersonalProfile.addClickListener(new ClickListener() {
			
			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displayProfileSubscriber();
			}
		});
		
		buttonSubscribing.addClickListener(new ClickListener() {
			
			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displaySubscribingProfile();
			}
		});
		
		buttonLastPurchase.addClickListener(new ClickListener() {
			
			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displayLastPurchasePage();
			}
		});
		
		buttonArticleBasket.addClickListener(new ClickListener() {
			
			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displayBasket();
			}
		});
	}

	public void displayProfileSubscriber() {
		
		addMenuForSubscriber();

		FlexTable flexTable = new FlexTable();

		flexTable.setText(0, 0, "Nom : ");
		flexTable.setText(0, 1, "SERGEANT");

		flexTable.setText(1, 0, "Prenom : ");
		flexTable.setText(1, 1, "Romain");

		flexTable.setText(2, 0, "Mail : ");
		flexTable.setText(2, 1, "romain.sergeant@gmail.com");
		
		flexTable.setText(3, 0, "Telephone : ");
		flexTable.setText(3, 1, "06 18 07 89 62");
		
		flexTable.setText(4, 0, "Code postal : ");
		flexTable.setText(4, 1, "54000");
		
		flexTable.setText(5, 0, "Facture : ");
		flexTable.setText(5, 1, "facture1.pdf");

		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(flexTable);
	}
	
	public void displaySubscribingProfile(){
		addMenuForSubscriber();
		
		Label label = new Label("Abonnenemnt : Vous n'etes pas encore abonne, le montant total est de 10 euro par mois");
		Button buttonSubcribe = new Button();
		buttonSubcribe.setText("Je veux souscrire");
		
		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(label);
		mainPage.getMainPanel().add(buttonSubcribe);
	}
	
	public void displayLastPurchasePage(){
		addMenuForSubscriber();

		FlexTable flexTable1 = new FlexTable();

		flexTable1.setText(0, 0, "Dossier achete : ");

		flexTable1.setText(1, 0, "La guerre 21 e siecle");
		flexTable1.setText(1, 1, "Achete le : 12/03/2014");
		flexTable1.setText(1, 2, "Comporte 10 article");
		
		flexTable1.setText(2, 0, "Voyage a travers le monde");
		flexTable1.setText(2, 1, "Achete le : 12/03/2014");
		flexTable1.setText(2, 2, "Comporte 2 article");
		
		FlexTable flexTable2 = new FlexTable();

		flexTable1.setText(0, 0, "Article a l'unite achete : ");

		flexTable1.setText(1, 0, "La guerre au proche orient");
		flexTable1.setText(1, 1, "Achete le : 12/03/2014");
		flexTable1.setText(1, 2, "5 etoiles");
		
		flexTable1.setText(2, 0, "La route du paradis");
		flexTable1.setText(2, 1, "Achete le : 12/03/2014");
		flexTable1.setText(2, 2, "3 etoiles");

		flexTable1.setText(2, 0, "Un dimanche comme les autres");
		flexTable1.setText(2, 1, "Achete le : 12/03/2014");
		flexTable1.setText(2, 2, "2 etoiles");

		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(flexTable1);
		mainPage.getMainPanel().add(flexTable2);
	}
	
	public void displayBasket(){
		
		FlexTable flexTable1 = new FlexTable();

		flexTable1.setText(0, 0, "Dossier achete : ");

		flexTable1.setText(1, 0, "La guerre 21 e siecle");
		flexTable1.setText(1, 1, "10 articles");
		flexTable1.setText(1, 2, "18 euros");
		flexTable1.setText(1, 3, "supprimer");
		
		flexTable1.setText(2, 0, "Voyage a travers le monde");
		flexTable1.setText(2, 1, "10 articles");
		flexTable1.setText(2, 2, "10 euros");
		flexTable1.setText(2, 3, "supprimer");
		
		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(flexTable1);
	}

}
