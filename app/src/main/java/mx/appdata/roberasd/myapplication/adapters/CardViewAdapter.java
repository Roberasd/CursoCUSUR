package mx.appdata.roberasd.myapplication.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.appdata.roberasd.myapplication.R;
import mx.appdata.roberasd.myapplication.models.CardModel;

/**
 * Created by Roberasd on 06/02/2016.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.Holder> {

    private ArrayList<CardModel> mCardModelArrayList;
    private Activity mAcvitivity;

    public CardViewAdapter(ArrayList<CardModel> cardModelArrayList, Activity activity){
        this.mCardModelArrayList = cardModelArrayList;
        mAcvitivity = activity;
    }

    @Override
    public int getItemCount() {
        return mCardModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.Holder holder, int position) {
        CardModel model = mCardModelArrayList.get(position);
        holder.mBackgroundImage.setImageResource(model.getBackgroundImage());
        holder.mIconBackground.setImageResource(model.getTypeImage());
        holder.mTitle.setText(model.getTitle());
        holder.mDescription.setText(model.getDescription());
    }

    @Override
    public CardViewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new Holder(itemView);
    }

    public class Holder extends RecyclerView.ViewHolder{
        private ImageView mBackgroundImage, mIconBackground;
        private TextView mTitle, mDescription;

        public  Holder(View v){
            super(v);

            mBackgroundImage = (ImageView) v.findViewById(R.id.imgBackground);
            mIconBackground = (ImageView) v.findViewById(R.id.iconBackground);
            mTitle = (TextView) v.findViewById(R.id.titleBackGround);
            mDescription = (TextView) v.findViewById(R.id.descriptionBackground);
        }
    }
}
