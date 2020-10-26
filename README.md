# global-load-library
A magic function that loads .so libraries with the RTLD_GLOBAL flag. It is especially useful when working with JNI library dependencies.

## Example:

``` java
import com.globalload;

public class HelloWorldJNI {
 
    static {
        // Loaded with RTLD_GLOBAL flag
        LibraryLoaderJNI.loadLibrary("/path/to/my_native_lib_A");
        // Not loaded with RTLD_GLOBAL flag
        System.load("/path/to/my_native_lib_B");
    }
    
    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }
 
    private native void sayHello();
}
```