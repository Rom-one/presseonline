package presseonline.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PresseonlineGWT implements EntryPoint {

	private VerticalPanel mainPanel;
	private HorizontalPanel menuPanel;
	private VerticalPanel rightNavPanel;
	private HorizontalPanel footerPanel;
	
	private PresseonlineAdmin adminPage;
	private PresseonlineJournalist journalistPage;
	private PresseonlineSubscriber subscriberPage;
	
	public PresseonlineGWT(){
		mainPanel = new VerticalPanel();
		menuPanel = new HorizontalPanel();
		rightNavPanel = new VerticalPanel();
		footerPanel = new HorizontalPanel();
		
		adminPage = new PresseonlineAdmin(this);
		journalistPage = new PresseonlineJournalist(this);
		subscriberPage = new PresseonlineSubscriber(this);
	}

	public VerticalPanel getMainPanel() {
		return mainPanel;
	}

	public HorizontalPanel getMenuPanel() {
		return menuPanel;
	}

	public VerticalPanel getLeftNavPanel() {
		return rightNavPanel;
	}

	public HorizontalPanel getFooterPanel() {
		return footerPanel;
	}

	public void onModuleLoad() {
		mainPanel.getElement().setAttribute("align", "center");
		RootPanel.get("content").add(mainPanel);

		RootPanel.get("menu").add(menuPanel);
		RootPanel.get("rightnav").add(rightNavPanel);
		RootPanel.get("footer").add(footerPanel);
		
		Label recentArticle = new Label("Derniers articles");
		recentArticle.addStyleName("rightnavTitle");
		rightNavPanel.add(recentArticle);
		
		displayLoginForm();
	}

	@SuppressWarnings("deprecation")
	public void displayLoginForm() {
		Label titleForm = new Label("Connexion");
		titleForm.addStyleName("pageTitle");
		
		final TextBox textBoxLogin = new TextBox();
		textBoxLogin.setText("Votre login");
		
		final TextBox textBoxPassword = new TextBox();
		textBoxPassword.setText("Votre mot de passe");
		
		Button buttonLogin = new Button("Valider");
		buttonLogin.addStyleName("sendButton");
		buttonLogin.getElement().getStyle().setProperty("align", "center");
		
		Hyperlink linkSubscribe = new Hyperlink("S'inscrire", "S'inscrire");
		linkSubscribe.getElement().getStyle().setProperty("align", "right");

		mainPanel.add(titleForm);
		mainPanel.add(textBoxLogin);
		mainPanel.add(textBoxPassword);
	
		mainPanel.add(buttonLogin);
		mainPanel.add(linkSubscribe);

		buttonLogin.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doLoginAction(textBoxLogin.getText(), textBoxPassword.getText());
			}
		});

		linkSubscribe.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				displaySubscribeForm();
			}
		});

	}

	public void displaySubscribeForm() {
		mainPanel.clear();
		final TextBox textBoxLogin = new TextBox();
		textBoxLogin.setText("Votre login");
		final TextBox textBoxPassword = new TextBox();
		textBoxPassword.setText("Votre mot de passe");
		final TextBox textBoxNom = new TextBox();
		textBoxNom.setText("Votre nom");
		final TextBox textBoxPrenom = new TextBox();
		textBoxPrenom.setText("Votre prenom");
		TextBox textBoxCatcha = new TextBox();
		textBoxCatcha.setText("2+2 = ?");
		Button buttonSubscribe = new Button("S'inscrire");
		buttonSubscribe.addStyleName("sendButton");

		mainPanel.add(textBoxLogin);
		mainPanel.add(textBoxPassword);
		mainPanel.add(textBoxNom);
		mainPanel.add(textBoxPrenom);
		mainPanel.add(textBoxCatcha);
		mainPanel.add(buttonSubscribe);

		buttonSubscribe.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				doSubscribeAction(textBoxLogin.getText(), textBoxPassword.getText(), textBoxLogin.getText(), textBoxPassword.getText());
			}
		});
	}

	/**
	 * Cette methode verifie le login et le mot de passe
	 * @param login
	 * @param password
	 */
	public void doLoginAction(String login, String password) {
		
		/*Effectuer le login et le mot de passe et affiche la page qui correspond 
		 au profil d'utilisateur*/
		
		/* Test the display of admin page (create account) */
		//adminPage.displayAdminCreateAccountPage();
		//journalistPage.displayJournalistAddArticleForm();
		subscriberPage.displayProfileSubscriber();
		
	}

	/**
	 * Cette methode permet d'ajouter un utilisateur dans la base de donnes
	 * @param login
	 * @param password
	 * @param name
	 * @param firstName
	 */
	public void doSubscribeAction(String login, String password, String name, String firstName) {
	
	}

}
