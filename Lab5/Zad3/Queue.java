package Lab5.Zad3;

public class Queue <T>{

    private Node<T> head,tail;
    private int count;

    public Queue(){
        head = null;
        tail = null;
        count = 0;
    }
    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public void enqueue(T element) {
        Node<T> elem = new Node<T>(element,null);
        if(isEmpty()){
            tail = elem;
            head = elem;
        }else {
            head.setNext(elem);
            head = elem;
        }
        count++;
    }

    public T dequeue() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        T result = tail.getElement();
        tail = tail.getNext();
        count--;
        return result;
    }

    public T inspect() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return head.getElement();
    }

    public T peek() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return tail.getElement();
    }
}
