# extends  image-multimedia-full by OpenCV
# OpenCV is a huge package. Use only when needed

require image-multimedia-full.bb

IMAGE_INSTALL_append += " opencv opencv-dev"

# This would add the pre-built samples to the image
# IMAGE_INSTALL_append += " opencv-samples"

# OpenCV depends on libav which has special license requirements 
# so don't forget to add the next line to your build/conf/local.conf (without the leading #)
# LICENSE_FLAGS_WHITELIST += " commercial"


