class MyHashMap {
    int[] map;
    public MyHashMap() {
        /*
        Maximum key = 10^6
        Initialize array with -1 (means no value)
        */
        map = new int[1000001];
        for(int i = 0; i < map.length; i++){
            map[i] = -1;
        }
    }  
    public void put(int key, int value) {
        /* insert or update value */
        map[key] = value;
    }
    public int get(int key) {
        /* return stored value or -1 */
        return map[key];
    }
    public void remove(int key) {
        /* mark as removed */
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
