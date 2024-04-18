package simstation;


import mvc.Model;
import mvc.View;
import stopLight.StopLightShape;
import stopLight.Stoplight;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class SimulationView extends View {
    int dotSize = 5;
    private Agent myAgent;
    public SimulationView(Model model) {
        super(model);
        setSize(10,10);
        setBackground(Color.LIGHT_GRAY);

        for (int count = 0; count < ((Simulation)model).agents.size(); count ++) {
            Agent temp = ((Simulation)model).agents.get(count);
            temp.subscribe(this);
         //   System.out.println("Subscriber added");

        }
        repaint();

    }

    public void paintComponent(Graphics gc) {

        //System.out.println("hits");
        super.paintComponent(gc);
        for (int count = 0; count < ((Simulation)model).agents.size(); count ++) {
            Agent temp = ((Simulation)model).agents.get(count);
            gc.setColor(temp.getColor());
            gc.fillOval(temp.xc - dotSize / 2, temp.yx - dotSize / 2, dotSize, dotSize);

        }

    }

    public void update(){
      //  System.out.println("repainting person/thing");
        repaint();
    }

}
