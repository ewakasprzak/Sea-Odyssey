package sea;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GUIHBox 
{
    private HBox hbox;

    public GUIHBox(GridPane pane, Button button)
    {
        this.hbox = new HBox(pane, button);
        this.hbox.setStyle("-fx-background-color: #000000;");
        this.hbox.setSpacing(10);
        this.hbox.setAlignment(Pos.CENTER);
        this.hbox.setPadding(new Insets(10));
    }

    public HBox getHBox()
    {
        return hbox;
    }   
}
