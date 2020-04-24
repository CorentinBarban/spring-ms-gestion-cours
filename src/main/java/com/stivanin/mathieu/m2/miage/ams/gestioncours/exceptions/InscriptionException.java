package com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions;

public class InscriptionException extends Exception {
    /**
     * Creates a new instance of <code>InscriptionException</code> without
     * detail message.
     */
    public InscriptionException() {
    }

    /**
     * Constructs an instance of <code>InscriptionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InscriptionException(String msg) {
        super(msg);
    }
}
