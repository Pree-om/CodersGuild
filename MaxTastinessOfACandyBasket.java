class Solution {
    public int maximumTastiness(int[] price, int k) {
        /* 
        Step 1: Sort the prices.
        Example:
        price = [13,5,1,8,21,2]

        After sorting:
        price = [1,2,5,8,13,21]

        Sorting helps because we want to check distances between candies
        in increasing order.
        */
        Arrays.sort(price);
        /*
        Binary Search Range:
        Minimum possible tastiness = 0
        Maximum possible tastiness = max(price) - min(price)
        Example:
        max = 21
        min = 1
        So search space = 0 → 20
        */
        int left = 0;
        int right = price[price.length - 1] - price[0];
        /*
        Binary search to find the largest minimum difference.
        */
        while (left < right) {
            /*
            We use (left + right + 1) / 2 to avoid infinite loop.
            Example:
            left = 0
            right = 20
            mid = 10
            Meaning:
            Can we pick k candies such that
            minimum difference between them ≥ 10 ?
            */
            int mid = (left + right + 1) / 2;
            /*
            If it is possible to pick k candies
            with minimum difference >= mid
            */
            if (canPick(price, k, mid)) {
                /*
                mid works.
                Try a bigger minimum difference.
                Example:
                if mid = 8 works
                maybe 9 or 10 also works
                */
                left = mid;
            } else {
                /*
                mid does NOT work.
                That means difference is too large.
                We must reduce the search space.
                */
                right = mid - 1;
            }
        }
        /*
        When binary search ends,
        left == right
        That value is the maximum tastiness.
        */
        return left;
    }
    private boolean canPick(int[] price, int k, int diff) {
        /*
        We always pick the first candy.
        */
        int count = 1;
        /*
        last stores the last picked candy price.
        */
        int last = price[0];
        /*
        Dry Run Example:
        price = [1,2,5,8,13,21]
        k = 3
        diff = 7
        Pick first candy:
        last = 1
        count = 1
        */
        for (int i = 1; i < price.length; i++) {
            /*
            Check if current candy is far enough
            from the last picked candy.
            Example:
            last = 1
            diff = 7
            Next valid candy must be >= 8
            */
            if (price[i] - last >= diff) {
                /*
                Pick this candy.
                */
                count++;
                /*
                Update last picked candy.
                */
                last = price[i];
                /*
                Example dry run:
                pick 1
                pick 8
                pick 21
                count = 3
                */
            }
        }
        /*
        If we managed to pick at least k candies,
        then this diff is valid.
        */
        return count >= k;
    }
}
