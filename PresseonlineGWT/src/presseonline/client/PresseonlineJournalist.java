package presseonline.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PresseonlineJournalist {
	
	private PresseonlineGWT mainPage;
	
	public PresseonlineJournalist(PresseonlineGWT mainPage){
		this.mainPage = mainPage;
	}
	
	@SuppressWarnings("deprecation")
	public void addMenuJournalist() {
		Hyperlink buttonWriteArticle = new Hyperlink("Ecrire un article", "ecrirearticle");
		Hyperlink buttonListArticles = new Hyperlink("Liste des articles", "listearticle");
		Hyperlink buttonLogout = new Hyperlink("Log out", "logout");

		buttonWriteArticle.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displayJournalistAddArticleForm();
			}
		});

		buttonListArticles.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displayJournalistListArticle(null);

			}
		});

		mainPage.getMenuPanel().clear();
		mainPage.getMenuPanel().add(buttonWriteArticle);
		mainPage.getMenuPanel().add(buttonListArticles);
		mainPage.getMenuPanel().add(buttonLogout);
	}

	public void displayJournalistAddArticleForm() {

		addMenuJournalist();
		mainPage.getMainPanel().clear();
		Label label = new Label("Redaction");
		label.addStyleName("pageTitle");
		mainPage.getMainPanel().add(label);
		
		TextBox textBoxTitle = new TextBox();
		textBoxTitle.setText("Titre");
		TextBox textBoxPrice = new TextBox();
		textBoxPrice.setText("Prix");
		TextArea textAreaContent = new TextArea();
		textAreaContent.setText("Contenu");
		textAreaContent.setSize("481px", "140px");
		FileUpload fileUpload = new FileUpload();
		Label labelSelect = new Label("Selectionner un fichier");
		Button buttonUpload = new Button("Charger le fichier");
		Button buttonSubmitArticle = new Button("Soumettre l'article");

		mainPage.getMainPanel().add(textBoxTitle);
		mainPage.getMainPanel().add(textBoxPrice);
		mainPage.getMainPanel().add(textAreaContent);

		HorizontalPanel uploadFile = new HorizontalPanel();
		uploadFile.add(labelSelect);
		uploadFile.add(fileUpload);
		uploadFile.add(buttonUpload);
		uploadFile.add(buttonSubmitArticle);

		mainPage.getMainPanel().add(uploadFile);
		mainPage.getMainPanel().add(buttonSubmitArticle);
	}

	public void displayJournalistListArticle(ArrayList listArticle) {

		addMenuJournalist();
		mainPage.getMainPanel().clear();
		Label label = new Label("Mes articles");
		label.addStyleName("pageTitle");
		mainPage.getMainPanel().add(label);

		FlexTable flexTable = new FlexTable();
		flexTable.setCellPadding(10);
		flexTable.setCellSpacing(0);
		flexTable.addStyleName("FlexTable");
		
		/*On récupère ici tous les articles de la base de données et faire une boucle pour les afficher*/
		
		flexTable.setText(0, 0, "La guerre au proche");
		flexTable.setText(0, 1, "Fait le 16/02/2014");
		flexTable.setText(0, 2, "valider");

		flexTable.setText(1, 0, "Comment faire une belle marquette");
		flexTable.setText(1, 1, "Fait le 16/02/2014");
		flexTable.setText(1, 2, "valider");

		flexTable.setText(2, 0, "Alice aux pays der merveilles");
		flexTable.setText(2, 1, "Fait le 11/02/2014");
		flexTable.setText(2, 2, "non valider");

		mainPage.getMainPanel().add(flexTable);
	}


}
