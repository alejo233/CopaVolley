package PanamericanCup.VolleyballCup.model;

public class Assistant extends Person implements Comparable<Assistant>{
	
	private Assistant next;
	private Assistant prev;
	
	public Assistant(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date) {
		super(id, first_name, last_name, email, gender, country, photo, date);
	}

	public void addPrev( Assistant assistant ) {
		assistant.next = this;
		assistant.prev = prev;
		if( prev != null )
		{
			prev.next = assistant;
		}
		prev = assistant;
	}
	
	public void addNext( Assistant assistant )
	{
		assistant.next = next;
		assistant.prev = this;
		if( next != null )
		{
			next.prev = assistant;
		}
		next = assistant;
	}
	
	public Assistant getNext() {
		return next;
	}

	public void setNext(Assistant next) {
		this.next = next;
	}

	public Assistant getPrev() {
		return prev;
	}

	public void setPrev(Assistant prev) {
		this.prev = prev;
	}

	public int compareTo(Assistant assistant) {
		return getId().compareToIgnoreCase(assistant.getId());
	}

}
