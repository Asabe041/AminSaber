/**
 * An implementation of the interface WordMap using linked elements.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */
import java.util.Comparator;

public class LinkedWordMap implements WordMap {
    
    private static class Node{
        
        private String key;
        private Integer count;
        private Node previous, next;
        
        public Node(String key, Node previous, Node next) {
            this.key = key;
            this.count=1;
            this.previous = previous;
            this.next = next;
        }
        
    }
    private final Node head;
    public LinkedWordMap() {
        head = new Node(null, null, null);
        head.previous = head.next = head;
    }
    
    
    public boolean add(String key) {
        // Remove line below and add your implementation.
        if(key==null){
            throw new IllegalArgumentException("null");
        }
        Node p = head;
        while(p.next != head && p.next.key.compareTo(key)<0){
            p=p.next;
        }
        Node q=p.next;
        p.next= new Node(key,p,p.next);
        q.previous=p.next;
        
        return true;
    }
    
    public String[] toArrayS(String[] elems) {
        if (elems == null) {
            throw new NullPointerException();
        }
        if (elems.length != size()) {
            throw new IllegalArgumentException("the length of the array should be: " + Integer.toString(size()));
        }       
        Node current = head.next;
        for (int i=0; i<size(); i++) {
            elems[i] = current.key;
            current = current.next;
        }
        return elems;
    }
	
    public Integer[] toArrayI(Integer[] elems) {
        
        if (elems == null) {
            throw new NullPointerException();
        }
        
        if (elems.length != size()) {
            throw new IllegalArgumentException("the length of the array should be: " + Integer.toString(size()));
        }
        
        Node current = head.next;
        
        for (int i=0; i<size(); i++) {
            elems[i] = current.count;
            current = current.next;
        }
        
        return elems;
    }
    
    public String toString() {
        
        StringBuilder buffer;
        buffer = new StringBuilder("[");
        
        Node current = head.next;
        
        while (current != head) {
            if (buffer.length() > 1) {
                buffer.append(", ");
            }
            buffer.append(current.key.toString());
            current = current.next;
        }
        
        buffer.append("]");
        
        return buffer.toString();
    }
    
   
    
    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */
    public int size(){
        return sizeRec(head.next);
    }
    
    public int sizeRec(Node current){
        if(current==head){
            return 0;
        }
        return 1+sizeRec(current.next);
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
        return getRec(head.next, key);
    }
    public Integer getRec(Node current,String key){
        if(current==head){
            return 0;
        }
        
        if(current.key==key){
            return current.count;
        }
        return getRec(current.next,key);
    }
    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    public boolean contains(String key) {
        return containsRec(head.next,key);
    }
    
    private boolean containsRec(Node current,String key){
        if(current==head){
            return false;
        }
        
        if(current.key.equals(key)){
            return true;
        }
        
        return containsRec(current.next, key);
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
		if(key==null){
			throw new NullPointerException();
		}
            updateRec(head.next,key);
        }
	
    public void updateRec(Node current, String key){
        if(size()==0 || current==head){
            add(key);
		}
		else if(current.key.equals(key)){
            current.count++;
		}
		else{
        updateRec(current.next,key);
    }
	}
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys() {
        String[] table=new String[size()];
        return toArrayS(table);
    }
    
    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    public Integer[] counts() {
        Integer[] table= new Integer[size()];
        return toArrayI(table);
        
    }

}
