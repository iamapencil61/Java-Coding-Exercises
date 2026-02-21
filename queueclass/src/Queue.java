class Queue {

    private int[] elements;

    Queue() {
        elements = new int[0];
    }

    public void enqueue(int value) {
        int[] newArray = new int[elements.length + 1];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        newArray[elements.length] = value;
        elements = newArray;
    }

    public int dequeue() {
        if (elements.length == 0) {
            return -1;
        }

        int front = elements[0];
        int[] newArray = new int[elements.length - 1];

        for (int i = 1; i < elements.length; i++) {
            newArray[i - 1] = elements[i];
        }

        elements = newArray;
        return front;
    }

    public int front() {
        if (elements.length == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return elements[0];
    }

    public int rear() {
        if (elements.length == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[elements.length - 1];
    }
}