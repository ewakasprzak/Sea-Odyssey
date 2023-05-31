package sea;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Field 
{
    private Rectangle rectangle = new Rectangle();
    private boolean clicked = false;
    private Point2D position;

    public Field(int i, int j)
    {
        this.position = new Point2D(i, j);

        rectangle.setWidth(40);
        rectangle.setHeight(40);
        rectangle.setFill((Paint) Color.BEIGE);
        rectangle.setStroke(Color.GREY);
        rectangle.setStrokeWidth(0.5);

        rectangle.setOnMouseClicked(e ->
        {
            if (clicked)
            {
                rectangle.setFill((Paint) Color.DARKBLUE);
                rectangle.setStroke(Color.BLACK);
            }
            else
            {
                rectangle.setFill((Paint) Color.RED);
                rectangle.setStroke(Color.BLACK);
            }
        });
        
    }

    public Rectangle getRectangle() 
    {
        return rectangle;
    }

    public boolean isClicked() 
    {
        return clicked;
    }

    public void changeColor()
    {
        rectangle.setFill((Paint) Color.DARKGREEN);
    }

    public Point2D getPosition()
    {
        return position;
    }

    public boolean isActive()
    {
        return clicked;
    }

    public void setActive()
    {
        clicked = true;
    }
    
}
