cmake_minimum_required(VERSION 2.6)

project(opencv-app)

file(GLOB_RECURSE src/*.cpp)

find_package(OpenCV REQUIRED)

add_executable(opencv-app src/opencv-app.cpp)

target_link_libraries(opencv-app opencv_core opencv_imgproc opencv_highgui opencv_videoio)

install(TARGETS opencv-app DESTINATION /usr/bin)

