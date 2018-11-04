#import "MofilerPlugin.h"
#import <Mofiler/Mofiler-Swift.h>

#import <Cordova/CDVAvailability.h>

@implementation MofilerPlugin

NSString* appName;
NSString* appKey;


- (void)pluginInitialize {
}

- (void)setURL:(CDVInvokedUrlCommand *)command
{
    
    NSString* url = [command.arguments objectAtIndex:0];
   //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
   //Inicializa las demas propiedades que no son obligatorias
    mof.url = url;
    
}

- (void)setAppKey:(CDVInvokedUrlCommand *)command
{
    NSString* appKey = [command.arguments objectAtIndex:0]; 
   
    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
    
    if(!mof.isInitialized) {
        
        mof.appKey = appKey;
        
        [mof setSdkTypeAndVersionWithSdk_type: @"Cordova iOS SDK" sdk_version:@"1.0.2"];
        
        //TODO setUseLocation
        if(![mof.appName  isEqual: @""])
            [mof initializeWithAppKey: appKey appName: mof.appName useLoc: true useAdvertisingId: true];
        
        NSLog(@"--AppKey %@", mof.appKey);
        NSLog(@"--AppName %@", mof.appName);
        
    } else {
        NSLog(@"Already initialized!");
        NSLog(@"--AppKey %@", mof.appKey);
        NSLog(@"--AppName %@", mof.appName);
    }
}

- (void)setAppName:(CDVInvokedUrlCommand *)command
{
    
    NSString* appName = [command.arguments objectAtIndex:0]; 
    
    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];

    if(!mof.isInitialized) {
        
        mof.appName = appName;
        
        //TODO setUseLocation
        if(![mof.appKey  isEqual: @""])
            [mof initializeWithAppKey: mof.appKey appName: appName useLoc: true useAdvertisingId: true];
        
        NSLog(@"--AppKey %@", mof.appKey);
        NSLog(@"--AppName %@", mof.appName);
    } else {
        NSLog(@"Already initialized!");
        NSLog(@"--AppKey %@", mof.appKey);
        NSLog(@"--AppName %@", mof.appName);
    }
}

- (void)addIdentity:(CDVInvokedUrlCommand *)command
{
    NSString* key = [command.arguments objectAtIndex:0]; 
    NSString* value = [command.arguments objectAtIndex:1]; 

    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
    [mof addIdentityWithIdentity:@{key:value}];
    
}

- (void)injectValue:(CDVInvokedUrlCommand *)command
{
    NSString* key = [command.arguments objectAtIndex:0]; 
    NSString* value = [command.arguments objectAtIndex:1]; 
    
    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
    [mof injectValueWithNewValue:@{key:value} expirationDateInMilliseconds:nil];
    
}

- (void)setUseVerboseContext:(CDVInvokedUrlCommand *)command
{
    
    bool boolean = [[command.arguments objectAtIndex:0] boolValue];
    
    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
    mof.useVerboseContext = boolean;
    
}

- (void)setUseLocation:(CDVInvokedUrlCommand *)command
{
    
    // bool boolean = [[command.arguments objectAtIndex:0] boolValue];
    
    //Singleton de mofiler
//    Mofiler* mof = [Mofiler sharedInstance];
//    mof.useLocation = boolean;
    
}

- (void)setReadPhoneState:(CDVInvokedUrlCommand *)command
{

}

- (void)flushDataToMofiler:(CDVInvokedUrlCommand *)command
{
    //Singleton de mofiler
    Mofiler* mof = [Mofiler sharedInstance];
 
    //Fuerza el envio de datos alojados
    [mof flushDataToMofiler];
}

@end


