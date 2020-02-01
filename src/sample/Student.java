package sample;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Student {

    private SimpleStringProperty studentNumber, firstName, hours, grade, serviceAward, hoursDate;

    public Student() {

    }

    /**
     * This is a constructor
     * @param studentNumber
     * @param firstName
     * @param hours
     * @param grade
     * @param serviceAward
     * @param hoursDate
     */
    public Student(String studentNumber, String firstName, String hours, String grade, String serviceAward, String hoursDate) {
        this.studentNumber = new SimpleStringProperty(studentNumber);
        this.firstName = new SimpleStringProperty(firstName);
        this.hours = new SimpleStringProperty(hours);
        this.grade = new SimpleStringProperty(grade);
        this.serviceAward = new SimpleStringProperty(serviceAward);
        this.hoursDate = new SimpleStringProperty(hoursDate);
    }

    /**
     * Getter for student number
     * @return
     */
    public String getStudentNumber() {
        return studentNumber.get();
    }

    /**
     * Setter for student name
     * @param studentNumber
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }

    /**
     * Getter for student name
     * @return
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * Setter for student name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    /**
     * Getter for number of community service hours
     * @return
     */
    public String getHours() {
        return hours.get();
    }

    /**
     * Setter for number of community service hours
     * @param hours
     */
    public void setHours(String hours) {
        this.hours.set(hours);
    }

    /**
     * Getter for student grade
     * @return
     */
    public String getGrade() {
        return grade.get();
    }

    /**
     * Setter for student grade
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    /**
     * Getter for service award
     * @return
     */
    public String getServiceAward() {
        return serviceAward.get();
    }

    /**
     * Setter for service award
     * @param serviceAward
     */
    public void setServiceAward(String serviceAward) {
        this.serviceAward.set(serviceAward);
    }

    /**
     * Getter for date when hours were completed
     * @return
     */
    public String getHoursDate() {
        return hoursDate.get();
    }

    /**
     * Setter for date when hours were completed
     * @param hoursDate
     */
    public void setHoursDate(String hoursDate) {
        this.hoursDate.set(hoursDate);
    }
}
