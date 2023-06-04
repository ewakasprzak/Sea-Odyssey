package sea;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Field 
{
    private Rectangle field;

    public Rectangle getField() 
    {
        return field;
    }

    public Field()
    {
        field = new Rectangle(30, 30);
        field.setFill(Color.WHITE);
        field.setStroke(Color.BLACK);
    }
}
