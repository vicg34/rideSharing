package computing.mobile.com.ridesharing;

import java.util.Map;

/**
 * Created by vicky on 8/4/18.
 */

public class NearByUsersWithoutDestinationEntity {
    public NearByUsersWithoutDestinationEntity(Map<Integer, Double[]> map) {
        this.map = map;
    }

    Map<Integer,Double []> map;
    public Map<Integer, Double[]> getMap() {
        return map;
    }


}
