import java.util.Scanner;

public class baseBallGameView {

    int userNumberScan() {
        Scanner sc = new Scanner(System.in);
        System.out.print(Utils.NUMBER_INSERT);
        int userNumber = Integer.parseInt(sc.nextLine());
        return userNumber;
    }

    boolean questionGameOver() {
        System.out.println(Utils.SUCCESS_NUMBER);
        System.out.println(Utils.REGAME_START);
        Scanner sc = new Scanner(System.in);
        int resetGame = Integer.parseInt(sc.nextLine());
        if (resetGame == 2) {
            System.out.println(Utils.GAME_OVER);
            return false;
        }
        if (resetGame != 1) {
            throw new IllegalArgumentException(Utils.MISSING_INSERT);
        }
        return true;
    }

    void judgeStrikeAndBall(int strike, int ball) {
        if (strike>0 && ball>0) {
            System.out.println(strike + Utils.STRIKE + ball + Utils.BALL);
        } else if (ball > 0) {
            System.out.println(ball + Utils.BALL);
        } else if (strike==0 && ball == 0) {
            System.out.println(Utils.NOTHING);
        } else {
            System.out.println(strike + Utils.STRIKE);
        }
    }
}
