package com.lugowoy.helper.factory.creator;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * An abstract class that is the root of a class hierarchy and declaring a contract
 *  for the implementation of the functional creates different objects.
 *
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> Type of objects to create.
 */

public abstract class Creator<T> implements Creating<T> {

    /**
     * The method executes the creation of an object by calling the constructor of parameters.
     *
     * @return Created object.
     */
    public abstract T create();

}
