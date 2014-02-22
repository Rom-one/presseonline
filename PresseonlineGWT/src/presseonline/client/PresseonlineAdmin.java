package presseonline.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PresseonlineAdmin {

	private PresseonlineGWT mainPage;

	public PresseonlineAdmin(PresseonlineGWT mainPage) {
		this.mainPage = mainPage;
	}

	/**
	 * Cette methode permet d'ajouter les elements au menu pour le profil de
	 * type administrateur
	 */
	@SuppressWarnings("deprecation")
	public void addMenuAdmin() {
		Hyperlink buttonAddAccount = new Hyperlink("Creation des comptes",
				"creationcompte");
		Hyperlink buttonListMembers = new Hyperlink("Membres", "membre");
		Hyperlink buttonLogout = new Hyperlink("Log out", "logout");

		mainPage.getMenuPanel().clear();
		mainPage.getMenuPanel().add(buttonAddAccount);
		mainPage.getMenuPanel().add(buttonListMembers);
		mainPage.getMenuPanel().add(buttonLogout);

		buttonAddAccount.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				displayAdminCreateAccountPage();
			}
		});

		buttonListMembers.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				displayAdminListMembersPage(null);
			}
		});

		buttonLogout.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * Cette methode permet d'afficher l'interface pour creer le compte
	 * d'utilisateur Elle appelle egalement a la fonction qui gere l'action du
	 * clic
	 */
	public void displayAdminCreateAccountPage() {

		addMenuAdmin();

		mainPage.getMainPanel().clear();
		final ListBox listUserType = new ListBox();
		listUserType.addItem("Journaliste");
		listUserType.addItem("Utilisateur");

		final TextBox textBoxLogin = new TextBox();
		textBoxLogin.setText("Votre login");
		final TextBox textBoxPassword = new TextBox();
		textBoxPassword.setText("Votre mot de passe");
		final TextBox textBoxMessagerie = new TextBox();
		textBoxMessagerie.setText("Messagerie");
		Button buttonSubscribe = new Button("Creer le membre");
		buttonSubscribe.addStyleName("sendButton");

		mainPage.getMainPanel().add(listUserType);
		mainPage.getMainPanel().add(textBoxLogin);
		mainPage.getMainPanel().add(textBoxPassword);
		mainPage.getMainPanel().add(textBoxMessagerie);
		mainPage.getMainPanel().add(buttonSubscribe);

		buttonSubscribe.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				doActionCreateAccount(listUserType.getItemText(listUserType
						.getSelectedIndex()), textBoxLogin.getText(),
						textBoxPassword.getText(), textBoxMessagerie.getText());
			}
		});
	}

	/**
	 * Cette methode affiche la liste de tous les membres
	 * 
	 * @param lMembers
	 */
	public void displayAdminListMembersPage(ArrayList lMembers) {
		addMenuAdmin();
		Label label = new Label("Sélectionner le type de profil");
		label.addStyleName("labelSelect");
		final ListBox listUserType = new ListBox();
		listUserType.addItem("Journaliste");
		listUserType.addItem("Utilisateur");
		listUserType.addItem("Lister tous");

		mainPage.getMainPanel().clear();
		final HorizontalPanel panel = new HorizontalPanel();
		panel.add(label);
		panel.add(listUserType);
		mainPage.getMainPanel().add(panel);
		listUserType.addChangeHandler(new ChangeHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void onChange(ChangeEvent event) {
				/**
				 * Parcourir la liste de membres et les ajouter dans le tableau
				 */
				FlexTable flexTable = new FlexTable();
				flexTable.setCellPadding(10);
				flexTable.addStyleName("FlexTable");

				flexTable.setText(0, 0, "Romain");
				flexTable.setText(0, 1, "Redaction : 10");
				Hyperlink linkModified = new Hyperlink("modifier", "modifier");
				Hyperlink linkDeleted = new Hyperlink("supprimer", "supprimer");
				linkModified.addClickListener(new ClickListener() {
					
					@Override
					public void onClick(Widget sender) {
						// TODO Auto-generated method stub
						modifyProfilMember("1");
					}
				});
				
				linkDeleted.addClickListener(new ClickListener() {
					
					@Override
					public void onClick(Widget sender) {
						// TODO Auto-generated method stub
						deleteProfileMember("1");
					}
				});
				flexTable.setWidget(0, 2, linkModified);
				flexTable.setWidget(0, 3, linkDeleted);

				flexTable.setText(1, 0, "Etienne");
				flexTable.setText(1, 1, "Redaction : 10");
				flexTable.setText(1, 2, "Modifier");
				flexTable.setText(1, 3, "Supprimer");

				flexTable.setText(2, 0, "Phongphet");
				flexTable.setText(2, 1, "Redaction : 10");
				flexTable.setText(2, 2, "Modifier");
				flexTable.setText(2, 3, "Supprimer");

				applyDataRowStyles(flexTable);
				mainPage.getMainPanel().clear();
				mainPage.getMainPanel().add(panel);
				mainPage.getMainPanel().add(flexTable);
			}
		});
	}

	public void doActionCreateAccount(String listUserType, String login,
			String password, String messagerie) {
		/* Faire l'ajout a la base de donnees */

	}
	
	public void modifyProfilMember(String id){
		
	}
	
	public void deleteProfileMember(String id){
		/*Suuprimer le membre de la base de donnees*/
		
		/*Recuperer de nouvelle fois la liste des membres et l'afficher*/
		displayAdminListMembersPage(null);
	}

	private void applyDataRowStyles(FlexTable flexTable) {
		HTMLTable.RowFormatter rf = flexTable.getRowFormatter();

		for (int row = 0; row < flexTable.getRowCount(); ++row) {
			if ((row % 2) != 0) {
				rf.addStyleName(row, "FlexTable-OddRow");
			} else {
				rf.addStyleName(row, "FlexTable-EvenRow");
			}
		}
	}
}
