package stopLight;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StoplightView extends View {

    public StoplightView(Stoplight light)
    {
        super(light);
        light.subscribe(this);
        setSize(500, 500);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.LIGHT_GRAY);
    }

    public void paintComponent(Graphics gc) {
        System.out.println("hits");
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Stoplight light = (Stoplight)model;
        StopLightShape shape = new StopLightShape(light);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }
}