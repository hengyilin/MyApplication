#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_example_hengyilin_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject jthis) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
