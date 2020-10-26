# global-load-library
A magic function that loads .so libraries with the RTLD_GLOBAL flag. It is especially useful when working with JNI library dependencies.

## Example:

``` java
    import com.globalload;

	public class HelloWorldJNI {
 
    static {
        LibraryLoaderJNI.loadLibrary("my_native_lib_A"); // loaded with RTLD_GLOBAL flag
        System.loadLibrary("my_native_lib_B");           // not loaded with RTLD_GLOBAL flag
    }
    
    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }
 
    private native void sayHello();
}
```