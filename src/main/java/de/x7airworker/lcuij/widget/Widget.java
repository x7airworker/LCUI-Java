package de.x7airworker.lcuij.widget;

import com.sun.jna.Pointer;
import de.x7airworker.lcuij.event.EventHandler;
import de.x7airworker.lcuij.library.LCUI;
import de.x7airworker.lcuij.library.NativeString;

import java.util.ArrayList;
import java.util.List;

public class Widget {
    protected final LCUI.Widget handle;

    protected Widget(LCUI.Widget handle) {
        this.handle = handle;
    }

    public void bindEvent(String name, EventHandler handler) {
        NativeString nString = new NativeString(name);
        LCUI.INSTANCE.Widget_BindEvent(handle, nString.getPointer(), createFunction(handler), null, null);
    }

    private LCUI.WidgetEventFunc createFunction(EventHandler handler) {
        return new LCUI.WidgetEventFunc(){
            @Override
            public void onEvent(LCUI.Widget self, Pointer event, Pointer args) {
                handler.onEvent(autoCast(self), event, args);
            }
        };
    }

    public void append(Widget otherWidget) {
        LCUI.INSTANCE.Widget_Append(handle, otherWidget.handle);
    }

    public void unwrap() {
        LCUI.INSTANCE.Widget_Unwrap(handle);
    }

    public String getWidgetType() {
        return handle.type.getString(0);
    }

    public static Widget fromFile(String path) {
        NativeString nString = new NativeString(path);
        return new Widget(LCUI.INSTANCE.LCUIBuilder_LoadFile(nString.getPointer()));
    }

    public static Widget fromString(String content) {
        NativeString nString = new NativeString(content);
        return new Widget(LCUI.INSTANCE.LCUIBuilder_LoadString(nString.getPointer(), content.length()));
    }

    public static Widget byId(String id) {
        NativeString nString = new NativeString(id);
        return autoCast(LCUI.INSTANCE.LCUIWidget_GetById(nString.getPointer()));
    }

    private static Widget autoCast(LCUI.Widget lWidget) {
        String type = lWidget.type.getString(0);

        if (type.equals("textedit")) {
            return new TextEdit(lWidget);
        } else if (type.equals("textview")) {
            return new TextView(lWidget);
        }

        return new Widget(lWidget);
    }

    public static Widget getRoot() {
        return autoCast(LCUI.INSTANCE.LCUIWidget_GetRoot());
    }
}
