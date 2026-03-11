class Solution {
    public int minOperations(int[] nums) {
        int moves = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                int needed = nums[i-1] + 1;
                moves += needed - nums[i];
                nums[i] = needed;
            }
        }
        return moves;
    }
}
