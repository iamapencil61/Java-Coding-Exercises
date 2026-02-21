package structures;

public class Stack {

    private int[] data;

    public Stack() {
        data = new int[0];
    }

    public void push(int x) {
        int newSize = data.length + 1;
        int[] newData = new int[newSize];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[newSize - 1] = x;
        data = newData;
    }

    public int pop() {
        if (data.length == 0) return 0;

        int last = data[data.length - 1];
        int newSize = data.length - 1;
        int[] newData = new int[newSize];

        for (int i = 0; i < newSize; i++) {
            newData[i] = data[i];
        }

        data = newData;
        return last;
    }

    public boolean empty() {
        return data.length == 0;
    }
}
