public class task2 {
    /**1. Создайте функцию, которая повторяет каждый символ в строке n раз*/
    public static String repeat(String str, int a){
        String out="";
        for (int i=0;i<str.length();i++){
            for(int j=0; j<a; j++){
                out+=str.charAt(i);
            }
        }
        return out;
    }

    /**2. Создайте функцию, которая принимает массив и возвращает разницу между самыми большими и самыми маленькими числами.*/
    public static int differenceMaxMin ( int [] mass) {
        int max = mass[0];
        int min = mass[0];
        for (int i = 0; i < mass.length;i++) {
            max = Math.max(max, mass[i]);
            min = Math.min(min, mass[i]);
        }
        return max-min;
    }

    /**3. Создайте функцию, которая принимает массив в качестве аргумента и возвращает true или false в зависимости от того,
     * является ли среднее значение всех элементов массива целым числом или нет.*/
    public static boolean isAvgWhole(int[] mas){
        int sum=0;
        for (int i=0;i<mas.length;i++){
            sum+=mas[i];
        }
        return (((double)sum)/mas.length)%2==0;
    }

    /**4. Создайте метод, который берет массив целых чисел и возвращает массив, в котором каждое целое число
     * является суммой самого себя + всех предыдущих чисел в массиве.*/
    public static int[] cumulativeSum (int [] mass) {
        for (int i = 1; i < mass.length; i++) {
            mass[i] = mass[i] + mass[i - 1];
        }
        return mass;
    }

    /**5. Создайте функцию, которая возвращает число десятичных знаков, которое имеет число (заданное в виде строки).
     * Любые нули после десятичной точки отсчитываются в сторону количества десятичных знаков.*/
    public static int getDecimalPlaces(String str){
        if (!str.contains(".")) return 0;
        else
            return str.split("\\.")[0].length();
    }

    /**6. Создайте функцию, которая при заданном числе возвращает соответствующее число Фибоначчи.*/
    public static int Fibonacci(int a){
        int[] mas = new int[a];
        mas[0]=1;
        mas[1]=2;
        for (int i=2;i<a;i++){
            mas[i]=mas[i-1]+mas[i-2];
        }
        return mas[a-1];
    }

    /**7. Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку, напишите функцию,
     * чтобы определить, является ли вход действительным почтовым индексом.
     * Действительный почтовый индекс выглядит следующим образом:
     * – Должно содержать только цифры (не допускается использование нецифровых цифр).
     * – Не должно содержать никаких пробелов.
     * – Длина не должна превышать 5 цифр.*/
    public static boolean isValid(String str){
        if (str.length()==5)
            try{
                Integer.parseInt(str);
                return true;
            }
            catch (Exception e){
                return false;
            }
        return false;
    }

    /**8. Пара строк образует странную пару, если оба из следующих условий истинны:
     * – Первая буква 1-й строки = последняя буква 2-й строки.
     * – Последняя буква 1-й строки = первая буква 2-й строки.
     * – Создайте функцию, которая возвращает true, если пара строк представляет собой странную пару, и false в противном случае.*/
    public static boolean isStrangePair (String str1, String str2) {
        if (str1.equals("") && str2.equals(""))
            return true;
        else
        if (!(str1.equals("") || str2.equals("")))
            if (str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0))
                return true;
            else
                return false;
        return false;
    }

    /**9. Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
     * – isPrefix должен возвращать true, если он начинается с префиксного аргумента.
     * – isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
     * – В противном случае верните false.*/
    public static boolean isPrefix(String str1, String str2){
        str2=str2.substring(0,str2.length()-1);
        return str1.startsWith(str2);
    }

    public static boolean isSuffix(String str1, String str2){
        str2=str2.substring(1);
        return str1.endsWith(str2);
    }

    /**10. Создайте функцию, которая принимает число (шаг) в качестве аргумента и возвращает количество полей
     * на этом шаге последовательности.Шаг 0: начните с 0
     *     Шаг 1: Добавьте 3
     *     Шаг 2: Вычтите 1
     *     Повторите Шаги 1 И 2*/
    public static int boxSeq (int a) {
        if (a >=0 && a%2==0)
            return a;
        else
        if (a >=0)
            return a+2;
        else return 0;
    }
}
