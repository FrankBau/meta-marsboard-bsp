# extends image by Qt5
# needs meta-qt5 layer, see https://github.com/FrankBau/meta-marsboard-bsp/wiki/Qt5-on-MarS-Board

require image-multimedia-full.bb

# this reserves some extra free space on the rootfs partition
# drawback: this empty spaces makes the .sdcard image larger and copying (dd) slower
# as an alternative you might want to create a third "data" partition on the microSD card
IMAGE_ROOTFS_EXTRA_SPACE = "1024000" 

IMAGE_INSTALL_append += " \
  eglinfo-fb \
"

IMAGE_INSTALL_append += " \
    qt3d \
    qt3d-plugins \
    qt3d-qmlplugins \
    qtbase-fonts \
    qtbase-plugins \
    qtbase-tools \
    qtconnectivity \
    qtconnectivity-tools \
    qtconnectivity-qmlplugins \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtimageformats-plugins \
    qtlocation \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtscript \
    qtsensors \
    qtsvg \
    qtsvg-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtwebkit \
    qtwebkit-qmlplugins \
"

IMAGE_INSTALL_append += " \
    cinematicexperience \
    qtsmarthome \
    qt5everywheredemo \
    qtwebkit-examples \
    qtwebkit-examples-examples \
"

