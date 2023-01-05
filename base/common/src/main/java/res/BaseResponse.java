package res;

import enums.ResCodeEnum;
import org.apache.commons.lang.time.DateFormatUtils;

import java.io.Serializable;
import java.util.Map;

public class BaseResponse<T> implements Serializable {

    private String resTimestamp = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS");
    private String resCode;
    private String resMsg;
    private String traceID;
    private T resData;
    private Map<String, String> ext;
    private String requestUrl;

    public BaseResponse() {
        this.resCode = ResCodeEnum.OK;
        this.resMsg = ResCodeEnum.OK_NAME;
    }

    public BaseResponse(String resCode, String resMsg, String traceID, T resData, Map<String, String> ext) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.traceID = traceID;
        this.resData = resData;
        this.ext = ext;
    }

    public BaseResponse(ResCodeEnum resCodeEnum, String traceID, T resData, Map<String, String> ext) {
        this.resCode = resCodeEnum.getStatusCode();
        this.resMsg = resCodeEnum.getStatusName();
        this.traceID = traceID;
        this.resData = resData;
        this.ext = ext;
    }

    public BaseResponse(ResCodeEnum resCodeEnum) {
        this(resCodeEnum.getStatusCode(), resCodeEnum.getStatusName());
    }

    public BaseResponse(ResCodeEnum resCodeEnum, T resData) {
        this(resCodeEnum.getStatusCode(), resCodeEnum.getStatusName(), resData);
    }

    public BaseResponse(String resCode, String resMsg) {
        this(resCode, resMsg, null);
    }

    public BaseResponse(String resCode) {
        this(resCode, ResCodeEnum.getResCodeEnum(resCode));
    }

    public BaseResponse(String resCode, T resData) {
        this(resCode, ResCodeEnum.getResCodeEnum(resCode), resData);
    }

    public BaseResponse(String resCode, String resMsg, T resData) {
        this(resCode, resMsg, null, resData, null);
    }

    public Map<String, String> getExt() {
        return this.ext;
    }

    public void setExt(Map<String, String> ext) {
        this.ext = ext;
    }

    public String getResTimestamp() {
        return this.resTimestamp;
    }

    public void setResTimestamp(String resTimestamp) {
        this.resTimestamp = resTimestamp;
    }

    public String getResCode() {
        return this.resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
        this.resMsg = ResCodeEnum.getResCodeEnum(resCode);
    }

    public void setResCode(ResCodeEnum resCodeEnum) {
        this.resCode = resCodeEnum.getStatusCode();
        this.resMsg = resCodeEnum.getStatusName();
    }

    public String getResMsg() {
        return this.resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public T getResData() {
        return this.resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public BaseResponse<T> setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    public static BaseResponse success(Object body) {
        return new BaseResponse(ResCodeEnum.RESCODE_SUCCESS, body);
    }

    public static BaseResponse fail(Object body) {
        return new BaseResponse(ResCodeEnum.RESCODE_OTHER_ERROR, body);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resTimestamp='" + resTimestamp + '\'' +
                ", resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", traceID='" + traceID + '\'' +
                ", resData=" + resData +
                ", ext=" + ext +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}
