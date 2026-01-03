package Buoi_10.exception;

import java.security.PublicKey;
import java.security.spec.ECFieldF2m;

public class MinLengthException extends Exception {
    public MinLengthException(String message) {
        super(message);
    }
}
