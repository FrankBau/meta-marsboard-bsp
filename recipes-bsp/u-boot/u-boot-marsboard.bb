require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

COMPATIBLE_MACHINE = "(marsboard)"

PROVIDES = "virtual/bootloader"

PV = "mainline+git${SRCPV}"

SRCREV = "f3363c060497515ca8b71451cb56f3ec0abacaa9"
SRC_URI = "git://git.denx.de/u-boot.git;branch=u-boot-2016.09.y \
           file://0001-increased-eth-phy-reset-time.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

