import java.util.Random;

public class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord() {
    }

    //Setters for x & y
    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    //Getters for x & y
    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    //increment & decrement functions for x & y
    public void decY() {
        this.y--;
    }

    public void incY() {
        this.y++;
    }

    public void decX() {
        this.x--;
    }

    public void incX() {
        this.x++;
    }

    public void randCoord(Map map) {
        Random rn = new Random();
        this.x = rn.nextInt(map.getX()) + 1;
        this.y = rn.nextInt(map.getY()) + 1;
    }

    public void printCoord() {
        System.out.println("Coordinates are [" + x + ", " + y + "]");
    }

    public String getCoord() {
        return x + ", " + y;
    }
}
