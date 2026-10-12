class Deque {

    private Node head;
    private Node tail;
    private int length;

    public Deque() {
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void append(int value) {
       Node current = new Node(null, tail, value);
       if (isEmpty()) {
            head = current;
            tail = current;
       } else {
            tail.next = current;
            tail = current;
       }
       length++;
    }

    public void appendleft(int value) {
        Node current = new Node(head, null, value);
        if (isEmpty()) {
            head = current;
            tail = current;
        } else {
            head.previous = current;
            head = current;
        }
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = tail.value;
        tail = tail.previous;
        length--;
        if (!isEmpty())
            tail.next = null;
        return val;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        int val = head.value;
        head = head.next;
        length--;
        if (!isEmpty())
            head.previous = null;
        return val;
    }

    private static class Node {
        int value;
        Node previous;
        Node next;
        public Node(Node next, Node previous, int value) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
    
}
