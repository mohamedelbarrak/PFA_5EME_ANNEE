package com.myweb.smartshoppingapp.ui.adapter;
import com.myweb.smartshoppingapp.R;
import com.myweb.smartshoppingapp.data.model.LignePanierCommande;
import com.myweb.smartshoppingapp.ui.commande.CommandeList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
public class CommandeDetails extends AppCompatActivity {
    private TextView textView11, textView12, textView13, textView10, textView15;
    private Switch switch1, switch2;
    private ImageButton imageButton4, imageButton3;
    private Bundle extras;
    private String num;
    private boolean visi;

    private RecyclerView recyclerView2;
    private List<LignePanierCommande> lists;
    private RecyclerView.Adapter adapter;



    public void call(View view){
        String number = num;
        Log.d(CommandeDetails.class.getSimpleName(),"number ="+number);
        Intent iDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
        startActivity(iDial);//Intent implicite
        //Toast.makeText(MainActivity.this, "tel:"+"0654451449", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande_details);

        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView10 = findViewById(R.id.textView10);

        textView15 = findViewById(R.id.textView15);
        extras = getIntent().getExtras();
        if(extras != null){
            textView11.setText(extras.getString("username")+"");
            textView12.setText(extras.getString("email")+"");
            num = extras.getString("mobile")+"";
            textView13.setText(num);
            textView10.setText(extras.getString("adresse")+"");
        }


        String a = extras.getString("commandeId")+"";
        new CommandeDetails.MyAsyncTaskresources().execute("http://192.168.56.1:8080/lignePanierCommande/commande/"+a);
        Log.d(CommandeDetails.class.getSimpleName(),"aze aze http://192.168.56.1:8080/lignePanierCommande/commande/"+a);



        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        Log.d(CommandeList.class.getSimpleName(),"**mohamed**1");
        if(extras.getString("etat").equalsIgnoreCase("false")){
            //textView23.setText("oui");
            switch1.setChecked(false);
            switch1.setText("Not yet");
        }
        else{
            //textView23.setText("non");
            switch1.setChecked(true);
            switch1.setText("Donne");
            visi = true;
            switch2.setVisibility(View.INVISIBLE);
            textView15.setVisibility(View.INVISIBLE);
        }

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked){
                    //textView4.setVisibility(View.VISIBLE);
                    //http://localhost/mo/db15.php?isDone=1&seanceID=2
                    //        Bundle extras22 = getIntent().getExtras();
//                    Log.d(CommandeDetails.class.getSimpleName(),"**titi*1*"+extras4.getString("MonitorId")+"**titi**"+extras4.getString("startDate"));
//                    new CommandeDetails.MyAsyncTaskresources().execute("http://192.168.56.1/mo/db20.php?isDone=1&seanceID="+extras4.getString("seanceID"));
                    switch1.setText("Donne");
                    visi = true;
                    switch2.setVisibility(View.INVISIBLE);
                    textView15.setVisibility(View.INVISIBLE);
                }
                else{
                    //textView4.setVisibility(View.INVISIBLE);
//                    Bundle extras22 = getIntent().getExtras();
//                    Log.d(MainActivity5.class.getSimpleName(),"**titi*0*"+extras4.getString("MonitorId")+"**titi**"+extras4.getString("startDate"));
//                    new MainActivity12.MyAsyncTaskresources().execute("http://192.168.56.1/mo/db20.php?isDone=0&seanceID="+extras4.getString("seanceID"));
                    switch1.setText("Not yet");
                    visi = false;
                    switch2.setVisibility(View.VISIBLE);
                    textView15.setVisibility(View.VISIBLE);
                }
            }
        });





        Log.d(CommandeList.class.getSimpleName(),"**mohamed**1");
        if(extras.getString("idLiv").equalsIgnoreCase("1")){
            //textView23.setText("oui");
            switch2.setChecked(false);
            switch2.setText("Not yes Taken");
        }
        else{
            //textView23.setText("non");
            switch2.setChecked(true);
            switch2.setText("Taken");
        }

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked){
                    //textView4.setVisibility(View.VISIBLE);
                    //http://localhost/mo/db15.php?isDone=1&seanceID=2
                    //        Bundle extras22 = getIntent().getExtras();
//                    Log.d(CommandeDetails.class.getSimpleName(),"**titi*1*"+extras4.getString("MonitorId")+"**titi**"+extras4.getString("startDate"));
//                    new CommandeDetails.MyAsyncTaskresources().execute("http://192.168.56.1/mo/db20.php?isDone=1&seanceID="+extras4.getString("seanceID"));
                    switch2.setText("Taken");
                }
                else{
                    //textView4.setVisibility(View.INVISIBLE);
//                    Bundle extras22 = getIntent().getExtras();
//                    Log.d(MainActivity5.class.getSimpleName(),"**titi*0*"+extras4.getString("MonitorId")+"**titi**"+extras4.getString("startDate"));
//                    new MainActivity12.MyAsyncTaskresources().execute("http://192.168.56.1/mo/db20.php?isDone=0&seanceID="+extras4.getString("seanceID"));
                    switch2.setText("Not yet Taken");
                }
            }
        });


