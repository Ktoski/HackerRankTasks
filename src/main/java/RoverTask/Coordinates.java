package RoverTask;

import java.util.Objects;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates moveNorth(){
        y = ++y;
        return this;
    }

    public Coordinates moveEast(){
        x =  ++x;
        return this;
    }
    public Coordinates moveSouth(){
        y = --y;
        return this;
    }
    public Coordinates moveWest(){
        x = --x;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return  String.valueOf(x) + " " +String.valueOf(y);
    }
}
