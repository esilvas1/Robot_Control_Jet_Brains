import java.util.Scanner;

class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {

        int fromX = robot.getX();
        int fromY = robot.getY();
        System.out.println("The current position (x,y) of the Robot is (" + robot.getX() + " , " + robot.getY() + ") and its direction is: " + robot.getDirection());

        //Movement with respect to X
        if(toX > fromX) {// Right direction
            if (robot.getDirection().equals(Direction.UP)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnLeft();
            }
            for (int i = 0; i < (toX - fromX); i++) {
                robot.stepForward();
            }
        } else if (toX < fromX) { //Left direction
            if(robot.getDirection().equals(Direction.RIGHT)){
                robot.turnLeft();
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.UP)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnRight();
            }
            for (int i = 0; i < (fromX - toX); i++) {
                robot.stepForward();
            }
        }

        //Movement with respect to Y
        if(toY > fromY) {// UP direction
            if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnLeft();
                robot.turnLeft();
            }
            for (int i = 0; i < (toY - fromY); i++) {
                robot.stepForward();
            }
        } else if (toY < fromY) { //DOWN direction
            if(robot.getDirection().equals(Direction.RIGHT)){
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.UP)) {
                robot.turnLeft();
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnLeft();
            }
            for (int i = 0; i < (fromY - toY); i++) {
                robot.stepForward();
            }
        }


        System.out.println("The final position (x,y) of the Robot is (" + robot.getX() + " , " + robot.getY() + ") and its direction is: " + robot.getDirection());

    }

    public static void main(String[] args){
        //Initial position
        Robot robot = new Robot(-10,-20,Direction.UP);
        //Final position
        Move.moveRobot(robot,-3,8);
        }


}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
