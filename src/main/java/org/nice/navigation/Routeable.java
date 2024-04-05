package org.nice.navigation;

import javax.swing.*;

public abstract class Routeable extends JPanel {
    public abstract void onNavigationEnter();

    public abstract void onNavigationExit(String newRoute);
}
