//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Random;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create events.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Event {
		
		private Participant first;
		private Viewer root;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Event Constructor</b>
		 * This method allows to create an event so its functions can be used.<br>
		 */
		public Event() {
				
		}
	//_____________________________________________________________________________________________________________________________________
		
		/**
		 * This method allows to get the root element of the binary searching tree that contains all the assistants inside the
		 * event.<br>
		 * <b>Pre:</b> the Event exists.
		 * @return
		 */
		public Viewer getRoot() {
			return root;
		}
		
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method allows to get the first element of the double linked list that contains only the participants inside the
		 * event.<br>
		 * <b>Pre:</b> the Event exists.
		 * @return
		 */
		public Participant getFirst() {
			return first;
		}
		
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the random information of the general viewers that are going to assist to the volleyball cup event
		 * <b>Pre:</b> the Event exists.
		 * <b>Pre:</b> the Path of the file is the right one.<br>
		 * <b>Pos:</b> the file with the information of the participants was loaded and the BST was created.<br>
		 * @param path the path where the textFile is located
		 * @throws IOException in the case that the file does not exist, or that something happens trying to read it
		 */
		public void loadInformation(String path) throws IOException{
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
		
			Random random = new Random();
			int pos = random.nextInt(2);
			
			Participant temp = first;
					
			while(line!=null) {
				if(!line.startsWith("#")) {
					
					String[] parts = line.split(",");
					
					//Creates the respective attributes from every line
					String id = parts[0];
					String firstName = parts[1];
					String lastName = parts[2];
					String email = parts[3];
					String gender = parts[4];
					String country = parts[5];
					String imageurl = parts[6];
					String birthday = parts[7];
					
					//determinates the gender of the assistant
					if(gender.equals("Male")) {
						//BINARY SEARCHING TREE:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
						Viewer maleViewer = new Viewer (id,firstName,lastName,email,Gender.MALE,country,imageurl,birthday);
						addViewerToBST(this.root, maleViewer);
						//LINKED LIST::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
						Participant maleParticipant = new Participant(maleViewer.getId(),maleViewer.getFirstName(),
									maleViewer.getLastName(),maleViewer.getEmail(),maleViewer.getGender(),
									maleViewer.getCountry(),maleViewer.getImageurl(),maleViewer.getBirthday());
						generateParticipants(pos,temp, maleParticipant);
						temp = maleParticipant;
						//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
					}
					else {
						//BINARY SEARCHING TREE:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
						Viewer femaleViewer = new Viewer (id,firstName,lastName,email,Gender.FEMALE,country,imageurl,birthday);
						addViewerToBST(this.root, femaleViewer);
						//LINKED LIST::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
						Participant femaleParticipant = new Participant(femaleViewer.getId(),femaleViewer.getFirstName(),
									femaleViewer.getLastName(),femaleViewer.getEmail(),femaleViewer.getGender(),
									femaleViewer.getCountry(),femaleViewer.getImageurl(),femaleViewer.getBirthday());
						generateParticipants(pos,temp,femaleParticipant);
						temp = femaleParticipant;
						//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
					}
				}
				line = br.readLine();
			}
			br.close();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a node to the viewers' binary searching tree using recursion.
		 * <b>Pre:</b> the Event exists.<br>
		 * <b>Pos:</b> the viewer was added with the right criteria inside the BST.<br>
		 * @param root the current node where the recursive function is going to keep looking for an empty tree.
		 * @param newViewer the viewer that is going to be added.
		 */
		public void addViewerToBST(Viewer current, Viewer newViewer) {
			if(current==null) {
				this.root = newViewer;
			}
			else {
				if(current.compareTo(newViewer)>0) {
					if(current.getLeft()==null) {
						current.setLeft(newViewer);
					}
					else {
						addViewerToBST(current.getLeft(), newViewer);
					}
				}
				else {
					if(current.compareTo(newViewer)<0) {
						if(current.getRight()==null) {
							current.setRight(newViewer);
						}
						else {
							addViewerToBST(current.getRight(), newViewer);
						}
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method searchs a Viewer by a given id using recursion<br>
		 * <b>Pre:</b> the event exists.<br>
		 * <b>Pos:</b> the searched viewer with their respective id is returned.<br>
		 * @param current the node from it is going to start the searching
		 * @param id the id that belongs to the searched viewer
		 * @return the searched viewer that matched with the id that arrived as parameter
		 */
		public Viewer searchForViewer(Viewer current,Viewer searched) {
			if(root!=null) {
				//BASIC CASE::::::::::::::::::::::::::::::::::::::::::::
				if(current.compareTo(searched)==0) {
					return current;
				}
				//RECURSION CALL::::::::::::::::::::::::::::::::::::::::
				else {
					if(current.compareTo(searched)>0) {
						return searchForViewer(current.getLeft(), searched);
					}
					else if(current.compareTo(searched)<0) {
						return searchForViewer(current.getRight(), searched);
					}
				}
			}
			return current;
		}	
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method determinates when it should be a new participant added to the linked list by determinating if 
		 * the line was odd or not
		 * <b>Pos:</b> The call to the adding method was correct.
		 * @param pos the determinant number that considered when the method should be call
		 * @param lastAdded the last element that was added to the structure
		 * @param newParticipant the new element that is going to make part of the linked list
		 */
		public void generateParticipants(int pos,Participant lastAdded, Participant newParticipant) {
			if(pos==0) {
				addParticipantToLinkedList(lastAdded, newParticipant);
			}
			else if(pos==1) {
				addParticipantToLinkedList(lastAdded, newParticipant);
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a node to the participants' double linked list using recursion.
		 * <b>Pre:</b> the Event exists.<br>
		 * <b>Pos:</b> the participant was added with the right criteria inside the Double linked list.<br>
		 * @param participant the participant that is going to be added.
		 */
		public void addParticipantToLinkedList(Participant current, Participant newParticipant) {
			if(current==null) {
				first = newParticipant;
			}
			else if(current.compareTo(newParticipant)>0) {
				newParticipant.setPrev(current.getPrev());
				current.getPrev().setNext(newParticipant);
				current.setPrev(newParticipant);
				newParticipant.setNext(current);
				
			}
			else if(current.compareTo(newParticipant)<0) {
				current.setNext(newParticipant);
				newParticipant.setPrev(current);
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @param current
		 * @param searched
		 * @return
		 */
		public Participant searchForParticipant(Participant current,Participant searched) {
			if(first!=null) {
				return searchParticipant(current, searched);
			}
			return null;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method searchs a participant by a given id using recursion<br>
		 * <b>Pre:</b> the event exists.<br>
		 * <b>Pos:</b> the searched participant with their respective id is returned.<br>
		 * @param current the node from it is going to start the searching
		 * @param id the id that belongs to the searched participant
		 * @return the searched participant that matched with the id that arrived as parameter
		 */
		private Participant searchParticipant(Participant current,Participant searched) {
				//BASIC CASE::::::::::::::::::::::::::::::::::::::::::::
				if(current.compareTo(searched)==0) {
					return current;
				}
				//RECURSION CALL::::::::::::::::::::::::::::::::::::::::
				else {
					if(current.getNext()!=null) {
						return searchForParticipant(current.getNext(), searched);
					}
				}			
			return current;
		}
	//_____________________________________________________________________________________________________________________________________
	//_____________________________________________________________________________________________________________________________________
		
		public void prueba() {
			Participant current = first;
			int i=0;
			while(current.getNext()!=null) {
				System.out.println(current.getId());
				System.out.println(i);
				current = current.getNext();
				i++;
			}
		}
//_________________________________________________________________________________________________________________________________________
}
