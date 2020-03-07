import java.util.ArrayList;

public class NodeArray {
    int size;

    public ArrayList<Node> addNode(ArrayList<Node> nodes, int value) {

        if (nodes.size() == 0) {
            Node nN = new Node(new Circle(285, 20), value, 0);
            nodes.add(nN);
            ++this.size; }

        else {
            int lr = this.findParent(nodes, value);
            System.out.println(lr);
            if (lr == 0) {
                Node nN;
                if (value >= nodes.get(0).value) { nN = new Node(new Circle(435, 50), value, this.size); }
                else { nN = new Node(new Circle(135, 50), value, this.size); }
                ++this.size;
                nodes.add(nN);
            }
            else {
                int xLoc = nodes.get(Math.abs(lr)).rep.center.x;
                int yLoc = nodes.get(Math.abs(lr)).rep.center.y;
                if (lr < 0) {
                    Node nN;
                    if (xLoc < 300) { nN = new Node(new Circle(xLoc / 2, yLoc + 30), value, this.size); }
                    else { nN = new Node(new Circle((xLoc - 300) / 2 + 300, yLoc + 30), value, this.size); }
                    nodes.add(nN);
                    ++this.size;
                }
                else if (lr > 0) {
                    Node nN;
                    if (xLoc >= 300) { nN = new Node(new Circle(600 - ((600 - xLoc) / 2), yLoc + 30), value, this.size); }
                    else { nN = new Node(new Circle(xLoc + ((300 - xLoc) / 2), yLoc + 30), value, this.size); }
                    nodes.add(nN);
                    ++this.size; } } }
        nodes = this.organize(nodes);
        return nodes;
    }

    public ArrayList<Node> organize(ArrayList<Node> nodes) {
        Node tracker;
        nodes = this.resetChildren(nodes);
        for (int i = 0; i < nodes.size(); ++i) {
            Node currNode = nodes.get(i);
            if (i == 0) continue;
            else if (i == 1) {
                tracker = nodes.get(0);
                tracker.addChild(currNode);
                nodes.set(0, tracker);
            }
            else {
                tracker = nodes.get(0);
                int pTrack;
                do {
                    System.out.println(tracker.toString());
                    pTrack = tracker.p;
                    tracker = tracker.getChild(currNode);
                } while (tracker.checkP(pTrack));
                // tracker.addChild(nodes.get(i));
                System.out.println("Setting " + tracker.toString() + " to position " + pTrack);
                nodes.set(tracker.p, tracker);
                nodes.set(currNode.p, currNode);
            } }
        return nodes;	}

    public ArrayList<Node> resetChildren(ArrayList<Node> nodes) {
        for (Node node : nodes) {
            node.leftChild = null;
            node.rightChild = null;
            nodes.set(node.p, node);
        }
        return nodes;
    }

    public int findParent(ArrayList<Node> nodes, int target) {
        Node tracker = nodes.get(0);
        do {
            if (target >= tracker.value) {
                if (tracker.hasRightChild()) tracker = tracker.getRightChild();
                else return tracker.p; }
            else {
                if (tracker.hasLeftChild()) tracker = tracker.getLeftChild();
                else return -tracker.p; }
        } while (true);	}

    public ArrayList<Node> subNode(ArrayList<Node> nodes, int value) {
        for (int i = 0; i < this.size; i++ ) {
            System.out.println(nodes.get(i));
            if (nodes.get(i).value == value) {
                nodes.remove(i);
                break;
            }
        }
        int lastP = 0;
        int p;
        this.size = 0;
        for (Node node : nodes) {
            p = node.p;
            while (p - lastP > 1) {
                node.p = node.p - 1;
                p = node.p;
            }
            node.leftChild = null;
            node.rightChild = null;
            lastP = p;
            ++size;
        }
        nodes = this.organize(nodes);
        return nodes;
    }


    public ArrayList<Node> restartTree(ArrayList<Node> nodes) {
        this.size = 0;
        return new ArrayList<Node>();
    }
}