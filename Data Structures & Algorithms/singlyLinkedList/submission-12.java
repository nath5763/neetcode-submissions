class LinkedList {

    Node head;
    Node tail;
    int length;

    public LinkedList() {
        length = 0;
    }

    private boolean indexExists (int index) {
        return length < 1 || index < 0  || index >= length;
    }

    private Node getNode(int index) {
        Node current;
        if (index >= length / 2) {
            current = tail;
            int currentIndex = length - 1;
            while (currentIndex != index) {
                current = current.previous;
                currentIndex--;
            }
        } else {
            current = head;
            while (index != 0) {
                current = current.next;
                index--;
            }
        }
        return current;
    }

    public int get(int index) {
        if(indexExists(index)) {
            return -1;
        }
        
        return getNode(index).value;
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
        
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.previous = null;
            }
        } else if (index == length-1) {
            tail = tail.previous;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
        } else {
            Node current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        length--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>(length);
        Node current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        return values;
    }

    private static class Node {
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
