public class MultiPerceptron {

    private int m;
    //instance variable m for number of classes
    private int n;
    //instance variable n for the number of inputs
    private Perceptron[] perceptrons;
    //instance variable perceptrons which hols m perceptrons

    public MultiPerceptron(int m, int n) {
        this.m = m;
        this.n = n;

        this.perceptrons = new Perceptron[m];
        for (int i = 0; i < perceptrons.length; i++) {
            perceptrons[i] = new Perceptron(n);
        }//end for
    }//end constructor, which initializes m and n, as well as the perceptrons array

    public int numberOfClasses() {
        return m;
    }//returns number of classes m

    public int numberOfInputs() {
        return n;
    }//returns number of inputs n


    //how to access weights array without getter?
    public int predictMulti(double[] x) {

        int index = 0;
        double larg_val = perceptrons[0].weightedSum(x);

        for (int i = 0; i < perceptrons.length; i++) {
            if (perceptrons[i].weightedSum(x) > larg_val) {
                larg_val = perceptrons[i].weightedSum(x);
                index = i;
            }//end if
        }//end for

        return index;

    }//predictMulti takes the argument x, returning the index of the perceptron with the greatest weighted sum given input array x

    public void trainMulti(double[] x, int label) {

        //int pred_index = predictMulti(x);

        for (int i = 0; i < perceptrons.length; i++) {

            if (i == label) {
                perceptrons[label].train(x, 1);
            }
            else {
                perceptrons[i].train(x, -1);
            }
        }
    }//trainMulti method takes the labeled input arguments x and label, adjusting the individual perceptrons based on the label given


    public String toString() {
        String output = "(";
        for (int i = 0; i < perceptrons.length; i++) {
            if (i != (perceptrons.length - 1)) {
                output += perceptrons[i] + ", ";
            }
            else {
                output += perceptrons[i] + ")";
            }
        }
        return output;
    }//end toString, which creates a string representation for the perceptron object


    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        double[] training1 = { 5.0, -4.0, 3.0 };
        double[] training2 = { 2.0, 3.0, -2.0 };
        double[] training3 = { 4.0, 3.0, 2.0 };
        double[] training4 = { -6.0, -5.0, 7.0 };
        MultiPerceptron perceptron = new MultiPerceptron(m, n);
        StdOut.println(perceptron);
        perceptron.trainMulti(training1, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training2, 0);
        StdOut.println(perceptron);
        perceptron.trainMulti(training3, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training4, 0);
        StdOut.println(perceptron);
    }
}
