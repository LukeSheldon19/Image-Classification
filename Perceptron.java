public class Perceptron {

    private int n;
    //instance variable number of inputs
    private double[] weights;
    //instance variable containing weight vector

    public Perceptron(int n) {
        this.n = n;
        this.weights = new double[n];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = 0;
        }//end for
    }//end constructor - initializes private int n and private double[] weights, filling the array with value 0

    public int numberOfInputs() {
        return n;
    }//returns the number of inputs n

    public double weightedSum(double[] x) {//assume length x == lemngth weights

        double weight_sum = 0.0;

        for (int i = 0; i < x.length; i++) {

            weight_sum += (weights[i] * x[i]);
        }//end for

        return weight_sum;
    }//weightedSum method takes the input argument x, returning the compiled weighted sum of the perceptron

    public int predict(double[] x) {

        double pn = weightedSum(x);

        if (pn > 0) {
            return 1;
        }//end if
        else {
            return -1;
        }//end else
    }//predict method takes the input argument x and returns the predicted value of the given perceptron

    public void train(double[] x, int label) {

        int lab_x = predict(x);

        if (label > lab_x) {//false negative
            for (int i = 0; i < x.length; i++) {
                weights[i] = weights[i] + x[i];
            }//end for
        }//end if
        else if (label < lab_x) {//false positive
            for (int i = 0; i < x.length; i++) {
                weights[i] = weights[i] - x[i];
            }//end for
        }//end else if
    }//train method takes the labeled input arguments x and label, comparing to the predicted label and adjusting the new weight values

    public String toString() {
        String output = "(";
        for (int i = 0; i < weights.length; i++) {
            if (i != (weights.length - 1)) {
                output += weights[i] + ", ";
            }//end if
            else {
                output += weights[i] + ")";
            }//end else
        }//end for
        return output;
    }//end toString, which creates a string representation for the perceptron object


    public static void main(String[] args) {
        double[] training1 = { 5.0, -4.0, 3.0 }; // yes
        double[] training2 = { 2.0, 3.0, -2.0 }; // no
        double[] training3 = { 4.0, 3.0, 2.0 }; // yes
        double[] training4 = { -6.0, -5.0, 7.0 }; // no
        int n = 3;
        Perceptron perceptron = new Perceptron(n);
        StdOut.println(perceptron);
        perceptron.train(training1, +1);
        StdOut.println(perceptron);
        perceptron.train(training2, -1);
        StdOut.println(perceptron);
        perceptron.train(training3, +1);
        StdOut.println(perceptron);
        perceptron.train(training4, -1);
        StdOut.println(perceptron);
    }//end main
}//end Perceptron Class

