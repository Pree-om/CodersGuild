class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = 0;      // current valid subarray length
        int maxLen = 0;   // best answer
        /*
        Dry run start
        nums = [3,2,5,4]
        threshold = 5
        */
        for(int i = 0; i < nums.length; i++){
            /*
            i = 0
            nums[0] = 3
            */
            if(nums[i] > threshold){
                /*
                If element exceeds threshold,
                it cannot be part of a valid subarray.
                Example:
                nums[i] = 7, threshold = 5
                */
                len = 0;
                continue;
            }
            /*
            If we are not currently building a subarray
            */
            if(len == 0){
                /*
                Subarray must start with EVEN number
                */
                if(nums[i] % 2 == 0){
                    /*
                    i = 1
                    nums[1] = 2
                    Start subarray:
                    [2]
                    */
                    len = 1;
                }

            }
            /*
            If we already started a subarray
            */
            else if(nums[i] % 2 != nums[i-1] % 2){
                /*
                Check alternating parity
                i = 2
                nums[2] = 5
                previous = 2 (even)
                current  = 5 (odd)
                Alternating ✔
                Subarray becomes:
                [2,5]
                */
                len++;
            }
            else{
                /*
                Parity did NOT alternate
                Example:
                even → even
                or
                odd → odd
                */
                if(nums[i] % 2 == 0){
                    /*
                    If current number is even,
                    we can start a NEW subarray.
                    Example:
                    [2,5,4,6]
                         ^
                    restart from 6
                    */
                    len = 1;
                }
                else{

                    /*
                    Odd number cannot start subarray
                    */

                    len = 0;
                }
            }
            /*
            Update best answer
            */
            maxLen = Math.max(maxLen, len);
            /*
            Dry run states:

            i = 0 → nums=3
            len=0 maxLen=0

            i = 1 → nums=2
            len=1 maxLen=1

            i = 2 → nums=5
            len=2 maxLen=2

            i = 3 → nums=4
            len=3 maxLen=3
            */
        }
        return maxLen;
    }
}
