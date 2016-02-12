package mx.appdata.roberasd.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import mx.appdata.roberasd.myapplication.R;
import mx.appdata.roberasd.myapplication.adapters.CardViewAdapter;
import mx.appdata.roberasd.myapplication.models.CardModel;

/**
 * Created by Roberasd on 05/02/2016.
 */
public class CardViewFragment extends Fragment{

    public static CardViewFragment newInstance(){
        CardViewFragment cardViewFragment =
                new CardViewFragment();

        return cardViewFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_frgment_layout,
                container, false);

        RecyclerView mRecyclerView = (RecyclerView)
                view.findViewById(R.id.cardList);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        int[] bg = {R.drawable.river,
                R.drawable.beach,
                R.drawable.mountain };

        int[] icon = {R.drawable.ic_river,
                R.drawable.ic_beach,
                R.drawable.ic_mountain };
        String[] title = {"Rio", "Playa", "Montaña"};
        String[] desc = {
                "Este es un rio y es de agua dulce",
                "en la playa hace mucho calor",
                "Puedes escalar pero hace mucho frio"};

        ArrayList<CardModel> arrayList = new ArrayList<>();
        CardViewAdapter adapter = new CardViewAdapter(arrayList, getActivity());
        mRecyclerView.setAdapter(adapter);

        for (int i = 0; i <= 2; i++){
            CardModel cardModel = new CardModel();
            cardModel.setBackgroundImage(bg[i]);
            cardModel.setTypeImage(icon[i]);
            cardModel.setTitle(title[i]);
            cardModel.setDescription(desc[i]);

            arrayList.add(cardModel);
        }



        return view;
    }
}
