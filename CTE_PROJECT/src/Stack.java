public class Stack<E> {
    private StackItem<E> top = null;

    public void push(E x) {
        StackItem<E> newItem = new StackItem<>(x);
        newItem.next = this.top;
        this.top = newItem;
    }

    public boolean empty() {
        return (this.top == null);
    }

    public E peek() {
        return this.top.value;
    }

    public void pop() {
        this.top = this.top.next;
    }
}
