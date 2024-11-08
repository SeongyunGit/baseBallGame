public class UserNumberList {
    private int[] userNumberList;
    private final int number = 3;

    UserNumberList() {
        this.userNumberList = new int[number];
    }

    public int[] getUserNumberList() {
        return userNumberList;
    }
}
