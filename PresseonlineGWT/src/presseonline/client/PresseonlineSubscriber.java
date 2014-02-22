package presseonline.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
		
		mainPage.getMainPanel().clear();
		
		Label labelProfile = new Label("Profil");
		labelProfile.addStyleName("pageTitle");
		mainPage.getMainPanel().add(labelProfile);

		FlexTable flexTable1 = new FlexTable();
		flexTable1.addStyleName("FlexTable");

		flexTable1.setText(0, 0, "Nom : ");
		flexTable1.setText(0, 1, "SERGEANT");

		flexTable1.setText(1, 0, "Prenom : ");
		flexTable1.setText(1, 1, "Romain");

		flexTable1.setText(2, 0, "Mail : ");
		flexTable1.setText(2, 1, "romain.sergeant@gmail.com");
		
		flexTable1.setText(3, 0, "Telephone : ");
		flexTable1.setText(3, 1, "06 18 07 89 62");
		
		flexTable1.setText(4, 0, "Code postal : ");
		flexTable1.setText(4, 1, "54000");
		
		mainPage.getMainPanel().add(flexTable1);
		Button buttonModified = new Button("Modifier");
		buttonModified.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		mainPage.getMainPanel().add(buttonModified);
		
		Label labelBill = new Label("Factures");
		labelBill.addStyleName("pageTitle");
		mainPage.getMainPanel().add(labelBill);
		
		FlexTable flexTable2 = new FlexTable();
		flexTable2.addStyleName("flexTable-profile");
		
		flexTable2.setText(0, 0, "facture1.pdf");
		flexTable2.setText(0, 1, "HTML | CSS");
		
		flexTable2.setText(1, 0, "facture2.pdf");
		flexTable2.setText(1, 1, "HTML | CSS");

		mainPage.getMainPanel().add(flexTable2);
	}
	
	public void displaySubscribingProfile(){
		addMenuForSubscriber();
		mainPage.getMainPanel().clear();
		Label labelSubscribingTitle = new Label("Abonnement");
		labelSubscribingTitle.addStyleName("pageTitle");
		mainPage.getMainPanel().add(labelSubscribingTitle);
		Label labelSubscribingInfo = new Label("Etat : Vous n'etes pas encore abonne, le montant total est de 10 euro par mois");
		Button buttonSubcribe = new Button();
		buttonSubcribe.addStyleName("buttonContinuedSubscribing");
		buttonSubcribe.setText("Je veux souscrire");
		
		
		mainPage.getMainPanel().add(labelSubscribingInfo);
		mainPage.getMainPanel().add(buttonSubcribe);
	}
	
	public void displayLastPurchasePage(){
		addMenuForSubscriber();
		
		Label labelFilePurchased = new Label("Dossier achete : ");
		labelFilePurchased.addStyleName("pageTitle");

		FlexTable flexTable1 = new FlexTable();
		flexTable1.addStyleName("FlexTable");

		flexTable1.setText(0, 0, "La guerre 21 e siecle \n");
		flexTable1.setText(0, 1, "Achete le : 12/03/2014");
		flexTable1.setText(0, 2, "Comporte 10 article");
		
		/*Ajouter ses elements*/
		flexTable1.setText(1, 0, "		La guerre au orient");
		flexTable1.setText(2, 0, "		La guerre fait rage");
		flexTable1.setText(3, 0, "		L'ecole part en fume");
		
		flexTable1.setText(4, 0, "Voyage a travers le monde");
		flexTable1.setText(4, 1, "Achete le : 12/03/2014");
		flexTable1.setText(4, 2, "Comporte 2 article");
		/*Ajouter ses elements*/
		flexTable1.setText(5, 0, "		Un sejour en autralie");
		flexTable1.setText(6, 0, "		Petits souvenir de chine");
		
		Label labelUnitPurchase = new Label("Article a l'unite achete : ");
		labelUnitPurchase.addStyleName("pageTitle");
		
		FlexTable flexTable2 = new FlexTable();
		flexTable2.addStyleName("FlexTable");

		flexTable2.setText(0, 0, "La guerre au proche orient par Anne PLISTF");
		flexTable2.setText(0, 1, "Achete le : 12/03/2014");
		flexTable2.setText(0, 2, "4 etoiles");
		
		flexTable2.setText(1, 0, "La route du paradis par Anne PLISTF");
		flexTable2.setText(1, 1, "Achete le : 12/03/2014");
		flexTable2.setText(1, 2, "3 etoiles");

		flexTable2.setText(2, 0, "Un dimanche comme les autres par Anne PLISTF");
		flexTable2.setText(2, 1, "Achete le : 12/03/2014");
		flexTable2.setText(2, 2, "2 etoiles");

		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(labelFilePurchased);
		mainPage.getMainPanel().add(flexTable1);
		mainPage.getMainPanel().add(labelUnitPurchase);
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
