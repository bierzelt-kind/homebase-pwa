package com.bierzelt.homebase;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.net.InetSocketAddress;
import java.net.Socket;

@CapacitorPlugin(name = "PortCheck")
public class PortCheckPlugin extends Plugin {

    @PluginMethod()
    public void check(PluginCall call) {
        String host = call.getString("host");
        Integer port = call.getInt("port");
        int timeout = call.getInt("timeout", 3000);

        if (host == null || port == null) {
            call.reject("host and port required");
            return;
        }

        final String h = host;
        final int p = port;
        final int t = timeout;

        new Thread(() -> {
            boolean isOpen = false;
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(h, p), t);
                isOpen = true;
            } catch (Exception e) {
                isOpen = false;
            }
            final boolean result = isOpen;
            JSObject ret = new JSObject();
            ret.put("open", result);
            call.resolve(ret);
        }).start();
    }
}
