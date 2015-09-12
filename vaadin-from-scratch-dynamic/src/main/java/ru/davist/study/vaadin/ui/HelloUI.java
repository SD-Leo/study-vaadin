/**
 * 12 сент. 2015 г.
 */
package ru.davist.study.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * @author danil
 *
 */
@Theme("valo")
@Title("Hello from Vaadin")
public class HelloUI extends UI {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		
		setContent(new Label("Hello from vaadin UI"));
		
	}
	
}
