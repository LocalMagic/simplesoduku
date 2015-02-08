import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    public static void main(final String[] args) {

        JFrame jFrame = new JFrame();

        JMenuBar jMenuBar = new JMenuBar();

        // FRAME setup
        // todo fra: play around and see what jframe. settings you can change
        jFrame.setSize(640, 640);
        jFrame.setTitle("Simple Sudoku");

        // PANEL setup
        GridLayout gridLayout = new GridLayout(9, 9);

        JPanel jPanel = new JPanel(gridLayout);

        for (int i = 0; i < gridLayout.getColumns(); i++) {

            for (int j = 0; j < gridLayout.getRows(); j++) {

                JTextField jTextField = new JTextField();

                if (j == 4 && i == 4) {
                    jTextField.setText("5");
                }

                jPanel.add(jTextField);

            }

            jPanel.add(new JTextField());
        }
        
        
        
        
        

        jFrame.add(jPanel);

        jFrame.setVisible(true);

    }
    
    
    public void 

}
