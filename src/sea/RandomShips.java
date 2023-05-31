package sea;

import java.util.Random;

import javafx.geometry.Point2D;

public class RandomShips 
{
    private int orient;
    private int row = 10;
    private int col = 10;
    private Random random = new Random();
    private Field[][] fields = new Field[10][10];
    private Point2D[] active = new Point2D[20];
    private int count = 0;

    public RandomShips(Field[][] fields)
    {
        this.fields = fields;
        random4(random);
    }

    public void random4(Random random)
    {
        orient = random.nextInt(2);

        if (orient == 0)
        {
            row = random.nextInt(10);
            col = random.nextInt(7);

            fields[row][col].setActive();
            fields[row][col].changeColor();
            active[count] = new Point2D(row, col);
            count++;

            fields[row + 1][col].setActive();
            fields[row + 1][col].changeColor();
            active[count] = new Point2D(row + 1, col);
            count++;

            fields[row + 2][col].setActive();
            fields[row + 2][col].changeColor();
            active[count] = new Point2D(row + 2, col);
            count++;

            fields[row + 3][col].setActive();
            fields[row + 3][col].changeColor();
            active[count] = new Point2D(row + 3, col);
            count++;

        }
        else
        {
            row = random.nextInt(7);
            col = random.nextInt(10); 

            fields[row][col].setActive();
            fields[row][col].changeColor();
            active[count] = new Point2D(row, col);
            count++;
        }  
    }   
}
