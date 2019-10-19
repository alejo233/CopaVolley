/**
 * 
 */
package PanamericanCup.VolleyballCup.UI;
import java.util.Scanner;

import PanamericanCup.VolleyballCup.model.Assistant;
import PanamericanCup.VolleyballCup.model.Participant;
import PanamericanCup.VolleyballCup.model.VolleyballCup;
/**
 * @author ASUS
 *
 */
public class Interfaz {

	private Scanner scanner;
	private  VolleyballCup volleyballCup;
	/**
	 * 
	 */
	public Interfaz() {
		scanner =  new Scanner(System.in);
		volleyballCup = new VolleyballCup();
		System.out.println("Ingrese la ruta del archivo a cargar ");
		String path = "C:\\Users\\ASUS\\Downloads\\MOCK_DATA.csv"; //scanner.nextLine();
		volleyballCup.loadParticipants(path);
		showMenu();
	}
	
	public void showMenu() {
		
		boolean aux = true;
		String menu = "Escoja una de las opciones \n1.Imprimir lista de posibles participantes \n2.Imprimir lista de Participantes\n3.Buscar Participante \n4.Buscar Asistente\n 0. Para salir";
		String option = "";

		while (option != "0" && aux) {
			System.out.println(menu);
			option = scanner.nextLine();
			switch (option) {
			case "1":
				participantList();
				break;
			case "2":
				System.out.println("Ingrese el pais donde desee la lista de asistentes");
				String country = scanner.nextLine();
				assistantList(country);
				break;
			case "3":
				System.out.println("Ingrese el ID del participante a buscar");
				String id = scanner.nextLine();
				 long TInicio, TFin, tiempo; 
				 TInicio = System.currentTimeMillis();
				 Participant participant = searchParticipant(id);
				 TFin = System.currentTimeMillis();
				 tiempo = TFin - TInicio;
				 if(participant != null) {
					 System.out.printf("ID: %s%nNombre: %s%nApellido: %s%nEmail: %s%nGenero: %s%nPaís: %s%nPhoto: %s%nFecha de Nacimiento: %s%n",
							 participant.getId(), participant.getFirst_name(), participant.getLast_name(), participant.getEmail(), participant.getGender(), 
							 participant.getCountry(), participant.getPhoto(), participant.getDate());
				 }
				 else {
					 System.out.println("No se ha encontrado el participante");
				 }

				 System.out.println("La busqueda se ha realizado en " + tiempo+" milisegundos"); 
				break;
			case "4":
				System.out.println("Ingrese el ID del asistente a buscar");
				String id2 = scanner.nextLine();
				 long TInicio2, TFin2, tiempo2; 
				 TInicio2 = System.currentTimeMillis();
				 Assistant assistant = searchAssistant(id2);
				 TFin2 = System.currentTimeMillis();
				 tiempo2 = TFin2 - TInicio2;
				 if(assistant != null) {
					 System.out.printf("ID: %s%nNombre: %s%nApellido: %s%nEmail: %s%nGenero: %s%nPaís: %s%nPhoto: %s%nFecha de Nacimiento: %s%n",
							 assistant.getId(), assistant.getFirst_name(), assistant.getLast_name(), assistant.getEmail(), assistant.getGender(), 
							 assistant.getCountry(), assistant.getPhoto(), assistant.getDate());
				 }
				 else {
					 System.out.println("No se ha encontrado el Asistente");
				 }

				 System.out.println("La busqueda se ha realizado en " + tiempo2+" milisegundos"); 			
				 break;
			default:
				aux = false;
			}
		}
		System.out.println("Terminada la ejecución del programa");
	}

	private Assistant searchAssistant(String id) {
		return volleyballCup.getAssistantManager().search(id);
	}

	private Participant searchParticipant(String id) {
		return volleyballCup.getParticipantManager().search(id);
	}

	private void assistantList(String country) {
		volleyballCup.getAssistantManager().getAssistants(country);
	}

	private void participantList() {
		volleyballCup.getParticipantManager().getParticipants();
	}
	
	public static void main(String[] args) {
		Interfaz interfaz = new Interfaz();
	}

}
