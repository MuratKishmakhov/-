import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.*;

public class task5 {
    /**1. Создайте две функции, которые принимают строку и массив и возвращают закодированное или декодированное сообщение.
     * Первая буква строки или первый элемент массива представляет собой символьный код этой буквы.
     * Следующие элементы-это различия между символами: например, A +3 --> C или z -1 --> y. */
    public static int[] encrypt(String str){
        char[] text=str.toCharArray();
        int[] out=new int[text.length];
        out[0]=text[0];
        for (int i=1;i<text.length;i++){
            out[i]=text[i]-text[i-1];
        }
        return out;
    }

    public static String decrypt(int[] in){
        String text=String.valueOf((char)in[0]);
        int score=in[0];
        for (int i=1;i<in.length;i++){
            text+=String.valueOf((char)(in[i]+score));
            score=in[i]+score;
        }
        return text;
    }

    /**2. Создайте функцию, которая принимает имя шахматной фигуры, ее положение и целевую позицию.
     * Функция должна возвращать true, если фигура может двигаться к цели, и false, если она не может этого сделать.
     * Возможные входные данные - "пешка", "конь", "слон", "Ладья", "Ферзь"и " король".*/
    public static boolean canMove(String name,String start, String end){
        char s1 = start.charAt(0);
        int s2 = Integer.parseInt(String.valueOf(start.charAt(1)));
        char e1 = end.charAt(0);
        int e2 = Integer.parseInt(String.valueOf(end.charAt(1)));
        if (s1==e1 && s2==e2) return false;
        switch (name){
            case "Pawn": {      //Пешка
                if (s1==e1 && s2==2 && e2==4) return true;
                if (s1==e1 && s2==(e2-1)) return true;
                return false;
            }
            case "Knight": {    //Конь
                if ((Math.abs(s1-e1)==2 && Math.abs(s2-e2)==1)||(Math.abs(s1-e1)==1 && Math.abs(s2-e2)==2)) return true;
                return false;
            }
            case "Bishop": {    //Слон
                if (Math.abs(s1-e1)==Math.abs(s2-e2))return true;
                return false;
            }
            case "Rook": {      //Ладья
                if ((s1==e1 && s2!=e2) || (s1!=e1 && s2==e2)) return true;
                return false;
            }
            case "Queen": {     //Ферзь
                if ((s1==e1 && s2!=e2) || (s1!=e1 && s2==e2)) return true;
                if (Math.abs(s1-e1)==Math.abs(s2-e2))return true;
                break;
            }
            case "King": {      //Король
                if (Math.abs(s1-e1)<2 && Math.abs(s2-e2)<2) return true;
                return false;
            }
            default: return false;
        }
        return false;
    }

    /**3. Входная строка может быть завершена, если можно добавить дополнительные буквы, и никакие буквы не должны быть удалены,
     * чтобы соответствовать слову. Кроме того, порядок букв во входной строке должен быть таким же, как и порядок букв в последнем слове.
     * Создайте функцию, которая, учитывая входную строку, определяет, может ли слово быть завершено.*/
    public static boolean canComplete(String str1,String str2){
        char[] text=str1.toCharArray();
        int pos=0;
        for(int i=0;i<text.length;i++){
            if (str2.indexOf(String.valueOf(text[i]),pos)!=-1)
                pos=str2.indexOf(String.valueOf(text[i]),pos)+1;
            else return false;
        }
        return true;
    }

    /**4. Создайте функцию, которая принимает числа в качестве аргументов, складывает их вместе
     * и возвращает произведение цифр до тех пор, пока ответ не станет длиной всего в 1 цифру. */
    public static int sumDigProd(int... number){
        int num=0;
        for (int i : number) {
            num+=i;
        }

        int mul=num;
        while(mul>9){
            mul=1;
            do{
                mul*=num%10;
                num=num/10;
            }while (num!=0);
            num=mul;
        }
        return num;
    }

    /**5. Напишите функцию, которая выбирает все слова, имеющие все те же гласные (в любом порядке и / или количестве),
     * что и первое слово, включая первое слово. */
    public static String[] sameVowelGroup(String[] str){
        List<String> list=new ArrayList<String>();
        list.add(str[0]);
        String glas="aeiyou";

        for(int i=1;i<str.length;i++){
            boolean flag=true;
            for(char c: glas.toCharArray()){
                if (str[0].contains(String.valueOf(c))!=str[i].contains(String.valueOf(c))) flag=false;
            }
            if (flag) list.add(str[i]);
        }
        return list.toArray(new String[list.size()]);
    }

