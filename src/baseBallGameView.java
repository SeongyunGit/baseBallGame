import java.util.Scanner;

public class baseBallGameView {

    static int userNumberScan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int userNumber = Integer.parseInt(sc.nextLine());
        return userNumber;
    }

    static int questionGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int resetGame = Integer.parseInt(sc.nextLine());
        return resetGame;
    }
    static void judgeStrikeAndBall(int strike, int ball) {
        if (strike>0 && ball>0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike==0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(strike + "스트라이크");
        }
    }
}
