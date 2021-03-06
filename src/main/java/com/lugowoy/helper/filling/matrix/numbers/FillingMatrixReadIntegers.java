package com.lugowoy.helper.filling.matrix.numbers;

import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerMatrix;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.matrix.FillingMatrixReadValues;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;

/**
 * <p>Created by Konstantin Lugowoy on 10.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.matrix.FillingMatrixReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.matrix.FillingMatrix
 * @see com.lugowoy.helper.filling.matrix.numbers.FillingMatrixNumbers
 * @since 1.0
 */
//TODO write documentation
public class FillingMatrixReadIntegers extends FillingMatrixReadValues
        implements FillingMatrixNumbers<Integer> {

    public FillingMatrixReadIntegers(final @NotNull Reader reader) {
        super(reader);
    }

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrix(integers);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        this.fillMatrix(matrix);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrix(integers);
        return integers;
    }

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix,
                     @NotNull final Integer bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromZeroToBound(integers, bound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix,
                     @NotNull final Integer bound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        this.fillMatrixFromZeroToBound(matrix, bound);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns,
                            @NotNull final Integer bound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkColumns(columns, Capacity.LOWER.get(),
                                   Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Integer.MAX_VALUE);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixFromZeroToBound(integers, bound);
        return integers;
    }

    @Override
    public void fill(@NotNull final Matrix<Integer> matrix,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[][] integers = new Integer[matrix.getRows()][matrix.getColumns()];
        this.fillMatrixFromLowerToUpper(integers, lowerBound, upperBound);
        matrix.setMatrix(integers);
    }

    @Override
    public void fill(@NotNull final Integer[][] matrix,
                     @NotNull final Integer lowerBound,
                     @NotNull final Integer upperBound) {
        CheckerMatrix.check(matrix, Capacity.UPPER.get(), Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillMatrixFromLowerToUpper(matrix, lowerBound, upperBound);
    }

    @Override
    public Integer[][] fill(final int rows, final int columns,
                            @NotNull final Integer lowerBound,
                            @NotNull final Integer upperBound) {
        CheckerMatrix.checkRows(rows, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerMatrix.checkRows(columns, Capacity.LOWER.get(),
                                Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Integer[][] integers = new Integer[rows][columns];
        this.fillMatrixFromLowerToUpper(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillMatrix(@NotNull final Integer[][] matrix) {
        this.fillMatrixFromLowerToUpper(matrix, Integer.MIN_VALUE,
                                        Integer.MAX_VALUE);
    }

    private void fillMatrixFromZeroToBound(@NotNull final Integer[][] matrix,
                                           final Integer bound) {
        this.fillMatrixFromLowerToUpper(matrix, BigDecimal.ZERO.intValue(),
                                        bound);
    }

    private void fillMatrixFromLowerToUpper(@NotNull final Integer[][] matrix,
                                            final Integer lowerBound,
                                            final Integer upperBound) {
        int valueRead = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (super.getReader().hasNextInt()) {
                    valueRead = super.getReader().nextInt();
                    CheckerNumber.check(valueRead, lowerBound, upperBound);
                }
                matrix[i][j] = valueRead;
            }
        }
    }

}
