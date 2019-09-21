package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.CheckerFillingArray;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;
import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH;

/**
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with data of the {@link Double} type with read by the {@link Reader} class object
 * encapsulated in the parent class {@link FillingArrayReadValues}.
 * The class is the heir of the {@link FillingArrayReadValues} class and implements it's contract.
 * Also implements the contract declared by the {@link FillingArrayNumbers} interface.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @see FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//todo edit doc's
public class FillingArrayReadDouble extends FillingArrayReadValues<Double> implements FillingArrayNumbers<Double> {

    /**
     * Constructs a new object of {@link FillingArrayReadDouble} class,
     * initializing an object of {@link Reader} class
     * encapsulated in the parent class to read data of the {@link Double} type to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in the parent class to read data of the {@link Double} type to fill the array.
     */
    public FillingArrayReadDouble(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object of {@link FillingArrayReadDouble} class,
     * initializing an object of {@link Reader} class
     * encapsulated in the parent class of the concrete implementation of the contract declared in the interface {@link Reading}
     * to read data of the {@link Double} type to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface
     *                to initialize an object of the {@link Reader} class encapsulated in the parent class
     *                to read data of the {@link Double} type to be fill array.
     */
    public FillingArrayReadDouble(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type
     * with read by the {@link Reader} class object.
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @throws NullPointerException If object argument is null.
     */
    @Override
    public void fill(Array<Double> array) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.fillArrayElementsEnteredDoubleNumbers(doubles);
            array.setArray(doubles);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     *
     * @param doubles The array to be filled with data of the {@link Double} type
     *                with read by the {@link Reader} class object.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(doubles)) {
            this.fillArrayElementsEnteredDoubleNumbers(doubles);
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled array with data of the {@link Double} type with read by the {@link Reader} class object.
     */
    @Override
    public Double[] fill(int lengthArray) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayElementsEnteredDoubleNumbers(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredDoubleNumbers(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @param bound The value of the bound for filling an object of the {@link Array} class with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isPositiveBound(bound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, POSITIVE_DOUBLE_BOUND);
                array.setArray(doubles);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
     *
     * @param doubles The array to be filled with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param bound   The value of the end bound for filling an array with data of the {@link Double} type
     *                with read by the {@link Reader} class object.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(doubles)) {
            if (isPositiveBound(bound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @param bound       The value of the border for filling the array with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Double} type with read by the {@link Reader} class object.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isPositiveBound(bound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, POSITIVE_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, POSITIVE_DOUBLE_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param array      The object of the {@link Array} class that must be filled with data of the {@link Double} type
     *                   with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param endBound   The value of the end bound for filling an object of the {@link Array} class with
     *                   data of the {@link Double} type with read by the {@link Reader} class object.
     * @throws NullPointerException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
                array.setArray(doubles);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                        NEGATIVE_DOUBLE_BOUND,
                        POSITIVE_DOUBLE_BOUND);
                array.setArray(doubles);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The object argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768,
     * then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param doubles    The array to be filled with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an array with data of the {@link Double} type
     *                   with read by the {@link Reader} class object.
     * @param endBound   The value of the end bound for filling an array with data of the {@link Double} type
     *                   with read by the {@link Reader} class object.
     * @throws NullPointerException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        //todo check or add relevant checks.
        if (checkNonNullArray(doubles)) {
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                        NEGATIVE_DOUBLE_BOUND,
                        POSITIVE_DOUBLE_BOUND);
            }
        } else {
            //todo consider the option of eliminating the use of exceptions in this code.
            throw new IllegalArgumentException(new NullPointerException("The array argument is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH}.
     * <p>The array is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     * or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesForFilling#NEGATIVE_DOUBLE_BOUND}
     * and {@link DefaultValuesForFilling#POSITIVE_DOUBLE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @param startBound  The value of the start bound for filling an array with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @param endBound    The value of the end bound for filling an array with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Double} type with read by the {@link Reader} class object.
     */
    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        //todo check or add relevant checks.
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (isCorrectRangeBounds(startBound, endBound) && isLowerBoundLessOrEqualThanUpperBound(startBound, endBound)) {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                        NEGATIVE_DOUBLE_BOUND,
                        POSITIVE_DOUBLE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH];
            this.fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                    NEGATIVE_DOUBLE_BOUND,
                    POSITIVE_DOUBLE_BOUND);
        }
        return doubles;
    }

    private void fillArrayElementsEnteredDoubleNumbers(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = super.getReader().readDouble();
        }
    }

    private void fillArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(Double[] doubles, double bound) {
        double value;
        for (int i = 0; i < doubles.length; i++) {
            value = super.getReader().readDouble();
            //todo fix to re-enter.
            if ((value >= START_BOUND) && (value <= bound)) {
                doubles[i] = value;
            } else {
                doubles[i] = DOUBLE_VALUE;
            }
        }
    }

    private void fillArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(Double[] doubles, double startBound, double endBound) {
        double value;
        for (int i = 0; i < doubles.length; i++) {
            //todo fix to re-enter.
            value = super.getReader().readDouble();
            if ((value >= startBound) && (value <= endBound)) {
                doubles[i] = value;
            } else {
                doubles[i] = DOUBLE_VALUE;
            }
        }
    }

}