/*
        if(!lists.isEmpty()){

            Log.d(CommandeList.class.getSimpleName(),"**mohamed**1");
            adapter = new MyAdaptorCommandeList(getApplicationContext(), lists);
            Log.d(CommandeList.class.getSimpleName(),"**mohamed**2");
            recyclerView1 = findViewById(R.id.recycleView1);
            recyclerView1.setHasFixedSize(true);
            recyclerView1.setLayoutManager(new LinearLayoutManager( getApplicationContext()));
            recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter
            Log.d(CommandeList.class.getSimpleName(),"**mohamed**3");

        }
        else
            Toast.makeText(getApplicationContext(),"vide",Toast.LENGTH_LONG).show();

*/

    }











    String result = "";
    public class MyAsyncTaskresources extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected String  doInBackground(String... params) {


            InputStream isr = null;

            try{
                String URL=params[0];
                java.net.URL url = new URL( URL);
                URLConnection urlConnection = url.openConnection();
                isr  = new BufferedInputStream(urlConnection.getInputStream());

            }

            catch(Exception e){

                Log.e("log_tag", "Error in http connection " + e.toString());



            }

//convert response to string

            try{

                BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);

                StringBuilder sb = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null) {

                    sb.append(line + "\n");

                }

                isr.close();

                result=sb.toString();

            }

            catch(Exception e){

                Log.e("log_tag", "Error  converting result " + e.toString());

            }

