# global-load-library
A magic function that loads .so libraries with the RTLD_GLOBAL flag. It is especially useful when working with JNI library dependencies.

## Add dependency:

The package is stored in Maven Central.
To add the dependency on global-load-library using Maven, add the following in your repository:
### With pom.xml:
``` xml
<dependency>
    <groupId>com.github.victor-paltz</groupId>
    <artifactId>global-load-library</artifactId>
    <version>1.1.0</version>
</dependency>
```

### With Gradle:
``` gradle
dependencies {
    implementation 'com.github.victor-paltz:global-load-library:1.1.0'
}
```

## Example:

``` java
import com.globalload.LibraryLoaderJNI;

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