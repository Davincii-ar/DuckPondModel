package main.java.com.globalsoftwaresupport.constants;

import java.util.Random;

public class Constants {
    private Constants(){

    }
    // setting
    public static final String TITLE = "The duck pond model";
    public static final int BOARD_WIDTH = 1250;
    public static final int BOARD_HEIGHT = 850;
    public static final int GAME_SPEED = 10;

    // song
    public static final String WHISTLING = "resources/sounds/whistle.wav";


    // images
    public static final String BACKGROUND_IMAGE_URL = "resources/images/background.jpg";
    public static final String ROCK_IMAGE_URL = "resources/images/rock.png";
    public static final String WATERLILY_IMAGE_URL = "resources/images/waterlily.png";
    public static final String DUCK_GREY_1_IMAGE_URL = "resources/images/duck-grey-1.png";
    public static final String DUCK_GREY_2_IMAGE_URL = "resources/images/duck-grey-2.png";
    public static final String DUCK_ORANGE_1_IMAGE_URL = "resources/images/duck-orange-1.png";
    public static final String DUCK_ORANGE_2_IMAGE_URL = "resources/images/duck-orange-2.png";
    public static final String DUCK_WHITE_IMAGE_URL = "resources/images/duck-white.png";

    // waterlilies
    public static final int WATERLILY_WIDTH = 100;
    public static final int WATERLILY_HEIGHT= 83;
    public static final int WATERLILY_X = 50;
    public static final int WATERLILY_Y = 50;
    public static final int WATERLILY_GAP_X = 250;
    public static final int WATERLILY_GAP_Y = 150;
    public static final int WATERLILIES_ROW = 5;
    public static final int WATERLILIES_COLUMN = 5;
    public static final int RANDOM_WATERLILIES = 3;

    // ducks
    public static final int STARTING_POINT = 18;
    public static final int DUCK_MAX_COLOR = 5;

    // time
    public static final int SPAWN= 10000;
    public static final int DECREASE= 2500;
}
