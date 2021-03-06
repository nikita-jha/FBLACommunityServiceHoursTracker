# FBLACommunityServiceHoursTracker
School Name: Northview High School

Name: Nikita Jha

Language: Java

JavaFX Dependencies: Java 12 & above, JavaFX, MSAccess (as Database), and Excel (for CSV)

Application Username: Northview

Application Password: titans

Build and Run Instructions:

*You can either run by downloading the executable or building and running from Intellij. Directions for both are listed below but you only have to do one in order to run the app. 

--Executable Download Instructions: 

    1) Download project from github URL (green CLONE/DOWNLOAD button on top right side of page)
    
    2) Navigate to Executable directory located in FBLACommunityServiceHoursTracker folder.
        
    3) Make sure you have Java 13 installed. The executable will not run with any lower Java version. The link can be found at:                
        https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html
    
    4) Java should be setup on System classpath to run with Java 13 (You can check the Java version by typing "java -version" on Windows console/cmd).
    
    5) Double click on  Executable/FBLACommunityServiceHours.bat
    
    6) The application will launch with a login screen.
    
--Project Build/Run Instructions For Intellij:

    1). Download project from github URL (green CLONE/DOWNLOAD button on top right side of page)

    2). Project is set up for IntelliJ IDE (.idea included). Open project in IntelliJ or Eclpise

    3). Ensure dependencies from libraries are fully resolved. Open Module Settings and import the libraries to run JavaFX projects.

    4). The Application uses MSAccess DB. https://sourceforge.net/projects/ucanaccess/files/. You have to download UCanAccess                   distribution and add the following JAR files to the classpath (In Intellij add these libraries as external dependencies):               ucanaccess-4.0.4.jar hsqldb-2.3.1.jar jackcess-2.1.11.jar commons-lang-2.6.jar commons-logging-1.1.3.jar The MSAaccess DB file           (FBLAAdvisorContact1.accdb) is included in the project under Database. Go to DBConnection.java and correct the file name where           this file is copied.)

    5). Compile and build the project. Ensure no error remains.

    6). Look for Main.java file and run (In Intellij, right click and select Run Main.java.

    5). A JavaFX standalone application Login page will open. Follow Application Instructions from here.


Application Instruction:

1). Type username and password to enter program.

        Application Username: Northview
        Application Password: titans

2). The new screen will have student entry fields and a grid where you can view all the students. Most of the information on the screen is intuitive. The grid has multiple columns to store all of a student's information including the student's name, grade, and number.

3). You can perform the following operations:

    a). Add Student - Enter all of a student's information into the entry fields and press "Add Student" to populate the database and   
        grid with the student.
    
    b). Edit Student - You  can edit a student's information by double clicking the name, grade, hours, or service award cell on the
        grid and then pressing enter. You cannot edit the student's number because this is the primary ID. 
    
    c). Add Community Service Hours - You can add community service hours by first double clicking on the student's number. Next, enter 
        the number of hours to add along with the date these hour(s) were completed on into the entry fields. Next, press "Add Hours."   
        Lastly, press "Reset" to bring the screen back to the original.  

    d). Search Student - You can search a student by entering the student ID & student name and then click search. This will allow you   
        to see all of the entries for that student. Lastly, press "Reset" to bring the screen back to the original. 

    e). Export Monthly Report - Any information that is visible in the Grid can also be exported as a monthly report. You can export a   
        monthly report by pressing "Generate Report". Choose the location where you want to save the document in your folder. MAKE SURE 
        TO ADD ".csv" TO THE END OF THE FILE WHEN SAVING. 
  
  Copyright Information: 

All images used are from these source(s):

     -Google images using the "Labeled for Reuse" Filter

The application is in compliance with all copyright laws, both federal and state. 

