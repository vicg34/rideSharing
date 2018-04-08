package computing.mobile.com.ridesharing;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by vicky on 31/3/18.
 */

public interface ApiInterface {

    @POST("/api/account/signup")
    Call<AccountResponseEntity> signUp(@Body SignUpUserEntity signEntity);

    @POST("/api/location/nearby-users-without-destination")
    Call<NearByUsersWithoutDestinationEntity> getNearByUsersWithoutDestination(@Body NearByUsersWithoutDestinationEntity nearByUsersWithoutDestinationEntity)

}
