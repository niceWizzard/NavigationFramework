package org.nice.navigation;

import javax.swing.*;
import java.awt.*;


/** This is a data class to hold information for Navigation
 * @param component the Routeable component
 * @param route the route to show the component
 */
public record NavRoute(Routeable component, String route) {

}