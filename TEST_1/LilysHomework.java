/*
Problem: Lily's Homework

Goal:
Minimum swaps to make array "beautiful"

Idea:
1. Try sorting in ascending → count swaps
2. Try sorting in descending → count swaps
3. Return minimum

Core Trick:
Minimum swaps = number of cycles in permutation
*/

public static int lilysHomework(List<Integer> arr) {

    List<Integer> asc = new ArrayList<>(arr);
    List<Integer> desc = new ArrayList<>(arr);

    Collections.sort(asc);
    desc.sort(Collections.reverseOrder());

    return Math.min(countSwaps(arr, asc), countSwaps(arr, desc));
}


/*
Simpler swap logic version
*/
private static int countSwaps(List<Integer> original, List<Integer> target) {

    // Map value → index
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < original.size(); i++) {
        map.put(original.get(i), i);
    }

    int swaps = 0;
    List<Integer> temp = new ArrayList<>(original);

    for (int i = 0; i < temp.size(); i++) {

        // If element is not in correct position
        if (temp.get(i) != target.get(i)) {

            swaps++;

            int correctValue = target.get(i);
            int j = map.get(correctValue);

            // Swap elements
            Collections.swap(temp, i, j);

            // Update map after swap
            map.put(temp.get(j), j);
            map.put(temp.get(i), i);
        }
    }

    return swaps;
}