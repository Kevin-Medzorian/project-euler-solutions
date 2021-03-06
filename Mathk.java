
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Kevin
 */
public class Mathk {

    public static boolean setContains(Set<int[]> arr, int[] compare) {
        return arr.stream().anyMatch((i) -> (Arrays.equals(i, compare)));
    }

    public static Integer[] GetPrimes(int max) throws Exception {
        Scanner chopper;

        if (!new File("src/primes.dat").exists()) {
            WritePrimes(max);
        }

        chopper = new Scanner(new File("src/primes.dat"));

        int length = chopper.nextInt();

        if (length < max) {
            WritePrimes(max);
        }

        ArrayList<Integer> primes = new ArrayList();

        primes.add(chopper.nextInt());

        for (int i = 0; primes.get(i) < max && chopper.hasNextInt(); i++) {
            primes.add(chopper.nextInt());
        }

        return primes.toArray(new Integer[primes.size()]);
    }

    public static void WritePrimes(int max) throws Exception {
        String primes = "2 ";

        int amount = 1;

        for (int i = 3; i < max; i += 2) {
            if (isPrime(i)) {
                primes += (i + " ");
                amount++;
            }
        }

        primes = max + " " + primes;

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/primes.dat"), "utf-8"))) {
            writer.write(primes);
        }
    }

    public static boolean[] sieve(int max) throws Exception {
        long time = System.currentTimeMillis();

        Scanner chopper = new Scanner(new File("src/primes.dat"));

        boolean[] out = new boolean[max];

        if (max <= chopper.nextInt()) {
            for (int n = chopper.nextInt(); n <= max; n = chopper.nextInt()) {
                out[n] = true;
            }

            System.out.println("Sieve complete. [" + (System.currentTimeMillis() - time) + " ms]");
            return out;
        }

        System.out.println("Sieve error: Array size it too large for the primes data file.");
        return null;
    }

    public static void calculate(int max) throws Exception {
        String primes = max + "\n";

        for (int i = 1; i < max; i++) {
            primes += (isPrime(i) ? 1 : 0) + " ";
        }

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/primes.dat"), "utf-8"))) {
            writer.write(primes);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0 || n < 2) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long DigitSum(long n) {
        int sum = 0;

        for (; n >= 1; n /= 10) {
            sum += n % 10;
        }

        return sum;
    }

    public static boolean isPrime(long n) {
        if (n == 2) {
            return true;
        }

        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static long pow(long a, int b) {
        long product = 1l;

        for (int i = 0; i < b; i++) {
            product *= a;
        }
        return product;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    public static int[] Sort(int[] arr) {
        int[] newArr = arr.clone();

        Arrays.sort(newArr);
        return newArr;
    }

    public static boolean Exists(ArrayList<int[]> list, int[] arr) {
        return list.stream().anyMatch((i) -> (Arrays.equals(i, arr)));
    }

    public static int StringLines(String s) {
        return s.split("\n").length;
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b.divide(gcd(a, b)));
    }

    public static long numLength(long i) {
        long count = 0, num = Math.abs(i);

        for (; i > 0; count++) {
            i /= 10;
        }

        return count;
    }

    public static long Factorial(long i) {
        return F(i);
    }

    public static int gcd(int f, int s) {
        return s == 0 ? f : gcd(s, f % s);
    }

    public static BigInteger F(String i) {
        BigInteger product = new BigInteger(i);

        for (int j = 1; j < Integer.parseInt(i); j++) {
            product = product.multiply(new BigInteger("" + j));
        }

        return product;
    }

    public static BigInteger F(BigInteger i) {
        BigInteger product = i;

        for (BigInteger index = BigInteger.ONE; index.compareTo(i) < 0; index.add(BigInteger.ONE)) {
            product = product.multiply(index);
        }

        return product;
    }

    public static int F(int i) {
        int product = 1;
        for (int j = 2; j <= i; j++) {
            product *= j;
        }

        return product;
    }

    public static long F(long i) {
        long product = 1;
        for (long j = 2; j <= i; j++) {
            product *= j;
        }
        return product;
    }

    public static int maxMod(int i) {
        return (int) Math.pow(10, (int) Math.log10(i));
    }

    public static int quickReverse(int i) {
        int num = 0;
        int divide = (int) Math.pow(10, (int) Math.log10(i));
        while (i >= 1) {
            num += (i % 10) * divide;
            i /= 10;
            divide /= 10;

        }
        return num;
    }

    public static long quickReverse(long i) {
        long num = 0;
        long divide = (long) Math.pow(10, (long) Math.log10(i));
        while (i >= 1) {
            num += (i % 10) * divide;
            i /= 10;
            divide /= 10;

        }
        return num;
    }

    public static int reverseInt(int i) {
        return Integer.parseInt(new StringBuilder("" + i).reverse().toString());
    }

    public static boolean fastIsPalindrone(int i) {
        int leng = (int) Math.log10(i) + 1;
        int num = 0;

        for (int l = (int) Math.pow(10, leng / 2 - ((leng % 2 == 0) ? 1 : 0)); l >= 1; l /= 10, i /= 10) {
            num += (i % 10) * l;
        }

        if (leng % 2 != 0) {
            num /= 10;
        }

        return num == i;
    }

    public static long reverseLong(long i) {
        return Long.parseLong(new StringBuilder("" + i).reverse().toString());
    }

    public static BigInteger reverseBig(BigInteger i) {
        return new BigInteger(new StringBuilder("" + i).reverse().toString());
    }

    public static boolean isBPalidrome(BigInteger i) {
        return reverseBig(i).equals(i);
    }

    public static boolean isPalidrome(int i) {
        return reverseInt(i) == i;
    }

    public static boolean isLPalidrome(long i) {
        return reverseLong(i) == i;
    }

    public static int ArrayIndexOf(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public static int[] toArray(int number) {
        int i = 0;
        int length = (int) Math.log10(number);
        int divisor = (int) Math.pow(10, length);

        int[] temp = new int[length + 1];

        while (number != 0) {
            temp[i] = number / divisor;
            if (i < length) {
                ++i;
            }
            number = number % divisor;
            if (i != 0) {
                divisor = divisor / 10;
            }
        }

        return temp;
    }

    public static int asNum(int[] number) {
        int num = 0;

        for (int i = 0; i < number.length; i++) {
            num += number[i] * (int) Math.pow(10, number.length - i - 1);
        }

        return num;
    }

    public static boolean isSquare(int num) {
        return Math.sqrt(num) % 1 == 0;
    }

    public static boolean hasDistinctDigits(int num) {
        int numM = 0,
                numD = (int) Math.log10(num) + 1;

        for (int i = 0; i < numD; i++) {
            int curD = (int) (num / Math.pow(10, i)) % 10,
                    dM = (int) Math.pow(2, curD);

            if ((numM & dM) > 0) {
                return false;
            }

            numM = numM | curD;
        }

        return true;
    }

    public static boolean Exists(int[] arr, int item) {
        for (int i : arr) {
            if (i == item) {
                return true;
            }
        }

        return false;
    }

    public static int ArrayIndexOf(int[] arr, int item, int constraint) {
        for (int i = 0; i < constraint; i++) {
            if (arr[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public static int[] FillArray(int[] arr, int[] vals) {
        System.arraycopy(vals, 0, arr, 0, vals.length);
        return arr;
    }

    public static String asFrac(float x) {

        if (x < 0) {
            return "-" + asFrac(-x);
        }

        float tolerance = 1.0E-6f,
                h1 = 1,
                h2 = 0,
                k1 = 0,
                k2 = 1,
                b = x;
        do {
            float a = (float) Math.floor(b);
            float aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);

        return h1 + "/" + k1;
    }
    
    
    
    static class Fraction {

        BigInteger num,
                 den = BigInteger.ONE;
        
        static final Fraction ONE = new Fraction(BigInteger.ONE, BigInteger.ONE),
                ZERO = new Fraction(BigInteger.ZERO, BigInteger.ONE),
                       TEN = new Fraction(BigInteger.TEN, BigInteger.ONE); 

        public Fraction(BigInteger n, BigInteger d) {
            num = n;
            den = d;
        }

        public Fraction(BigInteger n) {
            num = n;
        }

        public Fraction divide(Fraction other) {
            return new Fraction(num.multiply(other.den), den.multiply(other.num));
        }

        public Fraction multiply(Fraction other) {
            return new Fraction(num.multiply(other.num), den.multiply(other.den));
        }

        public Fraction add(Fraction other) {
            BigInteger comm = den.multiply(other.den);
            BigInteger newNum = other.den.multiply(num).add(den.multiply(other.num));

            BigInteger gcd = gcd(comm, newNum);

            comm = comm.divide(gcd);
            newNum = newNum.divide(gcd);

            return new Fraction(newNum, comm);
        }

        public Fraction subtract(Fraction other) {
            BigInteger comm = den.multiply(other.den);
            BigInteger newNum = other.den.multiply(num).subtract(den.multiply(other.num));

            BigInteger gcd = gcd(comm, newNum);

            comm = comm.divide(gcd);
            newNum = newNum.divide(gcd);

            return new Fraction(newNum, comm);
        }
        
        @Override
        public String toString() {
            return num + "/" + den;
        }
    }

}
