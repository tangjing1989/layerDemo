package com.tangjing.util.serverInfo;

/**
 * Describe:服务器信息
 * User:tangjing
 * Date:2017/3/19
 * Time:下午4:28
 */

public class ServerInfoPojo {


    private String sumCpuMhz; //CPU的总量MHz:
    private String sumCpuFreeMhz;//CPU当前空闲率:
    private String sumCpuUsedMhz; //CPU总的使用率:

    private String sumMemSize; //当前内存总量
    private String sumMemUsedSize;//当前内存使用量
    private String sumResidueSize; //当前内存剩余量
    private String sumMemUsedRate;//当前内存占用率

    private String sumDiskSize;//磁盘总大小:
    private String sumDiskFreeSize;//磁盘可用大小:
    private String sumDiskUsedSize;//磁盘已经使用量:
    private String sumDiskUsedRate;//当前硬盘占用率

    public String getSumCpuMhz() {
        return sumCpuMhz;
    }

    public void setSumCpuMhz(String sumCpuMhz) {
        this.sumCpuMhz = sumCpuMhz;
    }

    public String getSumCpuFreeMhz() {
        return sumCpuFreeMhz;
    }

    public void setSumCpuFreeMhz(String sumCpuFreeMhz) {
        this.sumCpuFreeMhz = sumCpuFreeMhz;
    }

    public String getSumCpuUsedMhz() {
        return sumCpuUsedMhz;
    }

    public void setSumCpuUsedMhz(String sumCpuUsedMhz) {
        this.sumCpuUsedMhz = sumCpuUsedMhz;
    }

    public String getSumMemSize() {
        return sumMemSize;
    }

    public void setSumMemSize(String sumMemSize) {
        this.sumMemSize = sumMemSize;
    }

    public String getSumMemUsedSize() {
        return sumMemUsedSize;
    }

    public void setSumMemUsedSize(String sumMemUsedSize) {
        this.sumMemUsedSize = sumMemUsedSize;
    }

    public String getSumResidueSize() {
        return sumResidueSize;
    }

    public void setSumResidueSize(String sumResidueSize) {
        this.sumResidueSize = sumResidueSize;
    }

    public String getSumMemUsedRate() {
        return sumMemUsedRate;
    }

    public void setSumMemUsedRate(String sumMemUsedRate) {
        this.sumMemUsedRate = sumMemUsedRate;
    }

    public String getSumDiskSize() {
        return sumDiskSize;
    }

    public void setSumDiskSize(String sumDiskSize) {
        this.sumDiskSize = sumDiskSize;
    }

    public String getSumDiskFreeSize() {
        return sumDiskFreeSize;
    }

    public void setSumDiskFreeSize(String sumDiskFreeSize) {
        this.sumDiskFreeSize = sumDiskFreeSize;
    }

    public String getSumDiskUsedSize() {
        return sumDiskUsedSize;
    }

    public void setSumDiskUsedSize(String sumDiskUsedSize) {
        this.sumDiskUsedSize = sumDiskUsedSize;
    }

    public String getSumDiskUsedRate() {
        return sumDiskUsedRate;
    }

    public void setSumDiskUsedRate(String sumDiskUsedRate) {
        this.sumDiskUsedRate = sumDiskUsedRate;
    }
}
