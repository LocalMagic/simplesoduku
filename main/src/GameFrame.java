import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    private final JPanel parentJPanel = new JPanel();
    private final JPanel buttonJPanel = new JPanel();
    private final JLabel jLabel = new JLabel("Validation result goes here");

    public GameFrame() {
        super("Sudoku");
        setSize(480, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setupButtonPanel();
        setupBoardPanel();
        setupParentPanel();

        add(parentJPanel);

    }

    private void setupParentPanel() {
        parentJPanel.add(boardJPanel);
        parentJPanel.add(buttonJPanel);
        parentJPanel.add(jLabel);
    }

    private void setupButtonPanel() {
        JButton validationJButton = new JButton("Validate");
        validationJButton.addActionListener(this);

        buttonJPanel.add(validationJButton);
        buttonJPanel.setPreferredSize(new Dimension(100, 100));
    }

    private void setupBoardPanel() {

        boardGridLayout = new GridLayout(9, 9);
        boardJPanel = new JPanel(boardGridLayout);

        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                textFields[i][j] = new JTextField("0");
                textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                boardJPanel.add(textFields[i][j]);
            }
        }

        boardJPanel.setPreferredSize(new Dimension(480, 480));
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

        // check rows
        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                currentArrayToValidate[j] = Byte.valueOf(textFields[i][j].getText());
                System.out.print(currentArrayToValidate[j] + ",");

            }

            System.out.println();

            if (!Main.isValidArray(currentArrayToValidate)) {
                isValid = false;
            }

        }

        // check columns
        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                currentArrayToValidate[j] = Byte.valueOf(textFields[j][i].getText());
                System.out.print(currentArrayToValidate[j] + ",");

            }

            System.out.println();

            if (!Main.isValidArray(currentArrayToValidate)) {
                isValid = false;
            }

        }

        if (isValid) {
            jLabel.setText("Congratulations the board is valid");
        } else {
            jLabel.setText("Sorry your solution is false");

        }

    }
}
