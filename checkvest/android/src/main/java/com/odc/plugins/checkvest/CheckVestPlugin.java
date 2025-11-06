package com.odc.plugins.checkvest;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
//import com.getcapacitor.annotation.PluginMethod;
import com.getcapacitor.JSObject;

@CapacitorPlugin(name = "CheckVest")
public class CheckVestPlugin extends Plugin {
    private CheckVest implementation;

    @Override
    public void load() {
        implementation = new CheckVest(getContext());
    }




    //@PluginMethod
    public void checkHasVest(PluginCall call) {
        String base64 = call.getString("imageBase64");
        boolean showLogs = Boolean.TRUE.equals(call.getBoolean("showLogs", false));

        boolean hasVest = implementation.checkHasVest(base64, showLogs);

        JSObject ret = new JSObject();
        ret.put("hasVest", hasVest);
        call.resolve(ret);
    }
}