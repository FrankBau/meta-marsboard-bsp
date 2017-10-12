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

LOCALVERSION = "-2.0.0_ga+yocto"
SRCBRANCH = "boundary-imx_4.1.15_2.0.0_ga"
SRCREV = "f7cc79eff5f3790104e85f00528cadf8572c38ea"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(marsboard)"

