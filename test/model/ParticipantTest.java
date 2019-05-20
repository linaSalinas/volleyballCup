//_________________________________________________________________________________________________________________________________________
	package model;
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary methods to manage and test the model class Participant
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	class ParticipantTest {
		
		private Participant participant;
		private Participant participant2;
		
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		/**
		 * This scenary is created to test the constructor of the class
		 */
		private void setUpScenary1() {
			
		}
	
		/**
		 * This scenary is created to test the prev's and next's methods that are needed to manage the linked list
		 */
		private void setUpScenary2() {
			participant = new Participant("98071858804","Diego","Tafur","juandiego@outlook.es",Gender.MALE,"Paris",
					"https://instagramuserpics.com","05/07/1998");
			participant2 = new Participant("9458623514","Manuel","Reyes","reyes@correoicesi.edu.co", Gender.MALE,"EEUU",
					"https://slackgalley.com","06/10/1980");
		}
//_________________________________________________________________________________________________________________________________________//_________________________________________________________________________________________________________________________________________

		@Test
		/**
		 * This method test the constructor method of the model class participant, making sure that it is possible to create a 
		 * participant and that its attributes get a correct value when they are called.
		 */
		public void testParticipant() {
			
			setUpScenary1();
			
			Participant participant = new Participant("1007836893", "Juan", "Valencia", "Juanchouni@hotmail.com",Gender.MALE,"Colombia",
					"https://image.com","13/03/2002");
			
			assertNotNull(participant,"The participant was not created its value is null");
			
			assertTrue("The id was not the correct and expected one", participant.getId().equals("1007836893"));
			assertTrue("The first name was not the correct and expected one",participant.getFirstName().equals("Juan"));
			assertTrue("The last name was not the correct and expected one",participant.getLastName().equals("Valencia"));
			assertTrue("The email was not the correct and expected one",participant.getEmail().equals("Juanchouni@hotmail.com"));
			assertTrue("The gender was not the correct and expected one",participant.getGender().equals(Gender.MALE));
			assertTrue("The country was not the correct and expected one",participant.getCountry().equals("Colombia"));
			assertTrue("The image url was not the correct and expected one",participant.getImageurl().equals("https://image.com"));
			assertTrue("The birthday date was not the correct and expected one",participant.getBirthday().equals("13/03/2002"));
			
			Participant participant2 = new Participant("66784129", "Lina","Salinas", "linasalinasd7@gmail.com",Gender.FEMALE, "Japón",
					"https://facebookprofilegetImage.com", "28/04/1999");
			
			assertNotNull(participant2,"The participant was not created its value is null");
			
			assertTrue("The id was not the correct and expected one", participant2.getId().equals("66784129"));
			assertTrue("The first name was not the correct and expected one",participant2.getFirstName().equals("Lina"));
			assertTrue("The last name was not the correct and expected one",participant2.getLastName().equals("Salinas"));
			assertTrue("The email was not the correct and expected one",participant2.getEmail().equals("linasalinasd7@gmail.com"));
			assertTrue("The gender was not the correct and expected one",participant2.getGender().equals(Gender.FEMALE));
			assertTrue("The country was not the correct and expected one",participant2.getCountry().equals("Japón"));
			assertTrue("The image url was not the correct and expected one",participant2.getImageurl().equals("https://facebookprofilegetImage.com"));
			assertTrue("The birthday date was not the correct and expected one",participant2.getBirthday().equals("28/04/1999"));
		}
	//________________________________________________________________________________________________________________________________________________
		
		@Test
		/**
		 * This method test the getters and setters methods of the itself relations
		 * with the model class Viewer making sure that they are working
		 * in the expected way and that with them there's no problem creating a linked lists
		 */
		public void testNextAndPrev() {
			
			setUpScenary2();
			
			assertNull(participant.getPrev(),"The previous element of this element is not null");
			assertNull(participant.getNext(),"The previous element of this element is not null");
			
			assertNull(participant2.getPrev(),"The previous element of this element is not null");
			assertNull(participant2.getNext(),"The previous element of this element is not null");
			
			participant.setNext(participant2);
			participant2.setPrev(participant);
			
			assertNotNull(participant.getNext(),"The next element of this node was not set as expected");
			assertNotNull(participant2.getPrev(),"The previous element of this node was not set as expected");
		}
//_________________________________________________________________________________________________________________________________________
}
