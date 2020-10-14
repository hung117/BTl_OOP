import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
    private ArrayList<Word> data = new ArrayList<Word>();


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

                    //try {
                    /*} catch (IOException ioException) {
                        ioException.printStackTrace();
                    }*/
                    if(dicAction.addWord(strT,strE,strP,data)){
                        textAreaO.setText("added successfully");
                    }else textAreaO.setText("Duplicate word");
                }
            }
        });

        showWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    textAreaO.setText(dicAction.showWord(data));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }*/
                textAreaO.setText(dicAction.showWord(data));
            }
        });
        SearchWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtomicBoolean suggested = new AtomicBoolean();
                /*AtomicBoolean suggested = new AtomicBoolean();
                //textAreaS.setText("test");   // test xem suggest field co hoat dong ko

                try {
                    String searched = dicAction.searchWord(textFieldT.getText(), suggested); // lay ket qua search dc
                    if(suggested.get()){ // neu suggest = true
                        textAreaS.setText(searched);

                    }
                    else textAreaO.setText(searched);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
                String searchedWord = dicAction.searchWord(textFieldT.getText(),data, suggested);
                if(suggested.get()){
                    textAreaS.setText(searchedWord);
                }else textAreaO.setText(searchedWord);
            }
        });
        deleteWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try {
                    if(dicAction.deleteWord(textFieldT.getText())){
                        textAreaO.setText("Delete successfully");
                    }
                    else textAreaO.setText("Your word doesn't exist");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
                textAreaO.setText(dicAction.deleteWord(data, textFieldT.getText()));
            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dicAction.readFile(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dicAction.writeToFile(data);
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
    private JButton readButton;
    private JButton writeButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    // public SwingGUI(JFrame frame,JButton addWordButton)
}
