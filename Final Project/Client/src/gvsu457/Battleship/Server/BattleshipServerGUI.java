package gvsu457.Battleship.Server;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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

    public Battleship ship1 = new Battleship(2, false, 0, false, 1);
    public Battleship ship2 = new Battleship(3, false, 0, false, 2);
    public Battleship ship3 = new Battleship(3, false, 0, false, 3);
    public Battleship ship4 = new Battleship(4, false, 0, false, 4);
    public Battleship ship5 = new Battleship(5, false, 0, false, 5);

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
        placingShipOnePieceOne,
        placingShipOneFinalPiece,
        placingShipTwoPieceOne,
        placingShipThreePieceOne,
        placingShipTwoFinalPiece,
        placingShipThreeFinalPiece,
        placingShipFourPieceOne, placingShipFourFinalPiece, placingShipFiveFinalPiece, placingShipFivePieceOne, donePlacingPieces;
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
        topLevelPanel.add(checkBoxPanel1);
        topLevelPanel.add(shipPanel);
        topLevelPanel.add(checkBoxPanel2);

        topLevelPanel.add(guessPanel);
        add(topLevelPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        //at this point the game is all set up, so we can move on to placing 4 status.
        theGameStatus = gameStatus.placingShipOnePieceOne;

        JOptionPane.showMessageDialog(this, "Place size 5 ship please!");

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JComponent e = (JComponent) event.getSource();

        if (theGameStatus == gameStatus.placingShipOnePieceOne) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setAllButtonsEnabled(i, j, false);
                        setButtonsAroundSelectionEnabled(i, j, true, ship5.getSize());
                        selectionButtons[i][j].setText("" + ship5.getSize());
                        gameBoard[i][j] = ship5.getSize();
                    }
                }
            }
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipOneFinalPiece) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        selectionButtons[i][j].setText("" + ship5.getSize());
                        gameBoard[i][j] = ship5.getSize();
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(ship5.getSize());
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipTwoPieceOne) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setAllButtonsEnabled(i, j, false);
                        setButtonsAroundSelectionEnabled(i, j, true, ship4.getSize());
                        selectionButtons[i][j].setText("" + ship4.getSize());
                        gameBoard[i][j] = ship4.getSize();
                    }
                }
            }
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipTwoFinalPiece) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        selectionButtons[i][j].setText("" + ship4.getSize());
                        gameBoard[i][j] = ship4.getSize();
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(ship4.getSize());
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipThreePieceOne) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setAllButtonsEnabled(i, j, false);
                        setButtonsAroundSelectionEnabled(i, j, true, ship3.getSize());
                        selectionButtons[i][j].setText("" + ship3.getSize());
                        gameBoard[i][j] = ship3.getSize();
                    }
                }
            }
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipThreeFinalPiece) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        selectionButtons[i][j].setText("" + ship3.getSize());
                        gameBoard[i][j] = ship3.getSize();
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(ship3.getSize());
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipFourPieceOne) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setAllButtonsEnabled(i, j, false);
                        setButtonsAroundSelectionEnabled(i, j, true, ship2.getSize());
                        selectionButtons[i][j].setText("" + ship2.getSize());
                        gameBoard[i][j] = ship2.getSize();
                    }
                }
            }
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipFourFinalPiece) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        selectionButtons[i][j].setText("" + ship2.getSize());
                        gameBoard[i][j] = ship2.getSize();
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(ship2.getSize());
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipFivePieceOne) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        setAllButtonsEnabled(i, j, false);
                        setButtonsAroundSelectionEnabled(i, j, true, ship1.getSize());
                        selectionButtons[i][j].setText("" + ship1.getSize());
                        gameBoard[i][j] = ship1.getSize();
                    }
                }
            }
            setNextStatus();
        } else if (theGameStatus == gameStatus.placingShipFiveFinalPiece) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e == selectionButtons[i][j]) {
                        selectionButtons[i][j].setText("" + ship1.getSize());
                        gameBoard[i][j] = ship1.getSize();
                    }
                }
            }

            fillGapsBetweenButtonsForShipSize(ship1.getSize());
            setNextStatus();
        }
        printGameBoard();
    }

    private void setButtonsAroundSelectionEnabled(int row, int col, boolean enabled, int shipSize) {
        try {
            selectionButtons[row + shipSize - 1][col].setEnabled(enabled);
        } catch (IndexOutOfBoundsException indexOOB) {

        }
        try {
            selectionButtons[row - shipSize + 1][col].setEnabled(enabled);
        } catch (IndexOutOfBoundsException indexOOB) {

        }
        try {
            selectionButtons[row][col + shipSize - 1].setEnabled(enabled);
        } catch (IndexOutOfBoundsException indexOOB) {

        }
        try {
            selectionButtons[row][col - shipSize + 1].setEnabled(enabled);
        } catch (IndexOutOfBoundsException indexOOB) {

        }
    }

    private void fillGapsBetweenButtonsForShipSize(int shipSize) {
        boolean wasRow = false;
        int elementCountPerRow = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard[i][j] == shipSize) {
                    elementCountPerRow++;
                }
            }
            if (elementCountPerRow >= 2) {
                fillGapsForRow(i, shipSize, elementCountPerRow);
                wasRow = true;
            }
            elementCountPerRow = 0;
        }

        if (!wasRow) {
            int elementCountPerCol = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (gameBoard[j][i] == shipSize) {
                        elementCountPerCol++;
                    }
                }
                if (elementCountPerCol >= 2) {
                    fillGapsForCol(i, shipSize, elementCountPerRow);
                }
                elementCountPerRow = 0;
            }
        }
    }

    private void fillGapsForCol(int i, int shipSize, int currentCount) {
        int remainingPiecesToPlace = shipSize - currentCount;
        boolean wasFirstElementSeen = false;
        for (int j = 0; j < 10; j++) {
            if (remainingPiecesToPlace > 0) {
                if (wasFirstElementSeen && gameBoard[j][i] != shipSize) {
                    gameBoard[j][i] = shipSize;
                    selectionButtons[j][i].setText("" + shipSize);
                    remainingPiecesToPlace--;

                } else if (wasFirstElementSeen && gameBoard[j][i] == shipSize) {
                    //we are done.
                    return;
                } else {
                    if (gameBoard[j][i] == shipSize) {
                        wasFirstElementSeen = true;
                    }
                }
            }
        }

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

//        if (checkIfShipPlacementCompleteForCurrentStatus()) {
//            //go to next status...
//            setNextStatus();
//        }
    }

    //if the status changes we should renable buttons that aren't placed pieces too
    private void setNextStatus() {
        if (theGameStatus == gameStatus.placingShipOnePieceOne) {
            theGameStatus = gameStatus.placingShipOneFinalPiece;
        } else if (theGameStatus == gameStatus.placingShipOneFinalPiece) {
            setAllButtonsWithoutPlacementEnabled();
            JOptionPane.showMessageDialog(this, "Now pick the 4 piece ship!");
            theGameStatus = gameStatus.placingShipTwoPieceOne;
        } else if (theGameStatus == gameStatus.placingShipTwoPieceOne) {
            theGameStatus = gameStatus.placingShipTwoFinalPiece;
        } else if (theGameStatus == gameStatus.placingShipTwoFinalPiece) {
            setAllButtonsWithoutPlacementEnabled();
            JOptionPane.showMessageDialog(this, "Now pick the 3 piece ship!");
            theGameStatus = gameStatus.placingShipThreePieceOne;
        } else if (theGameStatus == gameStatus.placingShipThreePieceOne) {
            theGameStatus = gameStatus.placingShipThreeFinalPiece;
        } else if (theGameStatus == gameStatus.placingShipThreeFinalPiece) {
            setAllButtonsWithoutPlacementEnabled();
            JOptionPane.showMessageDialog(this, "Now pick the 3 piece ship!");
            theGameStatus = gameStatus.placingShipFourPieceOne;
        } else if (theGameStatus == gameStatus.placingShipFourPieceOne) {
            theGameStatus = gameStatus.placingShipFourFinalPiece;
        } else if (theGameStatus == gameStatus.placingShipFourFinalPiece) {
            setAllButtonsWithoutPlacementEnabled();
            JOptionPane.showMessageDialog(this, "Now pick the 2 piece ship!");
            theGameStatus = gameStatus.placingShipFivePieceOne;
        } else if (theGameStatus == gameStatus.placingShipFivePieceOne) {
            theGameStatus = gameStatus.placingShipFiveFinalPiece;
        } else if (theGameStatus == gameStatus.placingShipFiveFinalPiece) {
            setAllButtonsWithoutPlacementEnabled();
            JOptionPane.showMessageDialog(this, "You are finished placing pieces!");
            theGameStatus = gameStatus.donePlacingPieces;
        }

        //setAllButtonsWithoutPlacementEnabled();
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
                if (gameBoard[i][j] == shipSize) {
                    retVal++;
                }
            }
        }
        return retVal;
    }

    private void setAllButtonsEnabled(int row, int col, boolean enabled) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // if (i != row && j != col) {
                selectionButtons[i][j].setEnabled(enabled);
                // }
            }
        }
    }

    private void printGameBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // if (i != row && j != col) {
                System.out.print(gameBoard[i][j] + " ");
                // }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
