/*
Problem: Beautiful Pairs

Idea:
1. Count matching elements using frequency map
2. If matches < n → answer = matches + 1
3. If matches == n → answer = matches - 1
*/

public static int beautifulPairs(List<Integer> A, List<Integer> B) {

    // Step 1: frequency map of A
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : A) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int matches = 0;

    // Step 2: count matches
    for (int num : B) {
        if (map.containsKey(num) && map.get(num) > 0) {
            matches++;
            map.put(num, map.get(num) - 1);
        }
    }

    int n = A.size();

    // Step 3: apply rule
    if (matches == n) {
        return matches - 1; // must break one
    } else {
        return matches + 1; // can improve by 1
    }
}