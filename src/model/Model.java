package model;

public class Model {
    private final ModelBoard modelBoard;
    private final ModelPawn modelPawn;

    private final int size;

    public Model(int size) {
        this.size = (size - 100) / 8;
        this.modelBoard = new ModelBoard();
        this.modelPawn = new ModelPawn(this.size);
    }

    public ModelBoard getModelBoard() {
        return this.modelBoard;
    }

    public ModelPawn getModelPawn() {
        return this.modelPawn;
    }

    public int getSize() {
        return this.size;
    }
}
