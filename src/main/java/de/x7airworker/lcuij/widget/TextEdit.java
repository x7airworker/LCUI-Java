package de.x7airworker.lcuij.widget;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import de.x7airworker.lcuij.library.LCUI;
import de.x7airworker.lcuij.library.NativeString;
import de.x7airworker.lcuij.library.Size_t;

public class TextEdit extends Widget {
    protected TextEdit(LCUI.Widget handle) {
        super(handle);
    }

    public void enableStyleTag(boolean enable) {
        LCUI.INSTANCE.TextEdit_EnableStyleTag(handle, enable);
    }

    public void enableMultiline(boolean enable){
        LCUI.INSTANCE.TextEdit_EnableMultiline(handle, enable);
    }

    public void moveCaret(int row, int col) {
        LCUI.INSTANCE.TextEdit_MoveCaret(handle, row, col);
    }

    public void clear() {
        LCUI.INSTANCE.TextEdit_ClearText(handle);
    }

    public String getText() {
        int size = getLength();
        NativeString ns = new NativeString((size + 1) * Native.WCHAR_SIZE);
        LCUI.INSTANCE.TextEdit_GetTextW(handle, new Size_t(0), new Size_t(size), ns.getPointer());
        return ns.getPointer().getWideString(0);
    }

    public int getLength() {
        return LCUI.INSTANCE.TextEdit_GetTextLength(handle).intValue();
    }

    public void setCaretBlink(boolean visibile, int time) {
        LCUI.INSTANCE.TextEdit_SetCaretBlink(handle, visibile, time);
    }

    public int setTextW(String text) {
        NativeString ns = new NativeString(text, true);
        return LCUI.INSTANCE.TextEdit_SetTextW(handle, ns.getPointer());
    }

    public int setText(String text) {
        NativeString ns = new NativeString(text);
        return LCUI.INSTANCE.TextEdit_SetText(handle, ns.getPointer());
    }

    public int appendTextW(String text) {
        NativeString ns = new NativeString(text, true);
        return LCUI.INSTANCE.TextEdit_AppendTextW(handle, ns.getPointer());
    }

    public int insertTextW(String text) {
        NativeString ns = new NativeString(text, true);
        return LCUI.INSTANCE.TextEdit_InsertTextW(handle, ns.getPointer());
    }

    public int setPlaceHolderW(String text) {
        NativeString ns = new NativeString(text, true);
        return LCUI.INSTANCE.TextEdit_SetPlaceHolderW(handle, ns.getPointer());
    }

    public int setPlaceHolder(String text) {
        NativeString ns = new NativeString(text);
        return LCUI.INSTANCE.TextEdit_SetPlaceHolder(handle, ns.getPointer());
    }

    public void setPasswordChar(char c) {
        LCUI.INSTANCE.TextEdit_SetPasswordChar(handle, c);
    }
}
