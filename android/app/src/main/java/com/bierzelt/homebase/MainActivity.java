package com.bierzelt.homebase;

import com.getcapacitor.BridgeActivity;
import android.os.Bundle;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(PortCheckPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
