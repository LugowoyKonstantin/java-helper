package com.lugowoy.helper.calculating;

/**
 * Created by Konstantin Lugowoy on 03-Feb-17.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * A functional interface that declares a contract to implement a function,
 *  and also provides a function for computing using a two input parameter.
 *
 * @param <T> - The type of data that will be returned by the result of the function.
 * @param <K> - The type of object that passed to parameter of the function.
 * @param <V> - The type of object that passed to parameter of the function.
 */

@FunctionalInterface
public interface CalculationUsingTwoParameters<T, K, V> {

    /**
     * A function that performs calculations using a two input parameter.
     *
     * @param kVar - The object passed by the parameter to the function and whose data will be used for the calculations.
     * @param vVar - The object passed by the parameter to the function and whose data will be used for the calculations.
     * @return The result of the execution (calculation) of the function is returned.
     * @since 1.0
     */
    T calculate(K kVar, V vVar);

}
