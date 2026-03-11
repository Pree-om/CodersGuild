class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        int minTime = Integer.MAX_VALUE;
        for(int t : time){
            minTime = Math.min(minTime, t);
        }
        long right = (long) minTime * totalTrips;
        while(left < right){
            long mid = left + (right - left) / 2;
            if(canComplete(time, totalTrips, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canComplete(int[] time, int totalTrips, long T){
        long trips = 0;
        for(int t : time){
            trips += T / t;
            if(trips >= totalTrips){
                return true;
            }
        }
        return false;
    }
}
