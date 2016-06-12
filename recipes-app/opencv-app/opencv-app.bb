DESCRIPTION = "cameracapture application"
SECTION = "examples"
LICENSE = "CLOSED"
PR = "r0"

DEPENDS = "opencv"

SRC_URI = "file://CMakeLists.txt file://src/opencv-app.cpp"

S = "${WORKDIR}"

inherit pkgconfig cmake
