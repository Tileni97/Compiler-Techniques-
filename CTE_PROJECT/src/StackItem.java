

public class StackItem<E> {
    public E value;

    public StackItem<E> next;

    public StackItem(E x) {
        this.value = x;
        this.next = null;
    }
}
