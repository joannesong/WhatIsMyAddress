package nyc.c4q.whatismyaddress.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.holder.EmailViewHolder;
import nyc.c4q.whatismyaddress.model.Email;

public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder>{
    private List<Email> emailList;

    public EmailAdapter(List<Email> emailList){
        this.emailList = emailList;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        return new EmailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        Email email = emailList.get(position);
        holder.onBind(email);
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }
}
