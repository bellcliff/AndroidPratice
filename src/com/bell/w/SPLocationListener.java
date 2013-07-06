package com.bell.w;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class SPLocationListener implements LocationListener {
	Context context;

	public SPLocationListener(Context context) {
		this.context = context;
	}

	@Override
	public void onLocationChanged(Location loc) {
		// send to server
		String locStr = loc.getLatitude() + "," + loc.getLongitude() + ","
				+ (loc.hasAltitude() ? loc.getAltitude() : "NULL") + ","
				+ (loc.hasAccuracy() ? loc.getAccuracy() : "NULL") + ","
				+ (loc.hasSpeed() ? loc.getSpeed() : "NULL") + ","
				+ (loc.hasBearing() ? loc.getBearing() : "NULL");
		Toast.makeText(context, locStr, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderDisabled(String arg0) {

	}

	@Override
	public void onProviderEnabled(String arg0) {

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

	}

}
