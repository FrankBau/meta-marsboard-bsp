# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

LOCALVERSION = "-1.0.1_ga+yocto"
SRCBRANCH = "boundary-imx_3.10.17_1.0.1_ga"
SRCREV = "bed3f6a3741ee09cfc767d9628148269ed4fcb12"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(marsboard)"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
  file://defconfig \
  file://imx6q-marsboard.dts \
"

do_cp_dts () {
  cp ${WORKDIR}/imx6q-marsboard.dts ${S}/arch/arm/boot/dts
}

addtask cp_dts after do_patch before do_compile

