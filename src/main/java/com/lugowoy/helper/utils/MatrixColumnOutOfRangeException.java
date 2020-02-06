package com.lugowoy.helper.utils;

/**
 * <p>Created by Konstantin Lugowoy on 10.06.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.7
 */
//todo write doc's
public class MatrixColumnOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MatrixColumnOutOfRangeException(String message) {
        super(message);
    }

}