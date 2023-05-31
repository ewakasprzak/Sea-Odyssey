package sea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application 
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) 
    {

        Pane pane = new Pane();

        new GUIPane(pane);

        Scene scene = new Scene(pane, 500, 500);

        stage.setScene(scene);
        stage.setTitle("SEA ODYSSEY");
        stage.show();
    }

    
}

