package cindodcindy.tonjootest.contactlist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.PojoContacts;

public class RvAdapterFromStorage extends RecyclerView.Adapter<RvAdapterFromStorage.ChildFromStorage> {
    public Context context;
    public List<PojoContacts> pojoContacts;

    public RvAdapterFromStorage(Context context, List<PojoContacts>pojoContacts){
        this.context=context;
        this.pojoContacts=pojoContacts;
    }

    @NonNull
    @Override
    public ChildFromStorage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_contact, parent, false);
        ChildFromStorage storageChild = new ChildFromStorage(mView);

        return storageChild;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildFromStorage holder, int position) {
        final PojoContacts pojoContactss=pojoContacts.get(position);


        holder.textView_first_name.setText(pojoContactss.getFisrtNameContact());
        holder.textView_lastName.setText(pojoContactss.getLastNameContact());
        holder.textView_email.setText(pojoContactss.getEmailUserContact());
        holder.textView_gender.setText(pojoContactss.getGenderUserContact());

       /* holder.textView_url_image.setText(pojoContactss.getFotoUserContact());
        ImageView imageView = holder.imageView_picture;

        Glide.with(context)
                .load(pojoContactss.getFotoUserContact())
                .into(imageView);

        */




    }

    @Override
    public int getItemCount() {
        return pojoContacts.size();
    }

    public class ChildFromStorage extends  RecyclerView.ViewHolder{

        public TextView textView_first_name, textView_lastName, textView_email, textView_gender, textView_url_image;

        public ImageView imageView_picture;

        public ChildFromStorage(@NonNull View itemView) {
            super(itemView);
            textView_first_name=itemView.findViewById(R.id.tv_to_storage_first_name);
            textView_lastName=itemView.findViewById(R.id.tv_to_storage_last_name);
            textView_email=itemView.findViewById(R.id.tv_to_storage_email);
            textView_gender=itemView.findViewById(R.id.tv_to_storage_gender);
            imageView_picture=itemView.findViewById(R.id.iv__to_storage_image);
            textView_url_image=itemView.findViewById(R.id.tv_to_storage_image);
        }
    }
}
