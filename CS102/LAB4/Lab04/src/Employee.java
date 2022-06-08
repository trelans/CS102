public class Employee extends Person {
    //constants
    private final int MAX_JOBS = 5;
    // variables
    private int currentJobs; // Initialized as 0
    private Delivery[] deliveries; // The undelivered packages, mails are held here
    private double salary;
    private int employeeNo;
    private boolean available;

    //methods
    public Employee(int employeeNo , String name) {
        super(name);
        this.employeeNo = employeeNo;
        salary = 0;
        currentJobs = 0;
        available = true;
        deliveries = new Delivery[MAX_JOBS];
    }
    public void adjustSalary(double value) {
        salary = value;
    }
    public boolean getAvailability() {
        if (currentJobs < MAX_JOBS) {
            available = true;
            return true;
        }
        available = false;
        return false;
    }
    public void addJob (Item sendItem, Customer sender, Customer receiver, int packageNo ) {
        if (sendItem.getWeight() <= 0.1 ) {
            currentJobs++;
            //mail
            Mail mail = new Mail(sendItem.getContent(), sender, receiver, packageNo);
            deliveries[currentJobs - 1] = mail;
        }
        else if (sendItem.getWeight() >= 0.1) {
            currentJobs++;
            //package
            Package packageI = new Package(sendItem , sender, receiver, packageNo);
            deliveries[currentJobs - 1] = packageI;
        }
    }
    public void deliverPackages() {
        // prints the deliveries
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] != null) {
                System.out.println(deliveries[i]);
            }
        }

        // clears the deliveries
        for (int i = 0; i < deliveries.length; i++) {
            deliveries[i] = null;
        }
    }
    public String toString() {
        String deliveriesString =  "";
        for (Delivery a : deliveries) {
            if (a != null) {
                deliveriesString = deliveriesString + a;
            }
        }
        return super.toString() + "\nCurrent Jobs: " + currentJobs + "\nDeliveries: \n" + deliveriesString + "\nSalary: " + salary + "\nEmployee no: " + employeeNo + "\nAvailable: " + available
                +
                "\n------------------------------------------------------\n";
    }
 }
