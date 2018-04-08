package computing.mobile.com.ridesharing;

/**
 * Created by vicky on 8/4/18.
 */

public class MyLocationWithDestinationEntity {
    int uid;
    double srcLatitude;
    double srcLongitude;
    double destLatitude;
    double destLongitude;
    String  destination;


    public MyLocationWithDestinationEntity(int uid, double srcLatitude, double srclongitude, double destLatitude, double destlongitude, String destination) {
        this.uid = uid;
        this.srcLatitude = srcLatitude;
        this.srcLongitude = srclongitude;
        this.destLatitude = destLatitude;
        this.destLongitude = destlongitude;
        this.destination = destination;
    }


    public int getUid() {
        return uid;
    }

    public double getSrcLatitude() {
        return srcLatitude;
    }

    public double getSrcLongitude() {
        return srcLongitude;
    }

    public double getDestLatitude() {
        return destLatitude;
    }

    public double getDestLongitude() {
        return destLongitude;
    }

    public String getDestination() {
        return destination;
    }


}
