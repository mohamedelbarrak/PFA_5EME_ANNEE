package com.myweb.smartshoppingapp.ui.commande;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myweb.smartshoppingapp.R;
import com.myweb.smartshoppingapp.data.model.CommandeModel;
import com.myweb.smartshoppingapp.ui.adapter.MyAdaptorCommandeList;

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


public class CommandeList extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private List<CommandeModel> lists;
    private RecyclerView.Adapter adapter;


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande_list);
    }
    */

    @Override
    protected void onStart() {//Bundle savedInstanceState
        super.onStart();//savedInstanceState
        setContentView(R.layout.activity_commande_list);

        new CommandeList.MyAsyncTaskresources().execute("http://192.168.56.1:8080/commande/list");
/*
        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent inten11 = new Intent( getApplicationContext(), MainActivityAddChi.class);
                startActivity(inten11);

            }
        });
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
                CommandeModel item1;
                String s = "";
                //Double id = 0.0;
                JSONArray jArray = new JSONArray(result);
                lists = new ArrayList<>();
                Log.d(CommandeList.class.getSimpleName(),"**mohamed**jArray.length()="+jArray.length());
                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject json = jArray.getJSONObject(i);
                    //String a = json.getString("userID");
                    //id = Double.parseDouble(a);
                    //private int userID, adminLevel, isActive;
                    //private String sessionToken, userEmail, userPasswd, userFName, userLName, description, userPhone, displayColor, userType, lastLoginTime, contractDate;
                    //private Bitmap userphoto;

                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**fName"+json.getString("commandeId"));
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
                    //getJSONArray aze = json.getJSONArray("lignePanierCommande");
                    item1 = new CommandeModel(json.getString("commandeId"),json.getString("date_commande"), json.getString("etat"),json.getJSONObject("livreur"),json.getJSONObject("login"), json.getJSONArray("lignePanierCommande"));
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**==>"+json.getInt("commandeId")+json.getString("date_commande")+json.getString("etat")+json.getJSONObject("livreur")+json.getString("login")+json.getJSONArray("lignePanierCommande"));
                    JSONObject liv = json.getJSONObject("livreur");
   //                 Log.d(CommandeList.class.getSimpleName(),"**mohamed**liv==>"+liv.getInt("id")+liv.getString("username"));
                    lists.add(item1);
                }


                if(!lists.isEmpty()){

                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**1");
                    adapter = new MyAdaptorCommandeList(getApplicationContext(), lists);
                    Log.d(CommandeList.class.getSimpleName(),"**mohamed**2");
                    recyclerView1 = findViewById(R.id.recycleView1);
                    recyclerView1.setHasFixedSize(true);
                    recyclerView1.setLayoutManager(new LinearLayoutManager( getApplicationContext()));
                    recyclerView1.setAdapter(adapter);//lier recyclerView1 avec adapter
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