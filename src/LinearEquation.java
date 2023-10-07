class LinearEquation {
    private double x1, y1, x2, y2;
    private double slope;
    private double yIntercept;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        calculateSlope();
        calculateYIntercept();
    }

    private void calculateSlope() {
        if (x1 == x2) {
            throw new IllegalArgumentException("Slope is undefined for vertical lines.");
        }
        slope = (y2 - y1) / (x2 - x1);
    }

    public double getSlope() {
        return slope;
    }

    private void calculateYIntercept() {
        yIntercept = y1 - slope * x1;
    }

    public double getYIntercept() {
        return yIntercept;
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public String getEquationString() {
        if (slope % 1 == 0 && yIntercept % 1 == 0) {
            return "y = " + (int) slope + "x + " + (int) yIntercept;
        } else {
            return "y = " + slope + "x + " + yIntercept;
        }
    }

    public String calculateCoordinate(double x) {
        double y = slope * x + yIntercept;
        return String.format("(%.2f, %.2f)", x, y);
    }

}