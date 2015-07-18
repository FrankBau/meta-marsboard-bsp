# extends fsl image by more features

require recipes-fsl/images/fsl-image-multimedia-full.bb

EXTRA_IMAGE_FEATURES += " ssh-server-openssh tools-sdk package-management" 

EXTRA_IMAGE_FEATURES += " tools-testapps tools-profile"

IMAGE_INSTALL_append += " htop i2c-tools"

IMAGE_INSTALL_append += " \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-gstreamer-full \
    packagegroup-fslc-gstreamer1.0 \
    packagegroup-fslc-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

# the default "Boot MarSBoard" is not a valid FAT label and caused stress
BOOTDD_VOLUME_ID = "BOOT"

# for on target development 
# this adds > 1GB additional sources and headers
# comment this out if not needed
EXTRA_IMAGE_FEATURES += " dev-pkgs"
IMAGE_INSTALL_append += " kernel-dev packagegroup-core-tools-profile packagegroup-core-buildessential kernel-devsrc kernel-modules"

# this reserves some extra free space on the rootfs partition
# drawback: this empty spaces makes the .sdcard image larger and copying (dd) slower
# as an alternative you might want to create a third "data" partition on the microSD card
IMAGE_ROOTFS_EXTRA_SPACE = "1024000" 

# strictly speaking: only needed for libav (OpenCV)
LICENSE_FLAGS_WHITELIST += " commercial"
