package org.nice;

import org.nice.navigation.Routeable;

import javax.swing.*;
import java.awt.*;

public class Page1 extends Routeable{
    public Page1() {
        setPreferredSize(new Dimension(280, 480));
        add(new JLabel("Page 1"));
        setBackground(new Color(0x92999));
    }
    @Override
    public void onNavigationEnter() {
        System.out.println("HELLO From page 1!");
    }

    @Override
    public void onNavigationExit(String newRoute) {

    }
}
