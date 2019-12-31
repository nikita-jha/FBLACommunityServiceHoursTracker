package sample;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Student {

    private SimpleStringProperty studentNumber, firstName, hours, grade, serviceAward, hoursDate;

    public Student() {

    }
    public Student(String studentNumber, String firstName, String hours, String grade, String serviceAward, String hoursDate) {
        this.studentNumber = new SimpleStringProperty(studentNumber);
        this.firstName = new SimpleStringProperty(firstName);
        this.hours = new SimpleStringProperty(hours);
        this.grade = new SimpleStringProperty(grade);
        this.serviceAward = new SimpleStringProperty(serviceAward);
        this.hoursDate = new SimpleStringProperty(hoursDate);
    }

    public String getStudentNumber() {
        return studentNumber.get();
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getHours() {
        return hours.get();
    }

    public void setHours(String hours) {
        this.hours.set(hours);
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getServiceAward() {
        return serviceAward.get();
    }

    public void setServiceAward(String serviceAward) {
        this.serviceAward.set(serviceAward);
    }

    public String getHoursDate() {
        return hoursDate.get();
    }

    public void setHoursDate(String hoursDate) {
        this.hoursDate.set(hoursDate);
    }
}
