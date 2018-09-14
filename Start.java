import java.util.Scanner;
public class Start
{
    public static void main(String [] args)
    {

        Headers Header = new Headers();

        Header.printHeaders();

        //Initiates the map
        System.out.println("Please select how tall the board should be (y in [x,y])");
        int mapY = getIntFromInput();
        System.out.println("Please select how long the board should be (x in [x,y])");
        int mapX = getIntFromInput();
        Map map = new Map(mapX, mapY);


        Coord coordTilSlange = new Coord();
        coordTilSlange.randCoord(map);
        Animal slange = new Animal("Snake", coordTilSlange);


        Coord coordTilKanin = new Coord();
        coordTilKanin.randCoord(map);
        Animal kanin = new Animal("Rabbit", coordTilKanin);

        while (kanin.currentCoord.getCoord() == slange.currentCoord.getCoord())
            kanin.currentCoord.randCoord(map);

        System.out.println("I am the "+kanin.getName()+", I am now standing on square "+kanin.currentCoord.getCoord());
        System.out.println("I am the "+slange.getName()+", I am now standing on square "+slange.currentCoord.getCoord());
        //kanin.move(map);
        kanin.alive = true;
        while(kanin.alive)
        {

            kanin.move(map);
            System.out.println("I am the "+kanin.getName()+", I am now standing on square "+kanin.currentCoord.getCoord());
            Update(slange, kanin);

        }
    }
    public static void Update(Animal ond, Animal god)
    {
        //Checker om slangen skal op eller ned
        if(ond.currentCoord.getY() > god.currentCoord.getY())
        {
            ond.currentCoord.decY();
        }
        else if(ond.currentCoord.getY() < god.currentCoord.getY())
        {
            ond.currentCoord.incY();
        }
        //Checker om slangen skal gå til højre eller venstre
        if(ond.currentCoord.getX() > god.currentCoord.getX())
        {
            ond.currentCoord.decX();
        }
        else if(ond.currentCoord.getX() < god.currentCoord.getX())
        {
            ond.currentCoord.incX();
        }

        System.out.println("I am the "+ond.getName()+", I am now standing on square "+ond.currentCoord.getCoord());
        //Checker om slangen er på et nabofelt
        if(
                (ond.currentCoord.getY() == god.currentCoord.getY()-1 || ond.currentCoord.getY() == god.currentCoord.getY() || ond.currentCoord.getY() == god.currentCoord.getY()+1)
                        &&
                        (ond.currentCoord.getX() == god.currentCoord.getX()-1 || ond.currentCoord.getX() == god.currentCoord.getX() || ond.currentCoord.getX() == god.currentCoord.getX()+1)
        )
        {
            System.out.println("Nooooo Please don't eat me!!");
            ond.currentCoord.setY(god.currentCoord.getY());
            ond.currentCoord.setX(god.currentCoord.getX());
            System.out.println("I am the "+ond.getName()+", I am now standing on square "+ond.currentCoord.getCoord());
            System.out.println("Ahhrrrrrr im eating you ha ha!");
            god.alive = false;

        }
    }
    //Gets input int from console
    public static int getIntFromInput()
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            String data = sc.next();
            return Integer.parseInt(data);
        }
        catch(Exception e)
        {
            //if input wasn't an int, will retry
            System.out.println("Invalid input, please use integers only");
            return getIntFromInput();
        }
    }
}
