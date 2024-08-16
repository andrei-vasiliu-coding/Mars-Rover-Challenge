package logic.layer;

public class PlateauSize {
    private int x;
    private int y;

    public PlateauSize(int x, int y) {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Plateau width must be a positive integer.");
        }

        if (y >= 0) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Plateau length must be a positive integer.");
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
