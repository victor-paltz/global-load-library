
#include "com_globalload_LibraryLoaderJNI.h"

#include <stdlib.h>
#include <iostream>
#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <dlfcn.h>
#include <string>
#include <sstream>
#include <jni.h>

#ifdef WINDOWS
#include <direct.h>
#define GetCurrentDir _getcwd
#else
#include <unistd.h>
#define GetCurrentDir getcwd
#endif

using namespace std;

std::string get_current_dir()
{
    char buff[FILENAME_MAX]; //create string buffer to hold path
    GetCurrentDir(buff, FILENAME_MAX);
    string current_working_dir(buff);
    return current_working_dir;
}

JNIEXPORT void JNICALL Java_com_globalload_LibraryLoaderJNI_test(JNIEnv *, jclass)
{

    std::cout << "Hello from C++ !!" << std::endl;

    std::cout << get_current_dir() << endl;
}

JNIEXPORT jboolean JNICALL Java_com_globalload_LibraryLoaderJNI_loadLibrary(JNIEnv *env, jclass thisClass, jstring path)
{

    const char *pathCharPointer = env->GetStringUTFChars(path, NULL);

    void *handle;
    handle = dlopen(pathCharPointer, RTLD_LAZY | RTLD_GLOBAL);

    if (!handle)
    {
        std::cout << "Failed loading" << pathCharPointer << std::endl;
        std::cerr << dlerror() << std::endl;

        jclass jcls = env->FindClass("java/lang/UnsatisfiedLinkError");
        env->ThrowNew(jcls, "Issue when loading the library");

        return false;
    }
    else
    {
        std::cout << "success loading" << pathCharPointer << "!!" << std::endl;
        return true;
    }
}