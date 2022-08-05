package main.java.com.globalsoftwaresupport.ui;

import main.java.com.globalsoftwaresupport.constants.Constants;
import main.java.com.globalsoftwaresupport.image.Image;
import main.java.com.globalsoftwaresupport.image.ImageFactory;

import javax.swing.*;

public class GameMainFrame  extends JFrame {
    public GameMainFrame(){
        initializeLayout();
    }

    private void initializeLayout() {
        add(new GamePanel());

        setTitle(Constants.TITLE);
        setIconImage(ImageFactory.createImage(Image.DUCK_WHITE).getImage());

        pack();

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }
}
