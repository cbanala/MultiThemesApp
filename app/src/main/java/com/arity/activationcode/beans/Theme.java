package com.arity.activationcode.beans;

import android.graphics.Color;

import com.arity.activationcode.state.UIButton;
import com.arity.activationcode.state.UITextView;

import java.util.List;

public class Theme {

    private int colorPrimary;
    private int colorPrimaryDark;
    private int colorAccent;
    private List<Style> themeStyle;
    private UITextView defaultTextStyle;
    private UITextView largeTextStyle;
    private UITextView smallTextStyle;
    private UIButton buttonStyle;
    private String appLogo;
    private String themeName;

    public List<Style> getThemeStyle() {
        return themeStyle;
    }

    public int getColorPrimary() {
        return colorPrimary;
    }

    public int getColorPrimaryDark() {
        return colorPrimaryDark;
    }

    public int getColorAccent() {
        return colorAccent;
    }

    public void setThemeStyle(List<Style> themeStyle) {
        this.themeStyle = themeStyle;
        for (int i = 0; i < themeStyle.size(); i++) {
            Style style = themeStyle.get(i);
            switch (style.getStyleClass()) {
                case "theme Color":
                    setThemeColor(style);
                    break;
                case "Default Text Style":
                    defaultTextStyle = new UITextView(style.getProperties());
                    break;
                case "Text Large Style":
                    largeTextStyle = new UITextView(style.getProperties());
                    break;
                case "Text Small Style":
                    smallTextStyle = new UITextView(style.getProperties());
                    break;
                case "Default Button Style":
                    buttonStyle = new UIButton(style.getProperties());
                    break;
                case "Theme Images":
                    List<Property> properties = style.getProperties();
                    for (Property property : properties) {
                        if (property.getPropertyName().equals("appLogo")) {
                            appLogo = property.getPropertyValue();
                        }
                    }
                    break;
            }
        }
    }

    private void setThemeColor(Style style) {
        List<Property> properties = style.getProperties();
        for (Property property : properties) {
            if (property.getPropertyType().equals("color")) {
                int color = Color.parseColor(property.getPropertyValue());
                switch (property.getPropertyName()) {
                    case "colorPrimary":
                        this.colorPrimary = color;
                        break;
                    case "colorPrimaryDark":
                        this.colorPrimaryDark = color;
                        break;
                    case "colorAccent":
                        this.colorAccent = color;
                        break;
                }
            }
        }
    }

    public UITextView getLargeTextStyle() {
        return largeTextStyle;
    }

    public UITextView getNormalTextStyle() {
        return defaultTextStyle;
    }

    public UITextView getSmallTextStyle() {
        return smallTextStyle;
    }

    public UIButton getButtonStyle() {
        return buttonStyle;
    }

    public Style getStyle(String styleClass) {
        List<Style> themeStyle = this.themeStyle;
        for (Style style : themeStyle) {
            if (style.getStyleClass().equals(styleClass)) {
                return style;
            }
        }
        return null;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
