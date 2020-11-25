import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        Complex Z = new Complex(0,0);
        int i;
        for (i=0; i<MAX_ITERATIONS && Z.getPow2Abs() < 4; i++){
            Z.setSoprPow2();
            Z.addXY(x,y);
        }
        if (i == MAX_ITERATIONS) return -1;
        return i;
    }

    public String toString() {
        return "Tricorn";
    }
}
