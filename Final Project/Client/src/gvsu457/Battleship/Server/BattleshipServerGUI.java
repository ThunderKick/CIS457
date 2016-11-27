package gvsu457.Battleship.Server;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Administrator on 11/27/2016.
 */
public class BattleshipServerGUI extends JFrame implements ActionListener {

    public JPanel topLevelPanel;
    public JPanel shipPanel;
    public JPanel guessPanel;
    public JPanel checkBoxPanel1;
    public JPanel checkBoxPanel2;
    public JPanel mainPanel;
    public JPanel topLeftPanel;
    public JPanel topRightPanel;
    public JButton[][] selectionButtons = new JButton[10][10];
    public JButton[][] guessButtons = new JButton[10][10];
    public int[][] gameBoard = new int[10][10];

    private JCheckBox box1;
    private JCheckBox box2;
    private JCheckBox box3;
    private JCheckBox box4;
    private JCheckBox box5;

    private JCheckBox theirBox1;
    private JCheckBox theirBox2;
    private JCheckBox theirBox3;
    private JCheckBox theirBox4;
    private JCheckBox theirBox5;


    private JLabel yourShipsLabel;
    private JLabel theirShipsLabel;

    public Battleship ship1 = new Battleship(2, false, 0, false);
    public Battleship ship2 = new Battleship(3, false, 0, false);
    public Battleship ship3 = new Battleship(3, false, 0, false);
    public Battleship ship4 = new Battleship(4, false, 0, false);
    public Battleship ship5 = new Battleship(5, false, 0, false);

    public ArrayList<Battleship> battleshipsArray = new ArrayList<Battleship>();

    public gameStatus theGameStatus = gameStatus.initialSetup;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    public enum gameStatus {
        initialSetup,
        placing4one,
        placing4two,
        placing4three,
        placing4four,
        placing3;
    }

