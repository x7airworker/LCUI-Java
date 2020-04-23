package de.x7airworker.lcuij.widget;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import de.x7airworker.lcuij.library.LCUI;
import de.x7airworker.lcuij.library.Size_t;

public class TextEdit extends Widget {
    protected TextEdit(LCUI.Widget handle) {
        super(handle);
    }

    public String getText() {
        int size = getLength();
        Pointer m = new Memory((size + 1) * Native.WCHAR_SIZE);
        LCUI.INSTANCE.TextEdit_GetTextW(handle, new Size_t(0), new Size_t(size), m);
        return m.getWideString(0);
    }

    public int getLength() {
        return LCUI.INSTANCE.TextEdit_GetTextLength(handle).intValue();
    }
}
