import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
public class TipCalculatorGUI extends JFrame implements ActionListener{
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
        newTC = new TipCalculator(0.0, 15,1);
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

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton) {
            JButton button = (JButton) source;
            String text = button.getText();
            if(text.equals("-")) {
                tipPercentageTextField.setText("100");
            } else {
                tipPercentageTextField.setText("101");
            }
        }

    }


}
