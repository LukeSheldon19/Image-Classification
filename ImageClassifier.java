import java.awt.Color;

public class ImageClassifier {

    public static double[] extractFeatures(Picture picture) {

        int width = picture.width();
        int height = picture.height();

        double[] pix_color = new double[width * height];

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {

                Color c_current = picture.get(col, row);
                pix_color[(row * width) + col] = c_current.getBlue();
            }//end for 2
        }//end for 1

        return pix_color;
    }//end extractFeatures

    private static void train(In training, MultiPerceptron mp) {

        while (!training.isEmpty()) {

            String file_path = training.readString();
            int label = training.readInt();
            Picture training_pic = new Picture(file_path);

            mp.trainMulti(extractFeatures(training_pic), label);


        }
    }

    private static void test(In testing, MultiPerceptron mp, int m, int h, int w) {

        int x = testing.readInt();//num of classes
        int h1 = testing.readInt();// height
        int w1 = testing.readInt();// width

        if (x != m) {
            System.out.println("Not a valid number of classes");
            //num_error++;
            return;
        }
        if (h != h1 || w != w1) {
            System.out.println("Incorrect dimensions");
            //num_error++;
            return;
        }

        int tot_tests = 0;
        int num_error = 0;

        while (!testing.isEmpty()) {

            tot_tests++;

            String file_path = testing.readString();
            Picture new_pic = new Picture(file_path);

            int label = testing.readInt();

            int pred_label = mp.predictMulti(extractFeatures(new_pic));

            if (pred_label != label) {
                System.out.println(file_path + "label: " + label + " predicted: " + pred_label);
                num_error++;
            }
        }

        double print_val = (num_error * 1.0) / (tot_tests * 1.0);

        System.out.println("test error rate = " + print_val);


        //m = testing.read int
        //test size m and h =

        //2 vals tot tests accumulated errors
        //while testing not empty tot tests predictmulti
        //in the loop printing file of mismatched label to prediction add 1 to accumulated errots
        //print double of testing error error/total


    }


    public static void main(String[] args) {

        In in_training = new In(args[0]);

        In in_testing = new In(args[1]);

        //if (args.length != 1) {
        //In in_testing = new In(args[1]);
        //}

        int m = in_training.readInt();
        int h = in_training.readInt();
        int w = in_training.readInt();

        //int m = 10;
        //int h = 28;
        //int w = 28;

        MultiPerceptron new_obj = new MultiPerceptron(m, (h * w));

        train(in_training, new_obj);

        test(in_testing, new_obj, m, h, w);


        //int x = new_obj.predictMulti()

    }
}

