package structures;

public class Stack {
    private int[] data;

    public Stack() {
        data = new int[0];
    }

    public void push(int x) {
        int[] newData = new int[data.length + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        newData[data.length] = x;
        data = newData;
    }

    public int pop() {
        if (data.length == 0) return 0;

        int value = data[data.length - 1];
        int[] newData = new int[data.length - 1];
        System.arraycopy(data, 0, newData, 0, data.length - 1);
        data = newData;

        return value;
    }

    public int top() {
        if (data.length == 0) return 0;
        return data[data.length - 1];
    }

    public int size() {
        return data.length;
    }

    public boolean empty() {
        return data.length == 0;
    }
}
