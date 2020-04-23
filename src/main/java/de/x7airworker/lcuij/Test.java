package de.x7airworker.lcuij;

import de.x7airworker.lcuij.widget.TextEdit;
import de.x7airworker.lcuij.widget.TextView;
import de.x7airworker.lcuij.widget.Widget;

public class Test {
    public static void main(String[] args) {
        LCUIJ.init();
        Widget root = Widget.getRoot();
        Widget pack = Widget.fromFile("example.xml");
        root.append(pack);
        pack.unwrap();
        Widget button = Widget.byId("btn");
        button.bindEvent("click", (self, event, args1) -> {
            TextEdit edit = (TextEdit) Widget.byId("edit");
            TextView txt = (TextView) Widget.byId("text-hello");
            String text = edit.getText();
            System.out.println(text);
            txt.setText(text);
        });

        System.exit(LCUIJ.run());
    }
}
