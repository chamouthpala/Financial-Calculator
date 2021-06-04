import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class help  {

    public static void start (Stage primaryStage) throws Exception{
        primaryStage.setTitle("Help");
        AnchorPane helproot =  new AnchorPane();
        helproot.setStyle("-fx-background-image: url('help.jpeg');-fx-background-size: 800,500");


        // Back Button

        Button btnback = new Button("Back");
        btnback.setLayoutX(715);
        btnback.setLayoutY(400);
        btnback.setPrefSize(60,30);
        btnback.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    homepage.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        helproot.getChildren().add(btnback);

        primaryStage.setScene(new Scene(helproot,800,450));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


}