# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://imx6q-marsboard.dts \
"

do_compile_prepend () {
	cp ${WORKDIR}/imx6q-marsboard.dts \
	${S}/arch/${ARCH}/boot/dts
}

LOCALVERSION = "-1.1.1+yocto"
SRCBRANCH = "boundary-imx_3.10.53_1.1.1_ga"
SRCREV = "${AUTOREV}"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(marsboard)"
