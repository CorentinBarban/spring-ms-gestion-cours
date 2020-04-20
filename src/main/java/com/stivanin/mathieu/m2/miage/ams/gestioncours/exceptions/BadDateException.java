package com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions;

public class BadDateException extends Exception {

    /**
     * Creates a new instance of <code>BadDateException</code> without
     * detail message.
     */
    public BadDateException() {
    }

    /**
     * Constructs an instance of <code>BadDateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadDateException(String msg) {
        super(msg);
    }

}
