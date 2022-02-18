package com.myweb.smartshoppingapp.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.myweb.smartshoppingapp.R;
import com.myweb.smartshoppingapp.RegistrationActivity;
import com.myweb.smartshoppingapp.pojo.Login;
import com.myweb.smartshoppingapp.pojo.LoginRegistration;
import com.myweb.smartshoppingapp.retrofit.BaseEndPoint;
import com.myweb.smartshoppingapp.retrofit.LoginEndPoint;
import com.myweb.smartshoppingapp.ui.commande.CommandeList;

import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView tvNavRegistration;
    TextInputLayout tv_username, tv_password;
    Button btn_login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvNavRegistration = findViewById(R.id.tv_nav_registration);
        tv_username = findViewById(R.id.tv_username);
        tv_password = findViewById(R.id.tv_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validation = checkValidation();
                if (validation) {

                    Login login = new Login();
                    login.setUsername(tv_username.getEditText().getText().toString().trim());
                    login.setPassword(tv_password.getEditText().getText().toString().trim());

                    LoginEndPoint loginEndPoint = BaseEndPoint.retrofit.create(LoginEndPoint.class);
                    Call<Map> checkMapCall = loginEndPoint.checkUserNameAndPassword(login);
                    SweetAlertDialog pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
      //              pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
   //                 pDialog.setTitleText("Loading ...");
 //                   pDialog.setCancelable(false);
//                    pDialog.show();
            /*      checkMapCall.enqueue(new Callback<Map>() {

                        @Override
                        public void onResponse(Call<Map> call, Response<Map> response) {
                            pDialog.hide();
                            new SweetAlertDialog(LoginActivity.this)
                                    .setTitleText(response.body().get("message").toString())
                                    .show();
                        }

                        @Override
                        public void onFailure(Call<Map> call, Throwable t) {
                            pDialog.hide();
                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText(t.getMessage())
                                    .show();
                        }




                    });
            */
                    Intent intent = new Intent(LoginActivity.this, CommandeList.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        tvNavRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    private boolean checkValidation() {
        boolean validation = true;
        if (tv_username.getEditText().getText().toString().trim().length() < 1) {
            tv_username.getEditText().setError("Pls, Enter Username");
            validation = false;
        }
        if (tv_password.getEditText().getText().toString().trim().length() < 1) {
            tv_password.getEditText().setError("Pls, Enter Password");
            validation = false;
        }
        return validation;
    }
}