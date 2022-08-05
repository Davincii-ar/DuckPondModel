package main.java.com.globalsoftwaresupport.model;

import main.java.com.globalsoftwaresupport.image.Image;
import main.java.com.globalsoftwaresupport.image.ImageFactory;

import javax.swing.ImageIcon;

public class WaterLily extends Sprite{
    private boolean visible = true;

    public WaterLily(int x, int y){
        this.x = x;
        this.y = y;
        initialize();
    }

    private void initialize(){
        ImageIcon imageIcon = ImageFactory.createImage(Image.WATERLILY);
        setImage(imageIcon.getImage());
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    @Override
    public void move() {
    }
}
