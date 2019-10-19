/**
 * 
 */
package PanamericanCup.VolleyballCup.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ASUS
 *
 */
public class VolleyballCup {

	private ParticipantManager participantManager;
	private AssistantManager assistantManager;
	
	/**
	 * 
	 */
	public VolleyballCup() {
		participantManager = new ParticipantManager();
		assistantManager = new AssistantManager();
	}
	
	public void loadParticipants(String path) {
		File file = new File(path);
		FileReader fileReader;
		BufferedReader bufferedReader;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = bufferedReader.readLine();
				int aux = 0;
				while (read != null) {
					read = bufferedReader.readLine();
					System.out.println(read);
					if (read!=null) {
						String[] data = read.split(",");
						participantManager.add(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
						if (aux %2 == 0)
							assistantManager.add(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
						aux++;
					}	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Se ha cargado el archivo correctamente");
	}

	public ParticipantManager getParticipantManager() {
		return participantManager;
	}

	public void setParticipantManager(ParticipantManager participantManager) {
		this.participantManager = participantManager;
	}

	public AssistantManager getAssistantManager() {
		return assistantManager;
	}

	public void setAssistantManager(AssistantManager assistantManager) {
		this.assistantManager = assistantManager;
	}

}
