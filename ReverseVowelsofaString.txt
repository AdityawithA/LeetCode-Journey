Q} Reverse Vowels of a String
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        String v = "aeiouAEIOU";
        int l = 0, r = a.length - 1;

        while (l < r) {
            while (l < r && v.indexOf(a[l]) == -1) l++;
            while (l < r && v.indexOf(a[r]) == -1) r--;

            char t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        }

        return new String(a);
    }
}