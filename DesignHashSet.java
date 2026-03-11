class MyHashSet {
    boolean[] set;
    public MyHashSet() {
        /* 
        Maximum key value = 10^6
        So we create an array of size 1,000,001
        */
        set = new boolean[1000001];
    }
    public void add(int key) {
        /* mark key as present */
        set[key] = true;
    } 
    public void remove(int key) {
        /* mark key as absent */
        set[key] = false;
    }    
    public boolean contains(int key) {
        /* check if key exists */
        return set[key];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
