import java.util.*;

public class task6 {
    /**1. Число Белла - это количество способов, которыми массив из n элементов может быть разбит на непустые подмножества.
     * Создайте функцию, которая принимает число n и возвращает соответствующее число Белла. */
    public static int bell(int n) {
        int sum = 0;
        int[][] mass = new int[n + 1][n + 1];
        mass[0][0] = 1;
        mass[n][n] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                mass[i][j] = mass[i - 1][j - 1] + j*mass[i - 1][j];
            }
        }
        for (int i = 0; i <= n; i++)
            sum += mass[n][i];
        return sum;
    }

    /**2. – Если слово начинается с согласного, переместите первую букву (буквы) слова до гласного до конца слова и добавьте «ay» в конец.
     *    – Если слово начинается с гласной, добавьте "yay" в конце слова. */
    public static String translateWord(String str){
        if (str.isEmpty()) return "";
        if(!Character.isLetter(str.charAt(0))) return "";
        if (str.matches("[aeiyouAEIYOU].*"))
            return str+"yay";
        else{
            String s=str.split("[aeiyouAEIYOU]")[0];
            return str.replaceFirst(s,"")+s+"ay";
        }
    }

    public static String translateSentence(String str){
        String out="";
        String buff="";
        for(char c: str.toCharArray()){
            if (Character.isLetter(c))
                buff+=c;
            else{
                out+=translateWord(buff);
                out+=c;
                buff="";
            }
        }
        return out+=translateWord(buff);
    }

    /**3. Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых значений допустимым или нет.
     * Создайте функцию, которая принимает строку (например, " rgb(0, 0, 0)") и возвращает true,
     * если ее формат правильный, в противном случае возвращает false.*/
    public static boolean validColor(String str) {
        if (!str.contains("rgb"))
            return false;
        String str1 = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        String[] s = str1.split(",");
        if (str.contains("rgba") && s.length != 4)
            return false;
        if (str.contains("rgb") && !str.contains("rgba") && s.length != 3)
            return false;
        try {
            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(s[i]) < 0 || Integer.parseInt(s[i]) > 255)
                    return false;
            }
            if (s.length == 4) {
                if (Double.parseDouble(s[3]) < 0 || Double.parseDouble(s[3]) > 1)
                    return false;
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**4. Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся параметры запроса и параметры,
     * указанные во втором аргументе (который будет необязательным массивом) Примечание:
     * Второй аргумент paramsToStrip является необязательным.
     * paramsToStrip может содержать несколько параметров.
     * Если есть повторяющиеся параметры запроса с разными значениями, используйте значение последнего встречающегося параметра..*/
    public static String stripUrlParams(String URL, String ...paramsToStrip) {
        if (!URL.contains("?"))
            return URL;
        String res = "";
        Map<String, String> map = new HashMap<>();
        String[] str = URL.split("\\?");
        res += str[0];
        if (str.length != 1) {
            str = str[1].split("&");
            for (int i = 0; i < str.length; i++) {
                String[] str1 = str[i].split("=");
                map.put(str1[0], str1[1]);
            }
            res += "?";
        }
        if (paramsToStrip != null) {
            for (String param : paramsToStrip) {
                map.remove(param);
            }
        }
        for (String k : map.keySet()) {
            res += k + "=" + map.get(k) + "&";
        }
        return res.substring(0,res.length()-1);
    }

    /**5. Напишите функцию, которая извлекает три самых длинных слова из заголовка газеты и преобразует их в хэштеги.
     * Если несколько слов одинаковой длины, найдите слово, которое встречается первым.*/
    public static String[] getHashTags(String str){
        List<String> words=new ArrayList<String>();
        String buff="";
        for (char c: str.toCharArray()){
            if (Character.isLetter(c))
                buff+=c;
            else{
                words.add("#"+buff.toLowerCase());
                buff="";
            }
        }
        if (!buff.isEmpty()) words.add("#"+buff.toLowerCase());
        Comparator<String> compare = (String  o1, String o2) -> o2.length()-o1.length();
        Collections.sort(words, compare);

        while (words.size()>3) words.remove(words.size()-1);

        return words.toArray(new String[words.size()]);
    }

    /**6. Создайте функцию, которая принимает число n и возвращает n-е число в последовательности Улама.*/
    public static int ulam(int n) {
        Vector<Integer> mass = new Vector<>();
        mass.add(1);
        mass.add(2);
        for (int i = 3; i < 2000; i++) {
            int k = 0;
            for (int j = 0; j < mass.size() - 1; j++) {
                for (int m = j + 1; m < mass.size(); m++) {
                    if (mass.get(j) + mass.get(m) == i) k++;
                    else if (k > 1)
                        break;
                }
                if (k > 1)
                    break;
            }
            if (k == 1)
                mass.add(i);
        }
        return mass.get(n - 1);
    }

    /**7. Напишите функцию, которая возвращает самую длинную неповторяющуюся подстроку для строкового ввода.*/
    public static String longestNonrepeatingSubstring(String str){
        String word="";
        String buff="";
        for(char c: str.toCharArray()){
            if (!buff.contains(String.valueOf(c)))
                buff+=c;
            else{
                if (buff.length()>word.length())
                    word=buff;
                buff=""+c;
            }
        }
        if (buff.length()>word.length())
            word=buff;
        return word;
    }

    /**8. Создайте функцию, которая принимает арабское число и преобразует его в римское число.*/
    public static String convertToRoman(int num){
        int iLet=1000;
        String let="MDCLXVI";
        int i=0;
        String out="";
        while(i!=7){
            if (num/iLet>0) {
                out += let.charAt(i);
                num-=iLet;
            }
            else {
                if (i % 2 == 0) iLet = iLet / 2;
                else iLet = iLet / 5;
                i++;
            }
        }
        return out;
    }

    /**9. Создайте функцию, которая принимает строку и возвращает true или false в зависимости от того,
     * является ли формула правильной или нет.*/
    public static boolean formula(String str) {
        if (!(str.contains("=")))
            return false;
        String[] form = str.split("=");
        double[] res = new double[form.length];
        for (int j =0; j < form.length; j++) {
            if (form[j].length() == 1)
                res[j] = Double.parseDouble(form[j]);
            else {
                String[] str1 = form[j].split(" ");
                for (int i = 0; i < str1.length; i++) {
                    switch (str1[i]) {
                        case "+":
                            str1[i+1] = String.valueOf(Double.parseDouble(str1[i-1]) + Double.parseDouble(str1[i+1]));
                            break;
                        case "-":
                            str1[i+1] = String.valueOf(Double.parseDouble(str1[i-1]) - Double.parseDouble(str1[i+1]));
                            break;
                        case "*":
                            str1[i+1] = String.valueOf(Double.parseDouble(str1[i-1]) * Double.parseDouble(str1[i+1]));
                            break;
                        case "/":
                            str1[i+1] = String.valueOf(Double.parseDouble(str1[i-1]) / Double.parseDouble(str1[i+1]));
                            break;
                        default:
                            break;
                    }
                }
                res[j] = Double.parseDouble(str1[str1.length - 1]);
            }
        }
        double check = res[0];
        for (int i = 1; i < res.length; i++) {
            if (res[i] != check)
                return false;
        }
        return true;
    }

    /**10. Создайте функцию, которая возвращает значение true, если само число является палиндромом
     * или любой из его потомков вплоть до 2 цифр (однозначное число - тривиально палиндром).
     * Прямой потомок числа создается путем суммирования каждой пары соседних цифр, чтобы создать цифры следующего числа.*/
    public static boolean palindromedescendant(int num){
        String number=String.valueOf(num);
        while(true){
            if (number.equals(new StringBuilder(number).reverse().toString())){
                return true;
            }else{
                if (number.length()%2==1) return false;
                String sum="";
                for (int i=1;i<number.length();i+=2){
                    sum+=Integer.parseInt(String.valueOf(number.charAt(i)))+Integer.parseInt(String.valueOf(number.charAt(i-1)));
                }
                number=sum;
            }
        }
    }


    public static void main(String[] args) {
        String[] s = {"b"};
        System.out.println(ulam(206));
    }
}
