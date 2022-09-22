import processing.core.PApplet;

public class Main extends PApplet{

    public static PApplet app;
    private Cells cell;

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
        boolean alive = true;
        mitosis = new Cells[rows][columns];

        for (int row = 0; row < mitosis.length; row++){
            for (int column = 0; column < mitosis[row].length; column++){
                int w = width/columns;
                int h = height/rows;
                int x = column * w;
                int y = row * h;


                cell = new Cells(h, w, x, y, alive);
                mitosis[row][column] = cell;
                cell.spawnCells();
            }
        }

    }

    public void mouseClicked(){ //sigh i dont know why this wont work
        for (Cells cell : mitosis) {
            cell.handleClick(mouseX, mouseY);
        }

}

}


