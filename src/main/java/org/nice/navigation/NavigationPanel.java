package org.nice.navigation;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class NavigationPanel extends JPanel  {

    private final CardLayout cardLayout = new CardLayout();
    private Map<String, Routeable> routeMap = new HashMap<>();

    private NavRoute activeRoute;
    private Routeable activeRouteable;

    public NavRoute getActiveRoute() {
        return activeRoute;
    }
    private void setActiveRoute(NavRoute newRoute) {
        if(activeRouteable != null) {
            activeRouteable.onNavigationExit(newRoute.route());
        }
        activeRoute = newRoute;
        activeRouteable = newRoute.component();
        cardLayout.show(this, newRoute.route());
    }


    public NavigationPanel()  {
        initialize();
    }

    public NavigationPanel(NavRoute[] initRoute)  {
        initialize(initRoute);
    }


    public void addRoute(String route, Routeable component) {

        routeMap.put(route, component);
    }

    public void navigateTo(String route) {
        if(Objects.equals(activeRoute.route(), route)) {
            return;
        }
        var componentClass = routeMap.get(route);
        setActiveRoute(new NavRoute(componentClass, route));

    }

    private void initialize(NavRoute... initRoute) {
        setLayout(cardLayout);
        for(var r : initRoute) {
            routeMap.put(r.route(), r.component());
            add(r.component(), r.route());
        }
        if(initRoute.length > 0) {
            NavRoute firstRoute = initRoute[0];
            setActiveRoute(firstRoute);
        }





    }
}
