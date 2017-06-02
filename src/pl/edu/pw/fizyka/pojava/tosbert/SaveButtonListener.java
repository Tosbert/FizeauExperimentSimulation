package pl.edu.pw.fizyka.pojava.tosbert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class SaveButtonListener implements ActionListener{ //Antonina Pater

	Frame frame;

	public SaveButtonListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			frame.chooser.setDialogTitle("Wybierz miejsce gdzie zapisaÄ‡ plik.");

			int result = frame.chooser.showSaveDialog(null);
			if (result != JFileChooser.APPROVE_OPTION){
				return;
			}
			frame.to = frame.chooser.getSelectedFile();
			//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(frame.to), "UTF-8") );

			//		FileWriter writer = new FileWriter(frame.to);
			//		notes.write(writer);

			PrintWriter pr = new PrintWriter(frame.to); 

			pr.println("n: "+ this.frame.bottom.settings.nTeeth.getSelectedItem());
			pr.println("d[m]: "+ this.frame.bottom.settings.distance.getSelectedItem());
			pr.println("w[rad/s] \t Q/Qmax");
			for (int i=0; i<frame.bottom.graph.data.length ; i++)
			{
				if(frame.bottom.graph.data[i]>-1){
					pr.println(i*5 + " \t " + frame.bottom.graph.data[i]/255.0);
				}
			}
			pr.close();
		}

		catch (IOException ee) {

			ee.printStackTrace();
		}		
	}


}


