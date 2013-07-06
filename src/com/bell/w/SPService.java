package com.bell.w;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SPService extends Service {
	private static final String tag = "spservice";

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	IBinder binder = new SPBinder();

	public class SPBinder extends Binder {
		SPService getService() {
			return SPService.this;
		}
	}

	LocationManager lm;
	SPLocationListener locationListener;
	NotificationManager mNM;

	/** Called when the activity is first created. */
	private void startMyService() {

		// ---use the LocationManager class to obtain GPS locations---
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		locationListener = new SPLocationListener(this);

		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 35,
				locationListener);

		Toast.makeText(getApplication(), "sp start", Toast.LENGTH_LONG).show();
	}

	private void stopMyService() {
		lm.removeUpdates(locationListener);

		Toast.makeText(getApplication(), "sp stop", Toast.LENGTH_LONG).show();
	}

	public void onCreate() {
		Log.i(tag, "myservice start");
		super.onCreate();
		startMyService();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopMyService();
	}
}
