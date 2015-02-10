import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by amurray on 08/02/15.
 */
public class Board extends JFrame {

    private JTextField[][] f = new JTextField[9][9];
    private JPanel[][] p = new JPanel[3][3];

    JTextField[][] textFields = new JTextField[9][9];

    public Board() {
        super("Sudoku");
        setSize(480, 480);

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

        setVisible(true);
    }

}
