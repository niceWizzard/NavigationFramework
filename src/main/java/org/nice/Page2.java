package org.nice;

import org.nice.navigation.Routeable;

import javax.swing.*;

public class Page2 extends Routeable {

    public Page2() {
        add(new JLabel("Page 2"));
    }
    @Override
    public void onNavigationEnter() {

    }

    @Override
    public void onNavigationExit(String newRoute) {

    }
}
