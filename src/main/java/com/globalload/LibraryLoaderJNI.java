package com.globalload;

import java.io.IOException;

public class LibraryLoaderJNI {

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libnativeload.so");
            System.out.println("Loaded nativeload");
        } catch (UnsatisfiedLinkError | IOException e) {
            System.out.println("Couldn't load nativeload");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public LibraryLoaderJNI() {
    }

    public static void main(String[] var0) {
        test();
    }

    public static native void test();

    public static native boolean loadLibrary(String var1);

}
