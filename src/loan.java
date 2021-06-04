import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loan  {


    static AnchorPane keyboard = new AnchorPane();

    public static void start (Stage primaryStage) throws Exception{
        primaryStage.setTitle("Loan");

        Label textTopic = new Label("Loan");
        textTopic.setLayoutX(260);
        textTopic.setLayoutY(60);

 //-----------------------------------getting inputs--------------------------------------------------------------

        Label lbl1 = new Label("Payment");
        lbl1.setLayoutX(50);
        lbl1.setLayoutY(130);

        TextField txtPMT = new TextField();
        txtPMT.setLayoutX(200);
        txtPMT.setLayoutY(130);
        txtPMT.setPrefSize(200,30);

        Label lbl2 = new Label("Present Value");
        lbl2.setLayoutX(50);
        lbl2.setLayoutY(180);

        TextField txtPV = new TextField();
        txtPV.setLayoutX(200);
        txtPV.setLayoutY(180);
        txtPV.setPrefSize(200,30);

        Label lbl3 = new Label("Time In Years");
        lbl3.setLayoutX(50);
        lbl3.setLayoutY(230);

        TextField txtTime = new TextField();
        txtTime.setLayoutX(200);
        txtTime.setLayoutY(230);
        txtTime.setPrefSize(200,30);

        Label lbl4 = new Label("Interest Rate");
        lbl4.setLayoutX(50);
        lbl4.setLayoutY(280);
        lbl4.setPrefSize(200,30);


        TextField txtIR = new TextField();
        txtIR.setLayoutX(200);
        txtIR.setLayoutY(280);
        txtIR.setPrefSize(200,30);

        Label lbl5 = new  Label(" ");
        lbl5.setLayoutX(200);
        lbl5.setLayoutY(400);
        lbl5.setPrefSize(500,30);

        Button btn2 = new Button();
        btn2.setLayoutX(150);
        btn2.setLayoutY(350);
        btn2.setPrefSize(90,50);
        btn2.setText("Clear");
        btn2.setStyle("-fx-background-color: burlywood");
        btn2.setOnAction(event -> {
            txtPMT.clear();
            txtPV.clear();
            txtIR.clear();
            txtTime.clear();
        });

        Button btn3 = new Button();
        btn3.setLayoutX(250);
        btn3.setLayoutY(350);
        btn3.setPrefSize(200,50);
        btn3.setText("Calculate");
        btn3.setStyle("-fx-background-color: burlywood");

        Button btn4 = new Button();
        btn4.setLayoutX(650);
        btn4.setLayoutY(450);
        btn4.setPrefWidth(90);
        btn4.setText("Back");
        btn4.setStyle("-fx-background-color: burlywood");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    homepage.start(primaryStage);
                    keyboard.getChildren().clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        AnchorPane loanroot =  new AnchorPane();

        //----------------------adding css to class-------------------------------------------------------------------

        loanroot.getStylesheets().add(homepage.class.getResource("Style.css").toExternalForm());
        loanroot.getChildren().addAll(textTopic,lbl1,lbl2,lbl3,lbl4,lbl5,btn2,btn3,btn4,keyboard,txtPMT,txtPV,txtTime,txtIR);

        primaryStage.setScene(new Scene(loanroot,800,500));
        primaryStage.setResizable(false);
        primaryStage.show();
        txtPV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtPV);
            }
        });

        txtPMT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtPMT);
            }
        });

        txtIR.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtIR);
            }
        });
        txtTime.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtTime);
            }
        });

        keypad.initialize(keyboard);

  //---------------------------------calculations------------------------------------------------------

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtPMT.getText().equals("")){
                    double P = Double.parseDouble(txtPV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double PMT = (P * R) / (1 - (1 / Math.pow((1 + R), T)));
                    String result = String.format("%.2f",PMT);
                    txtPMT.setText(result);
                    lbl5.setText("Payment is : "+result+" ");

                }else if (txtPV.getText().equals("")){
                    double PMT = Double.parseDouble(txtPMT.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double P = (PMT / R) * (1 - (1 / Math.pow((1 + R), T)));
                    String result = String.format("%.2f",P);
                    txtPV.setText(result);
                    lbl5.setText("Present value : "+result+" ");

                }else if(txtTime.getText().equals("")){
                    double PMT = Double.parseDouble(txtPMT.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double P = Double.parseDouble(txtPV.getText());
                    double T = Math.log((PMT / R) / ((PMT / R) - P)) / Math.log(1 + R);
                    String result = String.format("%.2f",T);
                    txtTime.setText(result);
                    lbl5.setText("Time in Years : "+result+" ");

                }
            }
        });


    }

}
