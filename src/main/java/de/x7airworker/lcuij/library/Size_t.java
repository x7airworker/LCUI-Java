package de.x7airworker.lcuij.library;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;

public class Size_t extends IntegerType {
    public Size_t() {
        this(0);
    }
    public Size_t(long value) {
        super(Native.SIZE_T_SIZE, value);
    }
}
