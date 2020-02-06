package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerMatrix;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.2
 */
//todo write doc's
public class FillingMatrixRandomDoubles implements FillingMatrixNumbers<Double> {

    @Override
    public void fill(Matrix<Double> matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            this.fillMatrixRandomDoubles(doubles);
            matrix.setMatrix(doubles);
        }
    }

    @Override
    public void fill(Double[][] matrix) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            this.fillMatrixRandomDoubles(matrix);
        }
    }

    @Override
    public Double[][] fill(int rows, int columns) {
        Double[][] matrix = new Double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            matrix = new Double[rows][columns];
            this.fillMatrixRandomDoubles(matrix);
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double bound) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
                this.fillMatrixRandomDoublesFromZeroToBound(doubles, bound);
                matrix.setMatrix(doubles);
            }
        }
    }

    @Override
    public void fill(Double[][] matrix, Double bound) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                this.fillMatrixRandomDoublesFromZeroToBound(matrix, bound);
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double bound) {
        Double[][] matrix = new Double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                matrix = new Double[rows][columns];
                this.fillMatrixRandomDoublesFromZeroToBound(matrix, bound);
            }
        }
        return matrix;
    }

    @Override
    public void fill(Matrix<Double> matrix, Double lowerBound, Double upperBound) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    matrix.setMatrix(doubles);
                }
            }
        }
    }

    @Override
    public void fill(Double[][] matrix, Double lowerBound, Double upperBound) {
        if (CheckerMatrix.checkMatrix(matrix)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillMatrixRandomDoublesFromLowerBoundToUpperBound(matrix, lowerBound, upperBound);
                }
            }
        }
    }

    @Override
    public Double[][] fill(int rows, int columns, Double lowerBound, Double upperBound) {
        Double[][] doubles = new Double[0][0];
        if (CheckerMatrix.checkRows(rows) && CheckerMatrix.checkColumns(columns)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    doubles = new Double[rows][columns];
                    this.fillMatrixRandomDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillMatrixRandomDoubles(Double[][] matrix) {
        for (Double[] doubles : matrix) {
            Arrays.setAll(doubles, j -> GeneratorRandomNumber.generateDouble());
        }
    }

    private void fillMatrixRandomDoublesFromZeroToBound(Double[][] matrix, double bound) {
        for (Double[] doubles : matrix) {
            Arrays.setAll(doubles, j -> GeneratorRandomNumber.generateDouble(bound));
        }
    }

    private void fillMatrixRandomDoublesFromLowerBoundToUpperBound(Double[][] matrix, double lowerBound, double upperBound) {
        for (Double[] doubles : matrix) {
            Arrays.setAll(doubles, j -> GeneratorRandomNumber.generateDouble(lowerBound, upperBound));
        }
    }

}