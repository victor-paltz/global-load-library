# global-load-library
A magic function that loads .so libraries with the RTLD_GLOBAL and RTLD_LAZY flags. It is especially useful when working with JNI library dependencies.

## Add dependency:

The package is stored in Maven Central.
To add the dependency on global-load-library using Maven, add the following in your repository:

### With pom.xml:
``` xml
<dependency>
    <groupId>com.github.victor-paltz</groupId>
    <artifactId>global-load-library</artifactId>
    <version>1.2.0</version>
</dependency>
```

### With Gradle:
``` gradle
dependencies {
    implementation 'com.github.victor-paltz:global-load-library:1.2.0'
}
```

## Example:

``` java
import com.globalload.LibraryLoaderJNI;

public class HelloWorldJNI {
 
    static {
        // Loaded with RTLD_GLOBAL flag
        try {
            LibraryLoaderJNI.loadLibrary("/path/to/my_native_lib_A");
        } catch (UnsatisfiedLinkError e) {
            System.Println("Couldn't load my_native_lib_A");
            System.Println(e.getMessage());
            e.printStackTrace();
        }

        // Not loaded with RTLD_GLOBAL flag
        try {
            System.load("/path/to/my_native_lib_B");
        } catch (UnsatisfiedLinkError e) {
            System.Println("Couldn't load my_native_lib_B");
            System.Println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }
 
    private native void sayHello();
}
```