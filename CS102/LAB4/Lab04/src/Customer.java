public class Customer extends Person {
    // variables
    private Item currentItem;
    // constructor
    public Customer(String name) {
        super(name);
    }
    // methods
    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    public Item getCurrentItem() {
        return currentItem;
    }
    public boolean sendItem(Company company, Item item, Customer receiver) {
        if (currentItem != null) {
            // HAS ITEM Ignore
            System.out.println("Customer has already a delivery!");
            return false;
        }

        if (company.createDeliverable(item , this,receiver)) {
                setCurrentItem(item);
                company.addCustomer(this);
            return true;
            }
            return false;
        }



    public String toString() {
        return super.toString() + "\n Item: \n" + currentItem +
                "\n------------------------------------------------------\n";
    }
}
