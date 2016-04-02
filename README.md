This repo extends the [FSL Community BSP](https://github.com/Freescale/fsl-community-bsp-platform)
with an additional [Yocto](https://www.yoctoproject.org/) layer to support the i.MX6 based [MarS Board](http://www.embest-tech.com/shop/star/marsboard.html)

Full docs are in the [wiki](https://github.com/FrankBau/meta-marsboard-bsp/wiki)


Test Setup
==========
Board connected via USB to a linux host using minicom.
`image-multimedia-full` boots from the microSD card

Test Cases
==========

Video Playback on HDMI
----------------------
A 1080p clip is played (audio+video) on HDMI with sound and about 5% CPU load:
`gst-play-1.0 big_buck_bunny_1080p_h264.mov`

You must first downlaod the clip from the internet, e.g. by typing
`wget https://download.blender.org/peach/bigbuckbunny_movies/big_buck_bunny_1080p_h264.mov`


Video Streaming Playback
------------------------
`gst-launch-1.0 uridecodebin uri=http://docs.gstreamer.com/media/sintel_trailer-480p.webm ! imxipuvideotransform ! imxipuvideosink`

 
Video Recording from USB Webcam
-------------------------------
An UVC compliant webcam with motionJPEG output was used (Microsoft LifeCam Studio).
The video stream is re-coded in H.264 and wrapped in a good old .avi container.

`gst-launch-1.0 v4l2src device=/dev/video0 ! 'image/jpeg,width=640,height=480' ! imxvpudec ! imxipuvideotransform ! imxvpuenc_h264 ! avimux ! filesink location=cam.avi`

The .avi file can be viewed using 

`gst-play-1.0 cam.avi`

Qt
--
On the build host bitbake shell enter:
`bitbake image-multimedia-full-with-qt` 
and install that image on the board.

On the board console enter:
`cd /usr/share/cinematicexperience-1.0`
`./Qt5_CinematicExperience -platform eglfs`
and watch the demo on HDMI monitor.

More examples are installed in parallel folders.






