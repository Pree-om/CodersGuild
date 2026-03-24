/*
Problem: Migratory Birds (HashMap Version)

Goal:
Find the most frequent bird ID.
If tie → return smallest ID.

Approach (HashMap):
1. Use HashMap to count frequency of each bird.
2. Traverse map to find max frequency.
3. If tie → choose smaller ID.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public static int migratoryBirds(List<Integer> arr) {

    // Step 1: Count frequency
    Map<Integer, Integer> map = new HashMap<>();

    for (int bird : arr) {
        if (map.containsKey(bird)) {
            map.put(bird, map.get(bird) + 1);
        } else {
            map.put(bird, 1);
        }
    }

    int maxCount = 0;
    int result = Integer.MAX_VALUE;

    // Step 2: Find answer
    for (int key : map.keySet()) {
        
        int count = map.get(key);

        // If higher frequency OR same frequency but smaller ID
        if (count > maxCount || (count == maxCount && key < result)) {
            maxCount = count;
            result = key;
        }
    }

    return result;
}