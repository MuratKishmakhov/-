import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        Complex Z = new Complex(0,0);
        int i;
        for (i=0; i<MAX_ITERATIONS && Z.getPow2Abs() < 4; i++){
            Z.setPow2();
            Z.addXY(x,y);
        }
        if (i == MAX_ITERATIONS) return -1;
        return i;
    }

    public String toString() {
        return "Mandelbrot";
    }
}
