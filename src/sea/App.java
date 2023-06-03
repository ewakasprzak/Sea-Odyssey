package sea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application 
{
    private static final int GRID_SIZE = 10;
    public static int getGridSize() 
    {
        return GRID_SIZE;
    }

    private static final int SHIPS_COUNT = 10;
    public static int getShipsCount() 
    {
        return SHIPS_COUNT;
    }

    private static final int MAX_TRIES = 15;
    public static int getMaxTries() 
    {
        return MAX_TRIES;
    }

    private Rectangle[][] grid;
    private boolean[][] shipGrid;
    private GUIGameGrid game; 
    private GUIHBox hbox; 

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
       
        Button resetButton = createResetButton();


        hbox = new GUIHBox(gameGrid, resetButton);

        new RandomShips(shipGrid);

        Scene scene = new Scene(hbox.getHBox());

        stage.setScene(scene);
        stage.setTitle("SEA ODYSSEY");
        stage.show();
    }

    private Button createResetButton() 
    {
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> 
        {
            game.resetGame();
            new RandomShips(shipGrid);
        });
        return resetButton;
    }

    
}

