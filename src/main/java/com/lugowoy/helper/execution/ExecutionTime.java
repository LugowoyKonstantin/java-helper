package com.lugowoy.helper.execution;

import com.lugowoy.helper.checkers.CheckerNumber;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * The class provides functionality for calculating the execution time of a
 * task.<br> The start time of the task in milliseconds, and the end time are
 * indicated, and the result is the value of the difference in milliseconds.
 * When creating an object of this class, its attributes the start and
 * end times are initialized with the value 0. To indicate the start of the run
 * time, one of the setters must be called to set the start time.
 * To end the run time, you also need to call the corresponding setter.
 * To get the result, namely the difference between the end time
 * and the start time, can be obtained by calling the {@link
 * ExecutionTime#calculateExecutionTime()} method.
 * <p>
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.7.8
 */
public class ExecutionTime {

    private long startMillis = 0L;
    private long endMillis = 0L;

    /**
     * Set the start time in milliseconds.<br> The start value in milliseconds
     * is taken from the method {@link System#currentTimeMillis()} call.
     */
    public void setStartTime() {
        this.startMillis = System.currentTimeMillis();
    }

    /**
     * Set the start time in milliseconds.<br> The start value in milliseconds
     * is taken from the {@code milliseconds} argument.
     *
     * @param milliseconds the start time in milliseconds.
     *
     * @throws IllegalArgumentException if the {@code milliseconds} argument
     * value is negative.
     */
    public void setStartTime(final long milliseconds) {
        if (CheckerNumber.isPositive(milliseconds)
                            || CheckerNumber.isZero(milliseconds)) {
            this.startMillis = milliseconds;
        } else {
            throw new IllegalArgumentException(
                            "Negative value of the argument in milliseconds.");
        }
    }

    /**
     * Set the end time in milliseconds.<br> The end value in milliseconds is
     * taken from the method {@link System#currentTimeMillis()} call.
     */
    public void setEndTime() {
        this.endMillis = System.currentTimeMillis();
    }

    /**
     * Set the end time in milliseconds.<br> The end value in milliseconds is
     * taken from the {@code milliseconds} argument.
     *
     * @param milliseconds the end time in milliseconds.
     *
     * @throws IllegalArgumentException if the {@code milliseconds} argument
     * value is negative.
     */
    public void setEndTime(final long milliseconds) {
        if (CheckerNumber.isPositive(milliseconds)
                            || CheckerNumber.isZero(milliseconds)) {
            this.endMillis = milliseconds;
        } else {
            throw new IllegalArgumentException(
                            "Negative value of the argument in milliseconds.");
        }
    }

    /*
    * Calculated run time. For the calculation, the start and end times are
    * encapsulated (also predefined by calling the corresponding setters).
    */
    public long calculateExecutionTime() {
        return BigDecimal.valueOf(this.startMillis).subtract(
                BigDecimal.valueOf(this.endMillis), MathContext.DECIMAL64)
                         .longValue();
    }

}
