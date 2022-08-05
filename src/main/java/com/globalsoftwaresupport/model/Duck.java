package main.java.com.globalsoftwaresupport.model;

import main.java.com.globalsoftwaresupport.constants.Constants;
import main.java.com.globalsoftwaresupport.image.Image;
import main.java.com.globalsoftwaresupport.image.ImageFactory;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.io.File;
import java.util.Random;

public class Duck extends Sprite{
    private boolean visible = true;
    protected int color;

    public Duck(){
        this.dx = 1;
        this.dy = 1;
        this.direction = 1;
        this.size = 1;
        initialize();
    }

    private void initialize(){
        ImageIcon imageIcon = ImageFactory.createImage(Image.DUCK_GREY_1);
        setImage(imageIcon.getImage());

        int start_x = Constants.WATERLILY_X + Constants.WATERLILY_GAP_X * Constants.WATERLILIES_COLUMN - Constants.WATERLILY_GAP_X;
        int start_y = Constants.WATERLILY_Y + Constants.WATERLILY_GAP_Y * Constants.WATERLILIES_ROW - Constants.WATERLILY_GAP_Y;

        setX(start_x);
        setY(start_y);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public void changeColor(){
        if(this.color == 0){
            this.die();
        }
        // GREY 1
        if(this.color == 1){
            ImageIcon imageIcon = ImageFactory.createImage(Image.DUCK_GREY_2);
            setImage(imageIcon.getImage());
        }
        // GREY 2
        if(this.color == 2){
            ImageIcon imageIcon = ImageFactory.createImage(Image.DUCK_ORANGE_1);
            setImage(imageIcon.getImage());
        }
        // ORANGE 1
        if(this.color == 3){
            ImageIcon imageIcon = ImageFactory.createImage(Image.DUCK_ORANGE_2);
            setImage(imageIcon.getImage());
        }
        // ORANGE 2
        if(this.color == 4){
            ImageIcon imageIcon = ImageFactory.createImage(Image.DUCK_WHITE);
            setImage(imageIcon.getImage());
            whistling();
        }
        // CHIEF DUCK (WHITE)

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        changeColor();
    }

    public int changeDirection(){
        if(this.y <= Constants.WATERLILY_Y + Constants.WATERLILY_GAP_Y * Constants.WATERLILIES_ROW - Constants.WATERLILY_GAP_Y)
            {// en haut
            if(y <= Constants.WATERLILY_Y){
                int r = new Random().nextInt(4); // Descend, Gauche, Droite
                switch(r){
                    case 1:
                        y += 1;
                        direction = 2;
                        break;
                    case 2:
                        y += 1;
                        direction = 3;
                        break;
                    case 3:
                        y += 1;
                        direction = 4;
                        break;
                    default:
                        break;
                }
            }
            // en bas
            if(this.y >= Constants.WATERLILY_Y + Constants.WATERLILY_GAP_Y * Constants.WATERLILIES_ROW - Constants.WATERLILY_GAP_Y){
                int r = new Random().nextInt(4); // Monte, Gauche, Droite  //
                switch(r){
                    case 1:
                        y -= 1;
                        direction = 1;
                        break;
                    case 2:
                        y -= 1;
                        direction = 3;
                        break;
                    case 3:
                        y -= 1;
                        direction = 4;
                        break;
                    default:
                        break;
                }
            }
            // à gauche
            if(this.x <= Constants.WATERLILY_X){
                int r = new Random().nextInt(4); // Monte, Descend, Droite
                switch(r){
                    case 1:
                        x += 1;
                        direction = 1;
                        break;
                    case 2:
                        x += 1;
                        direction = 2;
                        break;
                    case 3:
                        direction = 4;
                        break;

                    default:
                        break;
                }
            }
            // à droite
            if(this.x >= Constants.WATERLILY_X+Constants.WATERLILIES_COLUMN*Constants.WATERLILY_GAP_X - Constants.WATERLILY_GAP_X){
                int r = new Random().nextInt(4); // Monte, Descend, Gauche,
                switch(r){
                    case 1:
                        x -= 1;
                        direction = 1;
                        break;
                    case 2:
                        x -= 1;
                        direction = 2;
                        break;
                    case 3:
                        direction = 3;
                        break;
                    default:
                        break;
                }
            }
}
        return direction;
    }

    public static void whistling() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(Constants.WHISTLING)));
            clip.start();
        } catch(Exception ignored){}
    }

    @Override
    public void move() {
        changeDirection();
        switch (direction){
            case 1:
                y -= dy;
                break;
            case 2:
                y += dy;
                break;
            case 3:
                x -= dx;
                break;
            case 4:
                x += dx;
                break;
            default:
                y -= dy;
                break;
        }
        }
}
