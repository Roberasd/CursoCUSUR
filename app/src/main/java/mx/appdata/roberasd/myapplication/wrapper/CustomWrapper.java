package mx.appdata.roberasd.myapplication.wrapper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mx.appdata.roberasd.myapplication.R;


/**
 * Created by Roberasd on 05/02/2016.
 */
public class CustomWrapper {

    private View view;
    private TextView mPersonName, mNationality, mAddress, mYears;
    private ImageView mPictureProfile;
    
    public CustomWrapper(View view){
        this.view = view;
    }

    public TextView getTxtPersonName(){

        if(mPersonName == null)
            mPersonName = (TextView) view.findViewById(R.id.personName);

        return mPersonName;
    }

    public TextView getTxtNationality(){

        if(mNationality == null)
            mNationality = (TextView) view.findViewById(R.id.personNationality);

        return mNationality;
    }

    public TextView getTxtYears(){

        if(mYears == null)
            mYears = (TextView) view.findViewById(R.id.personYears);

        return mYears;
    }

    public TextView getTxtAddress(){

        if(mAddress == null)
            mAddress = (TextView) view.findViewById(R.id.personAddress);

        return mAddress;
    }

    public ImageView getImgProfile(){

        if(mPictureProfile == null)
            mPictureProfile = (ImageView) view.findViewById(R.id.personPicture);

        return mPictureProfile;
    }



}
