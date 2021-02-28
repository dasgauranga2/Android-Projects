package com.gauranga.fingerprint;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

import static androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG;
import static androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL;

public class MainActivity extends AppCompatActivity {

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    public void auth_user(View view) {
        // launch the biometric prompt
        biometricPrompt.authenticate(promptInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add the biometric dependencies in the manifest file
        // create an executor object
        executor = ContextCompat.getMainExecutor(this);
        // when user wants to use biometric authentication
        // a biometric prompt will appear
        // setup the actions for biometric prompt
        biometricPrompt = new BiometricPrompt(MainActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            // function is called if user exits the biometric prompt
            // or an error occurs while trying to use the biometric prompt
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "AUTHENTICATION ERROR : " + errString, Toast.LENGTH_SHORT)
                        .show();
            }
            // function is called if biometric authentication is successful
            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "AUTHENTICATION SUCCESSFUL", Toast.LENGTH_SHORT).show();
            }
            // function is called if biometric authentication fails
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "AUTHENTICATION FAILED",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        // setup the biometric prompt
        // set the the title
        // set the subtitle
        // set a button to exit the prompt
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Exit")
                .build();

    }
}