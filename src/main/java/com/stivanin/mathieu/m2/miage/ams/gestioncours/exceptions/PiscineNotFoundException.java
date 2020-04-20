package com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions;

public class PiscineNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>BadDateException</code> without
     * detail message.
     */
    public PiscineNotFoundException() {
    }

    /**
     * Constructs an instance of <code>BadDateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PiscineNotFoundException(String msg) {
        super(msg);
    }
}
