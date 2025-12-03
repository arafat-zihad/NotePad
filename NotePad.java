
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePad implements ActionListener {
    // Declaring propertise of NotePad
    JFrame frame;

    JMenuBar menuBar;
    JMenu file, edit;

    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectAll, close;

    JTextArea textArea;

    NotePad() {
        frame = new JFrame(); //Initialize a frame
        menuBar = new JMenuBar(); //Initialize a manubar
        textArea = new JTextArea(); //Initialize a textarea

        file = new JMenu("File"); //Initialize manu 1
        edit = new JMenu("Edit"); //Initialize manu 2

        //Initialize file manuItem
        newFile = new JMenuItem("New Window"); 
        openFile = new JMenuItem("Open File"); 
        saveFile = new JMenuItem("Save File");

        //Between Initialization and add items add Axtion listener to file menus
        newFile.addActionListener(this); //this keyword refering to te object of NotePad
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        //add menu items to file manu
        file.add(newFile); 
        file.add(openFile);
        file.add(saveFile);

        //Initialize edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        //Between Initialization and add items add Axtion listener to edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //add menu item to edit manu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        

        //add menu1 to menubar
        menuBar.add(file); 
        menuBar.add(edit);

        frame.setJMenuBar(menuBar); // set menuBar to frame

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setBounds(0, 0, 500, 500);
        frame.setTitle("NotePad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // To open window in the middle
        // keep default BorderLayout so the text area fills the window
        


        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){ //It respons when user interacts via ActionListener interface  when a even occour what it
    //first we need to get the source of the action event
        if(actionEvent.getSource()==cut){
            textArea.cut();
        }

        if(actionEvent.getSource()==copy){
            textArea.copy();
        }
        if(actionEvent.getSource()==paste){
            textArea.paste();
        }
        if(actionEvent.getSource()==selectAll){
            textArea.selectAll();
        }
        if(actionEvent.getSource()==close){
            System.exit(0);
        }

        if(actionEvent.getSource()==openFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                    String intermediate;
                    StringBuilder output = new StringBuilder();
                    while ((intermediate = bufferedReader.readLine()) != null) {
                        output.append(intermediate).append('\n');
                    }
                    textArea.setText(output.toString());
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }


            }
        }

        if(actionEvent.getSource() == saveFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showSaveDialog(null);
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");

                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(bufferedWriter);
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }

        if(actionEvent.getSource()==newFile){
            NotePad newTextEditorr = new NotePad();
        }

    }

    public static void main(String[] args) {
        NotePad notePad = new NotePad();
    }
}