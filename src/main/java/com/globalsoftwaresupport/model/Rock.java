package main.java.com.globalsoftwaresupport.model;

import main.java.com.globalsoftwaresupport.image.Image;
import main.java.com.globalsoftwaresupport.image.ImageFactory;

import javax.swing.*;

public class Rock extends Sprite{
    public Rock(int x, int y) {
        this.x = x;
        this.y = y;
        initialize();
    }

    private void initialize(){
        ImageIcon imageIcon = ImageFactory.createImage(Image.ROCK);
        setImage(imageIcon.getImage());
    }

    @Override
    public void move() {

    }
}
