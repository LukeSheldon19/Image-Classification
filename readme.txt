Programming Assignment: Image Classifier


/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 3

/**********************************************************************
 * Some people (especially in Europe and Latin America) write a 7     *
 * with a line through the middle, while others (especially in Japan  *
 * and Korea) make the top line crooked.                              *
 *                                                                    *
 * Suppose that the training data consists solely of samples that do  *
 * not use any of these conventions. How well do you think the        *
 * algorithm will perform when you test it on different populations?  *
 * What are the possible consequences?                                *
 **********************************************************************/

ANSWER: I think that if tested on different populations the algorithm would
not work as well, simply because the algorithm is trained with different data
so it knows only how to classify that data. After writing this program I noticed
that the training is not super flexible or accurate, so to account for different data
points we would need to include them in training. Consequences that I can think of include
misclassified data as well as errors.


/**********************************************************************
 * Now suppose that you are using a supervised learning algorithm to  *
 * diagnose cancer. Suppose the training data consists of examples    *
 * solely on individuals from population X but you use it on          *
 * individuals from population Y. What are the possible consequences? *
 **********************************************************************/

ANSWER: Some consequences could include incorrect or completely missed diagnosis, as the training data
is not catered towards population Y, so like the question above mis-classification is a very realistic possibility.



/**********************************************************************
 *  Did you receive help from classmates, past students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no? TA hours on Monday from Phoenix.




/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no? I wouldn't say serious problem, but I had trouble finalizing the extract features method.
It was an easy fix in the end all I had to do was switch the col and row variables but
it took way longer than it should have to figure that out. Sometimes it's just the smallest
details that are glossed over.




/**********************************************************************
 *  List any other comments here.
 **********************************************************************/


