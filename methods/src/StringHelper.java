public class StringHelper {
    private String text;

    public StringHelper(String text) {
        this.text = text;
    }

    public String toUpperCase() {
        return this.text.toUpperCase();
    }

    public int getLength() {
        return this.text.length();
    }

    public boolean contains(String word) {
        if (this.text.contains(word)) {
            return true;
        }
        return false;
    }

    public String repeat(int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(this.text);

            if (i != times - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}