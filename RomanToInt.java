class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++){
            if(map.get(arr[i]) < map.get(arr[i+1]))
                result -= map.get(arr[i]);
            else
                result += map.get(arr[i]);
        }

        result += map.get(arr[arr.length-1]);

        return result;
    }
}
