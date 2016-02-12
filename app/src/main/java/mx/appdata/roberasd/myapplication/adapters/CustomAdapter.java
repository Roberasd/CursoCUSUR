package mx.appdata.roberasd.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import mx.appdata.roberasd.myapplication.R;
import mx.appdata.roberasd.myapplication.models.PersonModel;
import mx.appdata.roberasd.myapplication.wrapper.CustomWrapper;

/**
 * Created by Roberasd on 05/02/2016.
 */
public class CustomAdapter extends ArrayAdapter<PersonModel>{

    public CustomAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonModel model = getItem(position);
        CustomWrapper wrapper;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_listview, null);
            wrapper = new CustomWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (CustomWrapper) convertView.getTag();
        }

        wrapper.getTxtPersonName().setText(model.getName());
        wrapper.getTxtYears().setText(model.getYears());
        wrapper.getTxtAddress().setText(model.getAddress());
        wrapper.getTxtNationality().setText(model.getNationality());

        wrapper.getImgProfile()
                .setImageResource(model.getPictureProfile());

        return convertView;
    }
}
