package com.ebookfrenzy.ejemplomapas

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ebookfrenzy.ejemplomapas.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val permisoFineLocation = Manifest.permission.ACCESS_FINE_LOCATION
    private val permisoCoarseLocation = Manifest.permission.ACCESS_COARSE_LOCATION
    private val CODIGO_SOLICITUD_PERMISO = 100
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap



        if(validarPermisoUbicacion()) {
            obtenerUbicacion()
        } else {
            pedirPermisos()
        }

        // Add a marker in Sydney and move the camera
        /*val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/
    }

    private fun validarPermisoUbicacion() : Boolean {
        val hayUbicacionPrecisa =
            ActivityCompat.checkSelfPermission(this, permisoFineLocation) == PackageManager.PERMISSION_GRANTED
        val hayUbicacionOrdinaria =
            ActivityCompat.checkSelfPermission(this, permisoCoarseLocation) == PackageManager.PERMISSION_GRANTED
        return hayUbicacionPrecisa && hayUbicacionOrdinaria
    }

    @SuppressLint("MissingPermission")
    private fun obtenerUbicacion() {
        fusedLocationClient.lastLocation.addOnSuccessListener(this, object: OnSuccessListener<Location> {

            override fun onSuccess(location: Location?) {
                if (location != null) {
                    Toast.makeText(applicationContext, location?.latitude.toString() + " - " +
                        location?.longitude.toString(), Toast.LENGTH_LONG).show()

                    val here = LatLng(location?.latitude, location?.longitude)
                    mMap.addMarker(MarkerOptions().position(here).title("Marker Here"))
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(here))
                }
            }

        })

        /*callback = object: LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)

                for (ubicacion in locationResult?.locations!!) {
                    Toast.makeText(applicationContext, ubicacion.latitude.toString() + " , " +
                            ubicacion.longitude.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, callback, null)*/
    }

    private fun pedirPermisos() {
        val deboProveerContexto = ActivityCompat.shouldShowRequestPermissionRationale(this, permisoFineLocation)
        if (deboProveerContexto) {
            //Mandar mensaje con explicación
            solicitudPermiso()
        } else {
            solicitudPermiso()
        }
    }

    private fun solicitudPermiso() {
        requestPermissions(arrayOf(permisoFineLocation, permisoCoarseLocation), CODIGO_SOLICITUD_PERMISO)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            CODIGO_SOLICITUD_PERMISO -> {
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    obtenerUbicacion()
                } else {
                    Toast.makeText(this, "No diste permiso para acceder a la ubicación",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    //private fun detenerActualizacionUbicacion() {
    //    fusedLocationClient.removeLocationUpdates(callback)
    //}

}