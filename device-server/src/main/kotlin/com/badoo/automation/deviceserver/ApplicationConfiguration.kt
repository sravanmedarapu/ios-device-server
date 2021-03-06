package com.badoo.automation.deviceserver

import com.badoo.automation.deviceserver.ios.proc.SimulatorWebDriverAgent
import com.badoo.automation.deviceserver.ios.simulator.video.SimulatorVideoRecorder
import java.lang.Boolean.getBoolean

class ApplicationConfiguration {
    private val wdaSimulatorBundlePathProperty = "wda.bundle.path"
    val wdaSimulatorBundlePath: String = System.getProperty(wdaSimulatorBundlePathProperty)
            ?: throw RuntimeException("Must set system property: -D$wdaSimulatorBundlePathProperty=" +
                    "/ABSOLUTE/PATH/ios/facebook/simulators/WebDriverAgentRunner-Runner.app")
    val wdaSimulatorBundleId: String = System.getProperty("wda.bundle.id", "com.facebook.WebDriverAgentRunner.xctrunner")

    private val wdaDeviceBundlePathProperty = "wda.device.bundle.path"
    val wdaDeviceBundlePath: String = System.getProperty(wdaDeviceBundlePathProperty)
            ?: throw RuntimeException("Must set system property: -D$wdaDeviceBundlePathProperty=" +
                    "/ABSOLUTE/PATH/ios/facebook/devices/WebDriverAgentRunner-Runner.app")

    private val deviceServerConfigPathProperty = "device.server.config.path"
    val deviceServerConfigPath: String = System.getProperty(deviceServerConfigPathProperty)
            ?: throw RuntimeException("Must set system property: -D$deviceServerConfigPathProperty=./config/.device_config")

    val fbsimctlVersion: String = System.getProperty("fbsimctl.version", "HEAD-d30c2a73")

    val remoteWdaSimulatorBundleRoot = System.getProperty("remote.wda.simulator.bundle.path", "/usr/local/opt/web_driver_agent_simulator")

    val remoteWdaDeviceBundleRoot = System.getProperty("remote.wda.device.bundle.path", "/usr/local/opt/web_driver_agent_device")

    val trustStorePath: String = System.getProperty("trust.store.path", "")
    val assetsPath: String = System.getProperty("media.assets.path", "")
    val videoRecorderClassName = System.getProperty("video.recorder", SimulatorVideoRecorder::class.qualifiedName)
    val videoRecorderFrameRate = Integer.getInteger("video.recorder.frame.rate", 4)
    val simulatorWdaClassName = System.getProperty("simulator.wda.class", SimulatorWebDriverAgent::class.qualifiedName)
    val shouldPreinstallWDA: Boolean = getBoolean("preinstall.simulator.wda")
}
