//_________________________________________________________________________________________________________________________________________

	package userInterface;
//_________________________________________________________________________________________________________________________________________
	import java.io.File;
	import java.io.IOException;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.control.Button;
	import javafx.scene.control.ScrollPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;
	import javafx.scene.shape.Line;
	import javafx.stage.FileChooser;
	import javafx.stage.Stage;
	import model.Event;
	import model.Gender;
	import model.Participant;
	import model.Viewer;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to design and control the events inside the userinterface.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class EventController {
		
		//DATA SECTION
			@FXML
			private TextField txtData;
	
			@FXML
			private Label dataMssg;
		
		    @FXML
		    private Button loadButton;
		//______________________________________
		
		//SEARCH SPECTATOR SECTION
			@FXML
			private TextField txtidViewer;
	
			@FXML
			private Label timeViewer;
			
			@FXML
		    private Label viewerMssg;
		//______________________________________
			
		//SEARCH PARTICIPANT SECTION
		    @FXML
		    private TextField txtidParticipant;
		
		    @FXML
		    private Label timeParticipant;
	
		    @FXML
		    private Label particMssg;
		//______________________________________
		
		//INFO SECTION
		    @FXML
		    private ImageView avatarImage;
		    
		    @FXML
		    private Label idNumber;

		    @FXML
		    private Label name;

		    @FXML
		    private Label lastName;

		    @FXML
		    private Label email;

		    @FXML
		    private Label gender;

		    @FXML
		    private Label country;

		    @FXML
		    private Label birthday;
		//______________________________________
		
		//VISUAL SECTION
		    @FXML
		    private BorderPane paintStructuresBorderPane;
		    
		    @FXML
		    private ScrollPane scrollSurface;
	    //________________________________________________
		    
		    private Stage stage;
	    
		    private Event event;
	    
//_________________________________________________________________________________________________________________________________________
		/**
		 * This methods set the stage of the controller to show it's properties and elements with the created in the main constructor one.
		 * @param stage the current stage that the controller is going to manage
		 */
		public void setStage(Stage stage) {
	    	this.stage = stage;
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to explore inside the system's file browser and choose the textfile with the information of the participants
	     * @param event the event triggered by the user
	     */
	    private void exploreForFilesToLoad(ActionEvent event) {
	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Navigation Window");
	    	File file = fileChooser.showOpenDialog(stage);
	    	if(file!=null) {
	    		txtData.setText(file.getAbsolutePath());
	    	}
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to load the information of the participants of the event once the file has been choosen for the explore 
	     * section<br>
	     * <b>Pre:</b> the path of the textfile exists after the right textFile was choosen<br>
	     * <b>Pos:</b> the information of the participants is loaded so now the user can search for viewers and participants<br>
	     * @param event the event triggered by the user
	     * @throws IOException in the case that the file requested does not exist or results a problem reading it
	     */
	    private void load(ActionEvent event) throws IOException {
	    	try {
	    		this.event = new Event();
	    		this.event.loadInformation(txtData.getText());
	    		loadButton.setDisable(true);
	    		dataMssg.setText("Wait while the information is being loaded");
				dataMssg.setText("The file was succesfully Loaded!!");
				loadButton.setDisable(false);
	    	} catch (IOException ioe) {
				loadIOWarningWindow();
			}
	    	catch(ArrayIndexOutOfBoundsException aioobe)
	    	{
	    		dataMssg.setText("OOPS!! looks like this is not the correct file");
	    	}
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to search for a participant by calling the respective function of the model class Event.
	     * @param event the event triggered by the user
	     */
	    private void searchParticipant(ActionEvent event) {
	    	try {
	    		
	    		long beggining = System.currentTimeMillis();
	    		Participant searched = this.event.searchForParticipant(txtidParticipant.getText());
	    		long end = System.currentTimeMillis();
	    		
	    		long time = (end-beggining);
	    		
	    		if(searched!=null) {
		    		if(searched.getId().equals(txtidParticipant.getText())) {
		    			particMssg.setText("We found your request!! :)");
		    			timeParticipant.setText(timeParticipant.getText().concat(" " + time + "\nMilliseconds"));
		    			showSearchedPInfo(searched);		
		    		}
		    		else {
		    			particMssg.setText("We couldn't find your request, sorry :(" + "\nTry with another id");
		    		}
	    		}
	    		else{
					particMssg.setText("We couldn't find your request, sorry :(" + "\nTry with another id");
	    		}
	    	}
	    	//if the user tries to search for a participant without previously loaded a file
	    	catch(NullPointerException npe) {
	    		particMssg.setText("You must first Load a file" + "\nto be able to search a participant");
	    	}
	    	catch(NumberFormatException nfe) {
	    		particMssg.setText("You must type valid information");
	    	}
	    }	    
	//_____________________________________________________________________________________________________________________________________
	    /**
	     * This method allows to show off the information of the requested searched participant
	     * @param participant the participant whose information is going to be showed in the GUI
	     */
	    private void showSearchedPInfo(Participant participant) {
	    	idNumber.setText(participant.getId());
	    	name.setText(participant.getFirstName());
	    	lastName.setText(participant.getLastName());
	    	email.setText(participant.getEmail());
	    	gender.setText(""+participant.getGender());
	    	country.setText(participant.getCountry());
	    	birthday.setText(participant.getBirthday());
	    	avatarImage.setImage(new Image(participant.getImageurl()));
	    }	    
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to seatch for a viewer by calling the respective function of the model class Event.
	     * @param event the event triggered by the user
	     */
	    private void searchViewers(ActionEvent event) {
	    	try {		
	    		long beggining = System.currentTimeMillis();
	    		Viewer searched = this.event.searchForViewer(txtidViewer.getText());
	    		long end = System.currentTimeMillis();
	    		
	    		long time = (end-beggining);
	    		
	    		if(searched!=null) {
		    		if(searched.getId().equals(txtidViewer.getText())) {
		    			viewerMssg.setText("We found your request!! :)");
		    			timeViewer.setText(timeViewer.getText().concat(" " + time + "\nMilliseconds"));
		    			showSearchedVInfo(searched);		
		    		}
		    		else {
		    			viewerMssg.setText("We couldn't find your request, sorry :(" + "\nTry with another id");
		    		}
	    		}
	    		else{
					viewerMssg.setText("We couldn't find your request, sorry :(" + "\nTry with another id");
	    		}
	    	}
	    	//if the user tries to search for a viewer without previously loaded a file
	    	catch(NullPointerException npe) {
	    		viewerMssg.setText("You must first Load a file" + "\nto be able to search a participant");
	    	}
	    	catch(NumberFormatException nfe) {
	    		viewerMssg.setText("You must type valid information");
	    	}
	    }
	//_____________________________________________________________________________________________________________________________________
	    /**
	     * This method allows to show off the information of the requested searched Viewer
	     * @param viewer the viewer whose information is going to be showed in the GUI
	     */
	    private void showSearchedVInfo(Viewer viewer) {
	    	idNumber.setText(viewer.getId());
	    	name.setText(viewer.getFirstName());
	    	lastName.setText(viewer.getLastName());
	    	email.setText(viewer.getEmail());
	    	gender.setText(""+viewer.getGender());
	    	country.setText(viewer.getCountry());
	    	birthday.setText(viewer.getBirthday());
	    	avatarImage.setImage(new Image(viewer.getImageurl()));
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to paint the structure of the participant so the user can see visually what is the main organization
	     * inside the event.<br>
	     * @param event the event triggered by the user.
	     */
	    private void paintParticipants(ActionEvent event) throws IOException {
	    	try {
		    	Participant current = this.event.getFirst();
		    	Pane content = new Pane();
		    	int i=0;
		    	
		    	while(current.getNext()!=null) {
		    		
		    		Image Avatar = new Image(current.getImageurl());
		    		Label id = new Label(current.getId());
		    		Label name = new Label(current.getFirstName());
		    		
		    		Line prev = new Line(100.0,-50.0,100.0,0.0);
		    		Line Next = new Line(100.0,-50.0,100.0,0.0);
		    		
		    		content.getChildren().add(i, id);
		    		content.getChildren().add(i, name);
		    		content.getChildren().add(i, prev);
		    		content.getChildren().add(i, Next);
		    		
	
		    		current = current.getNext();
		    		i++;
		    	}
	    	}
	    	catch(NullPointerException npe) {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WarningWindow.fxml"));
		    	Parent root1 = (Parent) fxmlLoader.load();
		    	Stage stage = new Stage();
		    	stage.setTitle("Warning Suggestions");
		    	stage.centerOnScreen();
		    	stage.setResizable(false);
		    	
		    	Image image = new Image ("userInterface/images/warningicon.png");
				stage.getIcons().add(image);
				
		    	stage.setScene(new Scene(root1));  
		    	stage.show();
	    	}
	    	
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * This method allows to paint the structure of the viewer so the user can see visually what is the main organization inside
	     * the event.<br>
	     * @param event the event triggered by the user.
	     */
	    private void paintViewers(ActionEvent event) {
	    
	    }
	//_____________________________________________________________________________________________________________________________________
	    /**
	     * This method allows to load the warning window that is needed to be showed to inform the user about a problem caused with
	     * the loading of the textfile
	     * @throws IOException in the case that the fxml file gets deleted externally
	     */
	    private void loadIOWarningWindow() throws IOException {
	   		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IOWarningWindow.fxml"));
	    	Parent root1 = (Parent) fxmlLoader.load();
	    	Stage stage = new Stage();
	    	stage.setTitle("Warning Suggestions");
	    	stage.centerOnScreen();
	    	stage.setResizable(false);
	    	
	    	Image image = new Image ("userInterface/images/warningicon.png");
			stage.getIcons().add(image);
			
	    	stage.setScene(new Scene(root1));  
	    	stage.show();
	    }
//_________________________________________________________________________________________________________________________________________	    
}
