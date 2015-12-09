require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
#LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

COMPATIBLE_MACHINE = "(marsboard)"

PROVIDES = "virtual/bootloader"

PV = "mainline+git${SRCPV}"

# this is 2015-06-28 shortly after tag v2015.07-rc2
# SRCREV = "7853d76b0bdab9b1a4da0bba8da6d12b5b8a303f"

# v2015.10
SRCREV = "5ec0003b19cbdf06ccd6941237cbc0d1c3468e2d"
SRC_URI = "git://git.denx.de/u-boot.git;rev=${SRCREV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"


