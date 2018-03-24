Cordova Mofiler Plugin
======

## Install
cordova plugin add cordova-plugin-mofiler

## Usage - init
```			
	MofilerPlugin.setURL ("mofiler.com/mock"); //http://mofiler.com/mock <— para pruebas
	MofilerPlugin.setAppKey ("TEST-KEY");
	MofilerPlugin.setAppName ("Test Name");
	MofilerPlugin.setUseVerboseContext(true);
	MofilerPlugin.setUseLocation(true);
	MofilerPlugin.setReadPhoneState(false);

	MofilerPlugin.addIdentity("username", "bt"); //add any identity available 
```

## Usage - push values 
```
	MofilerPlugin.injectValue("valueKey", ""+new Date().getTime());
    MofilerPlugin.flushDataToMofiler();
```

