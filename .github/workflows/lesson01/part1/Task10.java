package lesson01.part1;

//import org.graalvm.compiler.lir.alloc.lsra.Interval;

import java.util.Date;
import java.util.Scanner;

public class Task10 {

    /**
     * Не думать о секундах…
     * Напиши код, который считает сколько секунд прошло с 15:00, если на часах 15:30. Выведи результат на экран.
     * <p>
     * <p>
     * Требования:
     * 1. Программа должна выводить текст.
     * 2. Выведенный текст должен быть целым положительным числом.
     * 3. Выведенное число должно быть кратно 60.
     * 4. Выводимое число должно соответствовать заданию.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date1= scanner.nextLine();
        String date2= scanner.nextLine();
        System.out.println(sec(date2)-sec(date1));

    }
    public static int sec(String s){
        int a[] = new int[2];
        int i=0;
        for (String str:  s.split(":")){
            a[i]=Integer.parseInt(str);
            i++;
        }
        return a[0]*3600+a[1]*60;
    }
}

