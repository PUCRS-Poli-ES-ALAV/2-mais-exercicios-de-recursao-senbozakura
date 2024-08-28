import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(fatorial(4));
        System.out.println(sum(-6));
        System.out.println(fib(6));
        System.out.println(sumRange(3, 1));
        System.out.println(isPal("ossos"));
        System.out.println(convBase2(15 + 1));
        System.out.println(sumList(new ArrayList<>(List.of(1,2,3,4,5))));
        System.out.println(findBiggest(new ArrayList<>(List.of(1,5,2,7,1,74,3,9))));
        System.out.println(findSubstr("astral", "trala"));
        System.out.println(nroDigit(Integer.MAX_VALUE));
    }

    public static int nroDigit(int n) {
        if (n < 9) {
            return 1;
        }
        return 1 + nroDigit(n / 10);
    }

    public static boolean findSubstr(String str, String match) {
        if (str == null || match == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        if (str.regionMatches(0, match, 0, match.length())) {
            return true;
        }
        return findSubstr(str.substring(1), match);
    }

    public static Integer findBiggest(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        return findBiggest(list, list.removeLast());
    }

    private static Integer findBiggest(List<Integer> list, Integer biggest) {
        if (list.isEmpty()) {
            return biggest;
        }
        Integer last = list.removeLast();
        if (Integer.compare(last, biggest) > 0) {
            biggest = last;
        }
        return findBiggest(list, biggest);
    }

    public static int sumList(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        if (list.isEmpty()) {
            return 0;
        }
        return list.removeLast() + sumList(list);
    }

    public static String convBase2(int n) {
        if (n < 0) {
            return null;
        }
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return convBase2(n >> 1) + (n & 1);
    }

    public static boolean isPal(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        return str.charAt(0) == str.charAt(str.length() - 1) &&
            isPal(str.substring(1, str.length() - 1));
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
