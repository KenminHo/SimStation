package ca;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = this.makeCell(true);
                cell.row = row;
                cell.col = col;
                cells[row][col] = cell;
            }
        }
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].neighbors = getNeighbors(cells[row][col], 1);
            }
        }
        this.notifySubscribers();
    }

    // called when Populate button is clicked
        public void repopulate(boolean randomly) {
        for (int row = 0; row < dim; row++) {
            System.out.println("repopulating");
            for (int col = 0; col < dim; col++) {
                    System.out.printf("reset: %b \n", randomly);
                    cells[row][col].reset(randomly);
            }
        }

        this.notifySubscribers();

    }

    public Set<Cell> getNeighbors(Cell asker, int radius) {
        Set<Cell> neighbors = new HashSet<>();
        for (int row = asker.row - radius; row <= asker.row + radius; row++) {
            int tempRow = row >= 0 ? row : dim + row;
            tempRow = tempRow <= dim - 1  ? tempRow : -dim + tempRow;
            for (int col =  asker.col - radius; col <= asker.col + radius; col++){
                int tempCol = col >= 0 ? col : dim + col;
                tempCol = tempCol <= dim - 1 ? tempCol :  -dim + tempCol;
                if (asker.row == tempRow && asker.col == tempCol) {
                }
                else {
                neighbors.add(cells[tempRow][tempCol]);
                }
            }
        }
        System.out.println("NEIGHBORS SIZE: " + neighbors.size());
        return neighbors;
    }

    // overide these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
            }
        }
    }

    public void interact() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
    }

    public void update() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].update();

            }
        }
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            notifySubscribers();
            // System.out.println("time = " + time);
        }
    }
}
