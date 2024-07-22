package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static final String STUDENT_FILE_PATH = "C:\\SchoolData\\student_details.txt";
	private static final String TEACHER_FILE_PATH = "C:\\SchoolData\\teacher_details.txt";
      private static final String PASSWORD = "Praveen@23";
	private static  HashMap<Integer, Integer> studentDetails = new HashMap<>();
	 private static HashMap<String, String> teacherdetails= new HashMap<>();
	 public static void main(String[] args) {
		 // Scanner is used to get the input
	        Scanner scanner = new Scanner(System.in);
	       

	        // Password is used to access the database If wrong password entered more than 3 times access denied
	        String password;
	        int attempts = 0;	   
	        final int MAX_ATTEMPTS = 3;

	        do {
	            System.out.print("Enter the password: ");
	            password = scanner.nextLine();
	            attempts++;
	            if (!password.equals("Praveen@23") && attempts < MAX_ATTEMPTS) {
	                System.out.println("Incorrect password. Please try again.");
	            } else if (!password.equals("Praveen@23")) {
	                System.out.println("Access Denied.");
	                scanner.close(); // Close scanner before exiting
	                return; // Exit the program if max attempts reached
	            }
	        } while (!password.equals("Praveen@23") && attempts < MAX_ATTEMPTS);

	        if (password.equals("Praveen@23")) {
	            System.out.println("Access Granted.");

		}
//To select the option in the Database using  system menu
	 int choice;
     do {
         System.out.println("\nSchool Data Simple Query System Menu:");
         System.out.println("1. Add Student Details");
         System.out.println("2. Remove Student Details");
         System.out.println("3. Add Teacher Details");
         System.out.println("4. Remove Teacher Details");
         System.out.println("5. Query Data");
         System.out.println("6. Exit");
         System.out.println("\nSelect an option: ");
         choice = scanner.nextInt();
         scanner.nextLine(); 
         switch (choice) {
         case 1:
             addStudentDetails1(scanner);
             break;
         case 2:
             removeStudentDetails1(scanner);
             break;
         case 3:
             addTeacherDetails(scanner);
             break;
         case 4:
             removeTeacherDetails(scanner);
             break;
         case 5:
             queryData(scanner);
             break;
         case 6:
             System.out.println("Exiting...");
             break;
         default:
             System.out.println("Invalid option. Please try again.");
     }
 } while (choice != 6);
     scanner.close();
	    }
//Add student details in the student database
	  private static void addStudentDetails1(Scanner scanner) {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE_PATH, true))) {
	            System.out.println("Enter student's roll number: ");
	            int rollNumber = scanner.nextInt();
	            System.out.print("Enter student's marks: ");
	            int marks = scanner.nextInt();
	            writer.write(rollNumber + "," + marks + "\n");
	            studentDetails.put(rollNumber, marks);
	            System.out.println("Student details added successfully.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while adding student details.");
	            e.printStackTrace();
	        }
	    }
	  //Remove student details in the database
	  private static void removeStudentDetails1(Scanner scanner) {
	        System.out.println("Enter student's roll number to remove: ");
	        int rollNumber = scanner.nextInt();
	        if (studentDetails.containsKey(rollNumber)) {
	            studentDetails.remove(rollNumber);
	            updateStudentFile();
	            System.out.println("Student details removed successfully.");
	        } else {
	            System.out.println("Student with given roll number not found.");
	        }
	    }
	  //Add query data to the database
	private static void queryData(Scanner scanner) {
		System.out.println("Can you provide information about the admission process, tuition fees, and extracurricular activities offered at your school?");
		
	}
	//Remove teacher detail in the database
	private static void removeTeacherDetails(Scanner scanner) {
		System.out.println("Enter teacher name to remove:");
		String name = scanner.next();
		if (teacherdetails.containsKey(name)) {
			teacherdetails.remove(name);
			updateTeacherFile();
			System.out.println("teacher details removed successfully.");
		}else {
			System.out.println("Teacher given name is not found");
		}
	}
	//Add teacher details in the database
	private static void addTeacherDetails(Scanner scanner) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEACHER_FILE_PATH, true))) {
	            System.out.print("Enter teacher name: ");
	            String name = scanner.next();
	            System.out.print("Enter teacher subject: ");
	            String subject = scanner.next();
	            writer.write(name + "," + subject + "\n");
	            teacherdetails.put(name, subject);
	            System.out.println("Teacher details added successfully.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while adding teacher details.");
	            e.printStackTrace();
	        }
	    }
	// Is use to store data in text document of student details
	 private static void updateStudentFile() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE_PATH))) {
	            for (Map.Entry<Integer, Integer> entry : studentDetails.entrySet()) {
	                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while updating student details file.");
	            e.printStackTrace();
	        }
	    }
	 //Is use to store data in text document of teacher details
	 private static void updateTeacherFile() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEACHER_FILE_PATH))) {
	            for (Map.Entry<String, String> entry : teacherdetails.entrySet()) {
	                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while updating teacher details file.");
	            e.printStackTrace();
	        }
	    }
}

