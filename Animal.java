import java.util.Scanner;

public class Animal {
    private String name;
    public Coord currentCoord;
    public boolean alive;

    public Animal(String name, Coord currentCoord) {
        this.name = name;
        this.currentCoord = currentCoord;
    }

    public String getName() {
        return this.name;
    }

    public void move(Map map) {
        char whereToMove = getFirstChar();
        int prevX = currentCoord.getX(), prevY = currentCoord.getY();
        switch (whereToMove) {
            case 'b':
                //System.out.println("Moving down");
                currentCoord.decY();
                break;
            case 't':
                //System.out.println("Moving up");
                currentCoord.incY();
                break;
            case 'f':
                //System.out.println("Moving left");
                currentCoord.decX();
                break;
            case 'h':
                //System.out.println("Moving right");
                currentCoord.incX();
                break;
            case 'v':
                //System.out.println("Moving down-left");
                currentCoord.decX();
                currentCoord.decY();
                break;
            case 'n':
                //System.out.println("Moving down-right");
                currentCoord.incX();
                currentCoord.decY();
                break;
            case 'r':
                //System.out.println("Moving up-left");
                currentCoord.decX();
                currentCoord.incY();
                break;
            case 'y':
                //System.out.println("Moving up-right");
                currentCoord.incX();
                currentCoord.incY();
                break;
            default:
                //System.out.println("invalid input");
                break;
        }
        if (currentCoord.getY() > map.getY() || currentCoord.getX() > map.getX() || currentCoord.getY() < 1 || currentCoord.getX() < 1) {
            System.out.println(this.name + ": there's a wall there.");
            currentCoord.setY(prevY);
            currentCoord.setX(prevX);
        }
    }

    public char getFirstChar() {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        return data.charAt(0);
    }
}
