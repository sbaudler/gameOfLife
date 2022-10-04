public class Cells {

    private int size;
    private int upperLeftX;
    private int upperLeftY;

    private int row;

    private int column;


    //private boolean alive; //when true, square is white, when flase, square is black

    private CellState cellState;

    private Rules rules;



    public Cells(int size, int upperLeftX, int upperLeftY, int row, int column, CellState cellState, Rules rules){ //boolean alive as last parameter
        this.size = size;
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.row = row;
        this.column = column;
        this.cellState = cellState;
        this.rules = rules;
    }

    public void spawnCells() {
        if (cellState == CellState.DEAD || cellState == CellState.WILL_REVIVE) {
            Main.app.fill(255); //white
        } else if  (cellState == CellState.ALIVE || cellState == CellState.WILL_DIE){
            Main.app.fill(0); //black
        }
        Main.app.rect(upperLeftX, upperLeftY, size, size);
        Main.app.stroke(0);

    }

    public void handleMouseClicked(int inputX, int inputY) { //from GripReaper interface
        if (inputX > upperLeftX && inputX < (upperLeftX + size) &&
                inputY > upperLeftY && inputY < (upperLeftY + size)){
            if (cellState == CellState.ALIVE){
                cellState = CellState.DEAD;
                } else {
                        cellState = CellState.ALIVE;
                }
            }
        spawnCells();
        }

    public void applyRules(Cells[][] cells){
        int liveNeighbors = countLiveNeighbors(cells);
        cellState = rules.applyRules(cellState, liveNeighbors);
    }

    private int countLiveNeighbors(Cells[][] cells){
        int cln = 0;

        if (row < 48 && row > 0 && column < 98 && column > 0) {

            if (cells[row - 1][column - 1].cellState == CellState.ALIVE || cells[row - 1][column - 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row - 1][column].cellState == CellState.ALIVE || cells[row - 1][column].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row - 1][column + 1].cellState == CellState.ALIVE || cells[row - 1][column + 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row][column - 1].cellState == CellState.ALIVE || cells[row][column - 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row][column + 1].cellState == CellState.ALIVE || cells[row][column + 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row + 1][column - 1].cellState == CellState.ALIVE || cells[row + 1][column - 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row + 1][column].cellState == CellState.ALIVE || cells[row + 1][column].cellState == CellState.WILL_DIE) {
                cln++;
            }
            if (cells[row + 1][column + 1].cellState == CellState.ALIVE || cells[row + 1][column + 1].cellState == CellState.WILL_DIE) {
                cln++;
            }
        }
        return cln;


        /*
            float count = Main.app.random(7);
            int cln = (int) count;

            return cln;
            */

    }

    public void evolve(){
        if (cellState == CellState.WILL_REVIVE){
            cellState = CellState.ALIVE;
        } else if (cellState == CellState.WILL_DIE){
            cellState = CellState.DEAD;
        }
    }






}
