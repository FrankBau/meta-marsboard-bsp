# extends fsl image by more features

require recipes-fsl/images/fsl-image-multimedia-full.bb

EXTRA_IMAGE_FEATURES += " ssh-server-openssh tools-sdk package-management" 
EXTRA_IMAGE_INSTALL += " i2c-tools packagegroup-fslc-gstreamer1.0-full"
IMAGE_INSTALL += " kernel-dev"
IMAGE_ROOTFS_EXTRA_SPACE = "1024000" 
