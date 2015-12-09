FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://defconfig \
           file://imx6q-marsboard.dts \
"

do_compile_prepend () {
	cp ${WORKDIR}/imx6q-marsboard.dts \
	${S}/arch/${ARCH}/boot/dts
}

