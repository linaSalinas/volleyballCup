//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.jupiter.api.Assertions.*;
	import java.io.IOException;
	import org.junit.jupiter.api.Test;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary methods to manage and test the model class Participant
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class EventTest {

		private Event event;
		
		/**
		 * This scenary is created to test the constructor method
		 */
		private void setUpScenary1() {
			
		}
		
		/**
		 * This scenary is created to test the reading of the TextFile
		 */
		private void setUpScenary2() {
			event = new Event();
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method tests the constructor method of the model class event, making sure that an event can be created so its methods
		 * can be used to solve the general and specific problems
		 */
		public void testEvent() {
			
			setUpScenary1();
			
			Event event = new Event();
			
			assertNotNull(event,"The value was not the expected one, this was null. the event could not be instanced");	
		}
	//_____________________________________________________________________________________________________________________________________
		
		@Test
		/**
		 * This method tests the loadInformation method of the model class event, making sure that an event can load all the information
		 * needed to register the all persons that are going to assist to the cup celebration.
		 */
		public void testLoadInformation() {
			
			setUpScenary2();
			
			try {
				event.loadInformation("C:\\Users\\Usuario\\Documents\\eclipse-workspace\\volleyballCup\\src\\data\\information_data.txt");
				
			}
			catch(IOException ioe) {
				fail("The Method does not work event with the right path of the textfile");
			}
			
			try {
				event.loadInformation("C:\\Desktop\\NotTheRightFile.txt");
				fail();
			}
			catch(IOException ioe) {
				assertTrue("C:\\Desktop\\NotTheRightFile.txt"!="C:\\Users\\Usuario\\Documents\\eclipse-workspace\\volleyballCup\\src\\data\\information_data.txt");
			}
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the adding method to a binary searching tree of the model class Event, making sure that once the fileText
		 * with the information of the assistants has been successfully read the creation of the viewers and their adding with the right
		 * criteria is being the expected one
		 */
		public void testAddViewerToBST() {
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the searching method of a viewer of the model class Event, making sure that once the user wants to search 
		 * for an id the method searchs if wether someone is related with it or not
		 */
		public void testSearchForViewer() {
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method tests the adding method to a double linked list of the model class Event, making sure that once the fileText
		 * with the information of the assistants has been successfully read, the creation of the participants and their adding with the right
		 * criteria is the expected one
		 */
		public void testAddParticipantToLinkedList() {
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the searching method of a participant of the model class Event, making sure that once the user wants to search 
		 * for an id the method searchs if wether someone is related with it or not
		 */
		public void testSearchForParticipant() {
			
		}
//_________________________________________________________________________________________________________________________________________		
}
