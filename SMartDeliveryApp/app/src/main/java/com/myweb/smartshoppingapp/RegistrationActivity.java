package com.myweb.smartshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.myweb.smartshoppingapp.pojo.LoginRegistration;
import com.myweb.smartshoppingapp.retrofit.BaseEndPoint;
import com.myweb.smartshoppingapp.retrofit.RegistrationEndPoint;
import com.myweb.smartshoppingapp.ui.login.LoginActivity;

import java.util.Calendar;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    TextView tvNavLogin;
    TextInputLayout tv_fullname,tv_add,tv_mobile,tv_dateofbirth,tv_email;
    TextInputLayout tv_city,tv_state,tv_pin;
    TextInputLayout tv_username,tv_password,tv_con_password;
    Button btn_reg;

    //Intialize Date Picker
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tvNavLogin = findViewById(R.id.tv_nav_login);
        tv_fullname = findViewById(R.id.tv_fullname);
        tv_add = findViewById(R.id.tv_add);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_email = findViewById(R.id.tv_email);
        tv_city = findViewById(R.id.tv_city);
        tv_state = findViewById(R.id.tv_state);
        tv_pin = findViewById(R.id.tv_pin);
        tv_username = findViewById(R.id.tv_username);
        tv_password = findViewById(R.id.tv_password);
        tv_con_password = findViewById(R.id.tv_con_password);

        btn_reg = findViewById(R.id.btn_reg);



        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validation = checkValidation();
                if(validation){

                LoginRegistration loginRegistration = setLoginRegistrationData();
                    RegistrationEndPoint registrationEndPoint = BaseEndPoint.retrofit.create(RegistrationEndPoint.class);
                    Call<Map> addNewUser =  registrationEndPoint.putNewDataOnDb(loginRegistration);
                    SweetAlertDialog pDialog = new SweetAlertDialog(RegistrationActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog.setTitleText("Loading ...");
                    pDialog.setCancelable(false);
                    pDialog.show();
                    addNewUser.enqueue(new Callback<Map>() {
                        @Override
                        public void onResponse(Call<Map> call, Response<Map> response) {
                            pDialog.hide();
                            new SweetAlertDialog(RegistrationActivity.this)
                                    .setTitleText(response.body().get("message").toString())
                                    .show();
                        }

                        @Override
                        public void onFailure(Call<Map> call, Throwable t) {
                            pDialog.hide();
                            new SweetAlertDialog(RegistrationActivity.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText(t.getMessage())
                                    .show();
                        }
                    });


                }
            }
        });





        //DatePicker Assign
        tv_dateofbirth = findViewById(R.id.tv_dateofbirth);
        initDatePicker();

        //Input Keyboard Off
        tv_dateofbirth.getEditText().setInputType(InputType.TYPE_NULL);
        tv_dateofbirth.getEditText().setText(getTodaysDate());

        //Onclikc Event Handle
        tv_dateofbirth.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        tvNavLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private LoginRegistration setLoginRegistrationData() {
        LoginRegistration loginRegistration = new LoginRegistration();

        loginRegistration.setAddress1(tv_add.getEditText().getText().toString());
        loginRegistration.setCity(tv_city.getEditText().getText().toString());
        loginRegistration.setDob(tv_dateofbirth.getEditText().getText().toString());
        loginRegistration.setFullname(tv_fullname.getEditText().getText().toString());
        loginRegistration.setGender("Male");
        loginRegistration.setPincode(tv_pin.getEditText().getText().toString());
        loginRegistration.setState(tv_state.getEditText().getText().toString());


        loginRegistration.setEmail(tv_email.getEditText().getText().toString());
        loginRegistration.setMobile(tv_mobile.getEditText().getText().toString());
        loginRegistration.setPassword(tv_password.getEditText().getText().toString());

        loginRegistration.setUsername(tv_username.getEditText().getText().toString());
        return  loginRegistration;
    }

    private boolean checkValidation() {

        boolean validation = true;

        if(tv_fullname.getEditText().getText().toString().trim().length()<1){
            tv_fullname.getEditText().setError("Pls, Enter Fullname");
            validation = false;
        }
        if(tv_add.getEditText().getText().toString().trim().length()<1){
            tv_add.getEditText().setError("Pls, Enter Address");
            validation = false;
        }
        if(tv_mobile.getEditText().getText().toString().trim().length()<1){
            tv_mobile.getEditText().setError("Pls, Enter Mobile Number");
            validation = false;
        }
        else if(tv_mobile.getEditText().getText().toString().trim().length()!=10){
            tv_mobile.getEditText().setError("Pls, Enter Valid Mobile Number");
            validation = false;
        }
        if(tv_email.getEditText().getText().toString().trim().length()<1){
            tv_email.getEditText().setError("Pls, Enter Email");
            validation = false;
        }
        else{
            String email = tv_email.getEditText().getText().toString().trim();

            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if(!email.matches(emailPattern)){
                tv_email.getEditText().setError("Pls, Enter Valid Email Address");
                validation = false;
            }
        }
        if(tv_city.getEditText().getText().toString().trim().length()<1){
            tv_city.getEditText().setError("Pls, Enter City Name");
            validation = false;
        }
        if(tv_state.getEditText().getText().toString().trim().length()<1){
            tv_state.getEditText().setError("Pls, Enter State Name");
            validation = false;
        }
        if(tv_pin.getEditText().getText().toString().trim().length()<1){
            tv_pin.getEditText().setError("Pls, Enter Pincode");
            validation = false;
        } else if(tv_pin.getEditText().getText().toString().trim().length()!=6){
            tv_pin.getEditText().setError("Pls, Enter Valid Pincode Number");
            validation = false;
        }



        if(tv_username.getEditText().getText().toString().trim().length()<1){
            tv_username.getEditText().setError("Pls, Enter Username");
            validation = false;
        }
        if(tv_password.getEditText().getText().toString().trim().length()<1){
            tv_password.getEditText().setError("Pls, Enter Password");
            validation = false;
        }else if(tv_password.getEditText().getText().toString().trim().length() > 4 && tv_password.getEditText().getText().toString().trim().length() < 16 ){
            tv_password.getEditText().setError("Pls, Enter Valid Password");
            validation = false;
        }
        if(tv_con_password.getEditText().getText().toString().trim().length()<1){
            tv_con_password.getEditText().setError("Pls, Enter Confirm Password");
            validation = false;
        }
        else if(!tv_password.getEditText().getText().toString().equals(tv_con_password.getEditText().getText().toString()))
        {
            tv_con_password.getEditText().setError("Pls, Enter Both Password Same");
            validation = false;
        }
            return validation;
    }


    //DATE PICKER PRE_DEFINE CODE
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                tv_dateofbirth.getEditText().setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private String makeDateString(int day, int month, int year) {
        return day + " " + getMonthFormat(month) + " , " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "January";
        if(month == 2)
            return "Febuary";
        if(month == 3)
            return "March";
        if(month == 4)
            return "April";
        if(month == 5)
            return "May";
        if(month == 6)
            return "June";
        if(month == 7)
            return "July";
        if(month == 8)
            return "Auguest";
        if(month == 9)
            return "September";
        if(month == 10)
            return "October";
        if(month == 11)
            return "November";
        if(month == 12)
            return "December";
        //default month
        return "January";
    }

}