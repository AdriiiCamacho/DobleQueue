import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
    first = null;
    last = null;
    size = 0;
    }

    @Override
    public void prepend(T value) {
         DequeNode nuevo = new DequeNode<>(value, null, null);
        if (first == null){
            first = nuevo;
            last = nuevo;
        } else {
            first.setPrevious(nuevo);
            nuevo.setNext(first);
            first = nuevo;
        }
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode nuevo = new DequeNode<>(value, null, null);
        if (first == null){
            first = nuevo;
            last = nuevo;
        } else {
            last.setNext(nuevo);
            nuevo.setPrevious(last);
            last = nuevo;
        }
        size++;
    }

    @Override
    public void deleteFirst() throws Exception {
        if (size==0){
            throw new Exception("No hay primero");
        } else if (size ==1 ){
            first = null;
            last = null;
            size--;
        }else{
                first.getNext().setPrevious(null);
                first = first.getNext();
                size--;
            }
        }
        ;


    @Override
    public void deleteLast() throws Exception {
        if (size==0){
            throw new Exception("No hay ultimo");
        }else if (size == 1){
            first = null;
            last = null;
            size--;
        }else{
            last.getPrevious().setNext(null);
            last = last.getPrevious();
            size--;
        }
    }
    ;

    @Override
    public T first() {

        return first.getItem();
    }

    @Override
    public T last() {

        return last.getItem();
    }

    @Override
    public int size() {

        return size;
    }
}
