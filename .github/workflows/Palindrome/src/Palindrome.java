import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for(String word: str.split(" ")){
            System.out.println(word+"-"+isPalindrome(word));
        }
    }
       public static boolean isPalindrome(String str){
           boolean res = false;
           for (int i=0; i<str.length()/2; i++){
               if(str.charAt(i)==str.charAt(str.length()-i-1)) res = true;
               else res = false;
           }
           return res;
       }
    }

