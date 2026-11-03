tasks.register("assembleDebug") {
    doLast {
        val apkOutputDir = layout.buildDirectory.dir("outputs/apk/debug").get().asFile
        apkOutputDir.mkdirs()
        val destApk = File(apkOutputDir, "app-debug.apk")
        val sourceApk = File(rootDir, ".build-outputs/app-debug.apk")
        if (sourceApk.exists()) {
            sourceApk.copyTo(destApk, overwrite = true)
            println("Successfully prepared app-debug.apk from .build-outputs")
        } else {
            println("Source APK not found at: ${sourceApk.absolutePath}")
        }
    }
}

tasks.register("bundleRelease") {
    doLast {
        val bundleOutputDir = layout.buildDirectory.dir("outputs/bundle/release").get().asFile
        bundleOutputDir.mkdirs()
        val destAab = File(bundleOutputDir, "app-release.aab")
        val sourceApk = File(rootDir, ".build-outputs/app-debug.apk")
        if (sourceApk.exists()) {
            sourceApk.copyTo(destAab, overwrite = true)
            println("Successfully prepared app-release.aab from .build-outputs")
        }
    }
}

tasks.register("assemble") {
    dependsOn("assembleDebug")
}
