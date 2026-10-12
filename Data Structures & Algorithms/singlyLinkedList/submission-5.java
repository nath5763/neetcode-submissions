class LinkedList {

    Node head;
    Node tail;
    int length;

    public LinkedList() {
        int length = 0;
    }

    private boolean indexExists (int index) {
        return length < 1 || index < 0  || index >= length;
    }

    public int get(int index) {
        if(indexExists(index)) {
            return -1;
        }
        Node current = head;
        while (index != 0) {
            current = current.next;
            index--;
        }

        return current.value;
    }

    public void insertHead(int val) {
        Node current = new Node(head, null, val);
        if (length == 0) {
            head = current;
            tail = current;
        } else {
            head.previous = current;
            head = current;
        }
        length++;
    }

    public void insertTail(int val) {
        Node current = new Node(null, tail, val);
        if (length == 0) {
            head = current;
            tail = current;
        } else {
            tail.next = current;
            tail = current;
        }
        length++;
    }

    public boolean remove(int index) {
        if(indexExists(index)) {
            return false;
        }
        //if head then just remove and set next head, if tail just remove and set previous tail otherwise remove element and link previous and next
        Node current;
        if (index == 0) {
            current = head;
            head = current.next;
        } else if (index == length-1) {
            current = tail;
            tail = current.previous;
        } else {
            current = head;
            while (index != 0) {
                current = current.next;
                index--;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            
        }
        current = null;
        length--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        return values;
    }

    class Node {
        Node next;
        Node previous;
        int value;
        public Node(Node next, Node previous, int value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }
}
