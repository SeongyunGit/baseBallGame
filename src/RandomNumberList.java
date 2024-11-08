public class RandomNumberList {

    private int[] randomNumberList;
    private final int number = 3;

    RandomNumberList() {
        this.randomNumberList = new int[number];
    }

    public int[] getRandomNumberList() {
        return randomNumberList;
    }
}
