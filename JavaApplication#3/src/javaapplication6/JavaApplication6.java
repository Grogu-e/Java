/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import javax.swing.JOptionPane;
//import java.io.PrintWriter;
//import java.io.IOException;


/**
 *
 * @author butlera7742
 */
import java.util.Scanner;

public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //GPA studentGPA = new GPA();
        
       // studentGPA.getGrade();
        
       //double studentGrade = studentGPA.calculateGPA();
       Student stud = getstudentInfo();
       // printGPA(); 
        
       //System.out.println(stud.studentName);
       //System.out.println("Done");
       //System.out.println("Student semester GPA: ");
       //System.out.format("%.02f", studentGrade);
       Scanner keyboard = new Scanner(System.in);
       
       for (int i = 0; i < stud.numCourses; i++){
           System.out.println();
           stud.courses[i] = new Course();
                  
                  /*System.out.print("Enter the letter grade for course " + i+ " :");
                  stud.courses[i].grade = keyboard.nextLine();
                   System.out.print("Enter the credit unit hour for course" + i + " :");
                  stud.courses[i].credits = keyboard.nextInt();
                */
                  String grade =  JOptionPane.showInputDialog("Enter the letter grade");
                  String creditsStr = JOptionPane.showInputDialog("Enter number of credits");
                  int credits = Integer.parseInt(creditsStr);
                  stud.courses[i].grade = grade;
                  stud.courses[i].credits = credits;
                }
         //Dislpay object array of pass gpa
        
        Object [] gpaStud =
        {
        
            "*****************************",
            "Student Name: " +stud.studentName,
            "Semeter: " + stud.semester,
            "Number of Course: " + stud.numCourses,
            "Student's GPA: " + stud.gpa,
            "Courses" + stud.courses,
            "******************************"
        
        };
         JOptionPane.showMessageDialog(null, gpaStud,
               "GPA CALCULATOR",JOptionPane.INFORMATION_MESSAGE);
        
       }




   public static Student getstudentInfo(){
      
      // Asked the student info then put in a object.      
    //Scanner inputStudentName = new Scanner(System.in);
    //System.out.print("Enter student name: ");
    String studentName = JOptionPane.showInputDialog("Enter student name: ");

    //Scanner inputSemester = new Scanner(System.in);
    //System.out.print("Enter the semester: ");
    //inputSemester.nextLine();
    String semester = JOptionPane.showInputDialog("Enter the semester: ");

    //Scanner inputNumCourses = new Scanner(System.in);
    //System.out.print("Enter number of courses taken by student in " + semester + " :");
    //inputNumCourses.nextInt();  
    int numCourses = Integer.parseInt(JOptionPane.showInputDialog("Enter number of courses taken by student in " + semester + " :"));              
    System.out.println();
    
    Student stud = new Student();
    
    stud.studentName = studentName;
    
    stud.semester = semester;
    
    stud.numCourses = numCourses;
    
    stud.gpa = new GPA();
    
    stud.courses = new Course[numCourses];
    
    return stud;
        
}
//   public static void printGPA() throws IOExecption {
//       //Create the output file.
//            PrintWriter.outputFile = new PrintWriter(studentName+".txt");
//            //write file
//            outputFile.printIn(gpaStud);
//            //close the file
//            outputFile.close();
//        }
//   
   
    
}
class Student{
    // declare local variables tha t be accessed by the subclasses
    
    public String studentName,semester;
    public int numCourses;
    public Course[] courses;
    public GPA gpa;
    //create method to promp user to enter data
    //student object is modeling current semester
    
   Student(){
   
   }
}
class Course {
    public String grade;
    public int    credits;
       /*public String courseNameArray [] = new String [numCourses];
       public void getCourse(){
           for (int i = 0; i < numCourses;i++){
               Scanner inputCourseName = new Scanner(System.in);
               inputCourseName = new Scanner(System.in);
               System.out.print("Enter the course" + (i+1) +"name for " + studentName + " :"  );
               courseNameArray[i] = inputCourseName.nextLine();
           }
         }*/
       }
class Grade {
    /*
      public String courseGrade [] = new String[numCourses];
      public int courseCreditHours [] = new int [numCourses];
      
      void getGrade(){
          this.getCourse();
          
          Scanner inputCreditHours;
          try (Scanner inputGrade = new Scanner(System.in)) {
              inputCreditHours = new Scanner(System.in);
              //loop to promt user to enter grade and unit baded on
              for (int i = 0; i < numCourses; i++) {
                  System.out.println();
                  
                  System.out.print("Enter the letter grade for course " + this.courseNameArray[i]+ " :");
                  courseGrade[i] = inputGrade.nextLine();
                  
                  System.out.print("Enter the credit unit hour for course" + this.courseNameArray[i] + " :");
                  courseCreditHours[i] = inputCreditHours.nextInt();
              }
              //close the scanner objects
          }
    inputCreditHours.close();
      }
*/
  }
class GPA {
    double gpa,totalPoints, totalCreditHours;
    double[] gradePoints;
    /*
    int gradePoints[] = new int[numCourses];
    */
    
        public GPA() {
            totalPoints = 0;
            totalCreditHours = 0;
        }
        double calculateGPA(Student stud){
            gradePoints = new double[stud.numCourses];
            for(int i = 0; i < stud.numCourses; i++)
            {
                    //Switch block
                   switch(stud.courses[i].grade.toUpperCase()){
                        case "A":
                            gradePoints[i] = 4;
                            break;
                        case "B":
                            gradePoints[i] = 3;
                        case "C":
                            gradePoints[i] = 2;
                            break;
                        case "D":
                            gradePoints[i] = 1;
                            break;
                        default:
                            gradePoints[i] = 0;

                }
                   
                double thisCoursesPoints  = stud.courses[i].credits * gradePoints[i];
                totalPoints = thisCoursesPoints + totalPoints;
                totalCreditHours = stud.courses[i].credits + totalCreditHours;
                
            
            }
            gpa = totalPoints/totalCreditHours;
            return gpa;
        
        }
           
}
