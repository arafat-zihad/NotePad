
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePad {
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

        //Initialize edit menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");


        //add menu item to edit manu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //add menu items to file manu
        file.add(newFile); 
        file.add(openFile);
        file.add(saveFile);

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
    

    
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
    }
}