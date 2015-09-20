/**
 * 13 сент. 2015 г.
 */
package ru.davist.study.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author StarovoytovD
 *
 */
@Theme("valo")
@Title("Authorization")
public class LoginUI extends UI {
	
	private static final long serialVersionUID = 1L;
	
	private TextField usernameField;
	private PasswordField passwordField;
	private Button singIn;

	@Override
	protected void init(VaadinRequest request) {
		Layout layout = initLayout();
		
		final ObjectProperty<String> usernameProperty = new ObjectProperty<String>("");
		usernameField.setPropertyDataSource(usernameProperty);
		
		singIn.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if (usernameProperty.getValue() != null && !usernameProperty.getValue().isEmpty()) {
					Notification.show("User " + usernameProperty.getValue() + " successfull autirized");
				} else {
					Notification.show("Please enter Username", Type.ERROR_MESSAGE);
				}
			}
		});
		
		setContent(layout);
	}
	
	private Layout initLayout() {
		VerticalLayout main = new VerticalLayout();
		main.setSizeFull();
		main.setMargin(true);
		
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		Panel panel = new Panel("Авторизация", layout);
		panel.setSizeUndefined();
		
		usernameField = new TextField("Имя пользователя");
		layout.addComponent(usernameField);
		passwordField = new PasswordField("Пароль");
		layout.addComponent(passwordField);
		singIn = new Button("Войти");
		singIn.addStyleName(ValoTheme.BUTTON_PRIMARY);
		layout.addComponent(singIn);
		
		main.addComponent(panel);
		main.setComponentAlignment(panel, Alignment.TOP_CENTER);
		
		return main;
	}
	
}
