package quiz.b;

public class Node {
    private int index;
    private double value;
    private Node next;

    public Node(int index, double value, Node next) {
        this.index = index;
        this.value = value;
        this.next = next;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
