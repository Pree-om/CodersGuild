class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1])
                        left++;
                    while(left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
                else if(sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
/*
DRY RUN

Input:
[-1,0,1,2,-1,-4]

Step 1: Sort the array
[-4,-1,-1,0,1,2]

Iteration 1
i = 0 → nums[i] = -4
left = 1 → -1
right = 5 → 2

sum = -4 + (-1) + 2 = -3 < 0
Move left → left++

left = 2 → -1
sum = -3 → move left

left = 3 → 0
sum = -2 → move left

left = 4 → 1
sum = -1 → move left

left == right → stop

Iteration 2
i = 1 → nums[i] = -1
left = 2 → -1
right = 5 → 2

sum = -1 + (-1) + 2 = 0
Triplet found → [-1,-1,2]

Move pointers
left = 3 → 0
right = 4 → 1

sum = -1 + 0 + 1 = 0
Triplet found → [-1,0,1]

Final result:
[-1,-1,2]
[-1,0,1]

Time Complexity: O(n^2)
Space Complexity: O(1) excluding result list
*/
