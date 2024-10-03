import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class baseBall {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int randomNumber = randomNumberPick();
            int[] randomArr = new int[3];
            randomNumberList(randomArr,randomNumber);

            while (true) {
                int userNumber = userNumberScan();

                int[] userArr = new int[3];
                userNumberList(userNumber,userArr);

                List<Integer> strikeBall = strikeAndBall(userArr,randomArr);
                int strike = strikeBall.get(0);
                int ball = strikeBall.get(1);

                if (strike==0) {
                    ball = findBall(userArr,randomArr,ball);
                }
                if (strike == 3) {
                    break;
                }
                judgeStrikeAndBall(strike,ball);
            }
            int resetGame = questionGameOver();
            if (resetGame==2) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
                break;
            } else if (resetGame!=1) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 게임 종료합니다.");
            }
        }
    }
    private static int randomNumberPick() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int randomNumber = random.nextInt(899)+100;
        System.out.println(randomNumber);
        while (true) {
            int hundred = randomNumber/100;
            int ten = (randomNumber/10)%10;
            int one = randomNumber%10;

            if (hundred != ten && ten != one && hundred != one) {
                break;
            }
        }
        return randomNumber;
    }

    private static void randomNumberList(int[] randomArr,int randomNumber) {
        int number = 100;
        for (int j = 0; j < 3; j++) {
            randomArr[j] = randomNumber / number;
            int minus = number * randomArr[j];
            randomNumber -= minus;
            number /= 10;
        }
    }
    private static int userNumberScan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int userNumber = Integer.parseInt(sc.nextLine());
        return userNumber;
    }
    private static void userNumberList(int userNumber,int[] userArr) {
        int userNumberset = 100;
        for (int i = 0; i < 3; i++) {
            userArr[i] = userNumber / userNumberset;
            int minus = userNumberset * userArr[i];
            userNumber -= minus;
            userNumberset /= 10;
        }
    }
    private static List<Integer> strikeAndBall(int[] userArr, int[] randomArr) {
        List<Integer> strikeBall = new ArrayList<>();
        int strike = 0;
        int ball = 0;
        for (int i =0; i<3; i++) {
            if (userArr[i] == randomArr[i]) {
                strike += 1;
                if (userArr[(i+2)%3]==randomArr[(i+1)%3] && userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    ball += 2;
                } else if (userArr[(i+2)%3]==randomArr[(i+1)%3] || userArr[(i+1)%3] == randomArr[(i+2)%3]) {
                    ball += 1;
                }
            }
        }
        strikeBall.add(strike);
        strikeBall.add(ball);
        return strikeBall;
    }
    private static int questionGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int resetGame = Integer.parseInt(sc.nextLine());
        return resetGame;
    }

    private static int findBall(int[] userArr, int[] randomArr, int ball) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (i!=j && userArr[i]==randomArr[j]) {
                    ball+=1;
                }
            }
        }
        return ball;
    }
    private static void judgeStrikeAndBall(int strike, int ball) {
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