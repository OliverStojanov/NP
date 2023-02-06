package Lab2.Zad3;

import java.util.Arrays;

public class MovablesCollection {
    Movable [] movable;
    static int x_MAX=0;
    static int y_MAX=0;

    public MovablesCollection(int x_MAX, int y_MAX) {
        this.x_MAX = x_MAX;
        this.y_MAX = y_MAX;
        movable = new Movable[0];
    }

    public static void setxMax(int x_MAX) {
        MovablesCollection.x_MAX = x_MAX;
    }

    public static void setyMax(int y_MAX) {
        MovablesCollection.y_MAX = y_MAX;
    }

    void addMovableObject(Movable m) throws MovableObjectNotFittableException{
        if(m.typeOf() == TYPE.CIRCLE){
            if(m.getCurrentXPosition() +((MovableCircle) m).getRadius() > x_MAX || m.getCurrentXPosition() - ((MovableCircle) m).getRadius() < 0 || m.getCurrentYPosition() +((MovableCircle) m).getRadius() > y_MAX || m.getCurrentYPosition() - ((MovableCircle) m).getRadius() < 0){
                throw new MovableObjectNotFittableException(m);
            }
        }
        if(m.getCurrentXPosition() > x_MAX || m.getCurrentXPosition() < 0 || m.getCurrentYPosition() > y_MAX || m.getCurrentYPosition() < 0){
            throw new MovableObjectNotFittableException(m);
        }
        movable = Arrays.copyOf(movable,movable.length + 1);
        movable[movable.length -1] = m;
    }
    void moveObjectsFromTypeWithDirection (TYPE type, DIRECTION direction){
        for (Movable m : movable){
            if(m.typeOf() == type){
                try{
                    if(direction == DIRECTION.UP){
                        m.moveUp();
                    }else if(direction == DIRECTION.DOWN){
                        m.moveDown();
                    }else if(direction == DIRECTION.LEFT){
                        m.moveLeft();
                    }else if(direction == DIRECTION.RIGHT){
                        m.moveRight();
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Collection of movable objects with size " + movable.length +":\n");
        for (Movable m : movable){
            stringBuilder.append(m.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
