package de.x7airworker.lcuij.widget;

import de.x7airworker.lcuij.library.LCUI;

import java.util.Arrays;

public class TextView extends Widget {
    protected TextView(LCUI.Widget handle) {
        super(handle);
    }

    public void setText(final String text) {
        char[] str = text.toCharArray();
        LCUI.INSTANCE.TextView_SetTextW(handle, str);
    }
}
