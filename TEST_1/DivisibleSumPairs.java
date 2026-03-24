/*
Problem: Divisible Sum Pairs

Goal:
Count the number of pairs (i, j) such that:
- i < j
- (ar[i] + ar[j]) % k == 0

Approach (Simple):
1. Use two loops to check all possible pairs.
2. For each pair, check if their sum is divisible by k.
3. Count such pairs.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    
    int count = 0;  // to store number of valid pairs

    // Check all pairs
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            
            // Check if sum is divisible by k
            if ((ar.get(i) + ar.get(j)) % k == 0) {
                count++;
            }
        }
    }

    // Return total count
    return count;
}