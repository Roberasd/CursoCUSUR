package mx.appdata.roberasd.myapplication.models;

import android.widget.ImageView;

/**
 * Created by Roberasd on 05/02/2016.
 */
public class PersonModel {

    int pictureProfile;
    String name;
    String years;
    String address;
    String nationality;

    public int getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(int pictureProfile) {
        this.pictureProfile = pictureProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
