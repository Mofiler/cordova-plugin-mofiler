/**
 */
package com.mofiler.plugins;

import android.util.Log;

import com.mofiler.plugins.functions.AddIdentity;
import com.mofiler.plugins.functions.FlushDataToMofiler;
import com.mofiler.plugins.functions.InjectValue;
import com.mofiler.plugins.functions.SetAppKey;
import com.mofiler.plugins.functions.SetAppName;
import com.mofiler.plugins.functions.SetReadPhoneState;
import com.mofiler.plugins.functions.SetURL;
import com.mofiler.plugins.functions.SetUseLocation;
import com.mofiler.plugins.functions.SetUseVerboseContext;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class MofilerPlugin extends CordovaPlugin {
  private static final String TAG = "MofilerPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing MofilerPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(action.equals("setURL")) new SetURL().call(cordova, args);
    else if(action.equals("setAppKey")) new SetAppKey().call(cordova, args);
    else if(action.equals("setAppName")) new SetAppName().call(cordova, args);
    else if(action.equals("addIdentity")) new AddIdentity().call(cordova, args);
    else if(action.equals("setUseVerboseContext")) new SetUseVerboseContext().call(cordova, args);
    else if(action.equals("setReadPhoneState")) new SetReadPhoneState().call(cordova, args);
    else if(action.equals("setUseLocation")) new SetUseLocation().call(cordova, args);
    else if(action.equals("injectValue")) new InjectValue().call(cordova, args);
    else if(action.equals("flushDataToMofiler")) new FlushDataToMofiler().call(cordova, args);

//    if(action.equals("echo")) {
//      String phrase = args.getString(0);
//      // Echo back the first argument
//      Log.d(TAG, phrase);
//    } else if(action.equals("getDate")) {
//
//    }
    return true;
  }

}
