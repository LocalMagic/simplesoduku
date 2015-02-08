import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(final String[] args) {

        JFrame jFrame = new JFrame();

        // FRAME setup
        // todo fra: play around and see what jframe. settings you can change
        jFrame.setSize(640, 640);
        jFrame.setTitle("Simple Sudoku");

        // PANEL setup
        JPanel jPanel = new JPanel(new GridLayout(9, 9));
        jPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jFrame.add(new JPanel());
        jFrame.setVisible(true);

    }

}
