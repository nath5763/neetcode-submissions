class DynamicArray {

    private Integer[] array;
    private Integer length;

    public DynamicArray(int capacity) {
        array = new Integer[capacity];
        length = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        if (i < 0 || i >= length) {
            return;
        }
        array[i] = n;
        if(i == length)
            length++;
    }

    public void pushback(int n) {
        //add the element to the back of the array, resize if needed
        if (length == array.length) {
            this.resize();
        }
        array[length] = n;
        length++;
    }

    public int popback() {
        // take the last element then set as null in the array and return the value
        if (length==0)
            return 0;
        Integer val = array[length-1];
        array[length-1] = null;
        length--;
        return val;
    }

    private void resize() {
        //double the size of the array then transfer the data over
        int size = array.length * 2;
        Integer[] arrayDouble = new Integer[size];
        for(int i = 0; i < length; i++) {
            arrayDouble[i] = array[i];
        }
        array = arrayDouble;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        //total capacity
        return array.length;
    }
}
