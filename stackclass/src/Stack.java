class Stack {
    private int[] data;
    private int size;

    private int[] minData;
    private int minSize;

    private int[] maxData;
    private int maxSize;

    Stack() {
        data = new int[1];
        size = 0;

        minData = new int[1];
        minSize = 0;

        maxData = new int[1];
        maxSize = 0;
    }

    private int[] ensureCapacity(int[] array, int currentSize) {
        if (currentSize < array.length) {
            return array;
        }

        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];

        System.arraycopy(array, 0, newArray, 0, currentSize);
        return newArray;
    }

    void push(int x) {
        data = ensureCapacity(data, size);
        data[size] = x;
        size++;

        if (minSize == 0 || x <= minData[minSize - 1]) {
            minData = ensureCapacity(minData, minSize);
            minData[minSize] = x;
            minSize++;
        }

        if (maxSize == 0 || x >= maxData[maxSize - 1]) {
            maxData = ensureCapacity(maxData, maxSize);
            maxData[maxSize] = x;
            maxSize++;
        }
    }

    int pop() {
        if (size == 0) {
            return 0;
        }

        size--;
        int popped = data[size];

        if (minSize > 0 && popped == minData[minSize - 1]) {
            minSize--;
        }
        if (maxSize > 0 && popped == maxData[maxSize - 1]) {
            maxSize--;
        }
        return popped;
    }

    int top() {
        if (size == 0) {
            return 0;
        }
        return data[size - 1];
    }

    boolean empty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int min() {
        if (minSize == 0) {
            return 0;
        }
        return minData[minSize - 1];
    }

    int max() {
        if (maxSize == 0) {
            return 0;
        }
        return maxData[maxSize - 1];
    }
}