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
	 * This class manage the necessary methods to manage and test the model class Viewer
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	class ViewerTest {
		
		private Viewer viewer;
		private Viewer viewer2;
		
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		/**
		 * This scenary is created to test the constructor of the class
		 */
		private void setUpScenary1() {
			
		}
	
		/**
		 * This scenary is created to test the righty and lefty methods that are needed to manage the binary searching tree
		 */
		private void setUpScenary2() {
			viewer = new Viewer("98071858804","Diego","Tafur","juandiego@outlook.es",Gender.MALE,"Paris",
					"https://instagramuserpics.com","05/07/1998");
			viewer2 = new Viewer("9458623514","Manuel","Reyes","reyes@correoicesi.edu.co", Gender.MALE,"EEUU",
					"https://slackgalley.com","06/10/1980");
		}
//_________________________________________________________________________________________________________________________________________//_________________________________________________________________________________________________________________________________________

		@Test
		/**
		 * This method test the constructor method of the model class Viewer, making sure that it is possible to create a 
		 * viewer and that its attributes get a correct value when they are called.
		 */
		public void testViewer() {
			
			setUpScenary1();
			
			Viewer viewer = new Viewer("1007836893", "Juan", "Valencia", "Juanchouni@hotmail.com",Gender.MALE,"Colombia",
					"https://image.com","13/03/2002");
			
			assertNotNull(viewer,"The participant was not created its value is null");
			
			assertTrue("The id was not the correct and expected one", viewer.getId().equals("1007836893"));
			assertTrue("The first name was not the correct and expected one",viewer.getFirstName().equals("Juan"));
			assertTrue("The last name was not the correct and expected one",viewer.getLastName().equals("Valencia"));
			assertTrue("The email was not the correct and expected one",viewer.getEmail().equals("Juanchouni@hotmail.com"));
			assertTrue("The gender was not the correct and expected one",viewer.getGender().equals(Gender.MALE));
			assertTrue("The country was not the correct and expected one",viewer.getCountry().equals("Colombia"));
			assertTrue("The image url was not the correct and expected one",viewer.getImageurl().equals("https://image.com"));
			assertTrue("The birthday date was not the correct and expected one",viewer.getBirthday().equals("13/03/2002"));
			
			Viewer viewer2 = new Viewer("66784129", "Lina","Salinas", "linasalinasd7@gmail.com",Gender.FEMALE, "Japón",
					"https://facebookprofilegetImage.com", "28/04/1999");
			
			assertNotNull(viewer2,"The participant was not created its value is null");
			
			assertTrue("The id was not the correct and expected one", viewer2.getId().equals("66784129"));
			assertTrue("The first name was not the correct and expected one",viewer2.getFirstName().equals("Lina"));
			assertTrue("The last name was not the correct and expected one",viewer2.getLastName().equals("Salinas"));
			assertTrue("The email was not the correct and expected one",viewer2.getEmail().equals("linasalinasd7@gmail.com"));
			assertTrue("The gender was not the correct and expected one",viewer2.getGender().equals(Gender.FEMALE));
			assertTrue("The country was not the correct and expected one",viewer2.getCountry().equals("Japón"));
			assertTrue("The image url was not the correct and expected one",viewer2.getImageurl().equals("https://facebookprofilegetImage.com"));
			assertTrue("The birthday date was not the correct and expected one",viewer2.getBirthday().equals("28/04/1999"));
		}
	//________________________________________________________________________________________________________________________________________________
		
		@Test
		/**
		 * This method test the getters and setters methods of the itself relations
		 * with the model class Viewer making sure that they are working
		 * in the expected way and that with them there's no problem creating a binary searching tree
		 */
		public void testRightAndLeft() {
			
			setUpScenary2();
			
			assertNull(viewer.getRight(),"The righty element of this node is not null");
			assertNull(viewer.getLeft(),"The lefty element of this node is not null");
			
			assertNull(viewer2.getRight(),"The righty element of this node is not null");
			assertNull(viewer2.getLeft(),"The righty element of this node is not null");
			
			viewer.setRight(viewer2);
			assertNotNull(viewer.getRight(),"The righty element of this node was not set as expected");
			
			viewer.setLeft(viewer2);
			assertNotNull(viewer.getLeft(),"The lefty element of this node was not set as expected");
			
		}
//_________________________________________________________________________________________________________________________________________
}
