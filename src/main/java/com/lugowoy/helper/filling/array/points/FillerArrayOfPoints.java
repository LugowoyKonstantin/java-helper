package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The class is the inheritor of the class {@link FillerArray}.
 * <p>The class that is a container that encapsulates a specific implementation of a contract declared in the {@link FillingArrayOfPointsCoordinatesWithArrayNumbers} interface
 *  and delegates to it an obligation to perform functionality to fill a array with numeric data.
 *
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see FillingArrayOfPoints
 *
 * @param <T> The type of coordinates encapsulated in the object of the {@link Point} class.
 * */

public class FillerArrayOfPoints<T extends Number> extends FillerArray<Point<T>> implements FillingArrayOfPoints<T> {

    /**
     * Constructor to create a new {@link FillerArrayOfPoints} and initializes the object encapsulated in parent class to perform the functionality.
     *
     * @param fillingArrayOfPoints The object that implements the {@link FillingArrayOfPoints} interface contract to fill an array.
     * */
    private FillerArrayOfPoints(FillingArrayOfPoints<T> fillingArrayOfPoints) {
        super(fillingArrayOfPoints);
    }

    /**
     * Fills an object of class {@link Array} with the objects of the {@link Point} class with numerical coordinates.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link Filling} interface contract
     *  and is encapsulated in the object of parent class.
     *
     * @param array The object of class {@link Array} to be filled with the objects of the {@link Point} class with numerical coordinates.
     * @return The object of class {@link Array} filled with the objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Array<Point<T>> fill(Array<Point<T>> array) {
        return super.fill(array);
    }

    /**
     * Fills an array with the objects of the {@link Point} class with numerical coordinates.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArray} interface contract
     * and is encapsulated in the object of parent class.
     *
     * @param tArray The array to be filled with the objects of the {@link Point} class with numerical coordinates.
     * @return The array filled with the objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(Point<T>[] tArray) {
        return super.fill(tArray);
    }

    /**
     * Fills an array with data.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArray} interface contract
     * and is encapsulated in the object of parent class.
     *
     * @param lengthArray The length(size) of the array to be filled with the objects of the {@link Point} class with numerical coordinates.
     * @return Created and filled array with the objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(int lengthArray) {
        return super.fill(lengthArray);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     * in the range from "0" to "bound".
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArrayOfPointsCoordinatesWithArrayNumbers} interface contract
     * and is encapsulated in the object of parent class.
     *
     * @param array The object of the {@link Array} class to be filled with an object of the {@link Point} class with numerical coordinates.
     * @param bound The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return The object of the {@link Array} class filled with an object of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Array<Point<T>> fill(Array<Point<T>> array, T bound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(array, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to to "bound".
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArrayOfPointsCoordinatesWithArrayNumbers} interface contract
     * and is encapsulated in the object of parent class.
     *
     * @param points The array to be filled with objects of the {@link Point} class.
     * @param bound  The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return The array filled with objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(Point<T>[] points, T bound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(points, bound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "0" to "bound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link FillingArrayOfPointsCoordinatesWithArrayNumbers} interface contract
     * and is encapsulated in the object of parent class.
     *
     * @param lengthArray The length(size) of the array to be filled with objects of the {@link Point} class with numerical coordinates.
     * @param bound       The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array with objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(int lengthArray, T bound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(lengthArray, bound);
    }

    /**
     * Fills an object of the {@link Array} class with an object of the {@link Point} class with numerical coordinates
     * in the range from "startBound" to "endBound".
     *
     * @param array      The object of the {@link Array} class to be filled with an object of the {@link Point} class with numerical coordinates.
     * @param startBound The value of the start of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return The object of the {@link Array} class filled with an object of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Array<Point<T>> fill(Array<Point<T>> array, T startBound, T endBound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(array, startBound, endBound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "startBound" to to "endBound".
     *
     * @param points     The array to be filled with objects of the {@link Point} class.
     * @param startBound The value of the start of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound   The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return The array filled with objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(Point<T>[] points, T startBound, T endBound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(points, startBound, endBound);
    }

    /**
     * Fills an array with objects of the {@link Point} class with numerical coordinates in the range from "startBound" to "endBound" parameter.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with objects of the {@link Point} class with numerical coordinates.
     * @param startBound  The value of the start of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @param endBound    The value of the end of the range boundary of numerical values by which the coordinates of points in the array will be initialized.
     * @return Created and filled array with objects of the {@link Point} class with numerical coordinates.
     * */
    @Override
    public Point<T>[] fill(int lengthArray, T startBound, T endBound) {
        return ((FillingArrayOfPoints<T>)super.getFilling()).fill(lengthArray, startBound, endBound);
    }

    /**
     * Creates a new object of {@link FillerArrayOfPoints} class by calling a single constructor with a parameter
     *  for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param fillingArrayOfPoints The object that implements the {@link FillingArrayOfPoints} interface contract to fill an array with data.
     * @return The created object of this class.
     * */
    public static <T extends Number> FillerArrayOfPoints<T> getFillerArrayPoints(FillingArrayOfPoints<T> fillingArrayOfPoints) {
        return new FillerArrayOfPoints<T>(fillingArrayOfPoints);
    }

}
