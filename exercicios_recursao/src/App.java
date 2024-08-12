public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(fatorial(4));
        System.out.println(sum(-6));
        System.out.println(fib(6));
        System.out.println(sumRange(3, 1));
        
    }
    
    public static int sumRange(int j, int k) {
        if (j > k) {
            return sumRange(k, j);
        }
        if (j == k) {
            return j;
        }
        return j + sumRange(j + 1, k);
    } 

    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("invalid arg. should be greater than zero");
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return 0 - sum(Math.abs(n));
        }
        return n + sum(n - 1);
    }

    public static int fatorial(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid arg. should be greater than zero");
        }
        if (n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }
}
