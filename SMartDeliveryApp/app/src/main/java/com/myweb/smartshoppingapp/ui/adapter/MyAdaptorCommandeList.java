package com.myweb.smartshoppingapp.ui.adapter;
import com.myweb.smartshoppingapp.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myweb.smartshoppingapp.data.model.CommandeModel;
import com.myweb.smartshoppingapp.ui.commande.CommandeList;

import org.json.JSONException;

import java.util.List;

public class MyAdaptorCommandeList extends RecyclerView.Adapter<MyAdaptorCommandeList.ViewHolder> {

    private Context context;//context howa lmo7tawa name description age
    private List<CommandeModel> listitems;

    private String commandeId;
    private String date_commande;
    private String etat;

    private SharedPreferences sharedPreferences;
    private static final String MYKEY= "secret";

    public MyAdaptorCommandeList(Context context, List listitems){
        this.context = context;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commande_list_une, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommandeModel item = listitems.get(position);
        holder.commandeId.setText("Num: "+item.getCommandeId());
        holder.date_commande.setText("Date: "+item.getDate_commande());
        if(item.getEtat()=="true")
            holder.etat.setText("Status: "+"Done");
        else
            holder.etat.setText("Status: "+"Not yet done");
        commandeId = item.getCommandeId();
        date_commande = item.getDate_commande();
        etat = item.getEtat();

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView commandeId;
        private TextView date_commande;
        private TextView etat;

        /*
        private TextView clientEmail;
        private TextView clientPhone;
        private TextView inscriptionDate;
        private TextView ensurenceValidity;
        private TextView licenceValidity;
        private TextView notes;
        */
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);//pour la fonction onClick
            commandeId = itemView.findViewById(R.id.textView111);
            date_commande = itemView.findViewById(R.id.textView222);
            etat = itemView.findViewById(R.id.textView333);

            /*
            clientEmail = itemView.findViewById(R.id.textView6);
            clientPhone = itemView.findViewById(R.id.textView7);
            inscriptionDate = itemView.findViewById(R.id.textView8);
            ensurenceValidity = itemView.findViewById(R.id.textView9);
            licenceValidity = itemView.findViewById(R.id.textView10);
            notes = itemView.findViewById(R.id.editTextTextMultiLine);
*/
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            CommandeModel item = listitems.get(position);
//textView11  textView12  textView13   textView10
            Intent intent = new Intent(context, CommandeDetails.class);

            intent.putExtra("commandeId", item.getCommandeId());

            try {
                intent.putExtra("id", item.getLogin().getString("id")+"");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                intent.putExtra("username", item.getLogin().getString("username")+"");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                intent.putExtra("email", item.getLogin().getString("email")+"");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                intent.putExtra("mobile", item.getLogin().getString("mobile")+"");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                intent.putExtra("adresse", item.getLogin().getString("adresse"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                intent.putExtra("idLiv", item.getLivreur().getInt("id")+"");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            intent.putExtra("etat", item.getEtat()+"");


            try {
                Log.d(CommandeList.class.getSimpleName(),"**mohamed**=adapter=>"+item.getEtat()+item.getLogin().getString("username")+item.getLogin().getString("email")+item.getLogin().getString("mobile")+item.getLogin().getString("adresse"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
            //Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();


        }
    }
}
