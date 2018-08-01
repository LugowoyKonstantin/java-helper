package com.lugowoy.helper.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 *
 * The interface provides a functional for generating random integers and double numbers.
 *  Functionality is provided in a static context.
 */

public interface GeneratorRandomNumber {

    Random RANDOM = new Random();

    int SCALE = 2;

    int DEFAULT_START_BOUND_VALUE = 0;
    /**
     * The method generate a random byte number in the range from {@link Byte#MIN_VALUE} to {@link Byte#MAX_VALUE}.
     *
     * @return The generated byte number.
     */
    static byte generateByte() {
        return (byte) getRandomIntegerValueInRange(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * The method generate a random byte number in the range from {@link GeneratorRandomNumber#DEFAULT_START_BOUND_VALUE}
     * to parameter "bound".
     *
     * @return The generated byte number.
     */
    static byte generateByte(byte bound) {
        return (byte) getRandomIntegerValueInRange((byte) DEFAULT_START_BOUND_VALUE, bound);
    }

    /**
     * The method generate a random byte number in the range from parameter "startBound" to parameter "endBound" .
     *
     * @return The generated byte number.
     */
    static byte generateByte(byte startBound, byte endBound) {
        return (byte) getRandomIntegerValueInRange(startBound, endBound);
    }

    /**
     * The method generate a random integer number in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return /*getRandomIntegerValueInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);*/  RANDOM.nextInt();
    }

    /**
     * The method generate a random integer number in the range from "0" to parameter "bound".
     *
     * @return The generated integer number.
     */
    static int generateInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    /**
     * The method generate a random integer number in the range from parameter "startBound" to parameter "endBound" .
     *
     * @return The generated integer number.
     */
    static int generateInt(int startBound, int endBound) {
        return getRandomIntegerValueInRange(startBound, endBound);
    }

    /**
     * The method generate a random double number in the range from {@link Integer#MIN_VALUE}
     *  to {@link Integer#MAX_VALUE}.
     *
     * @return The generated double number.
     */
    static double generateDouble() {
        return new BigDecimal(getRandomDoubleValueInRange(Integer.MIN_VALUE, Integer.MAX_VALUE)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random double number in the range from "0" to parameter "bound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double bound) {
        return new BigDecimal(getRandomDoubleValueInRange(0, bound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * The method generate a random integer number from parameter "startBound" to parameter "endBound".
     *
     * @return The generated double number.
     */
    static double generateDouble(double startBound, double endBound) {
        return new BigDecimal(getRandomDoubleValueInRange(startBound, endBound)).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    private static int getRandomIntegerValueInRange(int startBound, int endBound) {
        return (RANDOM.nextInt() * (endBound - startBound)) + startBound;
    }

    private static double getRandomDoubleValueInRange(double startBound, double endBound) {
        return (RANDOM.nextDouble() * (endBound - startBound)) + startBound;
    }

}
