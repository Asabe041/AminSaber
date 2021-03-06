/**
 * A Binary Search Tree implementation of the interface WordMap.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TreeWordMap implements WordMap {

    private static class Elem {

        private String key;
        private int count;
        private Elem left, right;

        private Elem(String key) {
            this.key = key;
            count = 1;
        }

    }
    
    private Elem root;
    private int size;
    private LinkedList<String> table4Keys;
    private static LinkedList<Integer> table4Counts;
    
    
    public TreeWordMap(){
        size=0;
    }
    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified key
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public boolean contains(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        
        boolean found = false;
        Elem current = root;
        while (! found && current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }
    
    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public void update(String key) {
        int result;
        if(key == null){
            throw new NullPointerException();
        }
        Elem current=root;
        System.out.println(!contains(key));
        System.out.println(size==0);
        
        if(size==0){
            addOne(key, root);
        } else if(!contains(key)){
            addNew(key,root);
        }
        else{
            int test = key.compareTo(current.key);
            if(test==0){
                current.count++;
            }else if(test <0){
                update(current.left.key);
            }else{
                update(current.right.key);
            }
        }
        }
    
    private void addOne(String key, Elem current){
            root.key=key;
            size++;
        }
    
    
    private void addNew(String key, Elem current){
            if(current==null){
                current = new Elem(key);
                size++;
            }else{
                int test = key.compareTo(current.key);
                if (test<0){
                    addNew(key,current.left);
                }else{
                    addNew(key,current.right);
                }
            }
    }
    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param key the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public int get(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        
        boolean found = false;
        Elem current = root;
        while (current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                return current.count;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return 0;
    }
    
    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys() {
        return inOrderS(root);
    }
    private String[] inOrderS(Elem current){
        
        String[] table=new String[size];
        
        if(current != null){
            inOrderS(current.left);
            table.addLast(current.key);
            inOrderS(current.right);
        }
        return table.toArray(table);
    }
    
    
    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    public Integer[] counts() {
        LinkedList<Integer> table = new LinkedList<Integer>();
        return inOrderI(root, table);
    }
    
    private Integer[] inOrderI(Elem current, LinkedList<Integer> table){
        
        if(current != null){
            inOrderI(current.left,table);
            table.addLast(current.count);
            inOrderI(current.right,table);
            
        }
        Integer[] x= new Integer[size];
        return table.toArray(x);
    }
    
        
}
