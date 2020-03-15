package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_ZERO;

/**
 * Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.0
 */
//TODO write the doc's
public class FillingMatrixReadIntegers extends FillingMatrixReadValues<Integer> implements FillingMatrixNumbers<Integer> {

    public FillingMatrixReadIntegers(Reader reader) {
        super(reader);
    }

    public FillingMatrixReadIntegers(Reading reading) {
        super(reading);
    }

    @Override
    public void fill(Matrix<Integer> matrix) {
        CheckerMatrix.checkMatrix(matrix);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixReadIntegers(integers);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix) {
        CheckerMatrix.checkMatrix(matrix);
        this.fillMatrixReadIntegers(matrix);
    }

    @Override
    public Integer[][] fill(int rows, int columns) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixReadIntegers(integers);
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixReadIntegersFromZeroToBound(integers, bound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix, Integer bound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillMatrixReadIntegersFromZeroToBound(matrix, bound);
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer bound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkColumns(columns);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixReadIntegersFromZeroToBound(integers, bound);
        return integers;
    }

    @Override
    public void fill(Matrix<Integer> matrix, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(Integer[][] matrix, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkMatrix(matrix);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
    }

    @Override
    public Integer[][] fill(int rows, int columns, Integer lowerBound, Integer upperBound) {
        CheckerMatrix.checkRows(rows);
        CheckerMatrix.checkRows(columns);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillMatrixReadIntegers(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = super.getReader().readInt();
            }
        }
    }

    private void fillMatrixReadIntegersFromZeroToBound(Integer[][] matrix, int bound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, INT_ZERO, bound, i, j);
            }
        }
    }

    private void fillMatrixReadIntegersFromLowerBoundToUpperBound(Integer[][] matrix, int lowerBound, int upperBound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.assignReadValue(matrix, lowerBound, upperBound, i, j);
            }
        }
    }

    private void assignReadValue(Integer[][] matrix, int lowerBound, int upperBound, int i, int j) {
        int valueRead = super.getReader().readInt();
        if (isCorrectReadValue(valueRead, lowerBound, upperBound)) {
            matrix[i][j] = valueRead;
        } else {
            String msgEx = "Value not a double number or out of range (" + lowerBound + " - " + upperBound + ").";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

    private boolean isCorrectReadValue(int valueRead, int lowerBound, int upperBound) {
        return (valueRead >= lowerBound) && (valueRead <= upperBound);
    }

}
