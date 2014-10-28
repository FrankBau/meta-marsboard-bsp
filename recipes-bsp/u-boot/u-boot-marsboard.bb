require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
COMPATIBLE_MACHINE = "(marsboard)"

PROVIDES = "virtual/bootloader"

PV = "v2013.04+git${SRCPV}"

SRCREV = "389452b8485c4398e3a62d6db16db36920f4c53a"
SRCBRANCH = "v2014.07-20140914"
SRC_URI = "git://git@gitorious.org:u-boot-2013-04-port-on-imx6-marsboard/u-boot-2013-04-port-on-imx6-marsboard.git;rev=${SRCREV};subpath=u-boot-2013.04"

S = "${WORKDIR}/u-boot-2013.04"

PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_MACHINE = "mx6qmarsboard"

