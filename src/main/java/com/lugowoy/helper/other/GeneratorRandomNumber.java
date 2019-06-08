package com.lugowoy.helper.other;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Interface with static functionality for generate random number.
 * <p>Created by Konstantin Lugowoy on 01.01.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 */
public interface GeneratorRandomNumber {

    /**
     * The default zero value for some methods.
     */
    int VALUE_ZERO = 0;

    /**
     * Real number scale. Value of digits after the decimal point in double numbers.
     */
    int SCALE = 3;

    /**
     * Generate a random byte number in the range (inclusive)
     * from {@link Byte#MIN_VALUE} to {@link Byte#MAX_VALUE}.
     *
     * @return The generated byte type number.
     */
    static byte generateByte() {
        return (byte) RandomUtils.nextInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    /**
     * Generate a random positive byte number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument upper bound.
     *
     * @param bound The upper bound to generate number.
     * @return The generated byte type number.
     * @throws IncorrectBoundArgumentException If the bound value is out of range.
     */
    static byte generateByte(byte bound) {
        byte result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Byte.MAX_VALUE)) {
            result = (byte) RandomUtils.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random byte number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated byte type number.
     * @throws IncorrectBoundArgumentException If the bound value is out of range.
     */
    static byte generateByte(byte lowerBound, byte upperBound) {
        byte result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Byte.MIN_VALUE, Byte.MAX_VALUE) && (lowerBound < upperBound)) {
            result = (byte) RandomUtils.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random short number in the range (inclusive)
     * from {@link Short#MIN_VALUE} to {@link Short#MAX_VALUE}.
     *
     * @return The generated short number.
     */
    static short generateShort() {
        return (short) RandomUtils.nextInt(Short.MIN_VALUE, Short.MIN_VALUE);
    }

    /**
     * Generate a random positive short number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument upper bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated short type number.
     * @throws IncorrectBoundArgumentException If the bound value is out of range.
     */
    static short generateShort(short bound) {
        short result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Short.MAX_VALUE)) {
            result = (short) RandomUtils.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random short number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated short type number.
     */
    static short generateShort(short lowerBound, short upperBound) {
        short result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Short.MIN_VALUE, Short.MAX_VALUE) && (lowerBound < upperBound)) {
            result = (short) RandomUtils.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random integer number in the range (inclusive)
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @return The generated integer number.
     */
    static int generateInt() {
        return RandomUtils.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Generate a random positive integer number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated integer type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static int generateInt(int bound) {
        int result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Integer.MAX_VALUE)) {
            result = RandomUtils.nextInt(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random integer number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated integer type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static int generateInt(int lowerBound, int upperBound) {
        int result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE) && (lowerBound < upperBound)) {
            result = RandomUtils.nextInt(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random long number in the range (inclusive)
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @return The generated long type number.
     */
    static long generateLong() {
        return RandomUtils.nextLong(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Generate a random positive long number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated long type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static long generateLong(long bound) {
        long result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Long.MAX_VALUE)) {
            result = RandomUtils.nextLong(VALUE_ZERO, bound);
        }
        return result;
    }

    /**
     * Generate a random long number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated long type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static long generateLong(long lowerBound, long upperBound) {
        long result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Long.MIN_VALUE, Long.MAX_VALUE) && (lowerBound < upperBound)) {
            result = RandomUtils.nextLong(lowerBound, upperBound);
        }
        return result;
    }

    /**
     * Generate a random double number in the range (inclusive)
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @return The generated double type number.
     */
    static double generateDouble() {
        double resultDouble = RandomUtils.nextDouble(Long.MIN_VALUE, Long.MAX_VALUE);
        return new BigDecimal(resultDouble).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * Generate a random positive double number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated double type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static double generateDouble(double bound) {
        double result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Long.MAX_VALUE)) {
            result = RandomUtils.nextDouble(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * Generate a random double number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The lower bound to generate.
     * @param upperBound The upper bound to generate.
     * @return The generated double type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static double generateDouble(double lowerBound, double upperBound) {
        double result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Long.MIN_VALUE, Long.MAX_VALUE) && (lowerBound < upperBound)) {
            result = RandomUtils.nextDouble(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue();
    }

    /**
     * Generate a random float number in the range (inclusive)
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @return The generated float type number.
     */
    static float generateFloat() {
        float resultFloat = RandomUtils.nextFloat(Long.MIN_VALUE, Long.MAX_VALUE);
        return new BigDecimal(resultFloat).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();
    }

    /**
     * Generate a random positive float number in the range (inclusive)
     * from {@link GeneratorRandomNumber#VALUE_ZERO} to argument bound.
     *
     * @param bound The upper bound to generate.
     * @return The generated float type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static float generateFloat(float bound) {
        float result = 0;
        if (isBoundValueInRange(bound, bound, VALUE_ZERO, Long.MAX_VALUE)) {
            result = RandomUtils.nextFloat(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();
    }

    /**
     * Generate a random float number in the range (inclusive)
     * from argument lowerBound to upperBound.
     *
     * @param lowerBound The start bound to generate.
     * @param upperBound  The end bound to generate.
     * @return The generated float type number.
     * @throws IncorrectBoundArgumentException If the bound value is out in range.
     */
    static float generateFloat(float lowerBound, float upperBound) {
        float result = 0;
        if (isBoundValueInRange(lowerBound, upperBound, Long.MIN_VALUE, Long.MAX_VALUE) && (lowerBound < upperBound)) {
            result = RandomUtils.nextFloat(Long.MIN_VALUE, Long.MAX_VALUE);
        }
        return new BigDecimal(result).setScale(SCALE, RoundingMode.HALF_DOWN).floatValue();
    }

    private static boolean isBoundValueInRange(long lowerBound, long upperBound,
                                               long minLowerBound, long maxLowerBound ) {
        if (lowerBound >= minLowerBound && upperBound <= maxLowerBound) {
            return true;
        } else {
            throw new IncorrectBoundArgumentException("Bound value is out of range.");
        }
    }

    private static boolean isBoundValueInRange(double lowerBound, double upperBound,
                                               double minLowerBound, double maxLowerBound ) {
        if (lowerBound >= minLowerBound && upperBound <= maxLowerBound) {
            return true;
        } else {
            throw new IncorrectBoundArgumentException("Bound value is out of range.");
        }
    }

}
