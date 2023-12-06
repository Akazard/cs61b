public class HW0_EX2 {
    /** Returns the maximum value from m. */
    private static int max(int[] m) {
        int length = m.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < length - 1; i++) {
                if (m[i] > m[i + 1]){
                    int temp;
                    temp = m[i + 1];
                    m[i + 1] = m[i];
                    m[i] = temp;
                    flag = true;
                }
            }
        }
        return m[length - 1];
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));   
    }
}