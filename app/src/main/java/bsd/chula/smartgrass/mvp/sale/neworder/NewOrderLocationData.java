package bsd.chula.smartgrass.mvp.sale.neworder;

import com.google.android.gms.maps.model.LatLng;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by Dev_Tee on 5/13/17.
 */
@Parcel(Parcel.Serialization.BEAN)
public class NewOrderLocationData {

    private String mPlaceName;
    private LatLng mLatLng;
    private double mDistance;

    @ParcelConstructor
    public NewOrderLocationData(String placeName) {
        mPlaceName = placeName;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public void setPlaceName(String placeName) {
        mPlaceName = placeName;
    }

    public LatLng getLatLng() {
        return mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        mLatLng = latLng;
    }

    public double getDistance() {
        return mDistance;
    }

    public void setDistance(double distance) {
        mDistance = distance;
    }
}
