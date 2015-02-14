import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
public class GameFrame extends JFrame implements ActionListener, FocusListener {

    private JTextField[][] f = new JTextField[9][9];
    private JPanel[][] p = new JPanel[3][3];

    JTextField[][] textFields = new JTextField[9][9];
    private JPanel boardJPanel;

    private GridLayout boardGridLayout;
    private final JPanel parentJPanel = new JPanel();
    private final JPanel buttonJPanel = new JPanel();
    private final JLabel jLabel = new JLabel();

    private Rules rules = new Rules();

    public GameFrame() {
        super("Sudoku");
        setSize(490, 600);
        setResizable(false);
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
        buttonJPanel.setPreferredSize(new Dimension(480, 40));
    }

    /**
     * This created the main board panel, and adds the textFields used to input numbers for the game. These textFields
     * are also formatted and have different background colors set to them depending on which subsection they are in.
     */
    private void setupBoardPanel() {

        boardGridLayout = new GridLayout(9, 9, 2, 2); // the 2,2 is used to add a gap between the cells for a border
        boardJPanel = new JPanel(boardGridLayout);

        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {

                textFields[i][j] = new JTextField("0");
                textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                textFields[i][j].setBorder(BorderFactory.createLineBorder(Color.lightGray, 0)); //
                textFields[i][j].addFocusListener(this);

                /* sets the background color to light gray for particular subsections, uses the coordinates to decide on
                 * which ones should be made gray etc. */
                if (j < 3 && i < 3 || j > 5 && i < 3 || j < 3 && i > 5 || j > 5 && i > 5
                        || j > 2 && j < 6 && i < 6 && i > 2) {
                    textFields[i][j].setBackground(Color.lightGray);
                }

                boardJPanel.add(textFields[i][j]);

            }
        }

        boardJPanel.setPreferredSize(new Dimension(480, 480));
    }

    /**
     * This is used to handle events from the buttons. Because we added a actionListener to the button this is called
     * when it is pressed.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {

        byte[][] board = new byte[9][9];

        for (int i = 0; i < boardGridLayout.getRows(); i++) {
            for (int j = 0; j < boardGridLayout.getColumns(); j++) {
                board[i][j] = Byte.valueOf(textFields[i][j].getText());
            }
        }

        Rules rules = new Rules();
        if (rules.isValidBoard(board)) {
            jLabel.setText("Congratulations the board is valid");
        } else {
            jLabel.setText("Sorry your solution is false");

        }

    }

    /**
     * This is used for the textFields. Everytime a textfield is focussed on then we select all the text making it
     * easier for the user to change the values.
     */
    @Override
    public void focusGained(final FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            ((JTextField) e.getSource()).selectAll();

        }
    }

    /**
     * This is used for the textFields. Required but currently doesn't do anything.
     */
    @Override
    public void focusLost(final FocusEvent e) { }
}
