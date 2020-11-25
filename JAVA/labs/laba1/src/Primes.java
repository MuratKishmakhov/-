public class Primes {
    public static void main(String[] args)
    {
        int a = 2;
        while (a != 100)
        {
            if (isPrime(a))
            {
                System.out.println(a);
            }
            a ++;
        }
    }
    public static boolean isPrime(int n)
    {
        int count = 2;
        while (count != 100)
        {
            if (count != n)
            {
                if (n % count == 0)			
                {
                    return false;
                }
            }
            count ++;
        }
        return true;
    }
}
