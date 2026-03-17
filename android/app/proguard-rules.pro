# Capacitor WebView
-keep class com.getcapacitor.** { *; }
-keep class com.bierzelt.homebase.** { *; }
-keepclassmembers class * {
    @com.getcapacitor.annotation.CapacitorPlugin *;
}
# Cordova plugins
-keep class org.apache.cordova.** { *; }
# Don't obfuscate JS bridge
-keepattributes JavascriptInterface
