
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.add(new JScrollPane(textArea)); // add text area inside a scroll pane

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
    /*
    if(actionEven.getSource() == cut) {
        Perform cut operation
    }
    if(actionEven.getSource() == copy) {
        Perform copy operation
    }
    */

    }

    
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
    }
}