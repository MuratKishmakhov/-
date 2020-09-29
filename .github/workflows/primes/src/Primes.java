public class Primes {
    public static void main(String[] args) {
        int i = 2;
        while (i != 100)
        {
            if (isPrime(i))
            {
                System.out.println(i);
            }
            i ++;
        }
    }
    public static boolean isPrime(int n)
    {
        int b = 2;
        while ( b != 100)
        {
            if (b != n)
            {
                if (n % b == 0)
                {
                    return false;
                }
            }
           b ++;
        }
        return true;
    }

}
