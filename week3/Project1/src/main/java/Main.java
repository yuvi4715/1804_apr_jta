import model.Employee;
import model.Requests;
import service.ERSService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by bryanvillegas on 4/18/18.
 */
public class Main{

    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        int choice = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Employee Login");
            System.out.println("2. Manager Login");
            System.out.println("5. Quit");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                menu();
            }
            switch (choice) {

                case 1:
                    empLogin();
                    break;
                case 2:
                    managerLogin();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    //Employee can login
    public static void empLogin(){
        String username,password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email.");
        username = sc.next();
        System.out.println("Enter your password");
        password = sc.next();

        Employee emp = ERSService.getEmp(username, password);

        if(emp == null){
            System.out.println("Could not find user.");
            menu();
        }
        int choice;

        while(true) {
            System.out.println("Welcome, " + emp.getUsername() + ".");
            System.out.println("\n1. Submit a reimbursement request.");
            System.out.println("2. View pending reimbursement requests.");
            System.out.println("3. View approved reimbursement requests.");
            System.out.println("4. View your information");
            System.out.println("5. Update your information");
            System.out.println("6. Logout");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    submitReimburst(emp);
                    break;
                case 2:
                    viewRequestPending(emp);
                    break;
                case 3:
                    viewRequestApproved(emp);
                    break;
                case 4:
                    viewEmpInfo(emp);
                    break;
                case 5:
                    updateEmpInfo(emp);
                    break;
                case 6:
                    System.out.println("Logged out.");
                    menu();

            }
        }

    }

    //Employee can see their info
    public static void viewEmpInfo(Employee emp){
        System.out.println(emp.getFirstName() + emp.getLastName() + emp.getEmpID());
    }

    //Employee can view all their pending requests
    public static void  viewRequestPending(Employee emp){
        List<Requests> requests = ERSService.getAllRequests(emp.getEmpID());
        if(requests == null){
            System.out.println("Could not get your requests.");

        }
        else {
            System.out.println("\nRequest ID             Amount      Purpose");
            System.out.println("--------------------------------------------");
            for (Requests req : requests) {
                if(req.isApproved() == false){
                    System.out.printf("%d%-20s%.2f", req.getRequestID(), " ", req.getAmount());
                    System.out.print("     " + req.getPurpose() + "\n\n");
                }
            }
        }

    }

    //Employee can submit a request
    public static void submitReimburst(Employee emp){
        double amount;
        String purpose;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the purpose of this request");
        purpose = sc.nextLine();
        System.out.println("Enter the request amount");
        amount = sc.nextDouble();
        if(ERSService.insertRequest(emp.getEmpID(), amount, purpose)){
            System.out.println("Request was successful");
        }
        else
            System.out.println("Request was not submitted");

    }
    //Employee can view all their approved requests
    public static void viewRequestApproved(Employee emp){
        List<Requests> requests = ERSService.getAllRequests(emp.getEmpID());
        if(requests == null){
            System.out.println("Could not get your requests.");

        }
        else {
            System.out.println("\nRequest ID             Amount      Purpose");
            System.out.println("--------------------------------------------");
            for (Requests req : requests) {
                if(req.isApproved() == true){
                    System.out.printf("%d%-20s%.2f", req.getRequestID(), " ", req.getAmount());
                    System.out.print("     " + req.getPurpose() + "\n\n");
                }
            }
        }
    }
    //Manager can approve/deny any pending request
    public static void updateRequest(Employee man){

        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the request you want to approve.");
        id = sc.nextInt();
        List<Employee> emps = ERSService.getAllEmps();
        Employee emp = new Employee();
        if(emps == null){
            System.out.println("Could not get users.");

        }
        {
            for (Employee e : emps) {
                if (e.getEmpID() == id) {
                    emp = e;
                }
            }
            if(emp == null){
                System.out.println("Could not find user.");
            }
            else{
                if(ERSService.updateRequests(emp.getEmpID(),man.getEmpID()))
                    System.out.println("Request has been approved.");
                else
                    System.out.println("Request was not approved.");
            }
        }

    }
    //Manager can see all Employees
    public static void viewAllEmp(){
        List<Employee> emps = ERSService.getAllEmps();
        if(emps == null){
            //Log.debug("Could not get users.");
        }
        else {
            System.out.println("\nEmployee ID   Username    Name");
            System.out.println("-----------------------------------");
            for (Employee e : emps) {
                System.out.println(e.getEmpID() + "          " + e.getUsername() + "        " + e.getFirstName() + "  " + e.getLastName());
            }
        }
    }

    //Manager login CHANGE THIS - USE GET MANAGER
    public static void managerLogin(){
        String username,password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Username");
        username = sc.next();
        System.out.println("Enter a Password");
        password = sc.next();

        //Use getManager
        Employee manager = ERSService.getEmp(username, password);
        if(manager == null){
            //Log.error("Could not find admin user.");
            menu();
        }

        int choice;

        while(true) {
            System.out.println("\nWelcome, " + manager.getUsername() + ".");
            System.out.println("\n1. View pending reimbursement requests.");
            System.out.println("2. View approved reimbursement requests.");
            System.out.println("3. Approve/Deny reimbursement request.");
            System.out.println("4. View all employees");
            System.out.println("5. View all reimbursement requests from an employee.");
            System.out.println("6. Logout");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewAllReimburstPending();
                    break;
                case 2:
                    viewAllReimburstApproved();
                    break;
                case 3:
                    updateRequest(manager);
                    break;
                case 4:
                    viewAllEmp();
                    break;
                case 5:
                    viewSingleEmpReq();
                    break;
                case 6:
                    System.out.println("Logged out.");
                    menu();
                    break;
            }
        }
    }

    //Manager can view all pending requests
    public static void  viewAllReimburstPending(){
        List<Requests> requests = ERSService.getAllEmpRequests();
        if(requests == null){
            System.out.println("Could not get any requests.");

        }
        else {
            System.out.println("\nRequest ID             Amount      Purpose");
            System.out.println("--------------------------------------------");
            for (Requests req : requests) {
                if(req.isApproved() == false){
                    System.out.printf("%d%-20s%.2f", req.getRequestID(), " ", req.getAmount());
                    System.out.print("     " + req.getPurpose() + "\n\n");
                }
            }
        }
    }
    //Manager can view all approved requests
    public static void viewAllReimburstApproved(){
        List<Requests> requests = ERSService.getAllEmpRequests();
        if(requests == null){
            System.out.println("Could not get any requests.");

        }
        else {
            System.out.println("\nRequest ID             Amount      Purpose");
            System.out.println("--------------------------------------------");
            for (Requests req : requests) {
                if(req.isApproved() == true){
                    System.out.printf("%d%-20s%.2f", req.getRequestID(), " ", req.getAmount());
                    System.out.print("     " + req.getPurpose() + "\n\n");
                }
            }
        }
    }
    //Employee can update employees info
    public static void updateEmpInfo(Employee emp){

    }
    //Manager can view all requests from a single employee
    public static void viewSingleEmpReq(){}

}
