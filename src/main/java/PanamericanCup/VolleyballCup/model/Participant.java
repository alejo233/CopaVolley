/**
 * 
 */
package PanamericanCup.VolleyballCup.model;

import PanamericanCup.VolleyballCup.Exceptions.ParticipantAlreadyExistsException;

/**
 * @author 
 *
 */
public class Participant extends Person implements Comparable<Participant> {
	

	
	private Participant rigth;
	private Participant left;
	
	
	public Participant(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date) {
		super(id, first_name, last_name, email, gender, country, photo, date);
	}
	
	public Participant getRigth() {
		return rigth;
	}

	public void setRigth(Participant rigth) {
		this.rigth = rigth;
	}
	
	public Participant getLeft() {
		return left;
	}

	public void setLeft(Participant left) {
		this.left = left;
	}
	
	public Participant search(String id) {
		if(id.compareToIgnoreCase(id) == 0)
			return this;
		else if(id.compareToIgnoreCase(id) > 0)
			return (left == null) ? null: left.search(id);
		else 
			return (rigth == null) ? null: rigth.search(id);
	}
	
	public void add(Participant participant) throws ParticipantAlreadyExistsException {
		if(compareTo(participant) == 0) {
			throw new ParticipantAlreadyExistsException("The participant is already registered"+participant.getFirst_name()+" "+participant.getLast_name());
		}
		if (compareTo(participant) > 0) {
			if (left == null) {
				left = participant;
			}
			else {
				left.add(participant);
			}	
		}
		else {
			if (rigth == null) {
				rigth = participant;
			}
			else {
				rigth.add(participant);
			}	
		}
	}
	
	public int compareTo(Participant participant) {
		return super.getId().compareToIgnoreCase(participant.getId());
	}

	public void inOrden() {
		System.out.println(getId());
		if (left != null) {
			left.inOrden();
		}
		if(rigth != null) {
			rigth.inOrden();
		}
	}

}
