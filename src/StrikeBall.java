public class StrikeBall {

    private int strike;
    private int ball;
    private int[] strikeBall;

    public StrikeBall() {
        this.strikeBall = new int[2];
    }

    public int[] getStrikeBall() {
        return strikeBall;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }
}
