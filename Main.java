package frames;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(() -> new PatientInfo().FirstFrame()); 
        // new PatientInfo().FirstFrame();       
	}
}