//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________

	package userInterface;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;
	
	import java.io.File;
//___________________________________________ATTRIBUTES____________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the User Interface.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan Jos� Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Main extends Application{
		
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		
		@Override
		public void start(Stage stage) throws Exception{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("volleyballCup.fxml"));
			
			Parent root = loader.load();
			
			EventController ec = loader.getController();
			ec.setStage(stage);
			
			Scene scene = new Scene(root);
			stage.setTitle("VolleyBallCup");
			
			Image image = new Image("userInterface/images/icon.png");
			stage.getIcons().add(image);
				
			stage.setScene(scene);
			stage.show();
		}
	//___________________________________________________________________________________________________________________________________
	
		public static void main(String[]args){
			launch(args);
		}	
//___________________________________________________________________________________________________________________________________
}
