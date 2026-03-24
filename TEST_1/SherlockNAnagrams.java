/*
Problem: Sherlock and Anagrams

Goal:
Count number of pairs of substrings that are anagrams.

Idea (Easy + Standard):
1. Generate all substrings
2. Sort each substring → this becomes its "signature"
   (anagrams will have same sorted form)
3. Store frequency of each signature in a HashMap
4. If a signature appears 'f' times → pairs = f * (f - 1) / 2

Time Complexity: O(n^3 log n) (acceptable for constraints)
Space Complexity: O(n^2)
*/

public static int sherlockAndAnagrams(String s) {

    Map<String, Integer> map = new HashMap<>();

    // Step 1: generate all substrings
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
            
            // substring
            String sub = s.substring(i, j + 1);

            // Step 2: sort it → canonical form
            char[] chars = sub.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Step 3: store frequency
            if (map.containsKey(sorted)) {
                map.put(sorted, map.get(sorted) + 1);
            } else {
                map.put(sorted, 1);
            }
        }
    }

    int count = 0;

    // Step 4: count pairs
    for (int freq : map.values()) {
        count += (freq * (freq - 1)) / 2;
    }

    return count;
}