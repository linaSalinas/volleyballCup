package model;

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

}
