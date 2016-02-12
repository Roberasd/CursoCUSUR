package mx.appdata.roberasd.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import mx.appdata.roberasd.myapplication.R;
import mx.appdata.roberasd.myapplication.adapters.CustomAdapter;
import mx.appdata.roberasd.myapplication.models.PersonModel;

/**
 * Created by Roberasd on 05/02/2016.
 */
public class CustomListViewFragment extends Fragment {

    public static CustomListViewFragment newInstance(){
        CustomListViewFragment customListViewFragment =
                new CustomListViewFragment();

        return customListViewFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_listview_fragment,
                container, false);

        int[] images = {R.drawable.person1,
                        R.drawable.person2,
                        R.drawable.person3 };
        String[] names = {"juan perez", "sheldon", "obama"};
        String[] years = {"42", "43", "64"};
        String[] address = {"Allende #32 EEUU",
                            "Reforma #322 México",
                            "washington #21 EEUU "};
        String[] nationality = {"Mexicana",
                                "Peruana",
                                "Hondureño"};

        CustomAdapter adapter = new CustomAdapter(getActivity());
        ArrayList<PersonModel> arrayList = new ArrayList<>();
        ListView mCustomListView = (ListView) view.findViewById(R.id.listViewCustom);

        mCustomListView.setAdapter(adapter);

        for(int i = 0; i <= 2; i++){
            PersonModel model = new PersonModel();

            model.setName(names[i]);
            model.setYears(years[i]);
            model.setAddress(address[i]);
            model.setNationality(nationality[i]);
            model.setPictureProfile(images[i]);

            arrayList.add(model);
        }

        adapter.addAll(arrayList);


        return view;
    }
}
