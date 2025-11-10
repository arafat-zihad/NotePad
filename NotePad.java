
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class NotePad {

    // Creating Application Window
    JFrame  frame;
    JMenuBar manuBar;
    JMenu file, edit;

    public NotePad() { // When ever this NotePad constructor call a frame will be created

        frame = new JFrame(); // Initialize a frame
        manuBar = new JMenuBar(); 

        // Step 1: Createing JFrame (Application Window)
        frame.setBounds(0, 0, 400, 400); //Set Dimention of the frame
        frame.setLayout(null);
        frame.setJMenuBar(manuBar); // Add menubar into the frame




        // Step 2: Creating manuBar

        //Inicialize manubar
        // Set menuBar to frame

        
        // Step 3: Create and complete the Manus(file, edit) before add to the manuBar and frame
        file = new JMenu("File");
        edit = new JMenu("Edit");
        // Add manu to menuBar
        manuBar.add(file);
        manuBar.add(edit);





        frame.setVisible(true);
    }

    
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
    }


}