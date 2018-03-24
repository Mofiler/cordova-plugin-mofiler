package com.mofiler.plugins.functions;

import android.util.Log;

import com.mofiler.Mofiler;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;

public class SetUseVerboseContext {

	private static final String TAG = "SetUseVerboseContextFn";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Mofiler mof = Mofiler.getInstance(cordova.getActivity());
			mof.setUseVerboseContext(args.getBoolean(0));
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "error", e);
		}
	}

}
