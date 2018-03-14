package src;

public class GameConfig {
    private String type;
    private int noOfInputs;

    public GameConfig(String type, int noOfInputs) {
        this.type = type;
        this.noOfInputs = noOfInputs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfInputs() {
        return noOfInputs;
    }

    public void setNoOfInputs(int noOfInputs) {
        this.noOfInputs = noOfInputs;
    }
}
