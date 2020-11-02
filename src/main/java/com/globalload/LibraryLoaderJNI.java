package com.globalload;

import java.io.IOException;
import java.util.logging.Logger;

public class LibraryLoaderJNI {

    private static final Logger LOGGER = Logger.getLogger(LibraryLoaderJNI.class.getName());

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libnativeload.so");
            LOGGER.info("Loaded nativeload");
        } catch (UnsatisfiedLinkError | IOException e) {
            LOGGER.warning("Couldn't load nativeload");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    public LibraryLoaderJNI() {
    }

    public static void main(String[] var0) {
        test();
    }

    public static native void test();

    public static native boolean loadLibrary(String var1) throws UnsatisfiedLinkError;

}
