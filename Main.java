import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main
{
    public static void main(String args[])
    {               
        launchFX();              
    }

    private static void launchFX()
    {
        new JFXPanel();       // Initialises JavaFX
        Platform.runLater(() -> initialiseGUI());    // Runs initialisation on the JavaFX thread
    }

    private static void initialiseGUI() 
    {
        //instead of throwing an exception if a file is not found as we have done before
        //we'll use a try/catch 
        try { 
            //create the images
            Image shrekImg = new Image("shrek.png", 100, 100, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
            Image pigeonImg = new Image("pigeon.png",100, 100, false, true);
            Image carsImg = new Image("cars.png",100, 100, false, true);
            Image jellyFishImg = new Image("Jellyfish.png",100, 100, false, true);

            //create buttons and associate the images
            Button  button1 = new Button("Shrek", new ImageView(shrekImg));
            button1.setLayoutX(50);
            Button  button2 = new Button("Pigeon", new ImageView(pigeonImg));
            button2.setLayoutX(250);
            Button  button3 = new Button("Life is a highway", new ImageView(carsImg));
            button3.setLayoutX(450);
            Button  button4 = new Button("Life is a highway", new ImageView(carsImg));
            button3.setLayoutX(450);

            //create actions for the buttons
            button1.setOnAction((ActionEvent ae) -> playShrek());
            button2.setOnAction((ActionEvent ae) -> playPigeon());
            button3.setOnAction((ActionEvent ae) -> playCars());

            Label label = new Label ("Click on a button above");
            label.setLayoutX(200);
            label.setLayoutY(300);

            Stage stage = new Stage();
            stage.setTitle("Some Fun");
            stage.setResizable(false);
            Pane rootPane = new Pane();
            stage.setScene(new Scene(rootPane));                        
            stage.setWidth(1024);
            stage.setHeight(768);
            rootPane.getStylesheets().add("Simple.css");        

            rootPane.getChildren().addAll(button1, button2, button3, label);       
            stage.show(); 
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void playShrek(){
        Media media = new Media(Main.class.getResource("shrek.mp4").toString()); 
        MediaPlayer mediaplayer = new MediaPlayer(media);    
        mediaplayer.setAutoPlay(true);
        MediaView mediaview = new MediaView(mediaplayer);    
        mediaview.setFitWidth(720);
        mediaview.setFitHeight(405);
        Pane mediapane = new Pane(mediaview);        
        Stage stage = new Stage();
        stage.setScene(new Scene(mediapane));
        stage.show();
    }

    private static void playPigeon(){
        Media media = new Media(Main.class.getResource("storks.mp4").toString()); 
        MediaPlayer mediaplayer = new MediaPlayer(media);    
        mediaplayer.setAutoPlay(true);
        MediaView mediaview = new MediaView(mediaplayer);    
        mediaview.setFitWidth(720);
        mediaview.setFitHeight(405);
        Pane mediapane = new Pane(mediaview);        
        Stage stage = new Stage();
        stage.setScene(new Scene(mediapane));
        stage.show();
    }

    private static void playCars(){
        Media media = new Media(Main.class.getResource("cars.mp3").toString()); 
        MediaPlayer player = new MediaPlayer(media); 
        player.play();
    }

}

