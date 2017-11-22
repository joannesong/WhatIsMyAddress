package nyc.c4q.whatismyaddress.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.model.Email;


public class EmailViewHolder extends RecyclerView.ViewHolder {

    private TextView itemText;

    public EmailViewHolder(View itemView) {
        super(itemView);
        itemText = (TextView) itemView.findViewById(R.id.item_text);
    }
    public void onBind(Email email){
        itemText.setText(email.getEmail());
    }

}
