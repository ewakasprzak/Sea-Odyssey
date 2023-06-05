package sea;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GUIGameGrid 
{
    private GridPane gamePane = new GridPane();
    private Rectangle[][] grid;
    private int triesLeft = App.getMaxTries();
    private boolean[][] shipGrid;
    private boolean finished = false;

    public GUIGameGrid(GridPane gamePane, boolean[][] shipGrid, Rectangle[][] grid)
    {
        this.gamePane = gamePane;
        this.shipGrid = shipGrid;
        this.grid = grid;

        for (int row = 0; row < App.getGridSize(); row++) 
        {
            for (int col = 0; col < App.getGridSize(); col++) 
            {
                Field square = new Field();
                gamePane.add(square.getField(), col, row);
                grid[row][col] = square.getField();

                int finalRow = row;
                int finalCol = col;

                square.getField().setOnMouseClicked(event -> handleSquareClick(finalRow, finalCol));
            }
        }

    }

    private void handleSquareClick(int row, int col) 
    {
        if (grid[row][col].getFill().equals(Color.SIENNA) || grid[row][col].getFill().equals(Color.LIGHTSKYBLUE)) 
        {
            return;
        }
    
        if (shipGrid[row][col]) 
        {
            grid[row][col].setFill(Color.SIENNA);
            triesLeft--;
            if (triesLeft <= 0) 
            {
                showGameOverAlert();
            }

        } 
        else 
        {
            grid[row][col].setFill(Color.LIGHTSKYBLUE);
            triesLeft--;
            if (triesLeft <= 0) 
            {
                showGameOverAlert();
            }
        }
    
        if (checkGameWon()) 
        {
            showGameWonAlert();
        }

       
    }

    

    private boolean checkGameWon() 
    {
        for (int row = 0; row < App.getGridSize(); row++) 
        {
            for (int col = 0; col < App.getGridSize(); col++) 
            {
                if (shipGrid[row][col] && !grid[row][col].getFill().equals(Color.SIENNA)) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetGame() 
    {
        triesLeft = App.getMaxTries();
        for (int row = 0; row < App.getGridSize(); row++) 
        {
            for (int col = 0; col < App.getGridSize(); col++) 
            {
                grid[row][col].setFill(Color.WHITE);
            }
        }
    }

    private void showGameOverAlert() 
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("You have lost the game. Better luck next time!");
        alert.showAndWait();
        resetGame();
        new RandomShips(shipGrid);
    }

    private void showGameWonAlert() 
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Congratulations!");
        alert.setHeaderText(null);
        alert.setContentText("You have won the game! Well done!");
        alert.showAndWait();
        resetGame();
        new RandomShips(shipGrid);
    }
    
}
