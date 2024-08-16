package logic.layer;

public class Position {
    private int x;
    private int y;
    private CompassDirection facing;

    public Position(int x, int y, CompassDirection facing) {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Position must be a positive integer.");
        }

        if (y >= 0) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Position must be a positive integer.");
        }

        this.facing = facing;
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

    public CompassDirection getFacing() {
        return facing;
    }

    public void setFacing(CompassDirection facing) {
        this.facing = facing;
    }

}
