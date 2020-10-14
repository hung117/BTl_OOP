import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton addWordButton;
    private JButton deleteWordButtton;
    private JButton showWordButton;
    private JButton loadWordButton;
    private JTextField textFieldT;

    public SwingGUI() {
        addWordButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
               String strT =  textFieldT.getText();
               strT = strT.toLowerCase();
               String strE = textFieldE.getText();
               strE = strE.toLowerCase();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingGUI");
        frame.setContentPane(new SwingGUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTextField textFieldE;
    private JTextArea textArea1;
    private JTextField textFieldP;
    private JPanel rootPanel;

    // public SwingGUI(JFrame frame,JButton addWordButton)
}
