SUMMARY = "pulse audio modules (for use with bluetooth devices)"
SECTION = "console"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PV = "1.0"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
	libpulsecore \
	libpulsecommon \
	libpulse \
	libpulse-simple \
	libpulse-mainloop-glib \
	pulseaudio-server \
	pulseaudio-misc \
	pulseaudio-module-console-kit \
	pulseaudio \
	pulseaudio-bash-completion \
	pulseaudio-lib-bluez5-util \
	pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-policy \
	pulseaudio-module-bluez5-device \
"

#pulseaudio-dbg pulseaudio-staticdev pulseaudio-dev pulseaudio-doc pulseaudio-locale

