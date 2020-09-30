import java.util.ArrayList;
public class QueueImplementation<E> implements Queue<E> {

 // YOUR CODE HERE
    private ArrayList<E> queue;
    
    public QueueImplementation(){
        queue = new ArrayList<E>();
    }
    
    public void enqueue(E e){
        if(e==null){
            throw new NullPointerException("Element that you want to add is null");
        }
        queue.add(e);
        
    }
    public E dequeue(){
        E tmp = queue.remove(0);
        return tmp;
    }
    public boolean isEmpty(){
    return queue.size()==0;
    }
}
