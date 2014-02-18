package presseonline.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public class PresseonlineAdmin {
	
	private PresseonlineGWT mainPage;
	
	public PresseonlineAdmin(PresseonlineGWT mainPage){
		this.mainPage = mainPage;
	}
	
	public void addMenuAdmin() {
		Button buttonAddAccount = new Button("Creation des comptes");
		Button buttonListMembers = new Button("Membres");
		Button buttonLogout = new Button("Log out");

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

	public void displayAdminCreateAccountPage() {

		addMenuAdmin();

		mainPage.getMainPanel().clear();
		ListBox listUserType = new ListBox();
		listUserType.addItem("Journaliste");
		listUserType.addItem("Utilisateur");

		TextBox textBoxLogin = new TextBox();
		textBoxLogin.setText("Votre login");
		TextBox textBoxPassword = new TextBox();
		textBoxPassword.setText("Votre mot de passe");
		TextBox textBoxMessagerie = new TextBox();
		textBoxMessagerie.setText("Messagerie");
		Button buttonSubscribe = new Button("Creer le membre");
		buttonSubscribe.addStyleName("sendButton");

		mainPage.getMainPanel().add(listUserType);
		mainPage.getMainPanel().add(textBoxLogin);
		mainPage.getMainPanel().add(textBoxPassword);
		mainPage.getMainPanel().add(textBoxMessagerie);
		mainPage.getMainPanel().add(buttonSubscribe);
	}

	public void displayAdminListMembersPage(ArrayList lMembers) {
		addMenuAdmin();
		FlexTable flexTable = new FlexTable();

		flexTable.setText(0, 0, "Romain");
		flexTable.setText(0, 1, "Redaction : 10");
		flexTable.setText(0, 2, "Modifier");
		flexTable.setText(0, 3, "Supprimer");

		flexTable.setText(1, 0, "Etienne");
		flexTable.setText(1, 1, "Redaction : 10");
		flexTable.setText(1, 2, "Modifier");
		flexTable.setText(1, 3, "Supprimer");

		flexTable.setText(2, 0, "Phongphet");
		flexTable.setText(2, 1, "Redaction : 10");
		flexTable.setText(2, 2, "Modifier");
		flexTable.setText(2, 3, "Supprimer");

		mainPage.getMainPanel().clear();
		mainPage.getMainPanel().add(flexTable);
	}

}
