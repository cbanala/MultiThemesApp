package com.arity.activationcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivationScreenActivity extends AppCompatActivity {

    private EditText activateET;
    private Button activateBtn;
    private ProgressDialog asyncDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_activation_screen);

        activateET = (EditText) findViewById(R.id.activate_et);
        activateBtn = (Button) findViewById(R.id.activate_btn);
        activateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkActivationCode();
            }
        });
    }

    private void checkActivationCode() {
        if (!TextUtils.isEmpty(activateET.getText().toString())) {
            // Do check the activation code and decide company in database : THIS WILL BE A SERVER CALL
            // Once you the orgID then you will make another call and download the AppConfig.
            // Open json folder and download the appConfig : THERE CUSTOMIZE THE JSON FOR WHAT FIELD DO WE NEED TO DOWNLOAD
            // Load the app primary colors and change appLogo Icons after that.
            openDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    validateActivationCode(activateET.getText().toString());
                }
            }, 2000);

//            new checkForJsonFile(activateET.getText().toString());

        } else {
            Toast.makeText(this, "Please Enter the Activation Code....", Toast.LENGTH_SHORT).show();
        }
    }

    private void openDialog() {
        asyncDialog = new ProgressDialog(ActivationScreenActivity.this);
        asyncDialog.setMessage(getString(R.string.loadingtype));
        asyncDialog.show();
    }

    private void validateActivationCode(String activationCode) {
        if (activationCode.equals(ActivationCodeConstants.BATMAN)) {
            asyncDialog.dismiss();
            Toast.makeText(this, "WE RECOGNIZED YOU ARE FROM BATMAN COMPANY...", Toast.LENGTH_SHORT).show();
            //Load Batman company json file schema
            ThemeProvider instance = ThemeProvider.getInstance();
            instance.setTheme(instance.getTheme("batman"));

            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else if (activationCode.equals(ActivationCodeConstants.CAPTAIN_AMERICA)) {
            asyncDialog.dismiss();
            Toast.makeText(this, "WE RECOGNIZED YOU ARE FROM CAPTAIN_AMERICA COMPANY...", Toast.LENGTH_SHORT).show();
            //Load Captain America company json file schema
        } else if (activationCode.equals(ActivationCodeConstants.SPIDERMAN)) {
            asyncDialog.dismiss();
            Toast.makeText(this, "WE RECOGNIZED YOU ARE FROM SPIDERMAN COMPANY...", Toast.LENGTH_SHORT).show();
            //Load SpiderMan company json file schema
        } else if (activationCode.equals(ActivationCodeConstants.SUPERMAN)) {
            asyncDialog.dismiss();
            Toast.makeText(this, "WE RECOGNIZED YOU ARE FROM SUPERMAN COMPANY...", Toast.LENGTH_SHORT).show();
            //Load Superman company json file schema
            ThemeProvider instance = ThemeProvider.getInstance();
            instance.setTheme(instance.getTheme("superman"));
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            asyncDialog.dismiss();
            Toast.makeText(this, "SORRY :( WE CANNOT RECOGNIZE YOU.... ", Toast.LENGTH_SHORT).show();
            //Load Batman company json file schema
        }
    }

    private class checkForJsonFile extends AsyncTask<Void, Void, Void> {
        private final String activateCode;
        private ProgressDialog asyncDialog = new ProgressDialog(ActivationScreenActivity.this);
        private String typeStatus;

        public checkForJsonFile(String activateCode) {
            this.activateCode = activateCode;
        }

        @Override
        protected void onPreExecute() {
            //set message of the dialog
            asyncDialog.setMessage(getString(R.string.loadingtype));
            //show dialog
            asyncDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            //don't touch dialog here it'll break the application
            //do some lengthy stuff like calling login webservice
            //Make a webservice call and check whether validation code is valid or not
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //hide the dialog
            asyncDialog.dismiss();
            super.onPostExecute(result);
        }

    }
}
