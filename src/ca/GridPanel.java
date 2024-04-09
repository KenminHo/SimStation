package ca;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
        public GridPanel(GridFactory factory) {
            super(factory);
            ControlPanel.setLayout(new GridLayout(2,2,10, 75));

            // Create and add the buttons
            JButton change = new JButton("RUN1");
            change.addActionListener(this);
            ControlPanel.add(change);

            change = new JButton("RUN50");
            change.addActionListener(this);
            ControlPanel.add(change);

            change = new JButton("POPULATE");
            change.addActionListener(this);
            ControlPanel.add(change);

            change = new JButton("CLEAR");
            change.addActionListener(this);
            ControlPanel.add(change);
        }
}

