package de.x7airworker.lcuij.widget;

import de.x7airworker.lcuij.library.LCUI;
import de.x7airworker.lcuij.library.NativeString;

public class Button extends Widget {
    protected Button(LCUI.Widget handle) {
        super(handle);
    }

    public void setTextW(String text) {
        NativeString ns = new NativeString(text, true);
        LCUI.INSTANCE.Button_SetTextW(handle, ns.getPointer());
    }

    public void setText(String text) {
        NativeString ns = new NativeString(text);
        LCUI.INSTANCE.Button_SetText(handle, ns.getPointer());
    }
}
