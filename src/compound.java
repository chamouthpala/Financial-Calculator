import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class compound  {

    static AnchorPane keyboard = new AnchorPane();

    public static void start (Stage primaryStage) throws Exception{
        primaryStage.setTitle("Compound");

        Label textTopic = new Label("Compound Savings Calculator");
        textTopic.setLayoutX(260);
        textTopic.setLayoutY(60);

  //----------------------------getting inputs------------------------------------------------------------------

        Label lbl1 = new Label("Future Value");
        lbl1.setLayoutX(50);
        lbl1.setLayoutY(130);

        TextField txtFV = new TextField();
        txtFV.setLayoutX(220);
        txtFV.setLayoutY(130);
        txtFV.setPrefSize(200,30);

        Label lbl2 = new Label("Present Value");
        lbl2.setLayoutX(50);
        lbl2.setLayoutY(180);

        TextField txtPV = new TextField();
        txtPV.setLayoutX(220);
        txtPV.setLayoutY(180);
        txtPV.setPrefSize(200,30);

        Label lbl3 = new Label("Time In Years");
        lbl3 .setLayoutX(50);
        lbl3 .setLayoutY(230);

        TextField txtTime = new TextField();
        txtTime.setLayoutX(220);
        txtTime.setLayoutY(230);
        txtTime.setPrefSize(200,30);

        Label lbl4  = new Label("Interest Rate");
        lbl4.setLayoutX(50);
        lbl4.setLayoutY(280);
        lbl4.setPrefSize(200,30);


        TextField txtIR = new TextField();
        txtIR.setLayoutX(220);
        txtIR.setLayoutY(280);
        txtIR.setPrefSize(200,30);

        Label lbl5 = new Label("Monthly Payment");
        lbl5.setLayoutX(50);
        lbl5.setLayoutY(330);

        TextField txtPMT = new TextField();
        txtPMT.setLayoutX(220);
        txtPMT.setLayoutY(330);
        txtPMT.setPrefSize(200,30);

        Label lbl6 = new  Label(" ");
        lbl6.setLayoutX(250);
        lbl6.setLayoutY(425);
        lbl6.setPrefSize(500,30);

        Button btn2 = new Button("Clear");
        btn2.setLayoutX(150);
        btn2.setLayoutY(370);
        btn2.setPrefWidth(90);
        btn2.setPrefSize(90,50);
        btn2.setStyle("-fx-background-color: burlywood");
        btn2.setOnAction(event -> {
            txtFV.clear();
            txtPV.clear();
            txtIR.clear();
            txtTime.clear();
            txtPMT.clear();
        });

        Button btn3 = new Button();
        btn3.setLayoutX(250);
        btn3.setLayoutY(370);
        btn3.setPrefSize(200,50);
        btn3.setText("Calculate");
        btn3.setStyle("-fx-background-color: burlywood");

        Button btn4 = new Button();
        btn4.setLayoutX(650);
        btn4.setLayoutY(450);
        btn4.setPrefWidth(90);
        btn4.setText("Back");
        btn4.setStyle("-fx-background-color: burlywood");

   //---------------------------back button-------------------------------------------------------------------

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

        AnchorPane compoundroot =  new AnchorPane();
        compoundroot.getStylesheets().add(homepage.class.getResource("Style.css").toExternalForm());
        compoundroot.getChildren().addAll(textTopic,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,btn2,btn3,btn4,keyboard,txtFV,txtPV,txtTime,txtIR,txtPMT);
        primaryStage.setScene(new Scene(compoundroot,800,500));
        primaryStage.setResizable(false);
        primaryStage.show();

 //----------------------------------keyborad action-----------------------------------------------------------

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
        txtPMT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keypad.keyboard(txtPMT);
            }
        });


        keypad.initialize(keyboard);

  //------------------------------calculations---------------------------------------------------

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtFV.getText().equals("")){
                    double P = Double.parseDouble(txtPV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double PMT = Double.parseDouble(txtPMT.getText());
                    double FV = (P * Math.pow((1 + (R / 12)), (12 * T))) + (PMT * ((Math.pow((1 + (R / 12)), (12 * T)) - 1) / (R/12)));
                    String result = String.format("%.2f",FV);
                    txtFV.setText(result);
                    lbl6.setText("Future Value : "+result+" ");

                }else if (txtPV.getText().equals("")){
                    double PMT = Double.parseDouble(txtPMT.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double FV = Double.parseDouble(txtFV.getText());
                    double P = (FV - (PMT * ((Math.pow((1 + (R/12)), 12 * T) - 1) / (R/12))))/ (Math.pow((1 + (R/12)), 12 * T));
                    String result = String.format("%.2f",P);
                    txtPV.setText(result);
                    lbl6.setText("Present Value : "+result+" ");

                }else if(txtTime.getText().equals("")){
                    double PMT = Double.parseDouble(txtPMT.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double P = Double.parseDouble(txtPV.getText());
                    double FV = Double.parseDouble(txtFV.getText());
                    double T = Math.log(((((R * FV) / 12) + PMT) / (((P * R) / 12) + PMT))) / (12 * Math.log(1 + (R/12)));
                    String result = String.format("%.2f",T);
                    txtTime.setText(result);
                    lbl6.setText("Time in Years : "+result+" ");

                }else if(txtPMT.getText().equals("")){
                    double P = Double.parseDouble(txtPV.getText());
                    double R = Double.parseDouble(txtIR.getText());
                    double FV = Double.parseDouble(txtFV.getText());
                    double T = Double.parseDouble(txtTime.getText());
                    double PMT = (FV - (P * Math.pow((1 + (R / 12)), (12 * T)))) / ((Math.pow((1 + (R / 12)), (12 * T)) - 1) / (R / 12));
                    String result = String.format("%.2f",PMT);
                    txtPMT.setText(result);
                    lbl6.setText("Payment : "+result+" ");

                }
            }
        });



    }

}
