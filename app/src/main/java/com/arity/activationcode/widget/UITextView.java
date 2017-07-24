package com.arity.activationcode.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.arity.activationcode.beans.Property;
import com.arity.activationcode.beans.Style;
import com.arity.activationcode.beans.Theme;

import java.util.List;

public class UITextView extends AppCompatTextView {

    public UITextView(Context context) {
        super(context);
    }

    public UITextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UITextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void applyTheme(Style style) {
        List<Property> properties = style.getProperties();
        for (Property property : properties) {
            switch (property.getPropertyName()) {
                case "textColor":
                    setTextColor(Color.parseColor(property.getPropertyValue()));
                    break;
                case "font":
                    // TODO change font on availability
                    break;
                case "textSize":
                    setTextSize(Integer.parseInt(property.getPropertyValue()));
                    break;
                case "textStyle":
                    // TODO change font style
                    break;
            }
        }
    }

}
