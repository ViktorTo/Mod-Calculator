package sample.control;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private Label output;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button mod;
    @FXML
    private ToggleButton theme;

    private String result = "";
    private String input = "";
    private String cssLight = this.getClass().getResource("/sample/resources/style.css").toExternalForm();
    private String cssDark = this.getClass().getResource("/sample/resources/style2.css").toExternalForm();
    private String cssTemp = "";
    private int calc;

    public void inputKeys(KeyEvent event) {

        if (event.getCode() == KeyCode.BACK_SPACE) {
            if (input.equals("")) {

                output.setText("0");

            } else {

                input = input.substring(0, input.length() - 1);
                output.setText(input);
            }

        } else if (event.getCode().isDigitKey()) {

            input += event.getText();
            output.setText(input);
        } else if (event.getCode() == KeyCode.ENTER) {

            System.out.println("ENTER!!");

        }

    }

    public void exitButtonClicked(MouseEvent mouseEvent) {

        Platform.exit();

    }

    public void changeTheme(MouseEvent mouseEvent) {

        if (cssTemp.equals(cssLight) || cssTemp.equals("")) {

            cssTemp = cssDark;
            rootPane.getStylesheets().clear();
            rootPane.getStylesheets().add(cssDark);

        } else {

            cssTemp = cssLight;
            rootPane.getStylesheets().clear();
            rootPane.getStylesheets().add(cssLight);
        }

        System.out.println(cssTemp);

        theme.setText((theme.getText().equals("Light") ? "Dark" : "Light"));

    }

    public void modClickEvent(MouseEvent mouseEvent) {

        if (result.equals("")) {

            result = output.getText();
            output.setText("0");
            mod.setText("=");
            input = "";

        } else {

            int num1 = Integer.parseInt(result);
            int num2 = Integer.parseInt(output.getText());

            calc = num1 % num2;
            result = Integer.toString(calc);
            output.setText(result);
            result = "";
            mod.setText("MOD");
            input = "";

        }

    }

    public void cButtonClicked(MouseEvent mouseEvent) {

        result = "";
        input = "";
        calc = 0;
        output.setText("0");
        mod.setText("MOD");

    }

}
