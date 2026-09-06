public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        if (isEmpty()) {
            return "";
        }

        String result = "";
        Node<E> current = head;

        while (current != null) {
            result += current.getElement();

            current = current.getNext();
        }

        return result;
    }


    public E removeLast(){
        if (isEmpty()) {
            return null;
        }

        E lastE = tail.getElement();

        if (head == tail) {
            head = null;
            tail = null;
            return lastE;
        }

        Node<E> newLast = head;

        while (newLast.getNext() != tail) {
            newLast = newLast.getNext();
        }

        
        tail = newLast;
        tail.setNext(null);
        return lastE;

    }

    public void reverse(){       
        Node<E> prev = null;
        Node<E> current = head;

        tail = head;

        while (current != null) {
            Node<E> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }
}