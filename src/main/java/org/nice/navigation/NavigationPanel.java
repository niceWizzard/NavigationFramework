package org.nice.navigation;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/** Makes navigating between different panels easier.
 *
 */
public class NavigationPanel extends JPanel  {

    private final CardLayout cardLayout = new CardLayout();
    private final Map<String, Routeable> routeMap = new HashMap<>();

    private NavRoute activeRoute;

    /**
     * @return the current active route.
     */
    public NavRoute getActiveRoute() {
        return activeRoute;
    }


    private void setActiveRoute(NavRoute newRoute) {
        if(activeRoute != null) {
            activeRoute.component().onNavigationExit(newRoute.route());
        }
        activeRoute = newRoute;
        cardLayout.show(this, newRoute.route());
    }


    public NavigationPanel()  {
        initialize();
    }

    public NavigationPanel(NavRoute[] initRoute)  {
        initialize(initRoute);
    }


    /** Adds a new route-component pair
     */
    public void addRoute(String route, Routeable component) {
        routeMap.put(route, component);
        add(component, route);
    }

    /** Shows the panel to the specific route.
     * @param route the route to switch
     */
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
