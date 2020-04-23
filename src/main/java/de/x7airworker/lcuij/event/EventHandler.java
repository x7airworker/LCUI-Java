package de.x7airworker.lcuij.event;

import com.sun.jna.Pointer;
import de.x7airworker.lcuij.widget.Widget;

public interface EventHandler {
    void onEvent(Widget self, Pointer event, Pointer args);
}
