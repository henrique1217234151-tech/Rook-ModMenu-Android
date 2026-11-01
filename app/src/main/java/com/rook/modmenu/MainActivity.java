// Java / MainActivity.java / Android SDK / standalone mod-menu UI demo
package com.rook.modmenu;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int BG = Color.rgb(16, 16, 20);
    private static final int PANEL = Color.rgb(29, 29, 36);
    private static final int ACCENT = Color.rgb(255, 51, 79);
    private LinearLayout page;
    private boolean expanded = true;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(BG);
        getWindow().setNavigationBarColor(BG);
        render();
    }

    private GradientDrawable shape(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(radius);
        return d;
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setGravity(Gravity.CENTER_VERTICAL);
        return t;
    }

    private void render() {
        page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(20), dp(18), dp(20), dp(18));
        page.setBackgroundColor(BG);

        LinearLayout header = new LinearLayout(this);
        header.setGravity(Gravity.CENTER_VERTICAL);
        TextView brand = text("ROOK  /  MOD MENU", 20, Color.WHITE, true);
        header.addView(brand, new LinearLayout.LayoutParams(0, dp(54), 1));

        Button collapse = new Button(this);
        collapse.setText(expanded ? "−" : "+");
        collapse.setTextColor(Color.WHITE);
        collapse.setBackground(shape(ACCENT, dp(14)));
        header.addView(collapse, new LinearLayout.LayoutParams(dp(52), dp(48)));
        page.addView(header);
        collapse.setOnClickListener(v -> { expanded = !expanded; render(); });

        TextView subtitle = text("STANDALONE UI  •  ANDROID", 11, 0xFFAAAAB5, true);
        page.addView(subtitle);
        View line = new View(this);
        line.setBackgroundColor(ACCENT);
        LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(-1, dp(2));
        lineLp.setMargins(0, dp(14), 0, dp(14));
        page.addView(line, lineLp);

        if (expanded) {
            ScrollView scroll = new ScrollView(this);
            LinearLayout list = new LinearLayout(this);
            list.setOrientation(LinearLayout.VERTICAL);
            list.setPadding(dp(2), 0, dp(2), dp(8));

            list.addView(section("VISUAL / UI DEMO"));
            addToggle(list, "Show status badge", "Only changes this menu's preview.");
            addToggle(list, "Compact layout", "Toggle a local interface preference.");
            addToggle(list, "Accent highlight", "Toggle a local visual effect.");

            list.addView(section("TOOLS"));
            Button preview = new Button(this);
            preview.setText("TEST NOTIFICATION");
            preview.setTextColor(Color.WHITE);
            preview.setAllCaps(false);
            preview.setBackground(shape(ACCENT, dp(12)));
            LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, dp(50));
            bp.setMargins(0, dp(5), 0, dp(12));
            list.addView(preview, bp);
            preview.setOnClickListener(v -> Toast.makeText(this,
                    "Rook Mod Menu: interface funcionando.", Toast.LENGTH_SHORT).show());

            TextView note = text("As opções são demonstrativas e locais. Não se conectam ao jogo.",
                    12, 0xFFB9B9C4, false);
            note.setPadding(dp(2), dp(8), dp(2), dp(8));
            list.addView(note);
            scroll.addView(list);
            page.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));
        }

        setContentView(page);
    }

    private TextView section(String name) {
        TextView t = text(name, 12, ACCENT, true);
        t.setPadding(dp(2), dp(14), dp(2), dp(6));
        return t;
    }

    private void addToggle(LinearLayout parent, String title, String detail) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(14), dp(9), dp(12), dp(9));
        card.setBackground(shape(PANEL, dp(14)));
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(-1, -2);
        cp.setMargins(0, dp(5), 0, dp(5));
        parent.addView(card, cp);

        Switch toggle = new Switch(this);
        toggle.setText(title);
        toggle.setTextColor(Color.WHITE);
        toggle.setTextSize(15);
        card.addView(toggle, new LinearLayout.LayoutParams(-1, dp(42)));

        TextView hint = text(detail, 11, 0xFFAAAAB5, false);
        hint.setPadding(0, dp(2), 0, dp(5));
        card.addView(hint);
        toggle.setOnCheckedChangeListener((button, checked) ->
                Toast.makeText(this, title + ": " + (checked ? "ON" : "OFF"),
                        Toast.LENGTH_SHORT).show());
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
