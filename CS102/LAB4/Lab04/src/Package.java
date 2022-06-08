public class Package extends Delivery {
    // properties
    private Item packedItem;
    // constructor
    public Package(Item content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        packedItem = content;
    }
    // methods
    @Override
    double getWeight() {
        return packedItem.getWeight();
    }

    public String toString() {
        return "Item content: " + packedItem + "\nSender: " + sender + " \nReceiver: " + receiver + "\nPackage No: " + packageNo;
    }
}
