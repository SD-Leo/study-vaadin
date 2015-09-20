/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.Calendar;

import ru.davist.study.vaadin.domain.Address;
import ru.davist.study.vaadin.domain.Client;

/**
 * 
 * Привязка сущности Клиент в полям редактирования через FiedlGroup+BeanItem и через BeanFieldGroup
 * 
 * @author StarovoytovD
 * 		
 */
@SpringUI(path = "/client")
@Theme("valo")
public class ClientUI extends UI {
	
	private static final long serialVersionUID = 1L;
	
	private Label lableFilledClient;
	
	private TextField nameField;
	private TextField ageField;
	private DateField birthdayField;
	private TextField streetField;
	private TextField buildingNumberField;
	
	private Button btnShow;
	
	@Override
	protected void init(VaadinRequest request) {
		Layout layout = initLayout();
		
		final ObjectProperty<String> prop = new ObjectProperty<String>("");
		lableFilledClient.setPropertyDataSource(prop);
		
		final Client client = getClient();
		
		BeanItem<Client> clientBean = new BeanItem<Client>(client);
		clientBean.addNestedProperty("address.street");
		clientBean.addNestedProperty("address.number");
		final FieldGroup fieldGroup = new FieldGroup(clientBean);
		fieldGroup.bind(nameField, "name");
		fieldGroup.bind(ageField, "age");
		fieldGroup.bind(birthdayField, "birthday");
		fieldGroup.bind(streetField, "address.street");
		fieldGroup.bind(buildingNumberField, "address.number");
		
		// final BeanFieldGroup<Client> fieldGroup = new BeanFieldGroup<Client>(Client.class);
		// fieldGroup.setItemDataSource(client);
		// fieldGroup.bind(nameField, "name");
		// fieldGroup.bind(ageField, "age");
		// fieldGroup.bind(birthdayField, "birthday");
		// fieldGroup.bind(streetField, "address.street");
		// fieldGroup.bind(buildingNumberField, "address.number");
		
		btnShow.addClickListener(new Button.ClickListener() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					fieldGroup.commit();
				} catch (CommitException ex) {
					ex.printStackTrace();
				}
				prop.setValue(client.toString());
			}
			
		});
		
		setContent(layout);
	}
	
	private Layout initLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		
		lableFilledClient = new Label();
		
		nameField = new TextField("Имя");
		ageField = new TextField("Возраст");
		birthdayField = new DateField("День рождения");
		streetField = new TextField("Название улицы");
		buildingNumberField = new TextField("Номер дома");
		
		FormLayout form = new FormLayout();
		form.setSizeUndefined();
		form.addComponent(nameField);
		form.addComponent(ageField);
		form.addComponent(birthdayField);
		form.addComponent(streetField);
		form.addComponent(buildingNumberField);
		
		btnShow = new Button("Show client");
		form.addComponent(btnShow);
		
		layout.addComponent(lableFilledClient);
		layout.addComponent(form);
		layout.setComponentAlignment(form, Alignment.TOP_CENTER);
		
		return layout;
	}
	
	private static Client getClient() {
		Client client = new Client();
		
		client.setName("John Smith");
		client.setAge(Integer.valueOf(26));
		
		Calendar cal = Calendar.getInstance();
		cal.set(1989, 9, 12);
		client.setBirthday(cal.getTime());
		
		client.setAddress(new Address("Lenina st.", "105"));
		
		return client;
	}
	
}
