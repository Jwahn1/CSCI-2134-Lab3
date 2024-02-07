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
    /**
    Tests functionality in the add() function in the Matrix class via black box method by adding matrices
    with both positive and negative integers values in them and checking whether the result is correct in each array
    value of the result matrix. We also test whether the function returns null values when given improper inputs.
    Our test assumes the function can handle null, negative and positive values
     */
    void add() {
        Matrix current = new Matrix(3,3);
        Matrix b = new Matrix(3,3);
        Matrix res = new Matrix(3,3);
        for(int k = -10; k<11 ;k++){

            //add values to b matrix
            for(int i = 1 ; i<= b.getHeight(); i++){
                for(int j = 1 ; j<= b.getWidth(); j++){
                    b.setElem(i,j,k);
                }
            }

            //add values to current matrix
            for(int i = 1 ; i<= b.getHeight(); i++){
                for(int j = 1 ; j<= b.getWidth(); j++){
                    current.setElem(i,j,k);
                }
            }

            res = current.add(b,res);

            double expected = k+k; // expected value after addition
            assert res != null : "the addition has failed";
            //see if the values in res are correct as expected
            for(int i = 1 ; i<= b.getHeight(); i++){
                for(int j = 1 ; j<= b.getWidth(); j++){
                    assert res.getElem(i,j) == expected : "the addition has failed";
                }
            }
        }

        //block tests whether the function returns null values when given improper inputs
        //in this case the b matrix is null
        b = null;
        for(int i = 1 ; i<= current.getHeight(); i++){
            for(int j = 1 ; j<= current.getWidth(); j++){
                current.setElem(i,j,1);
            }
        }
        res = current.add(b,res);
        assert res == null : "add() function does not return null when given incorrect inputs";
    }
    /**
    Tests functionality of the function multiplyWithScalar from the Matrix Class  via black box method by multiplying
    with both positive and negative integer and also test whether the function properly returns null when given wrong
    inputs. Our test assumes that the function can handle negative and positive inputs and values in the matrices.
     */
    @Test
    void multiplyWithScalar() {

        Matrix current = new Matrix(4,4);
        Matrix res = new Matrix (4,4);

        int const1 = 2;
        int const2 = -2;

        for(int k = -10 ; k<11; k++){

            //add values to current matrix
            for(int i = 1 ; i<= current.getHeight(); i++){
                for(int j = 1 ; j<= current.getWidth(); j++){
                    current.setElem(i,j,k);
                }
            }

            //following two blocks test the scalar multiplication with positive integers
            res = current.multiplyWithScalar(const1,res);
            double expected = k*const1;

            for(int i = 1 ; i<= current.getHeight(); i++){
                for(int j = 1 ; j<= current.getWidth(); j++){
                    assert res.getElem(i,j) == expected : "scalar multiplication failed";
                }
            }
            //following two blocks test the scalar multiplication with negative integers
            res = current.multiplyWithScalar(const2,res);
            expected = k*const2;

            for(int i = 1 ; i<= current.getHeight(); i++){
                for(int j = 1 ; j<= current.getWidth(); j++){
                    assert res.getElem(i,j) == expected : "scalar multiplication failed";
                }
            }

        }

        //make a matrix with incompatible size compare to current Matrix
        Matrix wrongSize = new Matrix(23,33);
        for(int i = 1 ; i<= wrongSize.getHeight(); i++){
            for(int j = 1 ; j<= wrongSize.getWidth(); j++){
                wrongSize.setElem(i,j,1);
            }
        }

        //create current Matrix
        for(int i = 1 ; i<= current.getHeight(); i++){
            for(int j = 1 ; j<= current.getWidth(); j++){
                current.setElem(i,j,1);
            }
        }

        //after the multiplication it will fail since the result Matrix (wrong size) is bigger than Current Matrix
        wrongSize = current.multiplyWithScalar(3,wrongSize);
        assert wrongSize == null: "multiplyWithScalar() does not return null when given improper matrix sizes";

    }
    /**
    Tests the multiplyWithMatrix function from the Matrix class via black box method
     by multiplying matrices with both negative and positive values and verifying whether the function returns null
     values when given inproper matrix sizes for multiplication.
     */
    @Test
    void multiplyWithMatrix() {
        Matrix current = new Matrix(4,4);
        Matrix res = new Matrix (4,4);
        Matrix b = new Matrix (4,4);
        Matrix wrongSize = new Matrix(5,3);

        for(int k = -10 ; k<11 ; k++ ){

            //input values into current Matrix
            for (int i = 1; i <= current.getHeight(); i++) {
                for (int j = 1; j <= current.getWidth(); j++) {
                    current.setElem(i,j,k);
                }
            }
            //input values into b Matrix
            for (int i = 1; i <= b.getHeight(); i++) {
                for (int j = 1; j <= b.getWidth(); j++) {
                    b.setElem(i,j,(k+1));
                }
            }
            //multiply b with current
            res = current.multiplyWithMatrix(b,res);
            double expected = (k*(k+1))*4;//with matrix multiplcation  here would be 4 column values times 4 rows

            //verify that each value in the matrix is as expected
            for (int i = 1; i <= res.getHeight(); i++) {
                for (int j = 1; j <= res.getWidth(); j++) {
                    assert res.getElem(i,j) == expected : "the matrix multiplication failed";
                }
            }
        }
        //test whether the inputted matrices are of compatible sizes for multiplication
        //input values into current Matrix
        for (int i = 1; i <= current.getHeight(); i++) {
            for (int j = 1; j <= current.getWidth(); j++) {
                current.setElem(i,j,1);
            }
        }
        //input values into b Matrix
        for (int i = 1; i <= wrongSize.getHeight(); i++) {
            for (int j = 1; j <= wrongSize.getWidth(); j++) {
                wrongSize.setElem(i,j,1);
            }
        }

        res = current.multiplyWithMatrix(wrongSize,res);
        assert res == null : "the function does not return a null value if multiplication is not possible";
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