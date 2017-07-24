package com.arity.activationcode;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.arity.activationcode.beans.Property;
import com.arity.activationcode.beans.Theme;

import java.util.List;

public class BaseThemeActivity extends AppCompatActivity {

    private Theme theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeProvider themeProvider = ThemeProvider.getInstance();
        theme = themeProvider.getTheme();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(theme.getColorPrimaryDark());
        }
    }

    public Theme getAppTheme() {
        return theme;
    }

    protected void applyTextStyle(com.arity.activationcode.state.UITextView style, TextView... views) {
        for (TextView view : views) {
            List<Property> properties = style.getProperties();
            for (Property property : properties) {
                switch (property.getPropertyName()) {
                    case "textColor":
                        view.setTextColor(Color.parseColor(property.getPropertyValue()));
                        break;
                    case "font":
                        // TODO change font on availability
                        break;
                    case "textSize":
                        view.setTextSize(Integer.parseInt(property.getPropertyValue()));
                        break;
                    case "textStyle":
                        // TODO change font style
                        break;
                }
            }
        }
    }

    protected void applyButtonStyle(com.arity.activationcode.state.UIButton style, Button... views) {
        for (Button view : views) {
            List<Property> properties = style.getProperties();
            GradientDrawable mGradientDrawable = new GradientDrawable();
            for (Property property : properties) {
                switch (property.getPropertyName()) {
                    case "textColor":
                        view.setTextColor(Color.parseColor(property.getPropertyValue()));
                        break;
                    case "background":
                        mGradientDrawable.setColor(Color.parseColor(property.getPropertyValue()));
                        break;
                    case "cornerRadius":
                        mGradientDrawable.setCornerRadius(Float.parseFloat(property.getPropertyValue()));
                        break;
                }
            }
            if (Build.VERSION.SDK_INT >= 16)
                view.setBackground(mGradientDrawable);
            else view.setBackgroundDrawable(mGradientDrawable);
        }
    }

}
