package nl.han.ica.app.generics;

//https://stackoverflow.com/a/47237419
public class Square extends Shape<Square> {

    public Square(int area) {
        super(area);
    }

    @Override
    public int compareTo(Square other) {
        return super.getArea() - other.getArea();
    }
}