//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertNull;
	import static org.junit.Assert.assertTrue;
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
		
		private Viewer root;
		private Viewer left;
		private Viewer rigth;
		
		private Participant participant;
		private Participant prev;
		private Participant next;
		
		
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
		
		/**
		 * This scenary is created to test the adding and searching method over the binary searching tree
		 */
		private void setUpScenary3() {
			
			event = new Event();
			
			root = new Viewer("66784129", "Juan","Valencia","Juanchouni@hotmail.com",Gender.MALE,"Colombia",
					"https://image.com","13/03/2002");
			left = new Viewer("225894120", "Lina","Salinas", "linasalinasd7@gmail.com",Gender.FEMALE, "Japón",
					"https://facebookprofilegetImage.com", "28/04/1999");
			rigth = new Viewer("94586235148","Manuel","Reyes","reyes@correoicesi.edu.co", Gender.MALE,"EEUU",
					"https://slackgalley.com","06/10/1980");
		}
		
		/**
		 * This scenary is created to test the adding and searching method over the double linked list 
		 */
		private void setUpScenary4() {
			
			event = new Event();
			
			participant = new Participant("66784129", "Juan","Valencia","Juanchouni@hotmail.com",Gender.MALE,"Colombia",
					"https://image.com","13/03/2002");
			prev = new Participant("225894120", "Lina","Salinas", "linasalinasd7@gmail.com",Gender.FEMALE, "Japón",
					"https://facebookprofilegetImage.com", "31/05/1999");
			next = new Participant("94586235148","Manuel","Reyes","reyes@correoicesi.edu.co", Gender.MALE,"EEUU",
					"https://slackgalley.com","06/10/1980");
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
			
			setUpScenary3();
			
			assertNull("The root of the tree is already ocupied", event.getRoot());
			assertNull("This node already has an element in the left", root.getLeft());
			assertNull("This node already has an element in the right", root.getRight());
			
			event.addViewerToBST(root.getId(), root.getFirstName(), root.getLastName(), root.getEmail(), 
			root.getGender(),root.getCountry(), root.getImageurl(), root.getBirthday());
			
			event.addViewerToBST(left.getId(), left.getFirstName(), left.getLastName(), left.getEmail(), 
			left.getGender(),left.getCountry(), left.getImageurl(), left.getBirthday());
			
			event.addParticipantToLinkedList(rigth.getId(), rigth.getFirstName(), rigth.getLastName(), rigth.getEmail(), 
			rigth.getGender(),rigth.getCountry(), rigth.getImageurl(), rigth.getBirthday());
					
			assertNotNull(event.getRoot(), "The root node for this binary searching tree is null. it was not added as expected");
			assertNotNull(root.getLeft(), "The lefty node for this viewer is null. it was not added as expected");
			assertNotNull(root.getRight(), "The righty node for this viewer is null. it was not added as expected");
			
			
			assertTrue("The viewer node is not bigger than the lefty one", root.compareTo(left)>0);
			assertTrue("The viewer node is not smaller than the righty one", root.compareTo(rigth)<0);
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the searching method of a viewer of the model class Event, making sure that once the user wants to search 
		 * for an id the method searchs if wether someone is related with it or not
		 */
		public void testSearchForViewer() {
			
			setUpScenary3();
			
			event.addViewerToBST(root.getId(), root.getFirstName(), root.getLastName(), root.getEmail(), 
			root.getGender(),root.getCountry(), root.getImageurl(), root.getBirthday());
			
			event.addViewerToBST(left.getId(), left.getFirstName(), left.getLastName(), left.getEmail(), 
			left.getGender(),left.getCountry(), left.getImageurl(), left.getBirthday());
			
			event.addViewerToBST(rigth.getId(), rigth.getFirstName(), rigth.getLastName(), rigth.getEmail(), 
			rigth.getGender(),rigth.getCountry(), rigth.getImageurl(), rigth.getBirthday()); 
			 
			 
			Viewer searched = event.searchForViewer("225894120");
			assertNotNull("The searched node was null as not expected", searched);
			assertTrue("The id is not the one that was searched", "225894120".equals(searched.getId()));
			
			searched = event.searchForViewer("94586235148");
			
			assertNotNull("The searched node was null as not expected", searched);
			assertTrue("The id is not the one that was searched", "94586235148".equals(searched.getId()));
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method tests the adding method to a double linked list of the model class Event, making sure that once the fileText
		 * with the information of the assistants has been successfully read, the creation of the participants and their adding with the right
		 * criteria is the expected one
		 */
		public void testAddParticipantToLinkedList() {
			
			setUpScenary4();
		
			assertNull("The first element of the linked list is already ocupied", event.getFirst());
			assertNull("This node already has an element before it", participant.getPrev());
			assertNull("This node already has an element after it", participant.getNext());
			
			event.addParticipantToLinkedList(participant.getId(), participant.getFirstName(), participant.getLastName(), participant.getEmail(), 
			participant.getGender(),participant.getCountry(), participant.getImageurl(), participant.getBirthday());
			
			event.addParticipantToLinkedList(prev.getId(), prev.getFirstName(), prev.getLastName(), prev.getEmail(), 
			prev.getGender(),prev.getCountry(), prev.getImageurl(), prev.getBirthday());
			
			event.addParticipantToLinkedList(next.getId(), next.getFirstName(), next.getLastName(), next.getEmail(), 
			next.getGender(),next.getCountry(), next.getImageurl(), next.getBirthday()); 
			
			assertNotNull(event.getFirst(), "The first node for this double linked list is null. it was not added as expected");
			assertNotNull(participant.getPrev(), "The previous node for this participant is null. it was not added as expected");
			assertNotNull(participant.getNext(), "The next node for this participant is null. it was not added as expected");
			
			assertTrue("The participant node is not bigger than the previous one", participant.compareTo(prev)>0);
			assertTrue("The participant node is not smaller than the next one", participant.compareTo(next)<0);
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the searching method of a participant of the model class Event, making sure that once the user wants to search 
		 * for an id the method searchs if wether someone is related with it or not
		 */
		public void testSearchForParticipant() {
			
			setUpScenary4();
			
			event.addParticipantToLinkedList(participant.getId(), participant.getFirstName(), participant.getLastName(), participant.getEmail(), 
			participant.getGender(),participant.getCountry(), participant.getImageurl(), participant.getBirthday());
			
			event.addParticipantToLinkedList(prev.getId(), prev.getFirstName(), prev.getLastName(), prev.getEmail(), 
			prev.getGender(),prev.getCountry(), prev.getImageurl(), prev.getBirthday());
			
			event.addParticipantToLinkedList(next.getId(), next.getFirstName(), next.getLastName(), next.getEmail(), 
			next.getGender(),next.getCountry(), next.getImageurl(), next.getBirthday()); 
				
			Participant searched = event.searchForParticipant("94586235148");
	
			assertNotNull("The searched node was null as not expected", searched);
			assertTrue("The id is not the one that was searched", "94586235148".equals(searched.getId()));
			
			searched = event.searchForParticipant("225894120");
			
			assertNotNull("The searched node was null as not expected", searched);
			assertTrue("The id is not the one that was searched", "225894120".equals(searched.getId()));	
		}
//_________________________________________________________________________________________________________________________________________		
}
