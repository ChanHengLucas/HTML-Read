import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HTMLRead implements ActionListener{
    public static void main(String[] args) {
        HTMLRead html = new HTMLRead();
    }

    // Include GUI here

       public JFrame mainFrame;
       public JPanel mainPanel;
       public JPanel northPanel;
       public JPanel southPanel;
//       public JLabel URLLabel;
//       public JLabel SearchTermLabel;
       public JTextField inputURL;
       public JTextField inputSearchTerm;
       public JTextArea textArea;
       public JScrollPane scroll;
       public JButton inputConfirmButton;

     public void mainGUI() {

         mainFrame = new JFrame();
         mainPanel = new JPanel(new BorderLayout());
         northPanel = new JPanel();
         southPanel = new JPanel();
//         URLLabel = new JLabel();
//         SearchTermLabel = new JLabel();
         textArea = new JTextArea();
         textArea.setEditable(true);
         inputURL = new JTextField("Input URL: "); // replace text needed
         inputSearchTerm = new JTextField("Keyword: "); // replace text needed
         inputConfirmButton = new JButton("Confirm Input");
         inputConfirmButton.addActionListener(this);
         scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//         textArea.setText("Links:");
//         System.out.println(this.textArea);
     }


    public void actionPerformed(ActionEvent e) {

        Object buttonClicked = e.getSource();

        if (buttonClicked == inputConfirmButton){
            textArea.setText("");
            String s = inputURL.getText();
            String t = inputSearchTerm.getText();
            inputURL.setText("");
            inputSearchTerm.setText("");
            try {
                URL url = new URL(s); //replace with inputURL
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                String afterLine;
                while ((line = reader.readLine()) != null){
                    if (line.contains("a href")) {
                        int index = line.indexOf("a href");
                        int tempContainer = 0;
                        int otherTempContainer = 0;
                        int index2 = 0;
//                    int index2 = 1000;
//                    System.out.println(index + " ");
//                    System.out.println(index + ") " + line);
                        if (line.substring(index + 8).contains("\"")/* || line.substring(index + 6).contains("\'")*/){ //doesn't work, work on it next class
//                        System.out.println(line.substring(index));
//                        System.out.println(line.substring(index + 6));
                            index2 = line.substring(index + 8).indexOf("\"");
                            tempContainer = index + index2 + 8;
//                        if (index2 > line.substring(index + 6).indexOf("\'") &&
//                                line.substring(index + 6).indexOf("\'") != 0) {
//
//                            index2 = line.substring(index + 6).indexOf("\'");
//                        }
//                        System.out.println(line);
                            if (line.substring(index + 8, index + 8 + index2).contains(t)) {
                                System.out.println(line.substring(index + 8, index + 8 + index2));
                                textArea.setText(textArea.getText() + "\n" + line.substring(index + 8, index + 8 + index2));
                            }
                            //                        System.out.println(line.substring(index + 6));
                        } else {
                            System.out.println(line.substring(index + 8));
                        }


                        while (line.substring(tempContainer).contains("a href")){
//                        System.out.println(tempContainer);
//                        System.out.println(line);
                            index = line.substring(tempContainer).indexOf("a href");

//                        System.out.println(index + " | " + otherTempContainer);

                            if (index == otherTempContainer){
                                break;
                            }

                            if (line.substring(tempContainer + index + 8).contains("\"")){
                                index2 = line.substring(tempContainer + index + 8).indexOf("\"");
//                            tempContainer = index + index2 + 8;
                                if (line.substring(index + 8, index + 8 + index2).contains(t)) {
                                    System.out.println(line.substring(tempContainer + index + 8, tempContainer + index + index2 + 8));
                                    textArea.setText(textArea.getText() + "\n" + line.substring(tempContainer + index + 8, tempContainer + index + index2 + 8));
                                }
                                tempContainer = tempContainer + index + index2 + 8;
                                otherTempContainer = index;
                            }/* else {
                            System.out.println(line.substring(index + 8));
                            break;
                        }*/
                        }

//                    System.out.println(line);

//                    System.out.println(line.substring(index, (index+6)));
                    }
                }
            } catch(Exception a) {
                System.out.println(a);
            }
        }
    }

    public HTMLRead(){
         mainGUI();
         mainFrame.setVisible(true);
         try {
            URL url = new URL(inputURL.getText()); //replace with inputURL
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            String afterLine;
            while ((line = reader.readLine()) != null){
                if (line.contains("a href")) {
                    int index = line.indexOf("a href");
                    int tempContainer = 0;
                    int otherTempContainer = 0;
                    int index2 = 0;
//                    int index2 = 1000;
//                    System.out.println(index + " ");
//                    System.out.println(index + ") " + line);
                    if (line.substring(index + 8).contains("\"")/* || line.substring(index + 6).contains("\'")*/){ //doesn't work, work on it next class
//                        System.out.println(line.substring(index));
//                        System.out.println(line.substring(index + 6));
                        index2 = line.substring(index + 8).indexOf("\"");
                        tempContainer = index + index2 + 8;
//                        if (index2 > line.substring(index + 6).indexOf("\'") &&
//                                line.substring(index + 6).indexOf("\'") != 0) {
//
//                            index2 = line.substring(index + 6).indexOf("\'");
//                        }
//                        System.out.println(line);
                        System.out.println(line.substring(index + 8, index + 8 + index2));
                        textArea.setText(textArea.getText() + "\n" + line.substring(index + 8, index + 8 + index2));
    //                        System.out.println(line.substring(index + 6));
                    } else {
                        System.out.println(line.substring(index + 8));
                    }


                    while (line.substring(tempContainer).contains("a href")){
//                        System.out.println(tempContainer);
//                        System.out.println(line);
                        index = line.substring(tempContainer).indexOf("a href");

//                        System.out.println(index + " | " + otherTempContainer);

                        if (index == otherTempContainer){
                            break;
                        }

                        if (line.substring(tempContainer + index + 8).contains("\"")){
                            index2 = line.substring(tempContainer + index + 8).indexOf("\"");
//                            tempContainer = index + index2 + 8;
                            System.out.println(line.substring(tempContainer + index + 8, tempContainer + index + index2 + 8));
                            textArea.setText(textArea.getText() + "\n" + line.substring(tempContainer + index + 8, tempContainer + index + index2 + 8));
                            tempContainer = tempContainer + index + index2 + 8;
                            otherTempContainer = index;
                        }/* else {
                            System.out.println(line.substring(index + 8));
                            break;
                        }*/
                    }

//                    System.out.println(line);

//                    System.out.println(line.substring(index, (index+6)));
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
//change
        mainFrame.setSize(900, 600);
        mainFrame.add(mainPanel);
//        mainPanel.add(scroll);
//        mainFrame.getContentPane().add(scroll);
//        inputURL.setSize(200,10);
//        textArea.setSize(2000,1000);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
//        southPanel.add(URLLabel);
        southPanel.add(inputURL);
//        southPanel.add(SearchTermLabel);
        southPanel.add(inputSearchTerm);
        southPanel.add(inputConfirmButton);
    }

}
