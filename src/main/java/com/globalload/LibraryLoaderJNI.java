package com.globalload;

public class LibraryLoaderJNI {

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libnativeload.so");
            System.out.println("Loaded nativeload");
        } catch (UnsatisfiedLinkError var1) {
            System.out.println("Couldn't load nativeload");
            System.out.println(var1.getMessage());
        }
    }

    public LibraryLoaderJNI() {
    }

    public static void main(String[] var0) {
        LibraryLoaderJNI libraryLoader = new LibraryLoaderJNI();
        libraryLoader.test();
    }

    public native void test();

    public native boolean loadLibrary(String var1);

}
