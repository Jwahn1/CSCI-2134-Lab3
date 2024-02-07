import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Test failure record:
 * 1.   [Name of test method]  [Method that failed]   [Notes]
 * 2.
 * 3.
 * 4.
 * 5.
 *  ...
 */
class MatrixTest {

    @Test
    void testEquals() {
    }

    @Test
    void negate() {
    }

    @Test
    void add() {
        Matrix current = new Matrix(3,3);
        Matrix b = new Matrix(3,3);
        Matrix res = new Matrix(3,3);
        for(int k = -10; k<11 ;k++){

            //add values to b matrix
            for(int i = 1 ; i< b.getHeight(); i++){
                for(int j = 1 ; j< b.getWidth(); j++){
                    b.setElem(i,j,k);
                }
            }

            //add values to current matrix
            for(int i = 1 ; i< b.getHeight(); i++){
                for(int j = 1 ; j< b.getWidth(); j++){
                    current.setElem(i,j,k);
                }
            }

            res = current.add(b,res);

            double expected = k+k;
            assert res != null : "the addition has failed";
            //see if the values in res are correct as expected
            for(int i = 1 ; i< b.getHeight(); i++){
                for(int j = 1 ; j< b.getWidth(); j++){
                    assert res.getElem(i,j) == expected : "the addition has failed";
                }
            }
        }

        b = null;
        for(int i = 1 ; i< current.getHeight(); i++){
            for(int j = 1 ; j< current.getWidth(); j++){
                current.setElem(i,j,1);
            }
        }
        res = current.add(b,res);
        assert res == null : "add() function does not return null when given incorrect inputs";
    }

    @Test
    void multiplyWithScalar() {
    }

    @Test
    void multiplyWithMatrix() {
    }

    @Test
    void getElem() {
    }

    @Test
    void setElem() {
    }

    @Test
    void getHeight() {
    }

    @Test
    void getWidth() {
    }
}