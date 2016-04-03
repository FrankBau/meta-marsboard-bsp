# extends  image-multimedia-full by OpenCV
# OpenCV is a huge package. Use only when needed

require image-multimedia-full.bb

IMAGE_INSTALL_append += " opencv opencv-dev"

# This adds the opencv samples to the image
IMAGE_INSTALL_append += " opencv-samples"

# OpenCV depends on libav which has special license requirements 
LICENSE_FLAGS_WHITELIST += " commercial"


