import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CheckVestPlugin)
public class CheckVestPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CheckVestPlugin"
    public let jsName = "CheckVest"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = CheckVest()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
}
