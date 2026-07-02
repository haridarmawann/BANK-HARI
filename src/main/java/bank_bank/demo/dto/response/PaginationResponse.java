package bank_bank.demo.dto.response;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> data;
    private int size;
    private int per_size;
    private int page;
    private long total;

    public PaginationResponse(List<T> data, int size, int per_size, int page, long total) {
        this.data = data;
        this.size = size;
        this.per_size = per_size;
        this.page = page;
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPer_size() {
        return per_size;
    }

    public void setPer_size(int per_size) {
        this.per_size = per_size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
