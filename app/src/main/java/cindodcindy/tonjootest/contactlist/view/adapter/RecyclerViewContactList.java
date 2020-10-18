package cindodcindy.tonjootest.contactlist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.Datum;

public class RecyclerViewContactList extends RecyclerView.Adapter<RecyclerViewContactList.ChildContactsList> {

    public List<Datum> contactList;

    public Context context;

    public RecyclerViewContactList(Context context, List<Datum>contactList){
        this.context=context;
        this.contactList=contactList;
    }


    @NonNull
    @Override
    public ChildContactsList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_rv, parent, false);
        ChildContactsList mViewHolder = new ChildContactsList(mView);


        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ChildContactsList holder, int position) {
        final Datum datum= contactList.get(position);
        holder.textView_firstName.setText(datum.getFirstName());
        holder.textView_email.setText(datum.getLastName());
        holder.textView_email.setText(datum.getEmail());
        holder.textView_gender.setText(datum.getGender());
        ImageView imageView = holder.imageView_image;

        Glide.with(context)
                .load(datum.getAvatar())
                .into(imageView);

        holder.cardView_onKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ChildContactsList extends RecyclerView.ViewHolder{

        public TextView textView_firstName, textView_last_name, textView_email, textView_gender;
        public ImageView imageView_image;
        public CardView cardView_onKlik;

        public ChildContactsList(@NonNull View itemView) {
            super(itemView);
            textView_firstName=itemView.findViewById(R.id.tv_first_name);
            textView_last_name=itemView.findViewById(R.id.tv_last_name);
            textView_email=itemView.findViewById(R.id.tv_email);
            textView_gender=itemView.findViewById(R.id.tv_gender);
            imageView_image=itemView.findViewById(R.id.iv_image);
            cardView_onKlik=itemView.findViewById(R.id.cv_on_klik);
        }
    }
}
