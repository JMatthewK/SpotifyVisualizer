import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/*
 * 
 * @author John Matthew Kassapian
 * @version 1.0
 * description: A program that will take a user's spotify listening data, and will convert, sort and visualize it on two graphs
 */

public class Main extends Application implements EventHandler<ActionEvent>{
        Button sortData;
        Button homepageButton;
        Button tableButton;

        Button button;
        Button button1;
        Button button2;
        Button button3;
        Button button4;
        boolean isDataSorted;

        int windowWidth = 1280;
        int windowHeight = 720;
        private ArrayList <Song> songs;
        private ArrayList <ListenEvent> listenEvents;
        Scene homepage, scene2, tableScene, graph1, graph2, dataScene;
        dataSorter data = new dataSorter("ConvertedFiles/data.csv");
        JsonToCsv converter = new JsonToCsv();

        public static void main(String[] args) {
        launch(args);
    }

    
    @Override 
    public void start(Stage window) throws Exception {
        // initialize object lists
       songs = new ArrayList<Song>();
       listenEvents = new ArrayList<ListenEvent>();
        
        // Sort the csv
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File csvLocation = new File("ConvertedFiles");
        File jsonsLocation = new File("SpotifyJsonFilesHERE");
        File[] csvs = csvLocation.listFiles();
        File[] jsons = jsonsLocation.listFiles();

        if(csvs.length == 0 && jsons.length > 0){
            converter.convert();
        }
        else if(jsons.length <= 0){
            System.out.print("Please drag your jsons in");
        }

        data.sort();
        songs = data.getSongs();
        listenEvents = data.getListenEvents();

        // Fonts and sizes
        Font font = Font.loadFont("file:Resources/fonts/coolvetica.otf", 45);
        Font tabFont = Font.loadFont("file:Resources/fonts/coolvetica.otf", 20);

        // Window Setup
        Image icon = new Image("file:resources/images/icon.png");
        window.getIcons().add(icon);
        window.setTitle("Spotify Data Visualizer");

        Group root = new Group();
        Scene homepage = new Scene(root, windowWidth, windowHeight, Color.BLACK);

        showHomepage();


       
    }

    public void showHomepage(){
        homepage homepage = new homepage(this);
        window.setScene(new Scene(homepage.getPane(), windowWidth, windowHeight, Color.BLACK));
        window.show();
    }

    @Override
    public void handle(ActionEvent event){
    }

}
