public class Mail extends Delivery {
    // properties
    private String content;
    // constructor
    public Mail(String content, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        this.content = content;
    }
    // methods
    @Override
    double getWeight() {
        return 0.1;
    }
    public String toString() {
        return "Sender: " + sender + "\n Receiver: " + receiver + "\n Content: " + content + "\n PackageNo: " + packageNo;
    }
}

