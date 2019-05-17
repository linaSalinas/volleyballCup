package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Event {
	
	private Participant first;
	private Viewer root;
	
	public Event(Viewer root, Participant first) {
		
		this.root = root;
		this.first = first;
		
	}

	public Participant getFirst() {
		return first;
	}

	public void setFirst(Participant first) {
		this.first = first;
	}

	public Viewer getRoot() {
		return root;
	}

	public void setRoot(Viewer root) {
		this.root = root;
	}
	
	public void loadInformation(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		while(line!=null) {
			if(!line.startsWith("#")) {
				String[] parts = line.split(",");
				String id = parts[0];
				String firstName = parts[1];
				String lastName = parts[2];
				String email = parts[3];
				String gender = parts[4];
				String country = parts[5];
				String imageurl = parts[6];
				String birthday = parts[7];
				
				if(gender.equals("Male")) {
					Participant maleParticipant = new Participant (id,firstName,lastName,email,Gender.MALE,country,imageurl,birthday);
				}
				else {
					Participant femaleParticipant = new Participant (id,firstName,lastName,email,Gender.FEMALE,country,imageurl,birthday);
				}
				
			}
		}
		
		
		br.close();
	}
	

}
