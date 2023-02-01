package cn.liulin.algorithm.dhdesign.responchain;

/**
 * cn.liulin.algorithm.dhdesign.zzl$
 *
 * @author ll
 * @date 2021-03-12 09:54:52
 **/
public class Request {
    private Integer requestNumber;

    private String requestType;

    private String requestContent;

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }
}
