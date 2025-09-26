package org.skypro.skyshop.exeptions;


public class BestResultNotFound extends Exception {


    public BestResultNotFound() {
    }

    public BestResultNotFound(String s) {
        super(s);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }

    public BestResultNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}



