/*
Problem: Pairs with Given Difference

Goal:
Count the number of pairs such that:
|a - b| = k

Given:
- All elements are UNIQUE

Approach (Optimal - HashSet):
1. Store all elements in a HashSet.
2. For each number, check if (num + k) exists.
3. If yes → valid pair found.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public static int pairs(int k, List<Integer> arr) {

    // Store elements for fast lookup
    Set<Integer> set = new HashSet<>(arr);

    int count = 0;

    // Check for each element
    for (int num : arr) {
        
        // If num + k exists → valid pair
        if (set.contains(num + k)) {
            count++;
        }
    }

    return count;
}