/*
Problem: Sparse Arrays (Matching Strings)

Goal:
For each query string, count how many times it appears
in the given list of input strings.

Approach:
1. Use a HashMap to store frequency of each string.
2. Traverse the input list and count occurrences.
3. For each query, check:
   - If present → return its count
   - If not → return 0

Time Complexity: O(n + q)
Space Complexity: O(n)
*/

public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

    // Create a map to store string frequency
    Map<String, Integer> map = new HashMap<>();

    // Step 1: Count occurrences of each string
    for (String s : stringList) {
        
        // If string already exists, increase count
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } 
        // If string is new, add with count = 1
        else {
            map.put(s, 1);
        }
    }

    // Create result list to store answers
    List<Integer> result = new ArrayList<>();

    // Step 2: Process each query
    for (String q : queries) {
        
        // If query exists in map, add its count
        if (map.containsKey(q)) {
            result.add(map.get(q));
        } 
        // If not found, add 0
        else {
            result.add(0);
        }
    }

    // Return final result
    return result;
}