import java.awt.*;

public class Circle {

    Point center;
    Point drawPoint;
    int d = 30;
    int r = 15;


    public Circle(int x, int y) {
        this.center = new Point(x, y);
        this.drawPoint = new Point(center.x - r, center.y - r);
    }

    public Point drawingPoint(Point c) {
        return new Point(c.x - r, c.y - r);
    }


    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(this.drawPoint.x, this.drawPoint.y, d, d);
        g.setColor(Color.BLACK);
        g.drawOval(this.drawPoint.x, this.drawPoint.y, d, d);
    }

    public void moveTo(Point toHere) {
        this.center = toHere;
        this.drawPoint = this.drawingPoint(this.center);
    }

}



