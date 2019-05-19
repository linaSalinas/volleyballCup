//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create Participants.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Participant implements Comparable<Participant>{
		
		private String id;
		private String firstName;
		private String lastName;
		private String email;
		private Gender gender;
		private String country;
		private String imageurl;
		private String birthday;
		
		private Participant prev;
		private Participant next;
//_________________________________________________________________________________________________________________________________________
		/** 
		 * <b>Participant Constructor<b>
		 * @param id the unique identification number of the viewer
		 * @param firstName the first name of the person
		 * @param lastName the last name of the person
		 * @param email the contact email 
		 * @param gender the sexual gender of the person
		 * @param country the native place where the person was born
		 * @param imageurl the direction of the avatar that represents the person
		 * @param birthday the date of birth
		*/
		public Participant(String id, String firstName, String lastName, String email, Gender gender, String country,
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
		 * This method returns the unique number identification of the participants.
		 * @return an String that represents the id 
		 */
		public String getId() {
			return id;
		}

		/**
		 * This method return the first name of the Participant.
		 * @return an String that represents the name
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * This method returns the last name of the participant.
		 * @return an String that represents the last name
		 */
		public String getLastName() {
			return lastName;
		}
	
		/**
		 * This method returns the contact email of the participant.
		 * @return an String that represents the email
		 */
		public String getEmail() {
			return email;
		}
		
		/**
		 * This method returns the gender description of the participant.
		 * @return a gender value that can have two values
		 */
		public Gender getGender() {
			return gender;
		}
		
		/**
		 * This method returns the native place where the participant was born
		 * @return an String that represents the country
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * This method returns the direction that leads to the imagery representation of the participant
		 * @return an String that represents the original direction of the avatar image
		 */
		public String getImageurl() {
			return imageurl;
		}

		/**
		 * This method returns the date of birth of the participant
		 * @return an String that represents the date
		 */
		public String getBirthday() {
			return birthday;
		}	
	//_____________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the previous element and so the Smaller compared with the current node
		 * @return prev the previous element that goes before the current node in the linked list
		 */
		public Participant getPrev() {
			return prev;
		}
		
		/**
		 * This method sets the previous element and so the Smaller compared with the current node
		 * @param prev the previous element that goes before the current node in the Linked List
		 */
		public void setPrev(Participant prev) {
			this.prev = prev;
		}
		
		/**
		 * This method returns the next element and so the Bigger compared with the current node
		 * @return next the next element that is goes after the current node in the linked list
		 */
		public Participant getNext() {
			return next;
		}
		
		/**
		 * This method sets the next element and so the Bigger compared with the current node
		 * @param next the next element that goes after the current node in the Linked List
		 */
		public void setNext(Participant next) {
			this.next = next;
		}
	//_____________________________________________________________________________________________________________________________________
		
		@Override
		/**
		 * This method allows to compare participants with each other to have a organization criteria in the double linked list
		 * structure<br>
		 * <b>Pre:The participant exists.
		 * @param viewer the participant that is going to be compared with the current one
		 */
		public int compareTo(Participant participant) {
			int comparation = 0;
			if(this.getId().compareTo(participant.getId())>0) {
				comparation = 1;
			}
			else if(this.getId().compareTo(participant.getId())<0) {
				comparation = -1;
			}
			else {
				return comparation;
			}
			return comparation;
		}
//_________________________________________________________________________________________________________________________________________


}
