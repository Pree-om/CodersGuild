public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Solution \"your string here\"");
            return;
        }

        // Join arguments in case the user didn't use quotes
        String input = String.join(" ", args);
        Solution sol = new Solution();
        boolean result = sol.isPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + result);
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Move left pointer forward if not alphanumeric
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            // Move right pointer backward if not alphanumeric
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            // Case-insensitive comparison
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
