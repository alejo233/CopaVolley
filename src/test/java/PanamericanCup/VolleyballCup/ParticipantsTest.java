package PanamericanCup.VolleyballCup;

import junit.framework.TestCase;

import org.junit.Test;

import PanamericanCup.VolleyballCup.model.ParticipantManager;

public class ParticipantsTest extends TestCase {
	private ParticipantManager participantManager;
	
	private void setupScene1() {
		participantManager = new ParticipantManager();	
	}
	
	private void setupScene2() {
		setupScene1();
		participantManager.add("1", "", "", "", "", "", "", "");
		participantManager.add("2", "", "", "", "", "", "", "");
		participantManager.add("3", "", "", "", "", "", "", "");
		participantManager.add("4", "", "", "", "", "", "", "");
	}
	
	private void addTest() {
		for (int i = 0; i < participantManager.getSize(); i++) {
			assertTrue(participantManager.search(""+(i+1)).equals(i+1));
		}
	}
	
	@Test
	private void setupScene3() {
		setupScene1();
		participantManager.add("1", "", "", "", "", "", "", "");
		participantManager.add("2", "", "", "", "", "", "", "");
	}
	
	@Test
	public void addSearch() {
		setupScene3();
		for (int i = 0; i < participantManager.getSize(); i++) {
			assertTrue(participantManager.search(""+(i+1)).equals(i+1));
		}
	}
}
