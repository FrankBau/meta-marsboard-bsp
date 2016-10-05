# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)
# Adapted to MarS Board by Frank Bauernoeppel

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for MarS Board"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://imx6q-marsboard.dts \
"

do_compile_prepend () {
	cp ${WORKDIR}/imx6q-marsboard.dts \
	${S}/arch/${ARCH}/boot/dts
}

LOCALVERSION = "-1.0.0_ga+yocto"
SRCBRANCH = "boundary-imx_4.1.15_1.0.0_ga"
SRCREV = "76c24a0cde0d50fc8006b15db94f9c3efc5ec979"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(marsboard)"

