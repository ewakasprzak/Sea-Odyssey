package sea;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    private static final int GRID_SIZE = 10;
    private static final int SHIPS_COUNT = 10;
    private static final int MAX_TRIES = 66;

    private Rectangle[][] grid;
    private boolean[][] shipGrid;
    private GUIGameGrid game; 
    private GUIVBox vbox;
    private MediaPlayer media;
    private Button text = new Button();

    public static void main(String[] args) 
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) 
    {
        grid = new Rectangle[GRID_SIZE][GRID_SIZE];
        shipGrid = new boolean[GRID_SIZE][GRID_SIZE];
        

        music();

        GridPane gameGrid = new GridPane();
        game = new GUIGameGrid(gameGrid, shipGrid, grid, text);
       
        Button gameButton = createGameButton();

        vbox = new GUIVBox(gameGrid, gameButton, text);

        new RandomShips(shipGrid);

        Scene scene = new Scene(vbox.getVBox());

        stage.setScene(scene);
        stage.setTitle("SEA ODYSSEY");
        stage.show();

        showGameStartAlert();
    }

    @Override
    public void stop() 
    {
        media.dispose();
    }

    private Button createGameButton() 
    {
        Button resetButton = new Button("New Game");
        resetButton.setOnAction(event -> 
        {
            game.resetGame();
            new RandomShips(shipGrid);
        });
        return resetButton;
    }

    private void showGameStartAlert()
    {
        String info;
        
        try 
        {
            info = Files.readString(Path.of("src/sea/Rules.txt"));
        } catch (IOException e) 
        {
            info = "error";
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Hello!");
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    } 

    private void music()
    {
        String musicFile = "music.mp3";
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(musicFile);
        String path = url.toExternalForm();
        Media sound = new Media(path);
        media = new MediaPlayer(sound);
        media.setVolume(0.5);
        media.setCycleCount(MediaPlayer.INDEFINITE);
        media.play();
    }

    
    public static int getGridSize() 
    {
        return GRID_SIZE;
    }

    public static int getShipsCount() 
    {
        return SHIPS_COUNT;
    }

    public static int getMaxTries() 
    {
        return MAX_TRIES;
    }
}

