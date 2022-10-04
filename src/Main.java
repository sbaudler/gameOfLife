import processing.core.PApplet;

public class Main extends PApplet{

    public static PApplet app;
    final int rows = 50;
    final int columns = 100;

    final int cellSize = 10;


    Cells [][] mitosis;
    public boolean doEvolve = false;

    public static void main(String[] args){PApplet.main("Main");}

    public Main(){
        app = this;
    }

    public void settings(){
        size((columns * cellSize), (rows * cellSize));
    }

    public void setup(){

        mitosis = new Cells[rows][columns];
        Rules rules = new MooreRules(new int[]{3}, new int[]{2, 3});


        for (int row = 0; row < mitosis.length; row++){
            for (int column = 0; column < mitosis[row].length; column++){
                int w = width/columns;
                int h = height/rows;
                int x = column * w;
                int y = row * h;


                Cells cell = new Cells(h, x, y, row, column, CellState.DEAD, rules);
                mitosis[row][column] = cell;
                cell.spawnCells();
            }
        }


    }

    public void draw(){
        background(0);
        for (int r = 0; r < mitosis.length; r++){
            for (int c = 0; c < mitosis[r].length; c++){
                Cells cell = mitosis[r][c];
                cell.spawnCells();
                applyRules();
                if (doEvolve) {
                    evolve();
                }
            }
        }

    }

    public void mousePressed() {
        System.out.println("okay");
        for (Cells[] cellArray : mitosis) {
            for (Cells cell : cellArray) {
                cell.handleMouseClicked(mouseX, mouseY);

            }
        }
    }

    public void keyPressed() {
        doEvolve =! doEvolve;
    }

    public void applyRules() {
        for (Cells[] cellArray : mitosis) {
            for (Cells cell : cellArray) {
                cell.applyRules(mitosis);
            }
        }
    }

    public void evolve(){
        for (Cells[] cellArray : mitosis) {
            for (Cells cell : cellArray) {
                cell.evolve();
            }
        }
    }




}







