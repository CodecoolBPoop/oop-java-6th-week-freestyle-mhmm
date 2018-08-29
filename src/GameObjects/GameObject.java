package GameObjects;

public class GameObject {
    protected GameObjectType type;
    protected int X;
    protected int Y;

    public int getX() {
        return X;
    }

    public GameObjectType getType() {
        return type;
    }

    public int getY() {
        return Y;
    }

}
