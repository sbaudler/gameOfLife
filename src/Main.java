import processing.core.PApplet;

public class Main extends PApplet{

    public static PApplet app;

    public boolean alive = true;

    Cells [][] mitosis;

    public static void main(String[] args){PApplet.main("Main");}

    public Main(){
        app = this;
    }

    public void settings(){
        size(1000, 500);
    }

    public void setup(){
        int rows = 50;
        int columns = 100;
        mitosis = new Cells[rows][columns];

        for (int row = 0; row < mitosis.length; row++){
            for (int column = 0; column < mitosis[row].length; column++){
                int w = width/columns;
                int h = height/rows;
                int x = column * w;
                int y = row * h;


                Cells cell = new Cells(h, w, x, y, alive);
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
            }
        }
    }

    public void mousePressed(){
        System.out.println("okay");
        for (Cells[] cellArray : mitosis) {
            for (Cells cell : cellArray) {
               cell.handleMouseClicked(mouseX, mouseY);

            }
        }
}



}


