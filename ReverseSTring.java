class Solution {
    public void reverseString(char[] s) {

        // Initialize left pointer at the beginning of the array
        int l = 0;

        // Initialize right pointer at the end of the array
        int r = s.length - 1;

        // Run loop until left pointer is less than right pointer
        while (l < r) {

            // Store the left character temporarily
            char temp = s[l];

            // Assign right character to left position
            s[l] = s[r];

            // Assign stored character to right position
            s[r] = temp;

            // Move left pointer one step to the right
            l++;

            // Move right pointer one step to the left
            r--;
        }
    }
}
