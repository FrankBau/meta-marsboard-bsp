require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
#LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

COMPATIBLE_MACHINE = "(marsboard)"

PROVIDES = "virtual/bootloader"

PV = "mainline+git${SRCPV}"

# this is tag v2015.07
SRCREV = "33711bdd4a4dce942fb5ae85a68899a8357bdd94"
SRC_URI = "git://git.denx.de/u-boot.git;rev=${SRCREV} \
           file://0001-increased-eth-phy-reset-time.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

