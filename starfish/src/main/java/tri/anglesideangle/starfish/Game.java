package tri.anglesideangle.starfish;

import tri.anglesideangle.starfish.display.Display;

public class Game {
    private Display display;

    public int width, height;

    public Game(String title, int width, int height) {
        
        this.width = width;
        this.height = height;

        display = new Display(title, width, height);
    }
}
