package Characters;

public abstract class Character {
    int hitPoint;
    int damage;
    int X;
    int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }
}
