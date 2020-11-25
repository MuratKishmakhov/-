public class Complex {
    private double x,y;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPow2Abs(){
        return x*x+y*y;
    }

    public void setPow2(){
        double X = x*x-y*y;
        y=2*x*y;
        x=X;
    }

    public void setSoprPow2(){
        double X = x*x-y*y;
        y=-2*x*y;
        x=X;
    }

    public void setAbsPow2(){
        double X = x*x-y*y;
        y=2*Math.abs(x)*Math.abs(y);
        x=X;
    }

    public void addXY(double x, double y) {
        this.x += x;
        this.y += y;
    }
}
