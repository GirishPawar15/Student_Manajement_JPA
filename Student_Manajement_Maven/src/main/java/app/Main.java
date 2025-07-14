package app;

import entity.StudentEntity;
import service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
        	 System.out.println("\n--- Student Management System Menu ---");
             System.out.println("1. Add Student ");
             System.out.println("2. Update Student");
             System.out.println("3. Delete Student");
             System.out.println("4. Show All Students");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");
            
             int choice = sc.nextInt();
             sc.nextLine();

            switch (choice) {
                case 1: // Add New Employee
                	System.out.print("Enter Roll Number: ");
                    int roNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.nextLine();

                    System.out.print("Enter E-Mail Address: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Standard: ");
                    String std = sc.nextLine();

                    System.out.print("Enter Previous Year Marks: ");
                    double marks = sc.nextDouble();

                    
                    service.addStudent( roNo, name, address, mobile, email, std, marks);
                    break;

                case 2: // Update Employee
                    System.out.print("Enter Roll Number to update: ");
                    int updateRoNo;
                    try {
                        updateRoNo = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Roll Number Not Found .");
                        break;
                    }
                    System.out.print("Enter New  Name: ");
                    String newname = sc.nextLine();
                    
                    System.out.print("Enter New address: ");
                    String newaddress = sc.nextLine();
                    
                    System.out.print("Enter New Mobile Number: ");
                    String newmobile = sc.nextLine();
                    
                    System.out.print("Enter New E-Mail Address: ");
                    String newemail = sc.nextLine();

                    System.out.print("Enter New Standard: ");
                    String newstd = sc.nextLine();

                    System.out.print("Enter Previous Year Marks: ");
                    double newmarks = sc.nextDouble();
                   
                    service.updateStudent(updateRoNo, newname, newaddress, newmobile, newemail, newstd, newmarks);
                    break;

                case 3: // Delete Employee
                    System.out.print("Enter Roll Number to delete: ");
                    int deleteRo_No;
                    try {
                        deleteRo_No = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Roll Number not found.");
                        break;
                    }
                    service.deleteStudent(deleteRo_No);
                    break;


                case 4: // View All Employees
                    List<StudentEntity> stud = service.showAllStudents();
                    if (stud.isEmpty()) {
                        System.out.println("Student data not found.");
                    } else {
                        System.out.println("\nAll Students:");
                        for (StudentEntity e : stud) {
                            System.out.println("Roll number: " + e.getro_No() + ", Name: " + e.getname() + " ,address: " +e.getaddress() +" ,mobile"+ 
                                              e.getmobile() + ", Email: " + e.getemail() + ",standard : " +e.getstd() + " ,Marks : " + e.getmarks());
                        }
                    }
                    break;

                case 5: // Exit
                    running = false;
                    service.shutdown();
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice!! Please enter a correct Choice.");
            }
        }
        sc.close();
    }
}