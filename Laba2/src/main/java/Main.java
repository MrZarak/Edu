
public class Main {

    public static void main(String[] args) {
        double[][] A = {
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5},
                {0.1, 0.2, 0.3, 0.4, 0.5}
        };
        double[][] B = {
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1},
                {0.1, 0.1, 0.1, 0.1, 0.1}
        };
        try {
            if (A.length == 0 || A[0].length == 0 || A.length != B.length)
                throw new IllegalArgumentException("Розмірність матриць не дозволяє виконати додавання");
            double[][] C = new double[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                double[] ARow = A[i];
                double[] BRow = B[i];

                if (ARow.length != BRow.length)
                    throw new IllegalArgumentException("Розмірність матриці B не дозволяє виконати додавання");
                else {
                    for (int j = 0; j < ARow.length; j++) {
                        double AElement = ARow[j];
                        double BElement = BRow[j];
                        double CElement = (AElement + BElement);
                        C[i][j] = CElement;
                    }
                }
            }

            double sum = 0;
            for (int i = 0; i < C[0].length; i++) {
                try {
                    double max = Double.MIN_VALUE;
                    for (double[] row : C) {
                        double v = row[i];
                        if(v > max){
                            max = v;
                        }
                    }
                    sum+=max;
                    System.out.println(max);
                } catch (IndexOutOfBoundsException e) {
                    throw new IndexOutOfBoundsException("Не достатньо стовпців");
                }
            }
            System.out.println("\n\nРезультат: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "!!!!");
        }
    }
}
