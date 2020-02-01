    package sample;

    import javafx.application.HostServices;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.control.cell.TextFieldTableCell;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.FileChooser;
    import javafx.stage.Stage;

    import java.io.File;
    import java.net.URL;
    import java.time.LocalDate;
    import java.time.Month;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.Locale;
    import java.util.ResourceBundle;

    public class SecondWindowController implements Initializable {

        //configure the table
        @FXML private TableView<Student> tableView;
        @FXML private TableColumn<Student, String> studentNumberColumn;
        @FXML private TableColumn<Student, String> firstNameColumn;
        @FXML private TableColumn<Student, String> hoursColumn;
        @FXML private TableColumn<Student, String> gradesColumn;
        @FXML private TableColumn<Student, String> serviceAwardColumn;
        @FXML private TableColumn<Student, LocalDate> hoursDateColumn;

        DBConnection mydbconnection = new DBConnection();
        public static HostServices hostServices;


        /**
         * This method is for setting the name column to be editable
         * @param edditedCell
         */
        public void changeFirstNameCellEvent(TableColumn.CellEditEvent edditedCell) {
            Student studentSelected = tableView.getSelectionModel().getSelectedItem();
            studentSelected.setFirstName(edditedCell.getNewValue().toString());
            mydbconnection.updateStudent(studentSelected);
        }

        /**
         * This method is for setting the hours cell to be editable
         * @param edditedCell
         */
        public void changeHoursCellEvent(TableColumn.CellEditEvent edditedCell) {
            Student studentSelected = tableView.getSelectionModel().getSelectedItem();
            studentSelected.setHours(edditedCell.getNewValue().toString());
            mydbconnection.updateHours(studentSelected);
        }

        /**
         * This method is for setting the grade cell to be editable
         * @param edditedCell
         */
        public void changeGradeCellEvent(TableColumn.CellEditEvent edditedCell) {
            Student studentSelected = tableView.getSelectionModel().getSelectedItem();
            studentSelected.setGrade(edditedCell.getNewValue().toString());
            mydbconnection.updateHours(studentSelected);
        }

        /**
         * This method is for setting the service award cell to be editable
         * @param edditedCell
         */
        public void changeServiceAwardCellEvent(TableColumn.CellEditEvent edditedCell) {
            Student studentSelected = tableView.getSelectionModel().getSelectedItem();
            studentSelected.setServiceAward(edditedCell.getNewValue().toString());
            mydbconnection.updateStudent(studentSelected);

        }

        @FXML private TextField studentNumberTextField;
        @FXML private TextField firstNameTextField;
        @FXML private TextField hoursTextField;
        @FXML private ChoiceBox gradesChoiceBox;
        @FXML private ChoiceBox serviceAwardChoiceBox;
        @FXML private DatePicker datePicker;
        @FXML private Button buttonAddStudent;
        @FXML private Button buttonReset;
        @FXML private Button buttonSearch;
        @FXML private Button buttonAddHours;
        @FXML private Button printButton;



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);


        /**
         * This method is for initializing every single column in the data table and settings its name
         * @param url
         * @param rb
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            buttonAddHours.setDisable(true);
            buttonReset.setDisable(true);
            studentNumberColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNumber"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
            hoursColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("hours"));
            gradesColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("grade"));
            serviceAwardColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("serviceAward"));
            hoursDateColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("hoursDate"));

            tableView.setItems(getStudents(null));

            //Update the table to allow for the fields to be editable
            tableView.setEditable(true);
            //studentNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            hoursColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            gradesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            serviceAwardColumn.setCellFactory(TextFieldTableCell.forTableColumn());


            //This will allow the table to select only one row at once
            tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


            tableView.setOnMouseClicked((MouseEvent event) -> {
                if (event.getClickCount() > 1) {
                    onEdit();
                }
            });


        }

        /**
         * This method is for enabling or disabling certain buttons and checking the table's selected item
         */
        public void onEdit() {
            if (tableView.getSelectionModel().getSelectedItem() != null) {

                studentNumberTextField.setEditable(false);
                firstNameTextField.setEditable(false);
                buttonAddHours.setDisable(false);
                buttonAddStudent.setDisable(true);
                buttonSearch.setDisable(true);
                Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
                studentNumberTextField.setText(selectedStudent.getStudentNumber());
                firstNameTextField.setText(selectedStudent.getFirstName());
                gradesChoiceBox.setValue(selectedStudent.getGrade());
                serviceAwardChoiceBox.setValue(selectedStudent.getServiceAward());
            }
        }

        /**
         * This method creates the reset button and sets all the fields to be null after pressing the button
         */
        public void resetButtonPushed(){
                studentNumberTextField.setText(null);
                firstNameTextField.setText(null);
                gradesChoiceBox.setValue(null);
                datePicker.setValue(null);
                hoursTextField.setText(null);
                serviceAwardChoiceBox.setValue(null);
                buttonReset.setDisable(true);
                tableView.setItems(getStudents(null));
            }

        /**
         * This method adds hours to a student's profile
         */
        public void addHoursButtonPushed() {
            System.out.println((datePicker.getValue()).format(formatter));
            String formattedValue = (datePicker.getValue()).format(formatter);
            Student student = new Student(studentNumberTextField.getText(),
                    firstNameTextField.getText(),
                    hoursTextField.getText(),
                    (String)gradesChoiceBox.getValue(),
                    (String)serviceAwardChoiceBox.getValue(),
                    formattedValue);

            mydbconnection.insertHours(student);


            tableView.getItems().add(student);
            studentNumberTextField.setEditable(true);
            firstNameTextField.setEditable(true);
            buttonAddHours.setDisable(true);
            buttonAddStudent.setDisable(false);
            buttonReset.setDisable(false);

            buttonSearch.setDisable(false);

            tableView.setItems(getStudents(null));
        }

        /**
         * This method will create a new Student object and add it to the table
         */
        public void newStudentButtonPushed() {
            System.out.println((datePicker.getValue()).format(formatter));
            String formattedValue = (datePicker.getValue()).format(formatter);
            Student newStudent = new Student(studentNumberTextField.getText(),
                                             firstNameTextField.getText(),
                                             hoursTextField.getText(),
                                            (String)gradesChoiceBox.getValue(),
                                            (String)serviceAwardChoiceBox.getValue(),
                                            formattedValue);
            //Get all the items from the table as a list, then add the new Student to the list
            ArrayList<Student> al = mydbconnection.readQuery(newStudent);
            if (al.size() == 0) {
                mydbconnection.insertStudent(newStudent);
                mydbconnection.insertHours(newStudent);
            } else {
                mydbconnection.insertHours(newStudent);
                mydbconnection.updateStudent(newStudent);
            }

            tableView.getItems().add(newStudent);
            tableView.setItems(getStudents(null));
            studentNumberTextField.setText("");
            firstNameTextField.setText("");
            gradesChoiceBox.valueProperty().setValue(null);
            datePicker.setValue(null);
            hoursTextField.setText("");
            serviceAwardChoiceBox.valueProperty().setValue(null);
            buttonReset.setDisable(true);

        }

        /**
         * This method will search Student object and add it to the table
         */
        public void searchStudentButtonPushed() {

            Student student = null;
            if (!studentNumberTextField.getText().trim().equals(("")) || !firstNameTextField.getText().trim().equals((""))) {
                student = new Student(studentNumberTextField.getText(),
                        firstNameTextField.getText(),
                        null,
                        null,
                        null,
                        null);
            }
            //Get all the items from the table as a list, then add the new Student to the list
            tableView.setItems(getStudents(student));
            buttonReset.setDisable(false);
        }

        /**
         * Getter for all the students currently added to the Array List
         * @param passedStudent
         * @return
         */

        public ObservableList<Student> getStudents(Student passedStudent)  {
            ObservableList<Student> student = FXCollections.observableArrayList();
            ArrayList<Student> al = mydbconnection.readQuery(passedStudent);
            for (Student std : al) {
                student.add(new Student(std.getStudentNumber(),std.getFirstName(),std.getHours(),std.getGrade(),std.getServiceAward(), std.getHoursDate()));
            }
            return student;
        }

        /**
         * This method creates the generate report button and connects it to computer's documents file
         */
        public void generateReportButtonPushed() {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select PDF files");
            fileChooser.setInitialDirectory(new File("C:\\"));

            File selectedFiles = fileChooser.showSaveDialog(null);
            String filename = "";
            if (selectedFiles != null) {
                filename = selectedFiles.getAbsolutePath();
                System.out.println("The selected file is : " + filename);
            }
            try {
                mydbconnection.createCSVFile(null, filename);
                hostServices.showDocument(filename);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }






    }
