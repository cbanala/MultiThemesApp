package com.arity.activationcode;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arity.activationcode.beans.Theme;

public class MainActivity extends BaseThemeActivity {

    private Toolbar toolbar;
    private ImageView themeLogoIV;
    private TextView welcomeTV;
    private Button btn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Theme theme = getAppTheme();
        themeLogoIV = (ImageView) findViewById(R.id.companyLogoIV);
        welcomeTV = (TextView) findViewById(R.id.welcomeTV);
        btn = (Button) findViewById(R.id.btn);

        toolbar.setBackgroundColor(theme.getColorPrimary());

        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

        welcomeTV.setText(String.valueOf(batLevel));
//        welcomeTV.setText("Welcome : " + theme.getThemeName().toUpperCase());
        //applying largeTextStyle
        applyTextStyle(theme.getLargeTextStyle(), welcomeTV);
        applyButtonStyle(theme.getButtonStyle(), btn);
        setAppLogo();
    }

    private void setAppLogo() {
        Theme theme = getAppTheme();
        int resId = getResources().getIdentifier(theme.getAppLogo(), "drawable", getPackageName());
        themeLogoIV.setImageDrawable(ContextCompat.getDrawable(this, resId));
    }

}
