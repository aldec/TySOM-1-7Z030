#SRCREV := "646559729cbd1ae60dde8ab5189b6af7055314a6"
SRCREV := "0459660683261cccea374da8e53b3a6e4e1d6c5c"
#SRCREV := "e551d42b4ceb1517296af8f3bb2008455a39fc6e"
KBRANCH := "xcomm_zynq"
LINUX_VERSION := "4.4"
#LINUX_VERSION := "4.4+gitAUTOINC+0459660683"

# This version extension should match CONFIG_LOCALVERSION in defconfig
LINUX_VERSION_EXTENSION = ""
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

# Sources
SRC_URI = "git://github.com/analogdevicesinc/linux.git;protocol=https;branch=${KBRANCH}"

SRCREV_machine ?= "${SRCREV}"

require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Analog Devices Linux Kernel"

# Setup for Zynq architectures
#COMPATIBLE_MACHINE_ty-1_hdmi = "ty-1_hdmi"

COMPATIBLE_MACHINE_${MACHINE} = "${MACHINE}"

# # Uncomment this to make device trees. Device trees must be placed in ${THISDIR}/device_trees 
# FILESEXTRAPATHS_append := "${THISDIR}/device_trees"
# do_configure_prepend() {
#     cp ${WORKDIR}/*.dts ${TMPDIR}/work-shared/${MACHINE}/kernel-source/arch/${ARCH}/boot/dts/.
# }

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
SRC_URI_append = " file://defconfig"


SRC_URI_append = " \
		file://fix_simple_card.patch \
		"

