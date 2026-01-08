package quiz.b;

public class SparseVector {
    private final int dimension;
    private Node head;

    public SparseVector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("La dimension debe ser positiva");
        }
        this.dimension = dimension;
        this.head = null;
    }

    public int getDimension() {
        return dimension;
    }

    public void set(int index, double value) {
        validateIndex(index);
        if (value == 0.0) {
            remove(index);
            return;
        }
        if (head == null || index < head.getIndex()) {
            head = new Node(index, value, head);
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.getIndex() < index) {
            prev = current;
            current = current.getNext();
        }
        if (current != null && current.getIndex() == index) {
            current.setValue(value);
            return;
        }
        Node node = new Node(index, value, current);
        if (prev != null) {
            prev.setNext(node);
        }
    }

    public double get(int index) {
        validateIndex(index);
        Node current = head;
        while (current != null) {
            if (current.getIndex() == index) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return 0.0;
    }

    public Node getHead() {
        return head;
    }

    private void remove(int index) {
        if (head == null) {
            return;
        }
        if (head.getIndex() == index) {
            head = head.getNext();
            return;
        }
        Node current = head.getNext();
        Node prev = head;
        while (current != null) {
            if (current.getIndex() == index) {
                prev.setNext(current.getNext());
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= dimension) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dimension: ").append(dimension).append("\n");
        sb.append("No-cero: ");
        if (head == null) {
            sb.append("(vacio)");
            return sb.toString();
        }
        Node current = head;
        while (current != null) {
            sb.append("[").append(current.getIndex()).append(", ")
                .append(current.getValue()).append("]");
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}
