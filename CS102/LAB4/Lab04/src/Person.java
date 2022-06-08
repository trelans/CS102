public class Person implements Locatable {
    // variables
    String name;
    int posX;
    int posY;
    // constructors
    public Person (String name , int x , int y) {
        this.name = name;
        posX = x;
        posY = y;
    }
    public Person (String name) {
        this.name = name;
        posX = 0;
        posY = 0;
    }
    //methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

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
    public String toString() {
        return "\n------------------------------------------------------"
                + "\n Name: " + name ;
    }
}
