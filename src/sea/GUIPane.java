package sea;

import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GUIPane 
{
    Field[][] fields = new Field[10][10];
    Point2D[] activeFields = new Point2D[20];
    int row;
    int column;
    Random random = new Random();
    
    public GUIPane(Pane pane)
    {
        GridPane paneLeft = new GridPane();
        paneLeft.setLayoutX(40);
        paneLeft.setLayoutY(40);

        // GridPane paneRight = new GridPane();
        // paneRight.setLayoutX(270);
        // paneRight.setLayoutY(120);

        Rectangle rec = new Rectangle();
        

        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                Field f1 = new Field(i, j);
                fields[i][j] = f1;
                // Field f2 = new Field(i, j);
                paneLeft.add(f1.getRectangle(), j, i);
                // paneRight.add(f2.getRectangle(), j, i);
            }
        }

        for (int i = 0; i < 2; i++)
        {
            // row = random.nextInt(10);
            // column = random.nextInt(10);
            // fields[row][column].changeColor();
            
            // activeFields[i] = new Point2D(row, column);
            
            // for (Point2D point : activeFields)
            // {
            //     fields[row][column].setActive();
            RandomShips ship = new RandomShips(fields);
        }

        pane.getChildren().addAll(paneLeft);
    }
}
