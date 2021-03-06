package com.lugowoy.helper.filling.matrix.numbers.primitives;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.filling.matrix.numbers.primitives.FillingMatrixDoublePrimitives;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * <p>Created by Konstantin Lugowoy on 22.11.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.matrix.FillingMatrixReadValues
 * @since 3.0
 */
//TODO write documentation
public class FillingMatrixReadPrimitiveDoubles extends FillingMatrixReadValues
        implements FillingMatrixDoublePrimitives {

    public FillingMatrixReadPrimitiveDoubles(final @NotNull Reader reader) {
        super(reader);
    }

    @Override
    public void fill(@NotNull final MatrixDoubles matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(doubles);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final double[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    @Override
    public double[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        double[][] matrix = new double[rows][columns];
        this.fillMatrix(matrix);
        return matrix;
    }

    @Override
    public void fill(@NotNull final MatrixDoubles matrix, final double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(doubles, bound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final double[][] matrix, final double bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    @Override
    public double[][] fill(final int rows, final int columns,
                           final double bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkRows(columns, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        double[][] matrix = new double[rows][columns];
        this.fillMatrixFromZeroToBound(matrix, bound);
        return matrix;
    }

    @Override
    public void fill(@NotNull final MatrixDoubles matrix,
                     final double lowerBound, final double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[][] doubles = new double[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        matrix.setMatrix(doubles);
    }

    @Override
    public void fill(@NotNull final double[][] matrix, final double lowerBound,
                     final double upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    @Override
    public double[][] fill(final int rows, final int columns,
                           final double lowerBound, final double upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        double[][] doubles = new double[rows][columns];
        this.fillMatrixFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillMatrix(final double[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(final double[][] matrix,
                                           final double bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.doubleValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(final double[][] matrix,
                                            final double lowerBound,
                                            final double upperBound) {
        double valueRead = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (super.getReader().hasNextDouble()) {
                    valueRead = super.getReader().nextDouble();
                    CheckerNumber.check(valueRead, lowerBound, upperBound);
                }
                matrix[i][j] = valueRead;
            }
        }
    }

}
