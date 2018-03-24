
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MofilerPlugin';

var Mofiler = {
	setURL: function(url, cb)
	{
    exec(cb, null, PLUGIN_NAME, 'setURL', [url]);
	},

	setAppKey: function(appKey, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'setAppKey', [appKey]);
	},

	setAppName: function(appName, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'setAppName', [appName]);
	},

	addIdentity: function(key, value, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'addIdentity', [key, value]);
	},

	setUseVerboseContext: function(state, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'setUseVerboseContext', [state]);
	},

	setReadPhoneState: function(state, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'setReadPhoneState', [state]);
	},
	
	setUseLocation: function(state, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'setUseLocation', [state]);
	},
	
	injectValue: function(key, value, cb)
	{
		exec(cb, null, PLUGIN_NAME, 'injectValue', [key, value]);
	},
	
	flushDataToMofiler: function(cb)
	{
		exec(cb, null, PLUGIN_NAME, 'flushDataToMofiler', []);
	},
	
};

module.exports = Mofiler;
