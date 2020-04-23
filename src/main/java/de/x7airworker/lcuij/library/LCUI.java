package de.x7airworker.lcuij.library;

import com.sun.jna.*;
import de.x7airworker.lcuij.event.EventHandler;

public interface LCUI extends Library {
    LCUI INSTANCE = Native.load("LCUI", LCUI.class);

    void LCUI_Init();
    int LCUI_Main();

    Widget LCUIWidget_GetRoot();

    void Widget_Append(Widget widgetOne, Widget widgetTwo);
    void Widget_Unwrap(Widget widget);
    int Widget_BindEvent(Widget widget, Pointer name, WidgetEventFunc function, Pointer data, Pointer destroyData);

    Widget LCUIBuilder_LoadString(Pointer str, int size);
    Widget LCUIBuilder_LoadFile(Pointer filepath);

    Widget LCUIWidget_GetById(Pointer id);

    void TextEdit_ClearText(Widget widget);
    void TextEdit_GetTextW(Widget widget, Size_t start, Size_t end, Pointer buf);
    Size_t TextEdit_GetTextLength(Widget widget);

    void TextView_SetTextW(Widget widget, char[] str);

    @Structure.FieldOrder({"hash", "state", "id", "type", "classes", "status", "title", "dicts", "disabled", "event_blocked", "layout_x", "layout_y", "x", "y", "width", "height", "max_content_width", "max_content_height"})
    final class Widget extends Structure {
        public int hash;
        public int state;

        public Pointer id;
        public Pointer type;
        public Pointer classes;
        public Pointer status;
        public Pointer title;
        public Pointer dicts;
        public boolean disabled;
        public boolean event_blocked;

        public float layout_x;
        public float layout_y;

        public float x;
        public float y;
        public float width;
        public float height;

        public float max_content_width;
        public float max_content_height;
    }

    @Structure.FieldOrder({"type", "data", "target", "cancel_bubble"})
    final class WidgetEvent extends Structure {
        public Uint32_t type;
        public Pointer data;
        public Widget target;
        public boolean cancel_bubble;
    }

    interface WidgetEventFunc extends Callback {
        void onEvent(Widget self, Pointer event, Pointer args);
    }
}
