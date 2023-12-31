public class HW0_EX4 {
  public static void windowPosSum(int[] a, int n) {
    int length = a.length;
    for (int i = 0; i < length; i++) {
        if(a[i] < 0){
            continue;
        }
        int sum = 0;
        for (int j = i; j <= i + n; j++) {
            if(j >= length){
                break;
            }
            sum += a[j];
        }
        a[i] = sum;
    } 
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}