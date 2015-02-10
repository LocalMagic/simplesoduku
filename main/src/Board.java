import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by amurray on 08/02/15.
 */
public class Board extends JFrame {

    JTextField[][] textFields = new JTextField[9][9];

    public Board() {
        super();

        setTitle("Simple Sudoku");
        setSize(480, 480);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(9, 9));

        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields.length; j++) {

                textFields[i][j] = new JTextField("0");
                textFields[i][j].setHorizontalAlignment(JTextField.CENTER);

                jPanel.add(textFields[i][j]);

            }

        }

        add(jPanel);
        setVisible(true);

        // JText Area array

    }

}
