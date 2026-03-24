/*
Problem: Diagonal Difference

Goal:
Find the absolute difference between the sums of the two diagonals
of a square matrix.

Primary Diagonal: elements where row == column → arr[i][i]
Secondary Diagonal: elements where row + column == n-1 → arr[i][n-i-1]

Approach:
1. Traverse the matrix once.
2. Add primary diagonal elements.
3. Add secondary diagonal elements.
4. Return absolute difference of both sums.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public static int diagonalDifference(List<List<Integer>> arr) {

    int n = arr.size();          // size of matrix
    int primarySum = 0;          // sum of left-to-right diagonal
    int secondarySum = 0;        // sum of right-to-left diagonal

    // Traverse matrix
    for (int i = 0; i < n; i++) {
        
        // Add primary diagonal element
        primarySum += arr.get(i).get(i);
        
        // Add secondary diagonal element
        secondarySum += arr.get(i).get(n - i - 1);
    }

    // Return absolute difference
    return Math.abs(primarySum - secondarySum);
}