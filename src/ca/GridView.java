package ca;

import javax.swing.*;

import mvc.*;
import stopLight.StopLightShape;
import stopLight.Stoplight;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import java.awt.*;

public class GridView  extends View {

    private CellView[][] cellViews;


    public GridView(Model model) {
        super(model);
        cellViews = new CellView[((Grid)model).dim][((Grid)model).dim];

        this.setLayout((new GridLayout(((Grid)model).dim, ((Grid)model).dim)));

        for (int row = 0; row < ((Grid)model).dim; row++) {
            for (int col = 0; col < ((Grid)model).dim; col++) {
                CellView cell = new CellView(((Grid)model).getCell(row, col));
                cellViews[row][col] = cell;
                add(cell);
                cell.update();
            }
        }

        repaint();
    }

    //shu
    public void update(String msg, Object oldState, Object newState) {
        System.out.print("Fuck");
        update();
    }

    public void update() {
        for (int row = 0; row < ((Grid) model).getDim(); row++) {
            for (int col = 0; col < ((Grid) model).getDim(); col++) {
                CellView cellView = cellViews[row][col];
                Cell cell = ((Grid) model).getCell(row, col);
                cellView.setBackground(cell.getColor());
                cellView.setText(Integer.toString(cell.getValue()));
                cellView.repaint();
            }
        }
    }

    public void paintComponent() {

    }
}