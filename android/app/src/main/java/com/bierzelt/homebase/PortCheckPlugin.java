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
        Integer timeout = call.getInt("timeout", 3000);

        if (host == null || port == null) {
            call.reject("host and port required");
            return;
        }

        execute(() -> {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port), timeout);
                JSObject ret = new JSObject();
                ret.put("open", true);
                call.resolve(ret);
            } catch (Exception e) {
                JSObject ret = new JSObject();
                ret.put("open", false);
                call.resolve(ret);
            }
        });
    }
}
