Q} Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

class Solution {
    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {

            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            if (Character.toLowerCase(s.charAt(l)) !=
                Character.toLowerCase(s.charAt(r)))
                return false;

            l++;
            r--;
        }

        return true;
    }
}