import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Screen extends JComponent implements MouseListener, MouseMotionListener {
    //ArrayList<Circle> cs;
    ArrayList<Node> ns = new ArrayList<Node>();
    NodeArray bstFunctions = new NodeArray();
    Node current;

    public Screen() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

    }

    public void paintComponent(Graphics g) {
        for (Node n : this.ns) { n.drawChildren(g); }
        for (Node n : this.ns) { n.drawCircle(g);
            n.drawValue(g); }
    }

    public void mouseDragged(MouseEvent e) {
        if (this.current != null) {
            int x = e.getX();
            int y = e.getY();
            this.current.rep.moveTo(new Point(x, y));
            this.repaint();
            //System.out.println(this.current.toString());
        }

    }
    public void mouseMoved(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) {	}
    public void mouseEntered(MouseEvent e) {	}
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int min = 30;
        for (Node n : ns) {
            double dist = n.rep.center.distanceTo(new Point(x, y));
            if (dist <= min) {
                min = (int) dist;
                this.current = n;
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        //System.out.println(this.current.getChildren().toString());
        this.current = null; }


}
