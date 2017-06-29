package ru.davist.study.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    private TextField name;
    private Button button;
//    private Button logout;
    private VerticalLayout layout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        System.out.println(sdf.format(new Date()) + ": Init " + this);
        layout = new VerticalLayout();

        name = new TextField();
        name.setCaption("Type your name here:");

        button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() + ", it works!: " +  VaadinSession.getCurrent().getSession().getId()));
            System.out.println(sdf.format(new Date()) + ": Session: " +  VaadinSession.getCurrent().getSession().getId());
            System.out.println(sdf.format(new Date()) + ": IsCloseIdle: " +  VaadinSession.getCurrent().getConfiguration().isCloseIdleSessions());
            System.out.println(sdf.format(new Date()) + ": HeartBeat: " +  VaadinSession.getCurrent().getConfiguration().getHeartbeatInterval() + " seconds, MaxInactiveInterval: " +  VaadinSession.getCurrent().getSession().getMaxInactiveInterval() + " seconds");

            System.out.println("-=-=-=-=-");
        });

//        logout = new Button("Get over here!", event -> {
//            System.out.println(sdf.format(new Date()) + ": Close session: " +  VaadinSession.getCurrent().getSession().getId());
//            VaadinSession.getCurrent().close();
//            Page.getCurrent().reload();
//        });


        layout.addComponents(name, button);

        setContent(layout);
    }

    @Override
    public void detach() {
        System.out.println(sdf.format(new Date()) + ": Detach and Close UI " + this);
        super.detach();
    }

}
