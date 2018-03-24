package com.mofiler.plugins.functions;


import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.mofiler.Mofiler;
import com.mofiler.plugins.utils.AdvertisingIdClient;

import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;


public class AddIdentity {

	private static final String TAG = "AddIdentityFunction";

	public void call(CordovaInterface cordova, JSONArray args) {
		Log.d(TAG, "called.");
		try {

			Mofiler mof = Mofiler.getInstance(cordova.getActivity());

			//patch until we have this implemented in the SDK
			try {
				if(mof.getIdentity("advertisingIdentifier")==null){
					final Mofiler _mof = mof;
					final Context _context = cordova.getActivity();
					new Thread(new Runnable() {
						public void run() {
							try {
								_mof.addIdentity("advertisingIdentifier", AdvertisingIdClient.getAdvertisingIdInfo(_context).getId());
							} catch (Exception e) {
								Log.e(TAG, "advertisingIdentifier error", e);
							}
						}
					}).start();
				}
			} catch (Exception e) {
				Log.e(TAG, "advertisingIdentifier error", e);
			}
			try {
				if(mof.getIdentity("android_id")==null){
					mof.addIdentity("android_id", Settings.Secure.getString(cordova.getActivity().getContentResolver(), Settings.Secure.ANDROID_ID));
				}
			} catch (Exception e) {
				Log.e(TAG, "android_id error", e);
			}

			
			mof.addIdentity(args.getString(0), args.getString(1));
		} catch (Exception e) {
//			e.printStackTrace();
			Log.e(TAG, "error", e);
		}
	}

}
