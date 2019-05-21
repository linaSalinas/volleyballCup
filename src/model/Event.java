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
					
					Gender g = gender.equals("Male")?Gender.MALE:Gender.FEMALE;
					addViewerToBST(id,firstName,lastName,email,g,country,imageurl,birthday);
					Participant p = new Participant(id,firstName,lastName,email,g,country,imageurl,birthday);
					generateParticipants(pos,temp, p);
					temp = p;
				}
				line = br.readLine();
			}
			br.close();
		}
		
		
	//______________________________________________________________________________________________________________________________________

		public void addViewerToBST(String id, String firstName, String lastName, String email, Gender gender, String country,
				String imageurl, String birthday) {
			Viewer v = new Viewer (id,firstName,lastName,email,Gender.MALE,country,imageurl,birthday);
			if(root==null) {
				root = v;
			}else {
				addViewerToBST(root, v);
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a node to the viewers' binary searching tree using recursion.
		 * <b>Pos:</b> the viewer was added with the right criteria inside the BST.<br>
		 * @param current the current node where the recursive function is going to keep looking for an empty tree. current!=null 
		 * @param newViewer the viewer that is going to be added.
		 */
		private void addViewerToBST(Viewer current, Viewer newViewer) {
			if(current.compareTo(newViewer)>0) {
				System.out.println("menor");
				if(current.getLeft()==null) {
					current.setLeft(newViewer);
				}
				else {
					addViewerToBST(current.getLeft(), newViewer);
				}
			}
			else {
				if(current.compareTo(newViewer)<0) {
					System.out.println("mayor");
					if(current.getRight()==null) {
						current.setRight(newViewer);
					}
					else {
						addViewerToBST(current.getRight(), newViewer);
					}
				}
			}
		}
		
	//______________________________________________________________________________________________________________________________________
		/**
		 * This method calls the searching method of a viewer making sure that only it can be call
		 * if the binary searching tree are previously created
		 * @param id the id that its desired to be search
		 * @return the call of the recursive method that searchs the viewer requested
		 */
		public Viewer searchForViewer(String id) {
			return searchForViewer(root, id);
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
		private Viewer searchForViewer(Viewer current,String searched) {
			System.out.println("Current: "+current);
			if(current!=null) {
				//RECURSION CALL::::::::::::::::::::::::::::::::::::::::
				if(current.getId().compareTo(searched)>0) {
					return searchForViewer(current.getLeft(), searched);
				}
				else if(current.getId().compareTo(searched)<0) {
					return searchForViewer(current.getRight(), searched);
				}
			}
			//BASIC CASE::::::::::::::::::::::::::::::::::::::::::::
			System.out.println("Retornando: "+current);
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
			if(current.getPrev()!=null){
				current.getPrev().setNext(newParticipant);
			}	
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
		 * This method calls the searching method of a participant making sure that only it can be call
		 * if the linked list are previously created
		 * @param current the current element where the searching is going to start
		 * @param searched the element that it needs to be search and return
		 * @return null in the case that the linked list remains empty
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
				else if(current.getNext()!=null) {
						return searchForParticipant(current.getNext(), searched);
				}else {
					return null;
				}
		}
//_________________________________________________________________________________________________________________________________________
}
