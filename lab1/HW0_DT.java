import java.util.Scanner;

public class HW0_DT{
    private static void draw(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    draw(num);
    scanner.close();
    }
}