    public BattleshipServerGUI() {

        super("hello world");

        topLevelPanel = new JPanel(new FlowLayout());
        shipPanel = new JPanel(new GridLayout(10, 10));
        shipPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 5), "Ship Board"));
        guessPanel = new JPanel(new GridLayout(10, 10));
        guessPanel.setBorder(new TitledBorder(new LineBorder(Color.YELLOW, 5), "Guess Board"));
        checkBoxPanel1 = new JPanel();
        checkBoxPanel1.setLayout(new BoxLayout(checkBoxPanel1, BoxLayout.PAGE_AXIS));
        checkBoxPanel2 = new JPanel();
        checkBoxPanel2.setLayout(new BoxLayout(checkBoxPanel2, BoxLayout.PAGE_AXIS));
        topLeftPanel = new JPanel();
        topRightPanel = new JPanel();

        box1 = new JCheckBox("Cruiser    (2)");
        box1.setEnabled(false);
        box2 = new JCheckBox("Submarine  (3)");
        box2.setEnabled(false);
        box3 = new JCheckBox("Cruiser    (3)");
        box3.setEnabled(false);
        box4 = new JCheckBox("Battleship (4)");
        box4.setEnabled(false);
        box5 = new JCheckBox("Carrier    (5)");
        box5.setEnabled(false);

        theirBox1 = new JCheckBox("Cruiser    (2)");
        theirBox1.setEnabled(false);
        theirBox2 = new JCheckBox("Submarine  (3)");
        theirBox2.setEnabled(false);
        theirBox3 = new JCheckBox("Cruiser    (3)");
        theirBox3.setEnabled(false);
        theirBox4 = new JCheckBox("Battleship (4)");
        theirBox4.setEnabled(false);
        theirBox5 = new JCheckBox("Carrier    (5)");
        theirBox5.setEnabled(false);

        yourShipsLabel = new JLabel("Your Ships Remaining");
        theirShipsLabel = new JLabel("Their Ships Remaining");

        checkBoxPanel1.add(yourShipsLabel);
        checkBoxPanel1.add(box1);
        checkBoxPanel1.add(box2);
        checkBoxPanel1.add(box3);
        checkBoxPanel1.add(box4);
        checkBoxPanel1.add(box5);

        checkBoxPanel2.add(theirShipsLabel);
        checkBoxPanel2.add(theirBox1);
        checkBoxPanel2.add(theirBox2);
        checkBoxPanel2.add(theirBox3);
        checkBoxPanel2.add(theirBox4);
        checkBoxPanel2.add(theirBox5);

        battleshipsArray.add(ship1);
        battleshipsArray.add(ship2);
        battleshipsArray.add(ship3);
        battleshipsArray.add(ship4);
        battleshipsArray.add(ship5);

        //setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                selectionButtons[i][j] = new JButton();
                selectionButtons[i][j].addActionListener(this);
                selectionButtons[i][j].setPreferredSize(new Dimension(50, 50));
                shipPanel.add(selectionButtons[i][j]);
                gameBoard[i][j] = -1;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                guessButtons[i][j] = new JButton();
                guessButtons[i][j].addActionListener(this);
                guessButtons[i][j].setPreferredSize(new Dimension(50, 50));
                guessPanel.add(guessButtons[i][j]);
            }
        }
        //topLevelPanel.add(BorderLayout.WEST, checkBoxPanel);
        //topLeftPanel.add(checkBoxPanel);
        topLevelPanel.add(checkBoxPanel1);
        //topRightPanel.add(checkBoxPanel);

        topLevelPanel.add(shipPanel);
        topLevelPanel.add(checkBoxPanel2);

        topLevelPanel.add(guessPanel);
        add(topLevelPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        //at this point the game is all set up, so we can move on to placing 4 status.
        theGameStatus = gameStatus.placing4one;

        placeSizeFourShip();

        //at this point the game can move on to placing 3 status on so on until all ships are placed...
        //theGameStatus = gameStatus.placing3;

    }

    private void placeSizeFourShip() {
        JOptionPane.showMessageDialog(this, "Place size 4 ship please!");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JComponent e = (JComponent) event.getSource();

        if (theGameStatus == gameStatus.placing4one) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setNonRowColButtonsEnabled(i, j, false);
                        selectionButtons[i][j].setText("" + 4);
                        gameBoard[i][j] = 4;
                    }
                }
            }
            //after a spot was claimed figure out the next status.
            int nextStatus = 4 - getHowPiecesHaveBeenLayedForShipSize(4);

            if (nextStatus == 1) {
                theGameStatus = gameStatus.placing4four;
            } else if (nextStatus == 2) {
                theGameStatus = gameStatus.placing4three;
            } else if (nextStatus == 3) {
                theGameStatus = gameStatus.placing4two;
            } else if (nextStatus == 0) {
                theGameStatus = gameStatus.placing3;
            }

        } else if (theGameStatus == gameStatus.placing4two) {
            //set the piece and fill the gaps!
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        //setNonRowColButtonsEnabled(i, j, false);
                        selectionButtons[i][j].setText("" + 4);
                        gameBoard[i][j] = 4;
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(4);

        } else if (theGameStatus == gameStatus.placing4three) {

        } else if (theGameStatus == gameStatus.placing4four) {

        }

    }

    private void fillGapsBetweenButtonsForShipSize(int shipSize) {
        int elementCountPerRow = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard[i][j] == shipSize) {
                    elementCountPerRow++;
                }
            }
            if (elementCountPerRow >= 2) {
                fillGapsForRow(i, shipSize, elementCountPerRow);
            }
        }
    }

    private boolean checkIfShipPlacementCompleteForCurrentStatus() {
        if (theGameStatus == gameStatus.placing4one || theGameStatus == gameStatus.placing4two
                || theGameStatus == gameStatus.placing4three || theGameStatus == gameStatus.placing4four) {
            int count = getHowPiecesHaveBeenLayedForShipSize(4);
            if (count == 4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void fillGapsForRow(int i, int shipSize, int currentCount) {
        int remainingPiecesToPlace = shipSize - currentCount;
        boolean wasFirstElementSeen = false;
        for (int j = 0; j < 10; j++) {
            if (remainingPiecesToPlace > 0) {
                if (wasFirstElementSeen && gameBoard[i][j] != shipSize) {
                    gameBoard[i][j] = shipSize;
                    selectionButtons[i][j].setText("" + shipSize);
                    remainingPiecesToPlace--;

                } else if (wasFirstElementSeen && gameBoard[i][j] == shipSize) {
                    //we are done.
                    return;
                } else {
                    if (gameBoard[i][j] == shipSize) {
                        wasFirstElementSeen = true;
                    }
                }
            }
        }

        if (checkIfShipPlacementCompleteForCurrentStatus()) {
            //go to next status...
            setNextStatus();
        }
    }

    //if the status changes we should renable buttons that aren't placed pieces too
    private void setNextStatus() {
        if (theGameStatus == gameStatus.placing4one || theGameStatus == gameStatus.placing4two
                || theGameStatus == gameStatus.placing4three || theGameStatus == gameStatus.placing4four) {
            theGameStatus = gameStatus.placing3;
            setAllButtonsWithoutPlacementEnabled();
        }
    }

    private void setAllButtonsWithoutPlacementEnabled() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard[i][j] == -1) {
                    selectionButtons[i][j].setEnabled(true);
                } else {
                    selectionButtons[i][j].setEnabled(false);
                }
            }
        }
    }

    private int getHowPiecesHaveBeenLayedForShipSize(int shipSize) {
        int retVal = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard[i][j] == 4) {
                    retVal++;
                }
            }
        }
        return retVal;
    }

    private void setNonRowColButtonsEnabled(int row, int col, boolean enabled) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != row && j != col) {
                    selectionButtons[i][j].setEnabled(enabled);
                }
            }
        }

    }

}

