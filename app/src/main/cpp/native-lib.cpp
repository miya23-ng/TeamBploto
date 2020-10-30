#include <jni.h>
#include <string>

#include <opencv2/opencv.hpp>

extern "C" JNIEXPORT jint JNICALL
Java_com_camera_teambploto_opencv_processImage(
        JNIEnv* env,
        jobject, /* this */
        jlong   objMatSrc,
        jlong   objMatDst) {

    cv::Mat* matSrc = (cv::Mat*) objMatSrc;
    cv::Mat* matDst = (cv::Mat*) objMatDst;

    static cv::Mat *matPrevious = NULL;
    if (matPrevious == NULL) {
        /* lazy initialization */
        matPrevious = new cv::Mat(matSrc->rows, matSrc->cols, matSrc->type());
    }
    cv::absdiff(*matSrc, *matPrevious, *matDst);
    *matPrevious = *matSrc;
    return 0;
}