package PanamericanCup.VolleyballCup.model;

public interface IStructuresManager  {
	public void add(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String date);
	
	public Participant search(String id);	
}
