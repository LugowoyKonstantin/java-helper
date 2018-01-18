package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatingArray;
import com.lugowoy.helper.models.arrays.Array;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create {@link Array} class objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 *
 * @see com.lugowoy.helper.factory.Factory
 *
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 *
 * @param <T> The type of objects that are stored in the array created by the factory.
 */

public class FactoryArray<T> extends Factory<Array<T>> implements CreatingArray<T> {

    private FactoryArray(CreatingArray<T> creating) {
        super(creating);
    }

    /**
     * <p>
     * The method executes the creation of a class object Array<T> by calling the constructor with a parameter.
     * </p>
     * @since 1.1
     *
     * @param tArray An array of objects that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created class object {@link Array} the encapsulating array passed by the parameter.
     */
    @Override
    public Array<T> create(T[] tArray) {
        return ((CreatingArray<T>)super.getCreating()).create(tArray);
    }

    /**
     * <p>
     * The method executes the creation of a class object {@link Array} by calling the constructor with a parameter.
     * </p>
     * @since 1.1
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     */
    @Override
    public Array<T> create(int lengthArray) {
        return ((CreatingArray<T>)super.getCreating()).create(lengthArray);
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the {@link FactoryArray}.
     * </p>
     * @since 1.0
     *
     * @return Object type {@link FactoryArray}
     */
    public static <T> FactoryArray<T> getFactoryArray(CreatingArray<T> creatingArray) {
        return new FactoryArray<T>(creatingArray);
    }

}
