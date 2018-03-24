package com.mofiler.plugins.functions;

import android.util.Log;

import com.mofiler.Mofiler;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class InjectValue {

	private static final String TAG = "InjectValueFunction";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Mofiler mof = Mofiler.getInstance(cordova.getActivity());
			
			mof.injectValue(args.getString(0), args.getString(1));
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "error", e);
		}
	}

}
