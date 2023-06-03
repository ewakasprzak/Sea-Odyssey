package sea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class RandomShips 
{

    private boolean[][] shipGrid;

    public RandomShips(boolean[][] shipGrid)
    {
        this.shipGrid = shipGrid;
        
        Random random = new Random();

        for (int row = 0; row < App.getGridSize(); row++) 
        {
            for (int col = 0; col < App.getGridSize(); col++) 
            {
                shipGrid[row][col] = false;
            }
        }

        List<int[]> shipCoordinates = new ArrayList<>();

        for (int i = 1; i <= App.getShipsCount(); i++) 
        {
            int length = (i <= 4) ? 1 : (i <= 7) ? 2 : (i <= 9) ? 3 : 4;
            boolean horizontal = random.nextBoolean();

            int row, col;
            boolean validPlacement = false;

            while (!validPlacement) 
            {
                row = random.nextInt(App.getGridSize());
                col = random.nextInt(App.getGridSize());

                validPlacement = isValidShipPlacement(row, col, length, horizontal);

                if (validPlacement) 
                {
                    shipCoordinates.add(new int[]{row, col, length, (horizontal) ? 1 : 0});

                    for (int j = 0; j < length; j++) 
                    {
                        if (horizontal) 
                        {
                            shipGrid[row][col + j] = true;
                        } 
                        else 
                        {
                            shipGrid[row + j][col] = true;
                        }
                    }
                }
            }
        }

        System.out.println("Ship Coordinates:");
        for (int[] coordinates : shipCoordinates) 
        {
            System.out.println("Row: " + coordinates[0] + ", Col: " + coordinates[1] + ", Length: " + coordinates[2] + ", Orientation: " + ((coordinates[3] == 1) ? "Horizontal" : "Vertical"));
        }
    }

    private boolean isValidShipPlacement(int row, int col, int length, boolean horizontal) 
    {
        int endRow = (horizontal) ? row : row + length - 1;
        int endCol = (horizontal) ? col + length - 1 : col;

        if (endRow >= App.getGridSize() || endCol >= App.getGridSize()) 
        {
            return false;
        }

        for (int i = row - 1; i <= endRow + 1; i++) 
        {
            for (int j = col - 1; j <= endCol + 1; j++) 
            {
                if (i >= 0 && i < App.getGridSize() && j >= 0 && j < App.getGridSize()) 
                {
                    if (shipGrid[i][j]) 
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    
}
