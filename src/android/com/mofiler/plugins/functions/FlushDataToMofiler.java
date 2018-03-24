package com.mofiler.plugins.functions;

import android.util.Log;

import com.mofiler.Mofiler;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class FlushDataToMofiler {

	private static final String TAG = "FlushDataToMofilerFn";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Log.d(TAG, "before mof.");
//			Log.d(TAG, "before mof act:" + cordova.getActivity().getPackageName());
			Mofiler mof = Mofiler.getInstance(cordova.getActivity());
			Log.d(TAG, "after mof.");
//			Log.d(TAG, "appKey"+mof);
//			Log.d(TAG, "appKey:"+mof.getAppKey());
//			Log.d(TAG, "appURL:"+mof.getURL());
			mof.flushDataToMofiler();
		} catch (Exception e) {
			e.printStackTrace();
			Log.d(TAG, "error", e);
		}
	}

}
