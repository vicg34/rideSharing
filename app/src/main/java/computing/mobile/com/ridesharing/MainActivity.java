package computing.mobile.com.ridesharing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    PlaceAutocompleteFragment autocompleteFragment;
    final int REQUEST_LOCATION_PERMISSION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete);
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setCountry("IN")
                .build();

        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
            }

            @Override
            public void onError(Status status) {
                Log.e("Error happeneddddddddd", "An error occurred: " + status);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        /*
        19.136152, 72.905595
        19.134976, 72.908299
        19.136993, 72.910649
        19.135016, 72.908063*/
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(19.135088, 72.905713);
        mMap.setOnInfoWindowClickListener(this);
        enableLocation();
        mMap.addMarker(new MarkerOptions().position(sydney).title("IIT Bombay").snippet("Tap to Chat").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.136152, 72.905595)).title("Destination:Airport")
                .snippet("Tap to Chat").icon(BitmapDescriptorFactory.defaultMarker
                        (BitmapDescriptorFactory.HUE_GREEN)
        ));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.134976, 72.908299)).title("Destination:Railway Station")
                .snippet("Tap to Chat").icon(BitmapDescriptorFactory.defaultMarker
                        (BitmapDescriptorFactory.HUE_GREEN)
        ));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.136993, 72.910649)).title("Destination:Hostel")
                .snippet("Tap to Chat").icon(BitmapDescriptorFactory.defaultMarker
                        (BitmapDescriptorFactory.HUE_GREEN)
        ));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.135433, 72.906176)).title("Destination:IIT")
                .snippet("Tap to Chat").icon(BitmapDescriptorFactory.defaultMarker
                        (BitmapDescriptorFactory.HUE_GREEN)
        ));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                            String[] permissions,
                                            int[] grantResults) {
        // Check if location permissions are granted and if so enable the
        // location data layer.
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    enableLocation();
                    break;
                }
        }
    }

    private void enableLocation() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            FusedLocationProviderClient client=LocationServices.getFusedLocationProviderClient(this);
            client.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if ( location!= null) {
                                double lat=location.getLatitude();
                                double log=location.getLongitude();
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,log),15));
                                autocompleteFragment.setBoundsBias(new LatLngBounds(new LatLng(lat+0.3,log+0.3),new LatLng(lat+0.3,log+0.3)));
                            }
                        }
                    });
            ;

        } else {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},

                    REQUEST_LOCATION_PERMISSION);
        }
    }
    public void onclickmethod(View v)
    {
        if(v.getId()==R.id.button2)
        {
            Intent myIntent = new Intent(this, Second.class);
            startActivity(myIntent);
        }
        else if(v.getId()==R.id.button3)
        {
            autocompleteFragment.setText("");
        }
    }
    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent myIntent = new Intent(this, ChatActivity.class);
        myIntent.putExtra("details",marker.getTitle());
        startActivity(myIntent);
    }
}
