package de.x7airworker.lcuij;

import de.x7airworker.lcuij.library.LCUI;

public class LCUIJ {
    public static void init() {
        LCUI.INSTANCE.LCUI_Init();
    }

    public static int run() {
        return LCUI.INSTANCE.LCUI_Main();
    }
}
