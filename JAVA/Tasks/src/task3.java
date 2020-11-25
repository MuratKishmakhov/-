import java.util.*;

public class task3 {
    /**1. Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных решения для действительных значений x.
     * учитывая a, b и c, вы должны вернуть число решений в уравнение.*/
    public static int solutions (double a, double b, double c) {
        double D=b*b - 4*a*c;
        if ((a == 0) && (b == 0))
            System.out.print("Уравнения нет. Количество решений: ");
        else
        if (D > 0)
            return 2;
        else if (D == 0)
            return 1;
        else
            return 0;
        return 0;
    }

    /**2. Напишите функцию, которая возвращает позицию второго вхождения " zip " в строку, или -1,
     *  если оно не происходит по крайней мере дважды. Ваш код должен быть достаточно общим,
     *  чтобы передать все возможные случаи, когда "zip" может произойти в строке. */
    public static int findZip (String str) {
        if (str.indexOf("zip") == str.lastIndexOf("zip"))
            return -1;
        else
            return str.indexOf("zip", str.indexOf("zip") + 1);
    }

    /**3. Создайте функцию, которая проверяет, является ли целое число совершенным числом или нет.
     * Совершенное число - это число, которое можно записать как сумму его множителей, исключая само число. */
    public static boolean checkPerfect(int num){
        int sum=0;
        for(int i=1;i<=num/2;i++){
            if (num%i==0)sum+=i;
        }
        return num==sum;
    }

    /**4. Создайте функцию, которая принимает строку и возвращает новую строку
     * с заменой ее первого и последнего символов, за исключением трех условий:
     * – Если длина строки меньше двух, верните "несовместимо".".
     * – Если первый и последний символы совпадают, верните "два-это пара.". */
    public static String flipEndChars(String str){
        char start,end;
        start=str.charAt(0);
        end=str.charAt(str.length()-1);
        if (str.length()<2) return "Несовместимо.";
        else if (start==end) return "Два - это пара.";
        else return end+str.substring(1,str.length()-1)+start;
    }

    /**5. Создайте функцию, которая определяет, является ли строка допустимым шестнадцатеричным кодом.*/
    public static boolean isValidHexCode(String str){
        return str.matches("#[a-fA-F0-9]{6}");
    }

    /**6. Напишите функцию, которая возвращает true, если два массива имеют одинаковое количество уникальных элементов,
     * и false в противном случае.*/
    public static boolean same(int[] mas1, int[] mas2){
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        for (int i=0;i<mas1.length;i++) map1.put(mas1[i],"");
        Map<Integer, String> map2 = new HashMap<Integer, String>();
        for (int i=0;i<mas2.length;i++) map2.put(mas2[i],"");
        return map1.size()==map2.size();
    }

    /**7. Число Капрекара-это положительное целое число, которое после возведения в квадрат и разбиения
     * на две лексикографические части равно сумме двух полученных новых чисел:
     * – Если количество цифр квадратного числа четное, то левая и правая части будут иметь одинаковую длину.
     * – Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной половиной,
     *      а левая-самой маленькой или равной нулю, если количество цифр равно 1.
     * – Учитывая положительное целое число n, реализуйте функцию, которая возвращает true, если это число Капрекара, и false, если это не так.*/
    public static boolean isKaprekar (int num) {
        int a = num*num;
        String str=String.valueOf(a);
        if (str.length() == 1)
            if (a == num)
                return true;
            else
                return false;
        else
        if ((Integer.parseInt(str.substring(0, str.length()/2)) + Integer.parseInt(str.substring(str.length()/2))) == num)
            return true;
        else
            return false;
    }

    /**8. Напишите функцию, которая возвращает самую длинную последовательность последовательных нулей в двоичной строке.*/
    public static String longestZero(String str){
        String sum="";
        String max="";
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='0') sum+="0";
            else {
                if (max.length()<sum.length())max=sum;
                sum="";
            }
        }
        if (max.length()<sum.length())max=sum;
        return max;
    }

    /**9. Если задано целое число, создайте функцию, которая возвращает следующее простое число.
     * Если число простое, верните само число.*/
    public static int nextPrime (int a) {
        for (int i = 2; i < a; i++ )
            if (a % i == 0) {
                a ++;
                i = 2;
            }
        return a;
    }

    /**10. Учитывая три числа, x, y и z, определите, являются ли они ребрами прямоугольного треугольника.*/
    public static boolean rightTriangle(int x,int y, int z) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(x);
        list.add(y);
        list.add(z);
        Collections.sort(list);
        return Math.sqrt(list.get(0)*list.get(0)+list.get(1)*list.get(1))==list.get(2);
    }
}
