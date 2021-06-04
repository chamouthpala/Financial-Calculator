import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class keypad {
    static Button btn1= new Button();
    static Button btn2= new Button();
    static Button btn3= new Button();
    static Button btn4= new Button();
    static Button btn5= new Button();
    static Button btn6= new Button();
    static Button btn7= new Button();
    static Button btn8= new Button();
    static Button btn9= new Button();
    static Button btn0= new Button();
    static Button btndot= new Button();
    static Button btnclear= new Button();


    public static void initialize(AnchorPane root1) throws Exception{
        root1.setLayoutX(500);
        root1.setLayoutY(100);

        btn1.setText("1");
        btn1.setLayoutX(50);
        btn1.setLayoutY(30);
        btn1.setPrefSize(40,40);

        btn2.setText("2");
        btn2.setLayoutX(100);
        btn2.setLayoutY(30);
        btn2.setPrefSize(40,40);

        btn3.setText("3");
        btn3.setLayoutX(150);
        btn3.setLayoutY(30);
        btn3.setPrefSize(40,40);

        btn4.setText("4");
        btn4.setLayoutX(50);
        btn4.setLayoutY(80);
        btn4.setPrefSize(40,40);

        btn5.setText("5");
        btn5.setLayoutX(100);
        btn5.setLayoutY(80);
        btn5.setPrefSize(40,40);

        btn6.setText("6");
        btn6.setLayoutX(150);
        btn6.setLayoutY(80);
        btn6.setPrefSize(40,40);

        btn7.setText("7");
        btn7.setLayoutX(50);
        btn7.setLayoutY(130);
        btn7.setPrefSize(40,40);

        btn8.setText("8");
        btn8.setLayoutX(100);
        btn8.setLayoutY(130);
        btn8.setPrefSize(40,40);

        btn9.setText("9");
        btn9.setLayoutX(150);
        btn9.setLayoutY(130);
        btn9.setPrefSize(40,40);

        btndot.setText(".");
        btndot.setLayoutX(50);
        btndot.setLayoutY(180);
        btndot.setPrefSize(40,40);

        btn0.setText("0");
        btn0.setLayoutX(100);
        btn0.setLayoutY(180);
        btn0.setPrefSize(40,40);

        btnclear.setText("C");
        btnclear.setLayoutX(150);
        btnclear.setLayoutY(180);
        btnclear.setPrefSize(40,40);

        root1.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,btnclear);
    }
    public static void keyboard(TextField txt){
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"1");

            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"2");

            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"3");

            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"4");

            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"5");

            }
        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"6");

            }
        });
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"7");

            }
        });
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"8");

            }
        });
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"9");

            }
        });
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+"0");

            }
        });
        btnclear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

            }
        });
        btndot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt.setText(txt.getText()+".");

            }
        });
    }
}
