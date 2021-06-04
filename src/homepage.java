import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class homepage  {

    static AnchorPane keyboard = new AnchorPane();


    public static void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Home Page");
        AnchorPane root =  new AnchorPane();
        root.getStylesheets().add(homepage.class.getResource("Style.css").toExternalForm());

//------------ --------------------Topic of Main Page-------------------------------------

        Label textTopic = new Label("Finance Calculator");
        textTopic.setLayoutX(250);
        textTopic.setLayoutY(70);
        textTopic.setStyle("-fx-text-fill:rgba(188,240,255,0.94);-fx-font-family: 'Bebas Neue';-fx-font-size: 40px");

// ---------------------------------------Savings Button---------------------------------------------------------
        Button btn1 = new Button("Savings");
        btn1.setLayoutX(150);
        btn1.setLayoutY(200);
        btn1.setPrefWidth(200);
        btn1.setPrefHeight(60);
        btn1.setStyle("-fx-background-color: #d7dbd8");

//------------------------------- Savings Action(On Button Click)-------------------------------------------------------

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    savings.start(primaryStage);
                    keyboard.getChildren().clear();


                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

//--------------------------------------------- Loan Button-----------------------------------------------------

        Button btn2 = new Button("Loan");
        btn2.setLayoutX(450);
        btn2.setLayoutY(200);
        btn2.setPrefWidth(200);
        btn2.setPrefHeight(60);
        btn2.setStyle("-fx-background-color: #d7dbd8");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
//----------------------------------------loan button action(on Button Click)-----------------------------
            @Override
            public void handle(ActionEvent event) {
                try {
                    loan.start(primaryStage);
                    keyboard.getChildren().clear();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


//---------------------------------------------Mortgage Button------------------------------------------------
        Button btn3 = new Button("Mortgage");
        btn3.setLayoutX(150);
        btn3.setLayoutY(320);
        btn3.setPrefWidth(200);
        btn3.setPrefHeight(60);
        btn3.setStyle("-fx-background-color: #d7dbd8");

//------------------------------Mortgage On action Button(on button click)-------------------------------

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mortgage.start(primaryStage);
                    keyboard.getChildren().clear();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

//---------------------------------Compound Interest--------------------------------------------------------------

        Button btn4 = new Button("Compound Interest");
        btn4.setLayoutX(450);
        btn4.setLayoutY(320);
        btn4.setPrefWidth(200);
        btn4.setPrefHeight(60);
        btn4.setStyle("-fx-background-color: #d7dbd8");

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    compound.start(primaryStage);
                   keyboard.getChildren().clear();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

//-------------------------------------------Help Button--------------------------------------------------------
        Button btn5 = new Button("Help");
        btn5.setLayoutX(325);
        btn5.setLayoutY(425);
        btn5.setPrefWidth(150);
        btn5.setPrefHeight(45);
        btn5.setStyle("-fx-background-color: #d7dbd8");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    help.start(primaryStage);
                    keyboard.getChildren().clear();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,textTopic);

        Scene scene = new Scene(root,800,500);
        primaryStage.setScene(scene);
//---------------------------------set the fixed size for the window-------------------------------------------
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}