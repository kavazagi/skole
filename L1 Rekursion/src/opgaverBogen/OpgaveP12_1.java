package opgaverBogen;

public class OpgaveP12_1 {
    private int width;
    private int height;

    public OpgaveP12_1(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        if (width <= 0) {
            return 0;
        } else if (width == 1) {
            return height;
        } else {
            OpgaveP12_1 smallRectangle = new OpgaveP12_1(this.width - 1, this.height);
            return height + smallRectangle.getArea();
        }
    }
}
