package fragmentrecyclerview.com.fragmentrecyclerview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Contact> mdata;
    Dialog myDialog;

    //construtor
    public RecyclerViewAdapter(Context mContext, List<Contact> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    //implementar o necessário método para nossa classe de adapter
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //inicio do dialogo

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name_tv = (TextView)myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_phone_tv = (TextView)myDialog.findViewById(R.id.dialog_phone_id);
                ImageView dialogo_contact_img = (ImageView)myDialog.findViewById(R.id.dialog_img);
                dialog_name_tv.setText(mdata.get(vHolder.getAdapterPosition()).getName());
                dialog_phone_tv.setText(mdata.get(vHolder.getAdapterPosition()).getPhone());
                dialogo_contact_img.setImageResource(mdata.get(vHolder.getAdapterPosition()).getPhoto());
                Toast.makeText(mContext,"teste click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mdata.get(position).getName());
        holder.tv_phone.setText(mdata.get(position).getPhone());
        holder.img.setImageResource(mdata.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    //recyclerview precisa de uma classe de viewholders
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;
        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_contact = (LinearLayout)itemView.findViewById(R.id.contact_item_id);
            tv_name = (TextView)itemView.findViewById(R.id.name_contact);
            tv_phone = (TextView)itemView.findViewById(R.id.phone_contact);
            img = (ImageView) itemView.findViewById(R.id.img_contact);
        }
    }
}
