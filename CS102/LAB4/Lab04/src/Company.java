import java.util.ArrayList;

public class Company implements Locatable {
    // properties
    private final int EMPLOYEE_CAPACITY = 15;
    private Employee[] employees;
    private ArrayList<Customer> customers;
    private int numOfEmployees;
    private int employeeNo;
    private int packageNo;
    private int posX;
    private int posY;

    // interface methods
    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }
    //methods
    public Company (int x, int y) {
        posX = x;
        posY = y;
        numOfEmployees = 0;
        packageNo = 0;
        numOfEmployees = 0;
        employeeNo = 0;
        employees = new Employee[EMPLOYEE_CAPACITY];
        customers = new ArrayList<Customer>();
    }
    public boolean addEmployee (Employee candidate) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = candidate;
                numOfEmployees ++;
                employeeNo++;
                return true;
            }
        }
        return false;
    }
    public void addCustomer (Customer customer) {
        customers.add(customer);
    }
    public boolean terminateContract(int employeeIndex) {
        // checks whether there is employee at given the index
        if (employees[employeeIndex] != null) {
            // deletes the employee
            employees[employeeIndex] = null;
            numOfEmployees--;
            return true;
        }
        // if there is no employee given at the index
        return false;
    }
    public boolean createDeliverable (Item sendItem, Customer sender, Customer receiver) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getAvailability()) {
                    employees[i].addJob(sendItem, sender, receiver, packageNo++ );
                    return true;
                }
            }

        }
        // employees are not available
        System.out.println("All employees are busy!");
        return false;

    }
    public void deliverPackages(){
        // delivers and prints
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].deliverPackages();
            }
        }
    }
    public String toString () {
        String employeeInfo = "";
        for (int i = 0; i < EMPLOYEE_CAPACITY; i++) {
            if (employees[i] != null) {
                employeeInfo = employeeInfo + employees[i];
            }
        }
        return "Employee Capacity: " + EMPLOYEE_CAPACITY + "\n" + employeeInfo +
                "\nNumber Of Employee: " + numOfEmployees +
                "\nEmployee No: " + employeeNo +
                "\nTotal package No: " + packageNo +
                "\nPos X: " + posX +
                "\nPos Y: " + posY;

    }
}
