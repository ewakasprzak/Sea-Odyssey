package sea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application 
{
    private static final int GRID_SIZE = 10;
    private static final int SHIPS_COUNT = 10;
    private static final int MAX_TRIES = 30;

    private Rectangle[][] grid;
    private boolean[][] shipGrid;
    private GUIGameGrid game; 
    private GUIVBox vbox; 

    public static void main(String[] args) 
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) 
    {
        grid = new Rectangle[GRID_SIZE][GRID_SIZE];
        shipGrid = new boolean[GRID_SIZE][GRID_SIZE];

        GridPane gameGrid = new GridPane();
        game = new GUIGameGrid(gameGrid, shipGrid, grid);
       
        Button gameButton = createGameButton();

        vbox = new GUIVBox(gameGrid, gameButton);

        new RandomShips(shipGrid);

        Scene scene = new Scene(vbox.getVBox());

        stage.setScene(scene);
        stage.setTitle("SEA ODYSSEY");
        stage.show();

        showGameStartAlert();
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

