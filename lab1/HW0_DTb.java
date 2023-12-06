import java.util.Scanner;

public class HW0_DTb {
    private static void drawTriangle(int N){
        for (int i = 0; i < N; i += 2) {
            for (int j = 0; j < i + 1; j += 2) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    drawTriangle(num);
    scanner.close();
   }
}