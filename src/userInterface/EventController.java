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
	import javafx.scene.image.Image;
	import javafx.scene.layout.BorderPane;
	import javafx.stage.FileChooser;
	import javafx.stage.Stage;
	import model.Event;
		
//_________________________________________________________________________________________________________________________________________
	
	public class EventController {
	
	    @FXML
	    private TextField txtData;
	
	    @FXML
	    private Label dataMssg;
	
	    @FXML
	    private TextField txtidSpectator;
	
	    @FXML
	    private Label timeSpectator;
	
	    @FXML
	    private Label spectMssg;
	
	    @FXML
	    private TextField txtidParticipant;
	
	    @FXML
	    private Label timeParticipant;
	
	    @FXML
	    private Label particMssg;
	
	    @FXML
	    private BorderPane infoBorderPane;
	    
	    private Stage stage;
	    
	    private Event event;
	    
//_________________________________________________________________________________________________________________________________________
	   
	    
	//_____________________________________________________________________________________________________________________________________
	    public void setStage(Stage stage) {
	    	this.stage = stage;
	    }
	//_____________________________________________________________________________________________________________________________________
	    
	    @FXML
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
	    private void load(ActionEvent event) throws IOException {
	    	try {
				this.event.loadInformation(txtData.getText());
			} catch (IOException ioe) {
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
	    	catch (NullPointerException npe) {
	    		dataMssg.setText("Please you MUST select a file to LOAD");
	    	}
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    private void searchParticipant(ActionEvent event) {
	    	
	    }
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    private void searchSpectators(ActionEvent event) {
	
	    }
	//_____________________________________________________________________________________________________________________________________
	}
