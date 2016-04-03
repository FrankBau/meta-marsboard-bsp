# extends fsl image by more features

require recipes-fsl/images/fsl-image-multimedia-full.bb

EXTRA_IMAGE_FEATURES += " ssh-server-openssh tools-sdk package-management" 

EXTRA_IMAGE_FEATURES += " tools-testapps tools-profile"

IMAGE_INSTALL_append += " htop i2c-tools"

IMAGE_INSTALL_append += " \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

# 3DGPU HW acceleration stuff: egl, gles2, ...
IMAGE_INSTALL_append += " imx-gpu-viv eglinfo-fb"

# the default "Boot MarSBoard" is not a valid FAT label and caused stress
BOOTDD_VOLUME_ID = "BOOT"

# for on-target app development
EXTRA_IMAGE_FEATURES += " dev-pkgs"
IMAGE_INSTALL_append += " packagegroup-core-tools-profile packagegroup-core-buildessential"

# # for on-target kernel development
# this adds > 1GB additional sources and headers
# uncomment this if needed
# IMAGE_INSTALL_append += " kernel-dev kernel-devsrc kernel-modules"

IMAGE_INSTALL_append +=" cpufrequtils nano libsdl2 libsdl2-dev iperf git subversion wget" 

# the default "Boot MarSBoard" is not a valid FAT label and caused stress
BOOTDD_VOLUME_ID = "BOOT"

# this reserves some extra free space on the rootfs partition
# drawback: this empty spaces makes the .sdcard image larger and copying (dd) slower
# as an alternative you might want to create a third partition on the microSD card for storing data
IMAGE_ROOTFS_EXTRA_SPACE = "800000" 

# strictly speaking: only needed for libav (OpenCV)
LICENSE_FLAGS_WHITELIST += " commercial"
