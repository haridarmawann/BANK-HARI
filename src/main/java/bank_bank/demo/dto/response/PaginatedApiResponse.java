package bank_bank.demo.dto.response;

import java.util.List;

public class PaginatedApiResponse<T> {
    private boolean success;
    private String message;
    private List<T> data;
    private int size;
    private int per_size;
    private int page;
    private long total;

    public PaginatedApiResponse(boolean success, String message, List<T> data, int size, int per_size, int page, long total) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.size = size;
        this.per_size = per_size;
        this.page = page;
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public static <T> PaginatedApiResponse<T> success(String message,PaginationResponse<T> paginationResponse) {
        return new PaginatedApiResponse<>(true, message, paginationResponse.getData(), paginationResponse.getSize(), paginationResponse.getPer_size(), paginationResponse.getPage(),paginationResponse.getTotal());
    }

    public static <T> PaginatedApiResponse<T> error(String message) {
        return new PaginatedApiResponse<>(false, message, null,0,0,0,0);
    }
}
