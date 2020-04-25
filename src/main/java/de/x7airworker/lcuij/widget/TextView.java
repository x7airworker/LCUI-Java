package de.x7airworker.lcuij.widget;

import de.x7airworker.lcuij.library.LCUI;
import de.x7airworker.lcuij.library.NativeString;

public class TextView extends Widget {
    protected TextView(LCUI.Widget handle) {
        super(handle);
    }

    public void setText(final String text) {
        NativeString ns = new NativeString(text, true);
        LCUI.INSTANCE.TextView_SetTextW(handle, ns.getPointer());
    }
}
