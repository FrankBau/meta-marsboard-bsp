# extends fsl image by more features

require recipes-fsl/images/fsl-image-multimedia-full.bb

EXTRA_IMAGE_FEATURES += " ssh-server-openssh tools-sdk package-management" 

EXTRA_IMAGE_FEATURES += " tools-testapps tools-profile"

EXTRA_IMAGE_INSTALL += " i2c-tools packagegroup-fslc-gstreamer1.0-full"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fslc-gstreamer1.0 \
    packagegroup-fslc-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

IMAGE_INSTALL +=" cpufrequtils nano libsdl2 libsdl2-dev iperf git subversion wget" 

# the default "Boot MarSBoard" is not a valid FAT label and caused stress
BOOTDD_VOLUME_ID = "BOOT"

IMAGE_ROOTFS_EXTRA_SPACE = "512000" 

