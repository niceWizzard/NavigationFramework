package org.nice;

import org.nice.navigation.NavRoute;
import org.nice.navigation.NavigationPanel;

import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
    private final JPanel body;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setTitle("Navigation Try");
        body = new JPanel(new BorderLayout());


        init();

        setContentPane(body);
        setPreferredSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    private void init() {
        var navbar = new JPanel();
        var page1 = new JButton("Page 1");
        var page2 = new JButton("Page 2");
        var page3 = new JButton("Page 3");



        navbar.add(page1);
        navbar.add(page2);
        navbar.add(page3);

        body.add(navbar, BorderLayout.SOUTH);

        var p1 = new Page1();
        p1.add(new JLabel("LKSJDFD"));
        var main = new NavigationPanel(new NavRoute[]{
                new NavRoute(p1, "page1" ),
                new NavRoute(new Page2(), "page2")
        });

        body.add(main, "Center");

        page1.addActionListener(e -> {
            main.navigateTo("page1");
        });
        page2.addActionListener(e -> {
            main.navigateTo("page2");
        });
    }
}