package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Label resultLabel;

    @FXML
    private Button myButton;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Button printButton;



    public Controller() {
    }

    @FXML
    private void initialize() {
        resultLabel.setText("");
        // Handle Button event.
        myButton.setOnAction((event) -> {
            System.out.println("Button pressed");
            if (! (usernameTxt.getText().equals("Northview") && (passwordTxt.getText().equals("titans")))) {
                resultLabel.setText("Invalid password \n");
            } else {
                loginAction();
            }

        });
    }
    private void loginAction() {
        resultLabel.setText("");

        try{
            Stage stageP = (Stage) myButton.getScene().getWindow();
            stageP.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/secondWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
 private void printScreen() {
        // Handle Print Button event.
        printButton.setOnAction((event) -> {
            System.out.println("Print Button Pushed");
            try{
                Stage stageP = (Stage) printButton.getScene().getWindow();
                stageP.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/printScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });


        }


}

