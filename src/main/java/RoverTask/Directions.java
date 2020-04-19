package RoverTask;

public enum Directions {

    NORTH{
        @Override
        public Directions turnRight() {
            return Directions.EAST;
        }

        @Override
        public Directions turnLeft() {
            return Directions.WEST;
        }

        @Override
        public String toString() {
            return "N";
        }
    },
    SOUTH() {
        @Override
        public Directions turnRight() {
            return Directions.WEST;
        }

        @Override
        public Directions turnLeft() {
            return Directions.EAST;
        }

        @Override
        public String toString() {
            return "S";
        }
    },
    WEST() {
        @Override
        public Directions turnRight() {
            return Directions.NORTH;
        }

        @Override
        public Directions turnLeft() {
            return Directions.SOUTH;
        }

        @Override
        public String toString() {
            return "W";
        }
    },
    EAST() {
        @Override
        public Directions turnRight() {
            return Directions.SOUTH;
        }

        @Override
        public Directions turnLeft() {
            return Directions.NORTH;
        }

        @Override
        public String toString() {
            return "E";
        }
    };

    public abstract Directions turnRight();
    public abstract Directions turnLeft();
}
