import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class savings  {

    static AnchorPane keyboard = new AnchorPane();


    public static void start (Stage primaryStage) throws Exception{
        AnchorPane savingsroot =  new AnchorPane();

        //-------------------Adding css to file-----------------------------------------

        savingsroot.getStylesheets().add(homepage.class.getResource("Style.css").toExternalForm());
        primaryStage.setTitle("Savings");
        primaryStage.setScene(new Scene(savingsroot,800,500));

//-----------------------------set fixed size to the window--------------------------------------------

        primaryStage.setResizable(false);
        primaryStage.show();

//----------------------Topic of Main Page--------------------------------------

        Label textTopic = new Label(" Savings Calculator");
        textTopic.setLayoutX(260);
        textTopic.setLayoutY(60);

//---------------------------------getting inputs------------------------------------------------------------

        Label lblfv = new Label("Future Value");
        lblfv.setLayoutX(50);
        lblfv.setLayoutY(130);

        TextField txtFV = new TextField();
        txtFV.setLayoutX(200);
        txtFV.setLayoutY(130);
        txtFV.setPrefSize(200,30);

        Label labeldownPayment = new Label("Present Value");
        labeldownPayment.setLayoutX(50);
        labeldownPayment.setLayoutY(180);

        TextField txtPV = new TextField();
        txtPV.setLayoutX(200);
        txtPV.setLayoutY(180);
        txtPV.setPrefSize(200,30);

        Label labelloanTerm = new Label("Time In Years");
        labelloanTerm.setLayoutX(50);
        labelloanTerm.setLayoutY(230);

        TextField txtTime = new TextField();
        txtTime.setLayoutX(200);
        txtTime.setLayoutY(230);
        txtTime.setPrefSize(200,30);

        Label labelinterestRate = new Label("Interest Rate");
        labelinterestRate.setLayoutX(50);
        labelinterestRate.setLayoutY(280);
        labelinterestRate.setPrefSize(200,30);


        TextField txtIR = new TextField();
        txtIR.setLayoutX(200);
        txtIR.setLayoutY(280);
        txtIR.setPrefSize(200,30);

        Label totalLabel = new  Label(" ");
        totalLabel.setLayoutX(200);
        totalLabel.setLayoutY(400);
        totalLabel.setPrefSize(500,30);

     //-----------------------------------------clear--------------------------------------------------------------

        Button btn2 = new Button();
        btn2.setLayoutX(125);
        btn2.setLayoutY(350);
        btn2.setPrefSize(90,50);
        btn2.setText("Clear");
        btn2.setStyle("-fx-background-color: burlywood");
        btn2.setOnAction(event -> {
            txtFV.clear();
            txtPV.clear();
            txtIR.clear();
            txtTime.clear();
        });

  //--------------------------------------Calculate-------------------------------------------------------

        Button btn3 = new Button();
        btn3.setLayoutX(250);
        btn3.setLayoutY(350);
        btn3.setPrefSize(200,50);
        btn3.setStyle("-fx-background-color: burlywood");
        btn3.setText("Calculate");

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

        savingsroot.getChildren().addAll(textTopic,lblfv,labeldownPayment,labelloanTerm,labelinterestRate,totalLabel,btn2,btn3,btn4,keyboard,txtFV,txtPV,txtTime,txtIR);



        txtPV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtPV);
            }
        });

        txtFV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtFV);
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
//------------------------------------calculations----------------------------------------------------

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtFV.getText().equals("")){
                    double P = Double.parseDouble(txtPV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double A = P * (Math.pow((1 + (R / 12)), (12 * T)));
                    String result = String.format("%.2f",A);
                    txtFV.setText(result);
                    totalLabel.setText("Future value : "+result+" ");

                }else if (txtPV.getText().equals("")){
                    double A = Double.parseDouble(txtFV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double P = A / (Math.pow((1 + (R / 12)), 12 * T));
                    String result = String.format("%.2f",P);
                    txtPV.setText(result);
                    totalLabel.setText("Present value : "+result+" ");

                }else if(txtIR.getText().equals("")){
                    double A = Double.parseDouble(txtFV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double P = Double.parseDouble(txtPV.getText());
                    double R = 12 * ((Math.pow((A / P), (1/(12 * T)))) - 1);
                    String result = String.format("%.2f",R);
                    txtIR.setText(result);
                    totalLabel.setText("Interest Rate : "+result+" ");

                }else if(txtTime.getText().equals("")){
                    double A = Double.parseDouble(txtFV.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double P = Double.parseDouble(txtPV.getText());
                    double T = (Math.log(A / P)) / (12* (Math.log(1 + (R / 12))));
                    String result = String.format("%.2f",T);
                    txtTime.setText(result);
                    totalLabel.setText("Time in Years : "+result+" ");

                }
            }
        });
    }
}

