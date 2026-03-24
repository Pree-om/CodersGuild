/*
Problem: Jim and the Orders

Goal:
Determine the order in which customers receive their orders.

Key Idea:
Serve time = order number + prep time

Steps:
1. For each customer:
   - Calculate serve time
   - Store (serveTime, customerIndex)
2. Sort:
   - First by serveTime (ascending)
   - If tie → by customerIndex (ascending)
3. Return customer indices

Time Complexity: O(n log n) (due to sorting)
Space Complexity: O(n)
*/

public static List<Integer> jimOrders(List<List<Integer>> orders) {

    List<List<Integer>> list = new ArrayList<>();

    // Step 1: store (serveTime, customerIndex)
    for (int i = 0; i < orders.size(); i++) {
        int serveTime = orders.get(i).get(0) + orders.get(i).get(1);
        list.add(Arrays.asList(serveTime, i + 1));
    }

    // Step 2: sort using one-liner
    Collections.sort(list, (a, b) -> 
        a.get(0) != b.get(0) ? a.get(0) - b.get(0) : a.get(1) - b.get(1)
    );

    // Step 3: extract result
    List<Integer> result = new ArrayList<>();
    for (List<Integer> item : list) {
        result.add(item.get(1));
    }

    return result;
}