/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Bryce Blauser
 */
public class TargetControlException extends Exception {

    public TargetControlException() {
    }

    public TargetControlException(String message) {
        super(message);
    }

    public TargetControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public TargetControlException(Throwable cause) {
        super(cause);
    }

    public TargetControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
