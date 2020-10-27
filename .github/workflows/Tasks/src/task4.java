import java.util.*;

public class task4 {
    /**1. Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох,
     * она решает напечатать эссе с помощью текстового процессора. Эссе содержит N слов (1≤N≤100),
     * разделенных пробелами. Каждое слово имеет длину от 1 до 15 символов включительно и состоит только
     * из прописных или строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано
     * очень специфическим образом: каждая строка должна содержать не более K (1≤K≤80) символов, не считая пробелов.
     * К счастью, текстовый процессор Бесси может справиться с этим требованием, используя следующую стратегию:
     * – Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку.
     *      В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке.
     *      Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом.
     *      В конце любой строки не должно быть места.
     * – К сожалению, текстовый процессор Бесси только что сломался.
     *      Пожалуйста, помогите ей правильно оформить свое эссе! */
    public static String Text(int n, int k, String str){
        String[] text=str.split(" ");
        str="";
        String essay="";
        for(int i=0;i<n;i++){
            if (str.length()+text[i].length()>k){
                essay=essay.trim()+"\r\n"+text[i]+" ";
                str=text[i];
            }
            else{
                essay+=text[i]+" ";
                str+=text[i];
            }
        }
        return essay.trim();
    }

    /**2. Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.*/
    public static List<String> split(String klast) {
        List<String> res = new LinkedList<String>();
        int k = 0;
        String buf = "";
        for(int i = 0; i < klast.length(); i++) {
            if (klast.charAt(i) == '(')
                k++;
            else if (klast.charAt(i) == ')')
                k--;
            buf += klast.charAt(i);
            if (k == 0) {
                res.add(buf);
                buf = "";
            }
        }
        return res;
    }

    /**3. Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет одну строку и преобразует ее либо в camelCase, либо в snake_case.*/
    public static String toCamelCase(String camel) {
        String cam = "";
        for (int i = 0; i < camel.length(); i++) {
            if (camel.charAt(i) != '_')
                cam += camel.charAt(i);
            if (camel.charAt(i) == '_') {
                i++;
                String cam1 = Character.toString(camel.charAt(i));
                cam += cam1.toUpperCase();
            }
        }
        return cam;
    }
    public static String toSnakeCase(String snake) {
        String snak = "";
        for (int i = 0; i < snake.length(); i++) {
            if ((snake.charAt(i) >= 'A') && (snake.charAt(i) <= 'Z')) {
                snak += '_';
                String snak1 = Character.toString(snake.charAt(i));
                snak += snak1.toLowerCase();
            } else
                snak += snake.charAt(i);
        }
        return snak;
    }

    /**4. Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.

     Работа с 9 до 5: обычные часы работы После 5 вечера это сверхурочная работа Ваша функция получает массив с 4 значениями:
     – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
     – Конец рабочего дня. (Тот же формат)
     – Почасовая ставка
     – Множитель сверхурочных работ

     Ваша функция должна возвращать: $ + заработанные в тот день (округлены до ближайшей сотой) */
    public static String overTime(double[] mas){
        if (mas[1]>=17)
            return String.format("$%.2f",((17-mas[0])*mas[2])+((mas[1]-17)*mas[2]*mas[3]));
        else
            return String.format("$%.2f",(mas[1]-mas[0])*mas[2]);
    }

    /**5. Индекс массы тела (ИМТ) определяется путем измерения вашего веса в килограммах и деления на квадрат вашего роста в метрах.
     * Категории ИМТ таковы:

     Недостаточный вес: <18,5
     Нормальный вес: 18.5-24.9
     Избыточный вес: 25 и более Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах, метрах или дюймах)
     и возвращать ИМТ и связанную с ним категорию. Округлите ИМТ до ближайшей десятой.*/
    public static String BMI(String[] fat) {
        double mass = Double.parseDouble(fat[0].split(" ")[0]);
        double height = Double.parseDouble(fat[1].split(" ")[0]);
        String category = " ";
        if (fat[0].contains("pounds"))
            mass = mass * 0.453592;
        if (fat[1].contains("inches"))
            height *= 0.0254;
        double BMI = Math.round((mass/(height * height)) * 10.0)/10.0;
        if (BMI < 18.5)
            category = BMI + " Недостаточный вес";
        if (BMI >= 18.5 && BMI <= 24.9)
            category = BMI + " Нормальный вес";
        if (BMI > 25)
            category = BMI + " Избыточный вес";
        return category;
    }

    /**6. Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство,
     * которое представляет собой количество раз, которое вы должны умножать цифры в num, пока не достигнете одной цифры.*/
    public static int bugger(int num){
        int i=0;
        int mul=num;
        while(mul>9){
            mul=1;
            do{
                mul*=num%10;
                num=num/10;
            }while (num!=0);
            num=mul;
            i++;
        }
        return i;
    }

    /**7. Напишите функцию, которая преобразует строку в звездную стенографию. Если символ повторяется n раз, преобразуйте его в символ*n. */
    public static String toStarShorthand(String str){
        if (str.isEmpty()) return "";
        int j=1;
        char c=str.charAt(0);
        String text="";
        for(int i=1;i<str.length();i++){
            if (str.charAt(i)==c) j++;
            else {if (j>1)
                text+=c+"*"+j;
            else
                text+=c;
                c=str.charAt(i);
                j=1;
            }
        }

        if (j>1) text+=c+"*"+j;
        else text+=c;

        return text;
    }

    /**8. Создайте функцию, которая возвращает true, если две строки рифмуются, и false в противном случае.
     * Для целей этого упражнения две строки рифмуются, если последнее слово из каждого предложения содержит одни и те же гласные.*/
    public static boolean doesRhyme(String str, String str1) {
        str = str.substring(str.lastIndexOf(" ") + 1);
        str1 = str1.substring(str1.lastIndexOf(" ") + 1);
        String a = "aeiouyAEIOUY";
        String res = "", res1 = "";
        for (int i = 0; i < str.length(); i++) {
            if (a.indexOf(str.charAt(i)) != -1)
                res += str.charAt(i);
        }
        for (int i = 0; i < str1.length(); i++) {
            if (a.indexOf(str1.charAt(i)) != -1)
                res1 += str1.charAt(i);
        }
        if (res.toLowerCase().equals(res1.toLowerCase()))
            return true;
        else
            return false;
    }

    /**9. Создайте функцию, которая принимает два целых числа и возвращает true,
     * если число повторяется три раза подряд в любом месте в num1 и то же самое число повторяется два раза подряд в num2.*/
    public static boolean trouble(long num1, long num2){
        String a=String.valueOf(num1);
        String b=String.valueOf(num2);
        for(int i=0;i<10;i++){
            if (a.contains(i+String.valueOf(i)+i) && b.contains(String.valueOf(i)+i)) return true;
        }
        return false;
    }

    /**10. Предположим, что пара одинаковых символов служит концами книги для всех символов между ними.
     * Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать) между всеми парами концов книги.*/
    public static int countUniqueBooks(String str, char c){
        int sum=0;
        while (str.contains(String.valueOf(c))){
            Set<Character> set = new HashSet<Character>();
            str=str.substring(str.indexOf(c)+1);

            char ch=' ';
            for(int i=0;i<str.length();i++){
                ch=str.charAt(i);
                if (ch==c) break;
                set.add(str.charAt(i));
            }

            sum+=set.size();
            str=str.substring(str.indexOf(c)+1);
        }
        return sum;
    }
}
