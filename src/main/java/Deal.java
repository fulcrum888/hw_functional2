public class Deal {
    private final double length;
    private final double width;
    private final double cost;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getCost() {
        return cost;
    }

    public Deal(double length, double width, double cost) {
        this.length = length;
        this.width = width;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[length=" + length + ", width=" + width + ", cost=" + cost + ']';
    }
}
