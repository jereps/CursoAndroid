package br.com.sqlite.recycleview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.sqlite.R;
import br.com.sqlite.datamodel.ItemLogin;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private List<ItemLogin> lista;

    //contrutor
    public ItemAdapter (Context context, List<ItemLogin> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() { return 0; }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView email, senha;
        ImageButton btndelete;

        public ViewHolder(View itemView) {
            super(itemView);
            email = (TextView)itemView.findViewById(R.id.txtUser);
            senha = (TextView)itemView.findViewById(R.id.txtSenha);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
