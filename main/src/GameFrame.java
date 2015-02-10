import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Created by amurray on 08/02/15.
 */
public class GameFrame extends JFrame implements ActionListener {

    private JTextField[][] f = new JTextField[9][9];
    private JPanel[][] p = new JPanel[3][3];

    JTextField[][] textFields = new JTextField[9][9];
    private JPanel boardJPanel;
    private GridLayout boardGridLayout;

    public GameFrame() {
        super("Sudoku");
        setSize(480, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        FlowLayout parentFlowLayout = new FlowLayout();

        JPanel parentJPanel = new JPanel(parentFlowLayout);
        JPanel buttonJPanel = new JPanel();

        JButton validationJButton = new JButton();
        validationJButton.addActionListener(this);
        validationJButton.setText("Validate");
        buttonJPanel.add(validationJButton);

        setupBoardJPanel();

        buttonJPanel.setBorder(BorderFactory.createLineBorder(Color.green, 5));
        parentJPanel.setBorder(BorderFactory.createLineBorder(Color.red, 5));

        parentJPanel.add(boardJPanel);
        parentJPanel.add(buttonJPanel);

        add(parentJPanel);

    }

    private void setupBoardJPanel() {

        boardGridLayout = new GridLayout(9, 9);

        boardJPanel = new JPanel(boardGridLayout);

        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                textFields[i][j] = new JTextField("0");

                boardJPanel.add(textFields[i][j]);

            }
        }

        textFields[4][1].setText("5");
        boardJPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
    }

    private void setupBoardWithSubSections() {
        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                f[x][y] = new JTextField(1);
            }
        }

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                p[x][y] = new JPanel(new GridLayout(3, 3));
                p[x][y].setBorder(BorderFactory.createLineBorder(Color.black, 2));

            }
        }

        setLayout(new GridLayout(3, 3));

        // only creates one subSection you need to call this multiple times
        for (int u = 0; u <= 2; u++) {
            for (int i = 0; i <= 2; i++) {
                for (int x = 0; x <= 2; x++) {
                    for (int y = 0; y <= 2; y++) {
                        p[u][i].add(f[y][x]);
                        f[y][x].setText(y + "," + x);
                    }

                }

                add(p[u][i]);

            }
        }
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        byte[] currentArrayToValidate = new byte[9];
        boolean isValid = true;

        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                currentArrayToValidate[j] = Byte.valueOf(textFields[i][j].getText());
                if (!Main.isValidArray(currentArrayToValidate)) {
                    isValid = false;
                }

            }

        }

        if (isValid) {
            System.out.println("Congratulations the board is valid");

        } else {
            System.out.println("Sorry your solution is false");
        }

    }
}
