package sample;

import java.io.FileWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBConnection {

    private Connection conn;
    private Statement stmt;

    public DBConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\nikit\\FBLA_Community_Service_Hours_Tracker_DB.mdb");
            stmt = conn.createStatement();
            conn.setAutoCommit(true);
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public ArrayList<Student> readQuery(Student student) {

        ResultSet rest;
        ArrayList<Student> stdArray = new ArrayList<Student>();
        String query = "";
        try {
            if (student == null) {
                query = "SELECT st.number," +
                        "st.name, ht.grade, MAX(ht.hoursdate), SUM(ht.hours), st.ServiceAward FROM STUDENT_INFO st inner join hours_tracker ht on " +
                        "st.number = ht.number group by st.number, st.name, ht.grade,  st.ServiceAward";

                //search query
            } else {
                String whereClauseNumber = "";
                String whereClauseName = "";
                String whereClause = "";
                if (!(student.getStudentNumber() == null || student.getStudentNumber().trim().isEmpty())) {
                    whereClauseNumber = "st.Number = '"+student.getStudentNumber()+"'";
                    whereClause = "where  " +  whereClauseNumber;
                }
                if (!(student.getFirstName() == null || student.getFirstName().trim().isEmpty())) {
                    whereClauseName = "st.name = '"+student.getFirstName()+"'";
                    whereClause = "where  " + whereClauseName;
                }

                if ((!whereClauseNumber.isBlank() && !whereClauseName.isBlank())) {
                    whereClause = "where  " + whereClauseNumber + " and " + whereClauseName;
                }
                query = "SELECT st.number," +
                        "st.name, ht.grade, ht.hoursdate, ht.hours, st.ServiceAward FROM STUDENT_INFO st " +
                        "inner join hours_tracker ht on st.number = ht.number " + whereClause;
            }
            System.out.println("The read query called is : "  + query);
            rest = stmt.executeQuery(query);
            while(rest.next()) {
                Student std = new Student(rest.getString(1),
                        rest.getString(2),
                        rest.getString(5),
                        rest.getString(3),
                        rest.getString(6),
                        rest.getString(4));
                stdArray.add(std);
            }

        }
        catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        return stdArray;
    }

    public void insertStudent(Student student) {
        try
        {
            String queryStudent = "INSERT INTO Student_Info(Number, Name, ServiceAward) VALUES('"+student.getStudentNumber()+"' , " +
                    "'"+student.getFirstName()+"' , '"+student.getServiceAward()+"')";

            stmt = conn.createStatement();
            stmt.executeUpdate(queryStudent);

            System.out.println("successful");
        }
        catch(Exception e)
        {
            System.out.println("Not connected"+e);
        }

    }
    public void insertHours(Student student) {
        try
        {
            DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");

            String queryHours = "INSERT INTO Hours_Tracker(Number, Grade, HoursDate, Hours) VALUES('"+
                    student.getStudentNumber()+"' , '"+student.getGrade()+"' , #"
                    +student.getHoursDate()+"# , '"+student.getHours()+"')";
            System.out.println("The insert hour query is : " + queryHours);
            stmt = conn.createStatement();
            stmt.executeUpdate(queryHours);

            System.out.println("successful");
        }
        catch(Exception e)
        {
            System.out.println("Not connected"+e);
        }

    }
    public void deleteQuery(Student student) {
        try
        {
            String query = "DELETE * FROM Hours_Tracker WHERE Number = '"+student.getStudentNumber()+"' and Grade= '"+
                    student.getGrade()+"' and Hours= '"+student.getHours()+"' and HoursDate= '"+student.getHoursDate()+"'";
            System.out.println("The delete query : " + query);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);

            System.out.println("successful");
        }
        catch(Exception e)
        {
            System.out.println("Not connected"+e);
        }

    }



    public void updateStudent(Student student) {
        try
        {
            String query = "UPDATE Student_Info SET Name= '"+student.getFirstName()+"' , ServiceAward='"+student.getServiceAward()+
                    "' WHERE Number = '"+student.getStudentNumber()+"'";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();

            System.out.println("successful");
        }
        catch(Exception e)
        {
            System.out.println("Not connected"+e);
        }

    }

    public void updateHours(Student student) {
        try
        {
            String query = "UPDATE Hours_Tracker SET Grade= '"+student.getGrade()+"' , hours='"+student.getHours()+
                    "' , hoursdate='"+ student.getHoursDate() +
                     "' WHERE Number = '"+student.getStudentNumber()+"'";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();

            System.out.println("successful");
        }
        catch(Exception e)
        {
            System.out.println("Not connected"+e);
        }

    }

    public void closeConnection() {
        try {
            stmt.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void createCSVFile(Student student,
                              String filename) throws SQLException, Exception
// Create a statement
    {
        ResultSet rest;
        ArrayList<Student> stdArray = new ArrayList<Student>();
        String query = "";
        try {
            if (student == null) {
                query = "SELECT st.number," +
                        "st.name, ht.grade, format(ht.hoursdate,\"mmm yyyy\") as HoursDate, SUM(ht.hours) as Hours, st.ServiceAward FROM STUDENT_INFO st inner join hours_tracker ht on " +
                        "st.number = ht.number group by st.number, st.name, ht.grade,  st.ServiceAward, format(ht.hoursdate,\"mmm yyyy\")";

                //search query
            } else {
                String whereClauseNumber = "";
                String whereClauseName = "";
                String whereClause = "";
                if (!(student.getStudentNumber() == null || student.getStudentNumber().trim().isEmpty())) {
                    whereClauseNumber = "st.Number = '"+student.getStudentNumber()+"'";
                    whereClause = "where  " +  whereClauseNumber;
                }
                if (!(student.getFirstName() == null || student.getFirstName().trim().isEmpty())) {
                    whereClauseName = "st.name = '"+student.getFirstName()+"'";
                    whereClause = "where  " + whereClauseName;
                }

                if ((!whereClauseNumber.isBlank() && !whereClauseName.isBlank())) {
                    whereClause = "where  " + whereClauseNumber + " and " + whereClauseName;
                }
                query = "SELECT st.number," +
                        "st.name, ht.grade, ht.hoursdate, ht.hours, st.ServiceAward FROM STUDENT_INFO st " +
                        "inner join hours_tracker ht on st.number = ht.number " + whereClause;
            }
            System.out.println("The read query called is : "  + query);
            rest = stmt.executeQuery(query);
            FileWriter fw = new FileWriter(filename);
            //String record = null;
            boolean empty = true;
            try {
                ResultSetMetaData metaData = rest.getMetaData();
                int columns = metaData.getColumnCount();
                System.out.println("Entering to write");
                for (int j=1; j<= columns; j++) {
                    fw.append(rest.getMetaData().getColumnName(j));
                    fw.append(',');
                }
                fw.append('\n');
                while (rest.next()) {
                    empty = false;
                    for (int i = 1; i <= columns; i++) {
                        //record = rest.getString(i);
                        fw.append(rest.getString(i));
                        fw.append(',');
                        System.out.println("Writing : " + rest.getString(i));
                    }
                    fw.append('\n');

                }
            } finally {
                fw.flush();
                fw.close();
                rest.close();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Not connected"+e);
        }

    }
}

