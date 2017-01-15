# extends fsl image by more features

require recipes-fsl/images/fsl-image-multimedia-full.bb

IMAGE_FEATURES += " \
	ssh-server-openssh \
	dev-pkgs \
	tools-sdk \
	tools-testapps \
	tools-profile \
	package-management \
"

IMAGE_INSTALL_append += " strace tree htop tcpdump i2c-tools canutils"

IMAGE_INSTALL_append += " \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

IMAGE_INSTALL_append += " imx-gpu-viv"

# append only when framebuffer backend is used (check conf/local.conf)
IMAGE_INSTALL_append += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'eglinfo-x11', \
       bb.utils.contains('DISTRO_FEATURES', 'wayland', '', 'eglinfo-fb', d), d)} \
"

# Wlan stuff
IMAGE_INSTALL_append += " linux-firmware crda iw wireless-tools wpa-supplicant"

# for WiFi access point, needs meta-openembedded/meta-networking layer in bblayers.conf
IMAGE_INSTALL_append += " hostapd dnsmasq iptables"

# web server stuff
IMAGE_INSTALL_append += " lighttpd lighttpd-module-fastcgi php php-cli"

# the default "Boot MarSBoard" is not a valid FAT label and caused stress
BOOTDD_VOLUME_ID = "BOOTMARS"

# for on-target app development
IMAGE_INSTALL_append += " packagegroup-core-tools-profile packagegroup-core-buildessential"

# pulseaudio packages
IMAGE_INSTALL_append += " packagegroup-pulseaudio"



# # for on-target kernel development
# this adds > 1GB additional sources and headers
# uncomment this if needed
# IMAGE_INSTALL_append += " kernel-dev kernel-devsrc kernel-modules"

IMAGE_INSTALL_append +=" cpufrequtils nano iperf git subversion wget" 

# link errors in krogoth, t.b.d.
# IMAGE_INSTALL_append +=" libsdl2 libsdl2-dev" 

# this reserves some extra free space on the rootfs partition
# drawback: this empty spaces makes the .sdcard image larger and copying (dd) slower
# as an alternative you might want to create a third partition on the microSD card for storing data
IMAGE_ROOTFS_EXTRA_SPACE = "800000" 

IMAGE_FSTYPES = "sdcard"

# strictly speaking: only needed for libav (OpenCV)
LICENSE_FLAGS_WHITELIST += " commercial"

