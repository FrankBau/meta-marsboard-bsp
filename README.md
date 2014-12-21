meta-marsboard-bsp
==================

Yocto BSP Layer for Embest Tech iMX6 MarS Board.

MarS Board: http://www.embest-tech.com/shop/star/marsboard.html

This Yocto layer is based on a buildroot build environment
for the MarS Board by Hariharan Veerappan:

https://gitorious.org/u-boot-2013-04-port-on-imx6-marsboard/u-boot-2013-04-port-on-imx6-marsboard/source/389452b8485c4398e3a62d6db16db36920f4c53a:


Build a test image
==================

Prerequisites:

A Yocto build host (tested with Ubuntu 14.04 LTS).
See https://www.yoctoproject.org/documentation 
for detailed setup information.

Installed Freescale Community BSP (tested with branch daisy) 
See https://github.com/Freescale/fsl-community-bsp-platform
for detailed setup information.

1. git clone this repo into the source folder of the Freescale
community BSP (${BSPDIR}/sources), parallel to the other meta-* layers

2. in the build folder of the Freescale community BSP, edit the following files:

* in ${BSPDIR}/build/conf/bblayers.conf add a last line 

<pre>
  ...
  ${BSPDIR}/sources/meta-marsboard-bsp \
"
</pre>

* in ${BSPDIR}/build/conf/local.conf change the MACHINE name
</pre>
  MACHINE ??= 'marsboard'
</pre>

3. start bitbake environment from ${BSPDIR}:
<pre>
  . ./setup_environment.sh build
</pre>

4. bitbake U-Boot bootloader and a test image
<pre>
  bitbake virtual/bootloader
  bitbake core-image-minimal
</pre>

5. Test the image on your MarS Board 

Later you might switch to a larger image like the included image-multimedia-full

How to run you test image
=========================

Please make sure that you do not (over)write the content of the
on-board SPI flash or eMMC card!!! You may brick your board!!!

For booting via USB-OTG, build and install the imx_usb_loader 
  https://github.com/boundarydevices/imx_usb_loader/

- install the test image including kernel (uImage) and device tree blob (.dtb)
  on a microSD card, insert the microSD card into the board
- set the board in USB-OTG boot mode
- connect the board to build host via USB-OTG for download.
- also connect the board to build host via ("serial") console, aka "debug port"
  and setup a terminal program like on your host like minicom -D /dev/ttyUSB0
- power-up/reset the board and download u-boot.imx to the board using imx_usb_loader
- use u-boot shell to load and boot Linux from microSD card:
<pre>
fatload mmc 0:1 0x10800000 /uImage
fatload mmc 0:1 0x12000000 /imx6q-marsboard.dtb
bootm 0x10800000 - 0x12000000
</pre>

- a root login prompt will appear after successfull boot.

The microSD card is mmc dev 0 for u-boot (boot partition mmc 0:1) and /dev/mmcblk0 for Linux (root fs: /dev/mmcblk0p2).
The on-board eMMC seems to work with the latest mainline u-boot but not the linux kernel (error -110)

Boot linux automatically
------------------------

- flash u-boot.imx (e.g. put it on microSD card root-fs partition 2) to on-board SPI flash:
  Note: this will overwrite the factory default u-boot which you might want to save first
<pre>
ext2load mmc 0:2 10800000 /u-boot.imx
sf probe
sf erase 0 +0x80000
sf write 0x10800000 0x400 0x80000
</pre>

- edit and save the u-boot environment
<pre>
setenv bootcmd "mmc rescan; fatload mmc 0:1 0x10800000 /uImage; fatload mmc 0:1 0x12000000 /imx6q-marsboard.dtb; bootm 0x10800000 - 0x12000000"
setenv bootargs "console=ttymxc1,115200 init=/sbin/init rw root=/dev/mmcblk0p2 rootwait video=mxcfb0:dev=hdmi,1920x1080M@60,if=RGB24 fbmem=32M"
saveenv
reset
</pre> 

