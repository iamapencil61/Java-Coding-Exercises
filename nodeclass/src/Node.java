import java.util.Objects;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

class BinaryTree {

    private Node root;
    private boolean invalid;

    BinaryTree() {
        root = null;
    }

    void preOrderPrint() {
        StringBuilder sb = new StringBuilder();

        preOrderCollect(root, sb);
        System.out.print(sb.toString());
    }

    private void preOrderCollect(Node node, StringBuilder sb) {
        if (node == null) return;

        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(node.getValue());

        preOrderCollect(node.getLeft(), sb);
        preOrderCollect(node.getRight(), sb);
    }

    public void inOrderPrint() {
        StringBuilder sb = new StringBuilder();
        inOrderCollect(root, sb);
        System.out.print(sb.toString());
    }

    private void inOrderCollect(Node node, StringBuilder sb) {
        if (node == null) return;

        inOrderCollect(node.getLeft(), sb);

        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(node.getValue());

        inOrderCollect(node.getRight(), sb);
    }

    public void postOrderPrint() {
        StringBuilder sb = new StringBuilder();
        postOrderCollect(root, sb);
        System.out.print(sb.toString());
    }

    private void postOrderCollect(Node node, StringBuilder sb) {
        if (node == null) return;

        postOrderCollect(node.getLeft(), sb);
        postOrderCollect(node.getRight(), sb);

        if (sb.length() > 0) sb.append(' ');
        sb.append(node.getValue());
    }

    Node getRoot() {
        return root;
    }

    void setRoot(Node n) {
        root = n;
    }

    void buildTree(String repr) {
        if (repr == null || repr.trim().isEmpty()) {
            root = null;
            return;
        }

        int[] idx = {0};
        invalid = false;
        Node builtRoot = parseNode(repr, idx);
        if (invalid) {
            root = null;
        } else {
            root = builtRoot;
        }
    }

    void insert(int value) {
        if (root == null) {
            Node node = new Node();
            node.setValue(value);
            node.setLeft(null);
            node.setRight(null);
            root = node;
            return;
        }

        root = insertInto(root, value);
        return;
    }

    private Node insertInto(Node current, int value) {
        if (current == null) {
            Node node = new Node();
            node.setValue(value);
            node.setLeft(null);
            node.setRight(null);
            return node;
        }

        if (value < current.getValue()) {
            Node newLeft = insertInto(current.getLeft(), value);
            current.setLeft(newLeft);
        } else if (value > current.getValue()) {
            Node newRight = insertInto(current.getRight(), value);
            current.setRight(newRight);
        }

        return current;
    }

    Node parseNode(String s, int[] idx) {
        if (invalid) {
            return null;
        }

        skipSpaces(s, idx);

        // null child
        if (idx[0] + 4 <= s.length() && s.startsWith("null", idx[0])) {
            idx[0] += 4;
            return null;
        }

        // must start with '['
        consume('[', s, idx);
        if (invalid) return null;

        skipSpaces(s, idx);

        int value = parseInt(s, idx);

        consume(',', s, idx);
        if (invalid) return null;

        Node leftNode = parseNode(s, idx);
        if (invalid) return null;

        consume(',', s, idx);
        if (invalid) return null;

        Node rightNode = parseNode(s, idx);
        if (invalid) return null;

        consume(']', s, idx);
        if (invalid) return null;

        Node node = new Node();
        node.setValue(value);
        node.setLeft(leftNode);
        node.setRight(rightNode);
        return node;
    }

    private int parseInt(String s, int[] idx) {
        skipSpaces(s, idx);
        int sign = 1;
        if (idx[0] < s.length() && s.charAt(idx[0]) == '-') {
            sign = -1;
            idx[0]++;
        }
        int num = 0;
        while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
            num = num * 10 + (s.charAt(idx[0]) - '0');
            idx[0]++;
        }
        return sign * num;
    }

    private void skipSpaces(String s, int[] idx) {
        while (idx[0] < s.length() && Character.isWhitespace(s.charAt(idx[0]))) {
            idx[0]++;
        }
    }

    private void consume(char expected, String s, int[] idx) {
        skipSpaces(s, idx);
        if (idx[0] >= s.length() || s.charAt(idx[0]) != expected) {
            invalid = true;
            return;
        }
        idx[0]++;
    }
}

class Node {

    private int value;
    private Node left;
    private Node right;

    Node() {
        value = 0;
        left = null;
        right = null;
    }

    int getValue() {
        return value;
    }

    void setValue(int v) {
        value = v;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node n) {
        left = n;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node n) {
        right = n;
    }
}

class IsBalanced {
    public static boolean isBalanced(String treeString) {
        BinaryTree t = new BinaryTree();
        t.buildTree(treeString);

        Node r = t.getRoot();

        return checkHeight(r) != unbalanced;
    }

    final static int unbalanced = -2;
    private static int checkHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftH = checkHeight(node.getLeft());
        if (leftH == unbalanced) {
            return unbalanced;
        }

        int rightH = checkHeight(node.getRight());
        if (rightH == unbalanced) {
            return unbalanced;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return unbalanced;
        }

        return 1 + Math.max(leftH, rightH);
    }
}

class IsSymmetric {
    public static boolean isSymmetric(String treeString) {
        BinaryTree t = new BinaryTree();
        t.buildTree(treeString);

        Node r = t.getRoot();

        if (r == null) {
            return true;
        }

        return isMirror(r.getLeft(), r.getRight());
    }

    private static boolean isMirror(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.getValue() != b.getValue()) {
            return false;
        }

        return isMirror(a.getLeft(), b.getRight())
                &&
                isMirror(a.getRight(), b.getLeft());

    }
}

class GetMaxPath {
    public static int getMaxPath(String treeString) {
        BinaryTree t = new BinaryTree();
        t.buildTree(treeString);

        Node r = t.getRoot();

        if (r == null) {
            return 0;
        }

        return maxRootToLeaf(r);
    }

    private static int maxRootToLeaf(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node.getValue();
        }

        int leftSum;
        if (node.getLeft() != null) {
            leftSum = maxRootToLeaf(node.getLeft());
        } else {
            leftSum = Integer.MIN_VALUE;
        }

        int rightSum;
        if (node.getRight() != null) {
            rightSum = maxRootToLeaf(node.getRight());
        } else {
            rightSum = Integer.MIN_VALUE;
        }

        return node.getValue() + Math.max(leftSum, rightSum);
    }
}