    /**6. Создайте функцию, которая принимает число в качестве аргумента и возвращает true, если это число является
     * действительным номером кредитной карты, а в противном случае-false. Номера кредитных карт должны быть длиной
     * от 14 до 19 цифр и проходить тест Луна, описанный ниже:
     * – Удалите последнюю цифру (это"контрольная цифра").
     * – Переверните число.
     * – Удвойте значение каждой цифры в нечетных позициях. Если удвоенное значение имеет более 1 цифры,
     *      сложите цифры вместе (например, 8 x 2 = 16 ➞ 1 + 6 = 7).
     * – Добавьте все цифры.
     * – Вычтите последнюю цифру суммы (из шага 4) из 10.
     * Результат должен быть равен контрольной цифре из Шага 1.*/
    public static boolean validateCard (long num){
        if (!String.valueOf(num).matches("[0-9]{14,19}")) return false;
        //step 1-2
        long check=num%10;
        num=num/10;
        StringBuilder convert = new StringBuilder();
        num = Long.parseLong(convert.append(num).reverse().toString());
        //step 3-4
        int sum=0;
        String str=String.valueOf(num);
        for (int i=0;i<str.length();i++){
            if (i%2==0) {
                int duo = Integer.parseInt(String.valueOf(str.charAt(i))) * 2;
                sum += duo / 10;
                sum += duo % 10;
            }
            else
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        //step 5
        if (10-sum%10==check)
            return true;
        return false;
    }

    /**7. Напишите функцию, которая принимает положительное целое число от 0 до 999 включительно
     * и возвращает строковое представление этого целого числа, написанное на английском языке.*/
    public static String numToEng(int num){
        String str="";
        if (num==0) return "zero";
        switch (num/100){
            case 1: {str += "one hundred ";break;}
            case 2: {str += "two hundred ";break;}
            case 3: {str += "three hundred ";break;}
            case 4: {str += "four hundred ";break;}
            case 5: {str += "five hundred ";break;}
            case 6: {str += "six hundred ";break;}
            case 7: {str += "seven hundred ";break;}
            case 8: {str += "eight hundred ";break;}
            case 9: {str += "nine hundred ";break;}
        }
        switch (num/10%10){
            case 1: {switch (num%10){
                case 1: {str += "eleven";return str;}
                case 2: {str += "twelve";return str;}
                case 3: {str += "thirteen";return str;}
                case 4: {str += "fourteen";return str;}
                case 5: {str += "fifteen";return str;}
                case 6: {str += "sixteen";return str;}
                case 7: {str += "seventeen";return str;}
                case 8: {str += "eighteen";return str;}
                case 9: {str += "nineteen";return str;}}}
            case 2: {str += "twenty ";break;}
            case 3: {str += "thirty ";break;}
            case 4: {str += "forty ";break;}
            case 5: {str += "fifty ";break;}
            case 6: {str += "sixty ";break;}
            case 7: {str += "seventy ";break;}
            case 8: {str += "eighty ";break;}
            case 9: {str += "ninety ";break;}
        }
        switch (num%10){
            case 1: {str += "one";break;}
            case 2: {str += "two";break;}
            case 3: {str += "three";break;}
            case 4: {str += "four";break;}
            case 5: {str += "five";break;}
            case 6: {str += "six";break;}
            case 7: {str += "seven";break;}
            case 8: {str += "eight";break;}
            case 9: {str += "nine";break;}
        }
        return str;
    }

    public static String numToRus(int num){
        String str="";
        if (num==0) return "ноль";
        switch (num/100){
            case 1: {str += "сто ";break;}
            case 2: {str += "двести ";break;}
            case 3: {str += "триста ";break;}
            case 4: {str += "четыреста ";break;}
            case 5: {str += "пятьсот ";break;}
            case 6: {str += "шестьсот ";break;}
            case 7: {str += "семьсот ";break;}
            case 8: {str += "восемьсот ";break;}
            case 9: {str += "девятьсот ";break;}
        }
        switch (num/10%10){
            case 1: {str += "десять ";break;}
            case 2: {str += "двадцать ";break;}
            case 3: {str += "тридцать ";break;}
            case 4: {str += "сорок ";break;}
            case 5: {str += "пятьдесят ";break;}
            case 6: {str += "шестьдесят ";break;}
            case 7: {str += "семьдесят ";break;}
            case 8: {str += "восемьдесят ";break;}
            case 9: {str += "девяносто ";break;}
        }
        switch (num%10){
            case 1: {str += "один";break;}
            case 2: {str += "два";break;}
            case 3: {str += "три";break;}
            case 4: {str += "четыре";break;}
            case 5: {str += "пять";break;}
            case 6: {str += "шесть";break;}
            case 7: {str += "семь";break;}
            case 8: {str += "восемь";break;}
            case 9: {str += "девять";break;}
        }
        return str;
    }

    /**8. Создайте функцию, которая возвращает безопасный хеш SHA-256 для данной строки.
     * Хеш должен быть отформатирован в виде шестнадцатеричной цифры.*/
    public static String getSha256Hash(String str)throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] text=digest.digest(str.getBytes(StandardCharsets.UTF_8));
        return HexBin.encode(text).toLowerCase();
    }

    /**9. Напишите функцию, которая принимает строку и возвращает строку с правильным регистром.
     * Слова and, the, of и in должны быть строчными. Все остальные слова должны иметь первый символ
     * в верхнем регистре, а остальные-в Нижнем. */
    public static String correctTitle(String str){
        String[] text=str.toLowerCase().split(" ");
        String out="";
        for (String s:text){
            if (s.equals("and") || s.equals("the") || s.equals("of") || s.equals("in"))
                out+=s+" ";
            else out+=String.valueOf(s.charAt(0)).toUpperCase()+s.substring(1)+" ";
        }
        return out.trim();      /**Почти спойлеры схватил, хорошо, что досмотрел "Игру престолов" 2 дня назад*/
    }

    /**10. Напишите функцию, которая принимает целое число n и возвращает "недопустимое", если n не является
     * центрированным шестиугольным числом или его иллюстрацией в виде многострочной прямоугольной строки в противном случае.*/
    public static String hexLattice(int num){
        String str1="";
        String str2="";
        int n=1,i=1;
        while(n<num){
            i++;
            n=3*i*(i-1)+1;
        }
        if (n==num) {
            n=i;
            for (int k = 0; k <= i/2+1; k++) {
                String s=new String(new char[n-k*2]).replace("\0", " ")+
                        new String(new char[n]).replace("\0", "o ");
                str1+=s+"\n";
                if (k!=i/2+1)
                    str2=s+"\n"+str2;
                n++;
            }
            return str1+str2;
        }
        return "Invalid";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] str={"hoops", "chuff", "bot", "bottom"};
        System.out.println(sameVowelGroup(str));
    }
}
