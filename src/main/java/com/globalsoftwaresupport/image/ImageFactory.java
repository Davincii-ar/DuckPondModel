package main.java.com.globalsoftwaresupport.image;

import main.java.com.globalsoftwaresupport.constants.Constants;

import javax.swing.ImageIcon;


public class ImageFactory {
    public static ImageIcon createImage(Image image){
        ImageIcon imageIcon = null;

        switch(image){
            case BACKGROUND:
                imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
                break;
            case ROCK:
                imageIcon = new ImageIcon(Constants.ROCK_IMAGE_URL);
                break;
            case WATERLILY:
                imageIcon = new ImageIcon(Constants.WATERLILY_IMAGE_URL);
                break;
            case DUCK_GREY_1:
                imageIcon = new ImageIcon(Constants.DUCK_GREY_1_IMAGE_URL);
                break;
            case DUCK_GREY_2:
                imageIcon = new ImageIcon(Constants.DUCK_GREY_2_IMAGE_URL);
                break;
            case DUCK_ORANGE_1:
                imageIcon = new ImageIcon(Constants.DUCK_ORANGE_1_IMAGE_URL);
                break;
            case DUCK_ORANGE_2:
                imageIcon = new ImageIcon(Constants.DUCK_ORANGE_2_IMAGE_URL);
                break;
            case DUCK_WHITE:
                imageIcon = new ImageIcon(Constants.DUCK_WHITE_IMAGE_URL);
                break;
            default:
                break;
        }
        return imageIcon;
    }
}
