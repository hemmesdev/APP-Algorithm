package nl.han.ica.app.generics;

public class Shape<T extends Shape> implements Comparable<T> {

    private int area;

    public Shape(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape o) {
        return area - o.area;
    }
}
