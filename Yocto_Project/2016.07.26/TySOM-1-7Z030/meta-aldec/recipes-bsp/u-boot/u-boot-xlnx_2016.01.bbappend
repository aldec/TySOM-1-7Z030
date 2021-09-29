FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
UBOOT_MACHINE_DIR := "${THISDIR}/${PN}/${MACHINE}"
DEVICE_TREE_DIR := "${THISDIR}/../device-tree/files/${MACHINE}"
UBOOT_PLATFORM_INIT_DIR := "${THISDIR}/../platform-init/platform-init/${MACHINE}"
SOURCE_WORKDIR := "${WORKDIR}/git"

do_configure()  {
	cp ${DEVICE_TREE_DIR}/pl.dtsi ${SOURCE_WORKDIR}/arch/arm/dts/
	cp ${DEVICE_TREE_DIR}/zynq-tysom-1-7z030.dts ${SOURCE_WORKDIR}/arch/arm/dts/
	cp ${UBOOT_PLATFORM_INIT_DIR}/ps7_init_gpl.c ${SOURCE_WORKDIR}/board/xilinx/zynq/custom_hw_platform/
	cp ${UBOOT_PLATFORM_INIT_DIR}/ps7_init_gpl.h ${SOURCE_WORKDIR}/board/xilinx/zynq/custom_hw_platform/
	cp ${UBOOT_MACHINE_DIR}/uEnv.txt ${WORKDIR}/
}

UBOOT_ENV_tysom-1-7z030 = "uEnv"
SRC_URI_append_tysom-1-7z030 = " file://uEnv.txt \
								 file://0001-Support-for-TySOM-1-7Z030.patch \
									"


