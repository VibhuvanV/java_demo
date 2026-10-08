package arrays_strings.string_operations;

import java.util.Scanner;

public class StringOperations {

    public String reverseString(String s){
        String temp = "";
        int n = s.length();
        for(int i=n-1;i>=0;i--) {
            temp += s.charAt(i);
        }
        return temp;
    }

    public String reverseString(String s, StringBuilder s1) {
        s1.append(s);
        s = s1.reverse().toString();
        return s;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int countVowels(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            if(isVowel(s.toLowerCase().charAt(i))) ans++;
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s, StringBuilder s1) {
        s1.delete(0,s1.length());
        s1.append(s);
        return s.equals(s1.reverse().toString());
    }

    public int firstOccurrance(String s , char ch) {
        int ans = s.indexOf(""+ ch);
        return ans;
    }

    public int lastOccurrance(String s , char ch) {
        int ans = s.lastIndexOf(""+ ch);
        return ans;
    }

    public static void main(String[] args) {
        StringOperations obj = new StringOperations();
        Scanner scanner = new Scanner(System.in);
        StringBuilder s1 = new StringBuilder();

        String input = scanner.nextLine();
        System.out.println(obj.reverseString(input));
        System.out.println(obj.reverseString(input, s1));

        System.out.println("Number of Vowels: " + obj.countVowels(input));

        String palin = scanner.nextLine();
        System.out.println("Is palindrome: " + obj.isPalindrome(palin));
        System.out.println("Is Palindrome: "+ obj.isPalindrome(palin, s1));

        System.out.println("Enter the character to search: ");
        char ch = scanner.next().charAt(0);
        System.out.println("First Occurrance of " + ch + ": " + obj.firstOccurrance(input, ch));
        System.out.println("Last Occurrance of " + ch + ": " + obj.lastOccurrance(input, ch));

        //Substring
        String substr = input.substring(0,4);
        System.out.println(substr);
    }


}
