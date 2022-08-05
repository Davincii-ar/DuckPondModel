package main.java.com.globalsoftwaresupport.ui;

import main.java.com.globalsoftwaresupport.callbacks.Time;
import main.java.com.globalsoftwaresupport.constants.Constants;
import main.java.com.globalsoftwaresupport.image.Image;
import main.java.com.globalsoftwaresupport.image.ImageFactory;
import main.java.com.globalsoftwaresupport.model.Duck;
import main.java.com.globalsoftwaresupport.model.Rock;
import main.java.com.globalsoftwaresupport.model.WaterLily;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;

import java.util.*;
import java.util.List;


public class GamePanel extends JPanel {

    private ImageIcon backgroundImage;
    private Timer timer;

    private Time time;
    private java.util.Timer chronoSpawn;
    private java.util.Timer chronoDeath;
    private int timeDeath;

    private List<Rock> rocks;
    private List<WaterLily> waterLilies;
    private List<Duck> ducks;

    GamePanel(){
        initializeVariables();
        initializeLayout();
        initializeWaterlilies();
        initializeDucks();
    }
    // INITIALIZATION
    private void initializeVariables() {
        this.time = new Time();
        this.chronoSpawn = time.getChrono();
        this.chronoDeath = new java.util.Timer();
        this.timeDeath = 0;

        this.rocks = new ArrayList<>();
        this.waterLilies = new ArrayList<>();
        this.ducks = new ArrayList<>();

        this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
        ImageIcon rockImage = ImageFactory.createImage(Image.ROCK);
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();

    }
    private void initializeLayout() {
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
    }

    // WATERLILIES
    private void initializeWaterlilies(){
        // Waterlilies
        for(int i=0; i<Constants.WATERLILIES_ROW; i++){
            for(int j=0; j<Constants.WATERLILIES_COLUMN; j++){
                if(i == 0 || i == Constants.WATERLILIES_ROW-1 || j == 0 || j == Constants.WATERLILIES_COLUMN-1){
                    WaterLily waterLily = new WaterLily(Constants.WATERLILY_X + Constants.WATERLILY_GAP_X * j,
                                                        Constants.WATERLILY_Y + Constants.WATERLILY_GAP_Y * i);
                    this.waterLilies.add(waterLily);
                }
                else{
                    Rock rock = new Rock(Constants.WATERLILY_X + Constants.WATERLILY_GAP_X * j,
                                         Constants.WATERLILY_Y + Constants.WATERLILY_GAP_Y * i);
                    this.rocks.add(rock);
                }
            }
        }
        for(int i = 0; i < waterLilies.size() ; i++){
            int r = new Random().nextInt(Constants.RANDOM_WATERLILIES);
            if (r != 1){
                waterLilies.get(i).setVisible(false);
            }
        }
    }
    private void drawRocks(Graphics g){
        for (int i = 0; i < rocks.size() ; i++){
        g.drawImage(rocks.get(i).getImage(), rocks.get(i).getX(), rocks.get(i).getY(), this);
        }
    }
    private void drawWaterLilies(Graphics g){
        for (int i = 0; i < waterLilies.size() ; i++){
            if(waterLilies.get(i).isVisible()){
                g.drawImage(waterLilies.get(i).getImage(), waterLilies.get(i).getX(), waterLilies.get(i).getY(), this);
            }
        }
    }

    // DUCKS
    private void initializeDucks(){
        // Ducks
        Duck duck = new Duck();
        this.ducks.add(duck);
    }
    private void drawDuck(Graphics g){
        for(int i = 0; i < ducks.size() ; i++){
            if(!ducks.get(i).isDead()){
                g.drawImage(ducks.get(i).getImage(), ducks.get(i).getX(), ducks.get(i).getY(), this);
            }
        }

    }
    private void eating(){
        for (int i = 0; i < ducks.size() ; i++){
            for (int j = 0; j < waterLilies.size() ; j++){
                int waterlilyX = waterLilies.get(j).getX();
                int waterlilyY = waterLilies.get(j).getY();
                int duckX = ducks.get(i).getX();
                int duckY = ducks.get(i).getY();
                if(waterLilies.get(j).isVisible())
                if(waterlilyX-20 <= duckX && duckX <= waterlilyX+20){
                    if(waterlilyY-20 <= duckY && duckY <= waterlilyY+20){
                        waterLilies.get(j).setVisible(false);
                        if(ducks.get(i).getColor() != Constants.DUCK_MAX_COLOR)
                            ducks.get(i).setColor(ducks.get(i).getColor()+1);
                    }
                }
            }
        }
    }


    // DRAWING
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage.getImage(), 0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT, null);

        doDrawing(g);
    }
    private void doDrawing(Graphics g){
        boolean inGame = true;
        if(inGame){
            drawRocks(g);
            drawWaterLilies(g);
            drawDuck(g);
        } else{
            if(timer.isRunning()){
                timer.stop();
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    // UPDATE
    public void doOneLoop(){
        update();
        repaint();
    }
    private void update(){
        // ducks eating
        eating();
        // reset waterlilies
        this.chronoSpawn.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Constants.SPAWN);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initializeWaterlilies();
                initializeDucks();
            }
        }, Constants.SPAWN, Constants.SPAWN);
        // decrease weight of the duck
        this.chronoDeath.schedule(new TimerTask() {
            @Override
            public void run() {
                if(timeDeath == Constants.DECREASE){
                    //duckDecrease();
                    timeDeath = 0;
                }
                timeDeath ++;
            }
        }, 0);

        // move ducks
        for (int i = 0; i < ducks.size() ; i++){
            if(!ducks.get(i).isDead()){
                ducks.get(i).move();
            }
        }
    }
}
