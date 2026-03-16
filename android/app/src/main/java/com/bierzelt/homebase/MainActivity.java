package com.bierzelt.homebase;

import com.getcapacitor.BridgeActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        initialPlugins.add(PortCheckPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
