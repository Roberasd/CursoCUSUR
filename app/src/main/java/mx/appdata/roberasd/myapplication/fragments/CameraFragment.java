package mx.appdata.roberasd.myapplication.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import mx.appdata.roberasd.myapplication.R;

/**
 * Created by Roberasd on 03/02/2016.
 */
public class CameraFragment extends Fragment {

    private final static int SELECT_PICTURE = 200;
    private ImageView mSetPicture;

    public static CameraFragment newInstance(){
        CameraFragment cameraFragment = new CameraFragment();
        return cameraFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment_layout,
                container, false);


        Button mChoosePictureButton = (Button)
                view.findViewById(R.id.takePictureButton);

        mSetPicture = (ImageView) view.findViewById(R.id.setPicture);

        mChoosePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Tomer foto",
                        "Elegir de galeria",
                        "Cancelar"};
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity());
                builder.setTitle("Elige una opción");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (options[which] == "Tomer foto") {
                            openCamera();
                        } else if (options[which] == "Elegir de galeria") {
                            selectFromGallery();
                        } else
                            dialog.dismiss();
                    }
                });
            }
        });

        return view;
    }

    private void openCamera() {

    }

    private void selectFromGallery() {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(
                intent.createChooser(intent, "Selecciona una app de imágenes"),
                SELECT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case SELECT_PICTURE:
                if(resultCode == Activity.RESULT_OK){
                    Uri path = data.getData();
                    mSetPicture.setImageURI(path);
                }
        }

    }
}
