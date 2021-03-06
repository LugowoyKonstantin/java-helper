package com.lugowoy.helper.models.points;

import java.util.Objects;

/**
 * The class implements the 2D point model.
 * <p>Created by Konstantin Lugowoy on 23.12.2018.
 *
 * @param <T> The type of coordinates that initialize the coordinates of a 2D
 * point.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.points.Point
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.6
 */
//TODO review documentation
public class Point2D<T extends Number> extends Point<T> {

    private T y;

    /**
     * Constructs a new 2D point object.
     *
     * @param x Value to initialize X coordinate.
     * @param y Value to initialize Y coordinate.
     */
    public Point2D(final T x, final T y) {
        super(x);
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point2D)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Point2D<?> point2D = (Point2D<?>) o;
        return Objects.equals(this.y, point2D.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.y);
    }

    @Override
    public String toString() {
        return "Point2D[ " + "x=" + super.getX() + " y=" + this.y + " ]";
    }

    /**
     * Get the Y coordinate value.
     *
     * @return Y coordinate value.
     */
    public T getY() {
        return this.y;
    }

    /**
     * Set the Y coordinate value.
     *
     * @param y Value to set the Y coordinate.
     */
    public void setY(final T y) {
        this.y = y;
    }

}
