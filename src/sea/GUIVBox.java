package sea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIVBox {
    private VBox vbox;

    public GUIVBox(GridPane pane, Button button, Button text) 
    {
        this.vbox = new VBox(text, pane, button);
        text.setText("Tries left: 66");
        pane.setAlignment(Pos.CENTER);
        this.vbox.setSpacing(10);
        this.vbox.setAlignment(Pos.CENTER);
        this.vbox.setPadding(new Insets(10));

        try 
        {
            FileInputStream input = new FileInputStream("/home/ewa/Desktop/SeaOdyssey/src/sea.jpg");
            Image image = new Image(input);
            input.close(); 

            BackgroundImage backgroundimage = new BackgroundImage(image,
                                                                BackgroundRepeat.NO_REPEAT, 
                                                                BackgroundRepeat.NO_REPEAT, 
                                                                BackgroundPosition.DEFAULT,
                                                                BackgroundSize.DEFAULT);

            Background background = new Background(backgroundimage);
            vbox.setBackground(background);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public VBox getVBox() {
        return vbox;
    }
}
