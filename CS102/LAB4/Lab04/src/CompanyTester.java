/**
 * __Lab04___
 * @author __Kutay Senyigit___
 * @version __9 MARCH 2021__
 */
public class CompanyTester {
    public static void main(String[] args) {
        // creating company
        Company shippingService = new Company(1,2);
        // creating items
        Item item1 = new Item(2,"book");
        Item item2 = new Item(1,"book2");
        // creating customers
        Customer Adam = new Customer("Adam" );
        Customer Sue = new Customer("Sue" );
        Customer Ahmet = new Customer("Ahmet" );
        Customer Ayse = new Customer("Ayse" );
        Customer Ali = new Customer("Ali" );
        Customer Sude = new Customer("Sude" );
        Customer Sude2 = new Customer("Sude" );
        Customer Sude3 = new Customer("Sude" );
        Customer Sude4 = new Customer("Sude" );
        Customer Sude5 = new Customer("Sude" );
        Customer Sude6 = new Customer("Sude" );
        // creating employees
        Employee george = new Employee(1,"George");
        Employee melissa = new Employee(1,"Melissa");
        // hiring employees to the company
        shippingService.addEmployee(george);
        shippingService.addEmployee(melissa);

        Adam.sendItem(shippingService,item1,Sue);
        Sue.sendItem(shippingService,item2,Adam);
        Ahmet.sendItem(shippingService,item1,Adam);
        Ahmet.sendItem(shippingService,item1,Adam); // same customer tries to send item 2 times

        Ayse.sendItem(shippingService,item1,Adam);
        Ali.sendItem(shippingService,item1,Adam);
        Sude.sendItem(shippingService,item1,Adam);
        Sude2.sendItem(shippingService,item1,Adam);
        Sude3.sendItem(shippingService,item1,Adam);
        Sude4.sendItem(shippingService,item1,Adam);
        Sude5.sendItem(shippingService,item1,Adam);
        Sude6.sendItem(shippingService,item1,Adam);

        // delivers
        shippingService.deliverPackages();
        // prints company
        System.out.println(shippingService);









    }
}
