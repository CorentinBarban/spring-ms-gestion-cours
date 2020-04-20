package com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions;

public class CoursNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>BadDateException</code> without
     * detail message.
     */
    public CoursNotFoundException() {
    }

    /**
     * Constructs an instance of <code>BadDateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CoursNotFoundException(String msg) {
        super(msg);
    }

}
