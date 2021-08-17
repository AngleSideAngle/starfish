package tri.anglesideangle.starfish.display;

import javax.swing.JFrame;

public class Display {
    private JFrame frame;

    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        initFrame();
    }

    private void initFrame() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // maybe change later
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
