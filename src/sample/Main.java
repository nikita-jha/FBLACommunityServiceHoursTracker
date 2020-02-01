package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * This method creates the primary screen for the login page.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        SecondWindowController.hostServices = getHostServices();
        primaryStage.setTitle("Community Service Hours Tracker");
        primaryStage.setScene(new Scene(root, 850, 500));
        primaryStage.show();
    }

    /**
     * This is a test method used for testing individual features. This is not applicable for application.
     * @param args
     */
    public static void main(String[] args) {
        DBConnection myConnection = new DBConnection();
        myConnection.readQuery(null);
        Student student = new Student("123456",null,null,null,null,null);
        myConnection.readQuery(student);
        student.setStudentNumber(null);
        student.setFirstName("Scott");
        myConnection.readQuery(student);
        student.setStudentNumber("1234567");
        myConnection.readQuery(student);
        launch(args);
    }
}



