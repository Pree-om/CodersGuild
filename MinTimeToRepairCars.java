class Solution {
    public long repairCars(int[] ranks, int cars) {
        /*
        Step 1: Find the fastest mechanic.
        The fastest mechanic gives the upper bound of time,
        because in the worst case that mechanic repairs all cars.
        Example:
        ranks = [4,2,3,1]
        minRank = 1
        */
        int minRank = Integer.MAX_VALUE;
        for(int r : ranks){
            minRank = Math.min(minRank, r);
        }
        /*
        Binary Search Range:
        Minimum possible time = 1
        Maximum possible time:
        fastest mechanic repairs all cars
        time = r * n²
        Example:
        minRank = 1
        cars = 10
        max time = 1 * 10² = 100
        */
        long left = 1;
        long right = (long) minRank * cars * cars;
        /*
        Binary search to find the minimum time needed
        to repair all cars.
        */
        while(left < right){
            /*
            mid represents a candidate time.
            Example:
            left = 1
            right = 100
            mid = 50
            Meaning:
            Can all mechanics repair at least
            "cars" cars within 50 minutes?
            */
            long mid = left + (right - left) / 2;
            /*
            Check if repairing all cars within mid time
            is possible.
            */
            if(canRepair(ranks, cars, mid)){
                /*
                If it is possible,
                we try to reduce time further.
                So move right pointer.
                */
                right = mid;
            }else{
                /*
                If not possible,
                we need more time.
                */
                left = mid + 1;
            }
        }
        /*
        When binary search finishes,
        left == right
        That value is the minimum time required.
        */
        return left;
    }
    private boolean canRepair(int[] ranks, int cars, long time){
        /*
        repaired keeps track of how many cars
        all mechanics can repair in given time.
        */
        long repaired = 0;
        /*
        Formula:
        time = r * n²
        Solve for n:
        n = sqrt(time / r)
        This gives the number of cars
        a mechanic with rank r can repair.
        */
        for(int r : ranks){
            /*
            Example:
            time = 16
            rank = 4
            cars repaired = sqrt(16/4)
                          = sqrt(4)
                          = 2
            */
            repaired += (long)Math.sqrt(time / r);
            /*
            Early exit optimization.
            If repaired cars already ≥ required cars,
            we can stop checking further.
            */
            if(repaired >= cars){
                return true;
            }
        }
        /*
        If total repaired cars < required cars,
        this time is not sufficient.
        */
        return false;
    }
}