//parse json data


            return null;
        }

        protected void onPostExecute(String  result2){
            try {
                LignePanierCommande item1;
                String s = "";
                //Double id = 0.0;
                JSONArray jArray = new JSONArray(result);
                lists = new ArrayList<LignePanierCommande>();
                Log.d(CommandeList.class.getSimpleName(),"**mohamed**jArray.length()="+jArray.length());
                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject json = jArray.getJSONObject(i);
                    //String a = json.getString("userID");
                    //id = Double.parseDouble(a);
                    //private int userID, adminLevel, isActive;
                    //private String sessionToken, userEmail, userPasswd, userFName, userLName, description, userPhone, displayColor, userType, lastLoginTime, contractDate;
                    //private Bitmap userphoto;

                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**lignePanierCommandeId"+json.getString("lignePanierCommandeId"));
                    //s = s + "login info : "
                    //        + json.getString("userID") + " " + json.getString("adminLevel") + " " + json.getString("isActive")
                    //        + json.getString("sessionToken") + " " + json.getString("userEmail") + " " + json.getString("userPasswd")
                    //        + json.getString("userFName") + " " + json.getString("userLName") + " " + json.getString("description")
                    //        + json.getString("userPhone") + " " + json.getString("displayColor") + " " + json.getString("userType")
                    //        + json.getString("lastLoginTime") + " " + json.getString("contractDate") + " " + json.getString("userphoto");
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**=>"+i);
                    //        String flname = json.getString("fName");//+" "+json.getString("lName");



                    //item1 = new ListItem(flname, json.getString("identityNumber"),    json.getString("licenceValidity") , R.drawable.a);//getResources().getResourceEntryName(R.drawable.a)
//int clientID, String nameComplt,       String birthDate, String photo, String identityDoc, String identityNumber, String inscriptionDate, String ensurenceValidity, String licenceValidity, String clientEmail, String clientPhone, String notes
                    //getJSONArray aze = json.getJSONArray("lignePanierCommande");                            //quantite   product
                    item1 = new LignePanierCommande(json.getString("lignePanierCommandeId"),json.getString("quantite"),json.getJSONObject("product"),json.getString("idCom"));
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**==>"+json.getString("lignePanierCommandeId")+json.getString("quantite")+json.getJSONObject("product")+json.getString("idCom"));
           //         JSONObject liv = json.getJSONObject("livreur");
                    //                 Log.d(CommandeList.class.getSimpleName(),"**mohamed**liv==>"+liv.getInt("id")+liv.getString("username"));
                    lists.add(item1);
                }


                if(!lists.isEmpty()){

                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**1");
                    adapter = new MyAdaptorProductList(getApplicationContext(), lists);
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**2");
                    recyclerView2 = findViewById(R.id.recyclerView2);
                    recyclerView2.setHasFixedSize(true);





                    recyclerView2.setLayoutManager(new LinearLayoutManager( getApplicationContext()));
                    recyclerView2.setAdapter(adapter);//lier recyclerView1 avec adapter
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**3");
//                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    //Intent in=new Intent(getApplicationContext(),MainActivity3.class);
                    //in.putExtra("userID", id);
                    //startActivity(in);
                    //MainActivity.this.finish();

                    //editText = findViewById(R.id.editText);
                    //editText15 = findViewById(R.id.editText15);
                    //editText16 = findViewById(R.id.editText16);
                    //editText17 = findViewById(R.id.editText17);

                    //                textView = findViewById(R.id.textView);
                    //editText19 = findViewById(R.id.editText19);
                    //editText20 = findViewById(R.id.editText20);
                    //editText21 = findViewById(R.id.editText21);

                    //                textView2 = findViewById(R.id.textView2);
                    //                textView3 = findViewById(R.id.textView3);
                    //editText24 = findViewById(R.id.editText24);
                    //                textView4 = findViewById(R.id.textView4);

                    //editText26 = findViewById(R.id.editText26);
                    //editText27 = findViewById(R.id.editText27);



                    //editText.setText(user1.getUserID()+"");
                    //editText15.setText(user1.getAdminLevel()+"");
                    //editText16.setText(user1.getIsActive()+"");
                    //editText17.setText(user1.getSessionToken());

                    //               textView2.setText(user1.getUserEmail());
                    //editText19.setText(user1.getUserPasswd());
                    //editText20.setText(user1.getUserFName());
                    //editText21.setText(user1.getUserLName());

                    //editText22.setText(user1.getDescription());
                    //editText23.setText(user1.getUserPhone());
                    //editText24.setText(user1.getDisplayColor());
                    //editText25.setText(user1.getUserType());

                    //editText26.setText(user1.getLastLoginTime());
                    //editText27.setText(user1.getContractDate());

                    //               textView.setText(user1.getUserType());
                    //               textView4.setText(user1.getDescription());
                    //               textView3.setText(user1.getUserPhone());
                    //               int a = R.drawable.playstore;

                    //               imageView1 = findViewById(R.id.imageView1);
                    //               imageView1.setImageResource(a);
                }
                else
                    Toast.makeText(getApplicationContext(),"user name or password isnot correct",Toast.LENGTH_LONG).show();


            } catch (Exception e) {

// TODO: handle exception

                Log.e("log_tag", "Error Parsing Data "+e.toString());

            }
        }




    }
}

