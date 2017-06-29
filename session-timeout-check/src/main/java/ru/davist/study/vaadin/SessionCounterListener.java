package ru.davist.study.vaadin;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionCounterListener implements HttpSessionListener {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    private static int totalActiveSessions;

    public static int getTotalActiveSession() {
        return totalActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;

        System.out.println(sdf.format(new Date()) + ": HttpSession created " + arg0.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        totalActiveSessions--;
        System.out.println(sdf.format(new Date()) + ": HttpSession destroyed " + arg0.getSession().getId());
    }
}