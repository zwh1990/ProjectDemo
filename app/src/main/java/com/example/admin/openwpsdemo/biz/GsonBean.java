package com.example.admin.openwpsdemo.biz;

/**
 * @Created by zwh.
 * @description：Gson解析bean类
 * @date 2018/7/6 11:40
 * @邮箱：zhaowh@zgjzd.cn
 */
public class GsonBean {


    /**
     * MC : 强迫交易
     * SL : 0
     */

    private String MC;
    private String COUNT;
    private int SL;

    public String getMC() {
        return MC;
    }

    public void setMC(String MC) {
        this.MC = MC;
    }

    public String getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(String COUNT) {
        this.COUNT = COUNT;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    @Override
    public String toString() {
        return "GsonBean{" +
                "MC='" + MC + '\'' +
                ", COUNT=" + COUNT +
                ", SL=" + SL +
                '}';
    }
}
