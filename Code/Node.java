import java.awt.*;
import java.util.ArrayList;

public class Node {
    Circle rep;
    int value;
    int p;
    Node leftChild = null;
    Node rightChild = null;
    ArrayList<Node> children = new ArrayList<Node>();


    public Node(Circle c, int v, int p) {
        this.rep = c;
        this.value = v;
        this.p = p;
    }

    public ArrayList<Node> getChildren() {
        this.children = new ArrayList<Node>();
        //if (!(leftChild.checkP(p))) leftChild = null;
        //if (!(rightChild.checkP(p))) rightChild = null;
        this.children.add(leftChild);
        this.children.add(rightChild);
        return this.children;
    }

    public Boolean hasLeftChild() {
        Boolean tf;
        if (this.leftChild == null) tf = false;
        else tf = true;
        return tf;
    }

    public Boolean hasRightChild() {
        Boolean tf;
        if (this.rightChild == null) tf = false;
        else tf = true;
        return tf;
    }
    public Node getRightChild() {
        return this.rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Boolean hasChildren() {
        Boolean tf;
        if (this.hasLeftChild() || this.hasRightChild()) tf = true;
        else tf = false;
        return tf;
    }


    public void addChild(Node notThis) {
        if (this.value > notThis.value) this.leftChild = notThis;
        else this.rightChild = notThis;
        this.getChildren();
    }


    public void drawChildren(Graphics g) {
        if (leftChild != null) {
            g.setColor(java.awt.Color.BLUE);
            g.drawLine(this.rep.center.x, this.rep.center.y, leftChild.rep.center.x, leftChild.rep.center.y);
        }
        if (rightChild != null) {
            g.setColor(java.awt.Color.RED);
            g.drawLine(this.rep.center.x, this.rep.center.y, rightChild.rep.center.x, rightChild.rep.center.y);
        }
    }

    public void drawCircle(Graphics g) {
        this.rep.draw(g);
    }

    public void drawValue(Graphics g) {
        g.setColor(java.awt.Color.BLACK);
        g.drawString("" + value, this.rep.center.x - 5, this.rep.center.y + 5);
    }

    public String toString() {
        String str = "Node: " + this.value + ", " + this.p + ", " + this.hasLeftChild() + ", " + this.hasLeftChild();
        //System.out.println(str);
        return str;
    }

    public Node getChild(Node other) {
        if (other.value >= this.value) { //For if the value of the node is greater or equal to current node
            if (this.hasRightChild() == true) return this.rightChild; //if it has a greater than kid
            else {
                this.addChild(other);
                return this; } }
        else { //For if the value of the node is less than current node
            if (this.hasLeftChild() == true) return this.leftChild; //if it has a less than kid
            else {
                this.addChild(other);
                return this; } } }
    public Boolean checkP(int ppp) {
        if (this.p == ppp) return false;
        else return true;
    }
}
