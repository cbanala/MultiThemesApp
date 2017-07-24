package com.arity.activationcode.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.arity.activationcode.beans.Style;

public class UIButton extends AppCompatButton {

    public UIButton(Context context) {
        super(context);
    }

    public UIButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void applyTheme(Style style) {

    }

}
