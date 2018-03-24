#import <Cordova/CDVPlugin.h>

@interface MofilerPlugin : CDVPlugin {
}

// The hooks for our plugin commands
- (void)setURL:(CDVInvokedUrlCommand *)command;
- (void)setAppKey:(CDVInvokedUrlCommand *)command;
- (void)setAppName:(CDVInvokedUrlCommand *)command;
- (void)addIdentity:(CDVInvokedUrlCommand *)command;
- (void)injectValue:(CDVInvokedUrlCommand *)command;
- (void)setUseVerboseContext:(CDVInvokedUrlCommand *)command;
- (void)setUseLocation:(CDVInvokedUrlCommand *)command;
- (void)setReadPhoneState:(CDVInvokedUrlCommand *)command;
- (void)flushDataToMofiler:(CDVInvokedUrlCommand *)command;

@end
