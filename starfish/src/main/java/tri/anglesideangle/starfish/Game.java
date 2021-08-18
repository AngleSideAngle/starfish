package tri.anglesideangle.starfish;

import tri.anglesideangle.starfish.display.Display;
import tri.anglesideangle.starfish.gfx.imageLoader;

import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImg;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
        testImg = imageLoader.loadImage("/textures/test.png");
    }

    private void tick() {

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        
        // start drawing
        g.clearRect(0, 0, width, height);
        g.setColor(Color.CYAN);
        g.fillRect(19, 50, 10, 10);
        g.drawImage(testImg, 0, 0, null);


        // end drawing
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        while(running) {
            tick();
            render();
        }

        stop();
    }

    public synchronized void start() {
        if(running) return;
        running = true;
        
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running) return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
