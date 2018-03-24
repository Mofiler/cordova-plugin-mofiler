package com.mofiler.plugins.functions;

import android.util.Log;

import com.mofiler.Mofiler;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class SetAppKey {

	private static final String TAG = "SetAppKeyFunction";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Mofiler mof = Mofiler.getInstance(cordova.getActivity());

			mof.setSdkTypeAndVersion("Cordova Android SDK", "1.0.1");

			mof.setAppKey(args.getString(0));
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "error", e);
		}
	}

}
