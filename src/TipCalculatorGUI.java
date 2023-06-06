import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TipCalculatorGUI extends JFrame implements ActionListener, KeyListener {
    private JPanel mainPanel;
    private JLabel billLabel;
    private JTextField billTextField;
    private JLabel tipPercentageLabel;
    private JTextField tipPercentageTextField;
    private JButton tipMinusButton;
    private JButton tipPlusButton;
    private JLabel peopleLabel;
    private JButton peopleMinusButton;
    private JButton peoplePlusButton;
    private JTextField peopleTextField;
    private JLabel totalTipLabel;
    private JTextField totalTipTextField;
    private JLabel totalPriceLabel;
    private JTextField totalPriceTextField;
    private TipCalculator newTC;

    public TipCalculatorGUI() {
        newTC = new TipCalculator(0, 30,1);
        createUIComponents();
    }

    public void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Tip Calculator");
        setSize(800, 450);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        billTextField.setText("" + newTC.getBill());
        tipPercentageTextField.setText("" + newTC.getTip());
        peopleTextField.setText("" + newTC.getNumberOfPeople());
        totalTipTextField.setText("$" + newTC.calculateTip());
        totalPriceTextField.setText("$" + newTC.totalBill());

        tipMinusButton.addActionListener(this);
        tipPlusButton.addActionListener(this);
        peopleMinusButton.addActionListener(this);
        peoplePlusButton.addActionListener(this);
        billTextField.addKeyListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        billTextField.setText(billTextField.getText());
        Object source = e.getSource();
        if(source == tipMinusButton) {
            if(newTC.getTip() != 0 ) {
                newTC.setTipPercentage(newTC.getTip() - 1);
                tipPercentageTextField.setText("" + newTC.getTip());
            }
        } else if(source == tipPlusButton) {
            newTC.setTipPercentage(newTC.getTip() + 1);
            tipPercentageTextField.setText("" + newTC.getTip());
        } else if (source == peopleMinusButton) {
            if(newTC.getNumberOfPeople() != 0) {
                newTC.setNumberOfPeople(newTC.getNumberOfPeople() - 1);
                peopleTextField.setText("" +  newTC.getNumberOfPeople());
            }
        } else {
            newTC.setNumberOfPeople(newTC.getNumberOfPeople() + 1);
            peopleTextField.setText("" +  newTC.getNumberOfPeople());
        }

        if(newTC.getNumberOfPeople() > 1) {
            totalTipLabel.setText("Tip per person");
            totalPriceLabel.setText("Total per person");
            totalTipTextField.setText("$" + newTC.tipPerPerson());
            totalPriceTextField.setText("$" + newTC.totalPerPerson());
        } else {
            totalTipLabel.setText("Tip");
            totalPriceLabel.setText("Total");
            totalTipTextField.setText("$" + newTC.calculateTip());
            totalPriceTextField.setText("$" + newTC.totalBill());
        }


    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            newTC.setBill(Integer.parseInt(billTextField.getText()));
            if(newTC.getNumberOfPeople() > 1) {
                totalTipLabel.setText("Tip per person");
                totalPriceLabel.setText("Total per person");
                totalTipTextField.setText("$" + newTC.tipPerPerson());
                totalPriceTextField.setText("$" + newTC.totalPerPerson());
            } else {
                totalTipLabel.setText("Tip");
                totalPriceLabel.setText("Total");
                totalTipTextField.setText("$" + newTC.calculateTip());
                totalPriceTextField.setText("$" + newTC.totalBill());
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }



}
