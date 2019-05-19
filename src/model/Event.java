//_________________________________________________________________________________________________________________________________________
	package model;
//_________________________________________________________________________________________________________________________________________
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
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
		 * This method allows to get the root element of the binary searching tree that contains all the participants assistants inside the
		 * event.<br>
		 * <b>Pre:</b> the Event exists.
		 * @return
		 */
		public Viewer getRoot() {
			return root;
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
			
			System.out.println(line);
			int i=0;
			
			while(line!=null) {
				if(!line.startsWith("#")) {
					
					System.out.println("ciclo"+i);
					
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
						System.out.println("male");
						Viewer maleParticipant = new Viewer (id,firstName,lastName,email,Gender.MALE,country,imageurl,birthday);
						addViewerToBST(this.root, maleParticipant);
					}
					else {
						System.out.println("female");
						Viewer femaleParticipant = new Viewer (id,firstName,lastName,email,Gender.FEMALE,country,imageurl,birthday);
						addViewerToBST(this.root, femaleParticipant);
					}
				}
				line = br.readLine();
				i++;
				System.out.println(line);
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
		public void addViewerToBST(Viewer root, Viewer newViewer) {
			if(root==null) {
				System.out.println("root");
				this.root = newViewer;
			}
			else {
				if(root.compareTo(newViewer)>0) {
					System.out.println("left");
					if(root.getLeft()==null) {
						root.setLeft(newViewer);
					}
					else {
						addViewerToBST(root.getLeft(), newViewer);
					}
				}
				else {
					if(root.compareTo(newViewer)<0) {
						System.out.println("right");
						if(root.getRight()==null) {
							root.setRight(newViewer);
						}
						else {
							addViewerToBST(root.getRight(), newViewer);
						}
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a node to the participants' double linked list using recursion.
		 * <b>Pre:</b> the Event exists.<br>
		 * <b>Pos:</b> the participant was added with the right criteria inside the Double linked list.<br>
		 * @param participant the participant that is going to be added.
		 */
		public void addParticipantToLinkedList(Participant participant) {
			
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method searchs an Viewer by a given id using recursion<br>
		 * <b>Pre:</b> the event exists.<br>
		 * <b>Pos:</b> the searched viewed with their respective id is returned.<br>
		 * @param root the first node from it is going to start the searching
		 * @param id the id that belongs to the searched viewer
		 * @return the searched viewer that matched with the id that arrived as parameter
		 */
		public Viewer searchForViewer(Viewer root,String id) {
			if(root!=null) {
				System.out.println("Entré");
				//BASIC CASES:::::::::::::::::::::::::::::::::::::::::::
				if(root.getId().compareTo(id)==0) {
					System.out.println("root");
					return root;
				}
				else if(root.getRight().getId().compareTo(id)==0) {
					System.out.println("right");
						return root.getRight();
				}
				else if(root.getLeft().getId().compareTo(id)==0) {
					System.out.println("left");
						return root.getLeft();
				}
				//RECURSION CALL::::::::::::::::::::::::::::::::::::::::
				else {
					System.out.println("entré");
					if(root.getId().compareTo(id)>0) {
						System.out.println("recursion call");
						return searchForViewer(root.getLeft(), id);
					}
					else if(root.getId().compareTo(id)<0) {
						System.out.println("recursion call");
						return searchForViewer(root.getRight(), id);
					}
				}
			}
			System.out.println(root.getId());
			return root;
		}
//_________________________________________________________________________________________________________________________________________
}
