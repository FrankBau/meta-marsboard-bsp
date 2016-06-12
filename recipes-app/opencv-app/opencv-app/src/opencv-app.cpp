#include <iostream>

#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>

int main()
{
    cv::VideoCapture videoCapture(0);
    //cv::VideoCapture videoCapture("mfw_v4lsrc ! ffmpegcolorspace ! video/x-raw-rgb ! appsink");
    //cv::VideoCapture videoCapture("/home/root/big_buck_bunny_480p_h264.mp4");
    if( !videoCapture.isOpened() )
    {
        std::cerr << "failed to open video capture, exit" << std::endl;
        return -1;
    }

    cv::Mat image;
    while(1)
    {
        videoCapture >> image;
        if( image.empty() )
        {
            std::cerr << "failed to get video image, break" << std::endl;
            break;
        }
        cv::imshow( "image", image );
        int c = cv::waitKey(1);
        if( c=='x' )
            break;
    }
    return 0;
}

