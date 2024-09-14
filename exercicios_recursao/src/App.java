import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

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
        System.out.println(permutations("abc"));
    }
    /**
     * caso base -> lenght(str) == 0
     * caso de erro -> null(str)
     * caso recursivo -> length(str) > 0
     * 
     *     res = []
     *     para i de 0 até length(str)
     *         nStr = removeChar(str, i)
     *         perms = permutations(nStr)
     *             para perm em perms 
     *                 append(res, perm + charAt(str, i))
     */
    public static List<String> permutations(String str) {
        if (str == null) {
            throw new IllegalArgumentException("input is null");
        }
        ArrayList<String> res = new ArrayList<>();
        if (str.isEmpty()) {
            res.add(str);
            return res;
        }
        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            List<String> perms = permutations(newStr);
            for (String s : perms) {
                res.add(str.charAt(i) + s);
            }
        }
        return res;

    }

    /**
     * caso base = n < 10
     * caso de erro = N/A
     * caso recursivo = n > 9
     * 
     *     nroDigit(n) = 1 + nroDigit(n / 10)
     * @param n
     * @return
     */
    public static int nroDigit(int n) {
        if (n < 9) {
            return 1;
        }
        return 1 + nroDigit(n / 10);
    }

    /**
     * caso base -> str = null || length(str) = 0 || match = null || str.regionMatches(0, match, 0, length(match))
     * caso de erro -> N/A
     * caso recursivo -> not str.regionMatches(0, match, 0, length(match))
     * 
     *     findSubstr(str, match) = findSubstr(str.substr(1), match)
     * @param str
     * @param match
     * @return
     */
    public static boolean findSubstr(String str, String match) {
        if (str == null || str.isEmpty() || match == null) {
            return false;
        }
        if (str.regionMatches(0, match, 0, match.length())) {
            return true;
        }
        return findSubstr(str.substring(1), match);
    }

    /**
     * caso base -> size(list) = 0
     * caso de erro -> N/A
     * caso recursivo -> size(list) > 0
     * 
     *     findBiggest(list) = findBiggest(list, removeLast(list))
     *     findBiggest(list, biggest) =
     *         last = removeLast(list)
     *         if last > biggest then
     *             findBiggest(list, last)
     *             else
     *                 findBiggest(list, biggest)
     * @param list
     * @param biggest
     * @return
     */
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

    /**
     * caso base -> size(list) = 0
     * caso de erro -> list = null
     * caso recursivo -> size(list) > 0
     * 
     *     sumList(list) = removeLast(list) + sumList(list)
     * @param list
     * @return
     */
    public static int sumList(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        if (list.isEmpty()) {
            return 0;
        }
        return list.removeLast() + sumList(list);
    }

    /**
     * caso base -> n = 1 || n = 0
     * caso de erro -> n < 0
     * caso recursivo -> n > 1
     * 
     *     convBase2(n) = convBase2(n / 2) + (n % 2)
     * 
     * ou, com operadores bitwise,
     * 
     *     convBase(n) = convBase2(n >> 1) + (n & 1)
     * @param n
     * @return
     */
    public static String convBase2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.valueOf(n));
        }
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return convBase2(n >> 1) + (n & 1);
    }

    /**
     * caso base -> empty(str) || length(str) = 1
     * caso de erro -> str = null
     * caso recursivo -> length(str) > 1
     * 
     *     isPal(str) = str[0] == str[length(str) - 1] && isPal(str.substr(1, length(str) - 1))
     * @param str
     * @return
     */
    public static boolean isPal(String str) {
        if (str == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        return str.charAt(0) == str.charAt(str.length() - 1) &&
            isPal(str.substring(1, str.length() - 1));
    }
    
    /**
     * caso base -> j = k
     * caso de erro -> N/A
     * caso recursivo -> j != k
     * 
     *     se j > k, sumRange(j, k) = sumRange(k, j)
     *     se j < k, sumRange(j, k) = j + sumRange(j + 1, k)
     * @param j
     * @param k
     * @return
     */
    public static int sumRange(int j, int k) {
        if (j > k) {
            return sumRange(k, j);
        }
        if (j == k) {
            return j;
        }
        return j + sumRange(j + 1, k);
    }

    /**
     * caso base -> n = 1 || n = 2
     * caso de erro -> n <= 0
     * caso recursivo -> n >= 1
     * 
     *     fib(n) = fib(n - 1) + fib(n - 2)
     */
    public static int fib(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid arg. should be greater than zero");
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * caso base = 0
     * caso de erro = N/A
     * caso recursivo = abs(n) > 0
     * 
     *     para n > 0, sum(n) = n + sum(n - 1)
     *     para n < 0, sum(n) = 0 - sum(abs(n))
     */
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return 0 - sum(Math.abs(n));
        }
        return n + sum(n - 1);
    }

    /**
     * caso base -> n == 1
     * caso de erro -> n <= 0
     * caso recursivo -> n > 1
     * 
     *     fatorial(n) = n * fatorial(n - 1)
     */
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
