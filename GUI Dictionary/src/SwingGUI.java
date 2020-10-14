import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.Border;

public class SwingGUI extends DictionaryManagement {
    private JFrame frame;
    private JPanel panel;
    private JButton addWordButton;
    private JButton deleteWordButton;
    private JButton showWordButton;
    private JTextField textFieldT;
    protected String strT = null;
    protected String strE = null;
    protected String strP = null;
    private DictGUIAction dicAction = new DictGUIAction();
    DictDataFile curFile = new DictDataFile();


    public void action() {
        addWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strT = textFieldT.getText();
                strT = strT.toLowerCase();
                strE = textFieldE.getText();
                strE = strE.toLowerCase();
                strP = textFieldP.getText();
                strP = strP.toLowerCase();
                if(strT.equals("")){
                    textAreaO.setText("please enter valid word");
                }
                else {
                    textAreaO.setText("added successfully");
                    try {
                        dicAction.addWord(strT, strE, strP, curFile);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        showWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textAreaO.setText(dicAction.showWord(curFile));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        SearchWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtomicBoolean suggested = new AtomicBoolean();
                //textAreaS.setText("test");   // test xem suggest field co hoat dong ko

                try {
                    String searched = dicAction.searchWord(textFieldT.getText(), suggested); // lay ket qua search dc
                    if(suggested.get()){ // neu suggest = true
                        textAreaS.setText(searched);

                    }
                    else textAreaO.setText(searched);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        deleteWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(dicAction.deleteWord(textFieldT.getText(),false)){
                        textAreaO.setText("Delete successfully");
                    }
                    else textAreaO.setText("Your word doesn't exist");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }


    public void CreateGUI() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, (int) 20);
        textAreaS.setMargin(new Insets(10, 10, 10, 10));
        textAreaO.setMargin(new Insets(10, 10, 10, 10));
        //   textAreaS.setBorder(border);
        //   textAreaO.setBorder(border);

        frame = new JFrame();
        frame.add(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DICTIONARY_with_GUI");
        frame.pack();
        frame.setVisible(true);

        textAreaO.setEditable(false);
        textAreaS.setEditable(false);

        action();

    }

    private JTextField textFieldE;
    private JTextArea textAreaO;
    private JTextField textFieldP;
    private JPanel rootPanel;
    private JTextArea textAreaS;
    private JLabel Suggestion;
    private JButton SearchWordButton;
    private JTextField textFieldSearch;

    // public SwingGUI(JFrame frame,JButton addWordButton)
}
