package com.bierzelt.homebase;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.net.InetSocketAddress;
import java.net.Socket;

public class PortCheckPlugin extends Plugin {

    @PluginMethod()
    public void check(PluginCall call) {
        String host = call.getString("host");
        Integer port = call.getInt("port");
        Integer timeout = call.has("timeout") ? call.getInt("timeout") : 4000;

        if (host == null || port == null) {
            call.reject("host and port required");
            return;
        }

        new Thread(() -> {
            boolean open = false;
            try {
                Socket sock = new Socket();
                sock.connect(new InetSocketAddress(host, port), timeout);
                sock.close();
                open = true;
            } catch (Exception e) {
                // port closed or timeout
            }
            final boolean result = open;
            getActivity().runOnUiThread(() -> {
                JSObject ret = new JSObject();
                ret.put("open", result);
                call.resolve(ret);
            });
        }).start();
    }
}
