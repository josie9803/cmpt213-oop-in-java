package DataClass;
/**
* Represent a door's weight and state (open/closed)
*/
public class Door {
    public static final int MAX_WEIGHT_PER_HINGE_IN_G = 3000;
    private boolean isOpen;
    private int weightInG;

    //Command + N

    public Door(boolean isOpen, int weightInG) {
        this.isOpen = isOpen;
        this.weightInG = weightInG;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getWeightInG() {
        return weightInG;
    }

    public void setWeightInG(int weightInG) {
        this.weightInG = weightInG;
    }

    public int getMinNumHinges(){
        return (int) Math.ceil(
                (double)weightInG / MAX_WEIGHT_PER_HINGE_IN_G
                );
    }
    
    @Override
    public String toString() {
        return "Door{" +
                "isOpen=" + isOpen +
                ", weightInG=" + weightInG +
                '}';
    }
}
