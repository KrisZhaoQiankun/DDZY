package fun.krisme.smartbus;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ruan {
    @SerializedName("status")
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("ruan")
    private List<person> list;

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

    public List<person> getList() {
        return list;
    }

    public void setList(List<person> list) {
        this.list = list;
    }
}
