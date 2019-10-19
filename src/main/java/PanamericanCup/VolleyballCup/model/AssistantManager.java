/**
 * 
 */
package PanamericanCup.VolleyballCup.model;

/**
 * @author ASUS
 *
 */
public class AssistantManager {
	
	private Assistant first;

	private Assistant last;

	private int size;

	/**
	 * 
	 */
	public AssistantManager() {
		first = null;
		last = null;
		size = 0;
	}

	public void add(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date) {
		Assistant assistant = new Assistant(id, first_name, last_name, email, gender, country, photo, date);

		if(first==null){
			first= assistant;
			last= assistant;
		}
		else
		{
			assistant.setPrev(last);	
			last.setNext(assistant);
			last= assistant;
		}
		size++;
	}
	
	public Assistant search(String id) {
		Assistant assistant = first;
		while(assistant!=null){
			if(id.equals(assistant.getId())){
				return assistant;
			}
			assistant = assistant.getNext();
		}
		return null;
	}
	
	public Assistant getFirst() {
		return first;
	}


	public void setFirst(Assistant first) {
		this.first = first;
	}


	public Assistant getLast() {
		return last;
	}


	public void setLast(Assistant last) {
		this.last = last;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	public void getAssistants(String country) {
		Assistant assistant = first;
		while (assistant != null) {
			if(assistant.getCountry().equals(country)) {
				System.out.print(assistant.getId()+" ");
			}
			assistant = assistant.getNext();
		}
		System.out.println("");	}
}
