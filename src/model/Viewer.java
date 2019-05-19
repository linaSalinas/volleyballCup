//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create viewers.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Viewer implements Comparable<Viewer> {
	
		private String id;
		private String firstName;
		private String lastName;
		private String email;
		private Gender gender;
		private String country;
		private String imageurl;
		private String birthday;

		private Viewer right;
		private Viewer left;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Viewer Constructor<b>
		 * @param id the unique identification number of the viewer
		 * @param firstName the first name of the person
		 * @param lastName the last name of the person
		 * @param email the contact email 
		 * @param gender the sexual gender of the person
		 * @param country the native place where the person was born
		 * @param imageurl the direction of the avatar that represents the person
		 * @param birthday the date of birth
		 */
		public Viewer(String id, String firstName, String lastName, String email, Gender gender, String country,
				String imageurl, String birthday) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.gender = gender;
			this.country = country;
			this.imageurl = imageurl;
			this.birthday = birthday;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the unique number identification of the viewer.
		 * @return an String that represents the id 
		 */
		public String getId() {
			return id;
		}

		/**
		 * This method return the first name of the viewers
		 * @return an String that represents the name
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * This method returns the last name of the viewer
		 * @return an String that represents the last name
		 */
		public String getLastName() {
			return lastName;
		}
	
		/**
		 * This method returns the contact email of the viewer
		 * @return an String that represents the email
		 */
		public String getEmail() {
			return email;
		}
		
		/**
		 * This method returns the gender description of the viewer
		 * @return a gender value that can have two values
		 */
		public Gender getGender() {
			return gender;
		}
		
		/**
		 * This method returns the native place where the viewer was born
		 * @return an String that represents the country
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * This method returns the direction that leads to the imagery representation of the viewer
		 * @return an String that represents the original direction of the avatar image
		 */
		public String getImageurl() {
			return imageurl;
		}

		/**
		 * This method returns the date of birth of the viewer
		 * @return an String that represents the date
		 */
		public String getBirthday() {
			return birthday;
		}	
	//_____________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the right element and so the Bigger compared with the current node
		 * @return the right element in the sub-tree belonged to the current node
		 */
		public Viewer getRight() {
			return right;
		}
		
		/**
		 * This method sets the right element and so the Bigger compared with the current node
		 * @param right the new element that is going to take place in the right part of the sub-tree
		 */
		public void setRight(Viewer right) {
			this.right = right;
		}
		
		/**
		 * This method returns the right element and so the Smaller compared with the current node
		 * @return the left element in the sub-tree belonged to the current node
		 */
		public Viewer getLeft() {
			return left;
		}
		
		/**
		 * This method sets the left element and so the Smaller compared with the current node
		 * @param left the new element that is going to take place in the left part of the sub-tree
		 */
		public void setLeft(Viewer left) {
			this.left = left;
		}	
	//_____________________________________________________________________________________________________________________________________
		@Override
		/**
		 * This method allows to compare the viewers with each other to have a organization criteria in the binary searching tree
		 * structure<br>
		 * <b>Pre:The Viewer exists.
		 * @param viewer the viewer that is going to be compared with the current one
		 */
		public int compareTo(Viewer viewer) {
			
			int comparation = 0;
			if(this.getId().compareTo(viewer.getId())>0) {
				comparation = 1;
			}
			else if(this.getId().compareTo(viewer.getId())<0) {
				comparation = -1;
			}
			else {
				return comparation;
			}
			return comparation;
		}
//_________________________________________________________________________________________________________________________________________

		
}
