package com.isil.am2lesson11;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MainActivity extends ActionBarActivity {

    //-12.093531, -77.053057
    private GoogleMap mMap;
    private Double lat=-12.093531;
    private Double lng=-77.053057;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap == null) {
            return;
        }
        // Initialize map options. For example:
        // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //mMap.clear();
        //agregar marcador
        //-12.093531, -77.053057
        LatLng latLng= new LatLng(lat,lng);
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
        mMap.addMarker(new MarkerOptions()
                .title("ISIL")
                .snippet("Isil San Isidro")
                .position(latLng));


        // Polylines are useful for marking paths and routes on the map.
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(-12.093531, -77.053057))
                        .add(new LatLng(-12.097549, -77.048841))//-12.097549, -77.048841
                        .add(new LatLng(-12.096416, -77.057553))//-12.096416, -77.057553
                        .add(new LatLng(-12.093531, -77.053057))
        );
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.i("MAPA", "lng " + latLng.latitude + " lng " + latLng.longitude);
                mMap.addMarker(new MarkerOptions()
                        .title("Nuevo")
                        .snippet("Nuevo")
                        .position(latLng));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        //return super.onOptionsItemSelected(item);
        return false;
    }
}
