require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

COMPATIBLE_MACHINE = "(marsboard)"

PROVIDES = "virtual/bootloader"

PV = "mainline+git${SRCPV}"

SRCREV = "d8bec60c1b0de7770f9b56ad092ab9be801d99af"
SRC_URI = "git://git.denx.de/u-boot.git;rev=${SRCREV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"


