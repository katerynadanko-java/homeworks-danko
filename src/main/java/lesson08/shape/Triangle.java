package lesson08.shape;

public class Triangle extends Shape {
    private Point left;
    private Point right;
    private Point top;


    public Triangle(Point left, Point right, Point top) {
        this.left = left;
        this.right = right;
        this.top = top;
    }

    public Triangle(double xLeft, double yLeft, double xRight, double yRight, double xTop, double yTop) {
        this.left = new Point(xLeft, yLeft);
        this.right = new Point(xRight, yRight);
        this.top = new Point(xTop, yTop);
    }

    public double leftSide() {
        return Math.sqrt(Math.pow((top.getX() - left.getX()), 2) + Math.pow((top.getY() - left.getY()), 2));
    }

    public double rightSide() {
        return Math.sqrt(Math.pow((right.getX() - top.getX()), 2) + Math.pow((right.getY() - top.getY()), 2));
    }

    public double bottomSide() {
        return Math.sqrt(Math.pow((right.getX() - left.getX()), 2) + Math.pow((right.getY() - left.getY()), 2));
    }

    @Override
    public double square() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-leftSide())*(halfPerimeter-rightSide())*
                (halfPerimeter-bottomSide()));
    }

    @Override
    public double perimeter() {
        double per = leftSide() + rightSide() + bottomSide();
        return per;
    }

    @Override
    public void move(double dx, double dy) {
        left.setX(left.getX() + dx);
        left.setY(left.getY() + dy);
        right.setX(right.getX() + dx);
        right.setY(right.getY() + dy);
        top.setX(top.getX() + dx);
        top.setY(top.getY() + dy);
    }

    public Point getLeft() {
        return left;
    }

    public void setLeft(Point left) {
        this.left = left;
    }

    public Point getRight() {
        return right;
    }

    public void setRight(Point right) {
        this.right = right;
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "left=" + left +
                ", right=" + right +
                ", top=" + top +
                '}';
    }
}
