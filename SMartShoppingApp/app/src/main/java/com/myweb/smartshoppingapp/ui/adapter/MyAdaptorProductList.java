package com.myweb.smartshoppingapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myweb.smartshoppingapp.R;
import com.myweb.smartshoppingapp.data.model.CommandeModel;
import com.myweb.smartshoppingapp.data.model.LignePanierCommande;
import com.myweb.smartshoppingapp.ui.commande.CommandeList;

import org.json.JSONException;

import java.util.List;

public class MyAdaptorProductList extends RecyclerView.Adapter<MyAdaptorProductList.ViewHolder> {
    //quantite   product
    private Context context;//context howa lmo7tawa name description age
    private List<LignePanierCommande> listitems;

    private String lignePanierCommandeId;
    private String quantite;
    private String price;
    public MyAdaptorProductList(Context context, List listitems){
        this.context = context;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_une, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LignePanierCommande item = listitems.get(position);
        try {
            holder.lignePanierCommandeId.setText(""+item.getProduct().getString("productName"));
            holder.price.setText(item.getProduct().getString("price")+" DH");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.quantite.setText("Quantity: "+item.getQuantite());

   //     lignePanierCommandeId = item.getLignePanierCommandeId();
     //   quantite = item.getQuantite();
       // price = item.getQuantite();
    //    etat = item.getEtat();
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView lignePanierCommandeId;
        private TextView quantite;
        private TextView price;

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
            lignePanierCommandeId = itemView.findViewById(R.id.textView222);
            quantite = itemView.findViewById(R.id.textView111);
            price = itemView.findViewById(R.id.textView333);
    //        etat = itemView.findViewById(R.id.textView333);

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
            LignePanierCommande item = listitems.get(position);
//textView11  textView12  textView13   textView10
            Intent intent = new Intent(context, CommandeDetails.class);

            /*
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.lignePanierCommandeId.getContext());
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("NomDeLaVariable","Variable");
            editor.apply();

            intent.putExtra("commandeId", item.get);


/*
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

 */
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
            //Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();


        }
    }
}
