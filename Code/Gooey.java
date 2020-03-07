import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gooey extends JFrame implements ActionListener {
    JTextField t;
    JLabel l;
    Screen screen = new Screen();
    NodeArray bstFunctions = new NodeArray();

    public Gooey() {

        this.t = new JTextField( );
        t.setPreferredSize( new Dimension(60, 20) );
        this.l = new JLabel("Binary Search Tree GUI");
        JButton add = new JButton("Add");
        JButton sub = new JButton("Remove");
        JButton restart = new JButton("Reset Tree");

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bstFunctions.addNode(screen.ns, Integer.parseInt(t.getText()));
                repaint();
            }});

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bstFunctions.subNode(screen.ns, Integer.parseInt(t.getText()));
                repaint();
            }});

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (screen.ns.size() > 0) {
                    screen.ns.remove(0);
                    repaint();
                }
                bstFunctions.size = 0;
                repaint();
            }});

        JPanel contain = new JPanel();

        contain.setLayout(new BorderLayout()); //get them to line up downwards

        JPanel p = new JPanel(); // brings the flow layout with it
        p.add(this.l);
        p.add(this.t);
        p.add(add);
        p.add(sub);
        p.add(restart);



        contain.add(p, BorderLayout.PAGE_START);
        contain.add(screen, BorderLayout.CENTER);
        this.add(contain);
        //this.setVisible(true);
        //this.setSize(400, 50);
    }
    public void actionPerformed(ActionEvent e) {
        this.l.setText( this.t.getText() );
    }
    public static void main(String[] args) {
        JFrame a = new Gooey();
    }
}