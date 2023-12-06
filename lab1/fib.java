public class fib {
    public static long fib(int n) {
        int n1 = 0;
        int n2 = 1;
        if(n == 1){
            return n1;
        }
        if(n == 2){
            return n2;
        }
        long a =0l, b =1l, c = 0l;
        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fib2(int n) {
        if (n == 1){
            return 0;
        }

        if (n == 2 || n == 3){
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib2(6));
    }
}