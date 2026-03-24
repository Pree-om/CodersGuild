/*
Problem: Ice Cream Parlor (Two Sum Variation)

Goal:
Find two distinct indices such that:
arr[i] + arr[j] = m

Return indices in 1-based indexing (i < j)

Approach (Optimal - HashMap):
1. Traverse the array.
2. For each element, calculate complement = m - current value.
3. Check if complement already exists in map:
   - If yes → we found the pair
4. Otherwise, store current value with its index.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public static List<Integer> icecreamParlor(int m, List<Integer> arr) {

    // Map to store value -> index
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.size(); i++) {
        
        int current = arr.get(i);
        int complement = m - current;

        // If complement already exists → we found the pair
        if (map.containsKey(complement)) {
            
            // Return indices in ascending order (1-based)
            return Arrays.asList(map.get(complement) + 1, i + 1);
        }

        // Store current value with its index
        map.put(current, i);
    }

    return new ArrayList<>(); // (won't happen as per constraints)
}