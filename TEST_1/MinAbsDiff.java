/*
Problem: Minimum Absolute Difference

Goal:
Find the minimum absolute difference between any two elements.

Best Idea:
1. Sort the array
2. Compare ONLY adjacent elements
   (closest numbers will be next to each other after sorting)

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

public static int minimumAbsoluteDifference(List<Integer> arr) {

    // Step 1: sort the array
    Collections.sort(arr);

    int minDiff = Integer.MAX_VALUE;

    // Step 2: check adjacent elements
    for (int i = 1; i < arr.size(); i++) {
        
        int diff = Math.abs(arr.get(i) - arr.get(i - 1));
        
        if (diff < minDiff) {
            minDiff = diff;
        }
    }

    return minDiff;
}