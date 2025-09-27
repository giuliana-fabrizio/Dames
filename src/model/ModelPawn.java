package model;

public class ModelPawn {
    private final double radius;

    public ModelPawn(int pawnSize) {
        this.radius = pawnSize / 3;
    }

    public double getRadius() {
        return this.radius;
    }
}
