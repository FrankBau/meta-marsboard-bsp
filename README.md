meta-marsboard-bsp
==================

Yocto BSP Layer for Embest Tech iMX6 MarS Board.

This Yocto layer is based on a buildroot build environment
for the MarS Board by Hariharan Veerappan:

https://gitorious.org/u-boot-2013-04-port-on-imx6-marsboard/u-boot-2013-04-port-on-imx6-marsboard/source/389452b8485c4398e3a62d6db16db36920f4c53a:


Build a test image
==================

Pre-requisites:

A Yocto build host (tested with Ubuntu 14.04 LTS).
See https://www.yoctoproject.org/documentation 
for detailed setup information.

Installed Freescale Community BSP (tested with branch daisy) 
See https://github.com/Freescale/fsl-community-bsp-platform
for detailed setup information.

1. git clone this repo into the source folder of the Freescale
community BSP (${BSPDIR}/sources), parallel to the other meta-* layers

2. in the build folder of the Freescale community BSP, edit the following files:
2.1. in ${BSPDIR}/build/conf/bblayers.conf add a last line 

  ...
  ${BSPDIR}/sources/meta-marsboard-bsp \
"

2.2. in ${BSPDIR}/build/conf/local.conf change the MACHINE name

  MACHINE ??= 'marsboard'

3. start bitbake environment from ${BSPDIR}:

  . ./setup_environment.sh build

4. bitbake U-Boot bootloader and a test image

  bitbake virtual/bootloader
  bitbake core-image-minimal

5. Test the image on your MarS Board 
  http://www.embest-tech.com/shop/star/marsboard.html

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
- use u-boot shell to load and boot Linux
- a root login prompt will appear after successfull boot.

