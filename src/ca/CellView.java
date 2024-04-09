package ca;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState(); // changes the state of myCell
        setBackground(myCell.color);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getValue());

        update();
    }

    // called by notifySubscribers and GridView.update

    @Override
    public void update(String msg, Object oldState, Object newState) {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getValue());
        update();
    }

    @Override
    public void update() {
        System.out.println("repainting cell");
        setText("" + myCell.getValue());
        this.repaint();
    }
}


