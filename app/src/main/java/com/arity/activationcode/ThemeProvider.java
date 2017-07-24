package com.arity.activationcode;

import com.arity.activationcode.beans.Style;
import com.arity.activationcode.beans.Theme;
import com.arity.activationcode.widget.UITextView;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ThemeProvider {

    private static ThemeProvider instance;
    private Theme theme;
    private UITextView uiTextView;

    private ThemeProvider() {
    }

    private String loadJSONFromAsset(String themeName) {
        String json = null;
        try {
            ActivationApp instance = ActivationApp.getInstance();
            InputStream is = instance.getAssets().open(themeName + "_theme.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static ThemeProvider getInstance() {
        if (instance == null) {
            instance = new ThemeProvider();
        }
        return instance;
    }

    public Theme getTheme() {
        return theme;
    }

    public Theme getTheme(String themeName) {
        Theme theme = new Theme();
        theme.setThemeName(themeName);
        String jsonStr = loadJSONFromAsset(themeName);
        Style[] styles = new Gson().fromJson(jsonStr, Style[].class);
        List<Style> themeStyles = Arrays.asList(styles);
        theme.setThemeStyle(themeStyles);
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

}
