class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=Integer.MAX_VALUE;
        int sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                len = Math.min(len, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if(len == Integer.MAX_VALUE)
            return 0;
        else 
            return len;
    }
}
