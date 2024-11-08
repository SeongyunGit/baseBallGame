import java.util.Random;

public class BaseballRandomNumber {

    private int baseballNumber;
    Random random = new Random();

    public BaseballRandomNumber() {
        this.baseballNumber = random.nextInt(899)+100;
    }

    public int getBaseballNumber() {
        return baseballNumber;
    }
}
