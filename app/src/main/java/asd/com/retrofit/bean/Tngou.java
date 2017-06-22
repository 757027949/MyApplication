package asd.com.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */

public class Tngou {
    @SerializedName("status")
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("tngou")
    private List<Cook> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Cook> getTngou() {
        return tngou;
    }

    public void setTngou(List<Cook> tngou) {
        this.tngou = tngou;
    }
}
