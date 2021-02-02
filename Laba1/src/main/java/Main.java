public class Main {
    static final byte A = 1;//Початковий індекс №1
    static final byte B = 1;//Початковий індекс №2
    static final byte N = 4;//Фінальний індекс №1
    static final byte M = 5;//Фінальний індекс №2
    static final byte C = 1;//Константа

    //Номер заликової: 0112
    public static void main(String[] args) {
        byte res = 0;
        for (byte i = A; i <= N; i++) {
            byte bottom = (byte) (i + C);
            if (bottom == 0) {
                System.out.println("Помилка у операції (/), знаменник == 0");
                return;
            }
            for (byte j = B; j <= M; j++) {
                if (j == 0) {
                    System.out.println("Помилка у операції (%), [j] == 0");
                    return;
                }
                byte top = (byte) (i % j);
                res += top / bottom;
            }
        }
        System.out.println(res);
    }
}
