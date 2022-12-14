package com.josh.nativelib

class NativeLib {

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
   external fun stringFromJNI(): String

    companion object {
        // Used to load the 'nativelib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}