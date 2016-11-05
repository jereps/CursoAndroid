package br.com.sqlite.recycleview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() { return 0; }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
