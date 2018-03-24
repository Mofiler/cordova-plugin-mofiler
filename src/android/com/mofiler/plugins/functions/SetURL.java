package com.mofiler.plugins.functions;

import android.util.Log;

import com.mofiler.Mofiler;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class SetURL {

	private static final String TAG = "SetUrlFunction";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Mofiler mof = Mofiler.getInstance(cordova.getActivity());
			mof.setURL(args.getString(0));
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "error", e);
		}
	}

}
