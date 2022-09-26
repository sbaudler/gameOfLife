public class Cells {

    private int height;
    private int width;
    private int upperLeftX;
    private int upperLeftY;
    private boolean alive; //when true, square is white, when flase, square is black

    public Cells(int height, int width, int upperLeftX, int upperLeftY, boolean alive){ //boolean alive as last parameter
        this.height = height;
        this.width = width;
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.alive = alive;
    }

    public void spawnCells() {
        Main.app.rect(upperLeftX, upperLeftY, width, height);
        Main.app.stroke(0);
        if (alive) {
            Main.app.fill(255); //white
        } else {
           Main.app.fill(0); //black
        }
    }

    public void handleMouseClicked(int inputX, int inputY) { //from GripReaper interface
        if (inputX > upperLeftX && inputX < (upperLeftX + width)) {
            if (inputY > upperLeftY && inputY > (upperLeftY - height)) {
                alive = !alive;
            }
        }
    }
}
