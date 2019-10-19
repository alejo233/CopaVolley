package PanamericanCup.VolleyballCup.model;

import PanamericanCup.VolleyballCup.Exceptions.ParticipantAlreadyExistsException;

public class ParticipantManager implements IStructuresManager {

	private Participant root;
	private int size;
	
	public ParticipantManager() {
		root = null;
		size = 0;
	}
	
	public void add(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date) {
		Participant participant = new Participant(id, first_name, last_name, email, gender, country, photo, date);
		if(root == null) {
			root = participant;
		}
		else {
			try {
				root.add(participant);
			} catch (ParticipantAlreadyExistsException e) {
				e.printStackTrace();
			}
		}
		size++;
	}
	
	public void getParticipants() {
		if(root == null) {
			System.out.println("No hay registros");
		}
		else {
			root.inOrden();
		}
	}

	public Participant search(String id) {
		return root == null ? null:  root.search(id);
	}
	
	public Participant getRoot() {
		return root;
	}

	public void setRoot(Participant root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
