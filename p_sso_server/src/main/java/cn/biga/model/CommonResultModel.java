package cn.biga.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
public class CommonResultModel{
    //返回的值
    private Map<String,Object> returnValue;
    private String status;
    private String msg;
    private String redriectUrl;


    public Map<String, Object> getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Map<String, Object> returnValue) {
        this.returnValue = returnValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRedriectUrl() {
        return redriectUrl;
    }

    public void setRedriectUrl(String redriectUrl) {
        this.redriectUrl = redriectUrl;
    }

    /**
     *
     * 添加数据
     * @param key
     * @param value
     * @return
     */
    public CommonResultModel put(String key, Object value){
        if(returnValue==null){
            returnValue = new HashMap<String, Object>();
        }
        returnValue.put(key, value);
        return this;
    }
    /**
     *
     * 返回失败的实例
     * @return
     */
    public static CommonResultModel newFailedInstance(){
        CommonResultModel resultModel = new CommonResultModel();
        resultModel.setStatus("0000");
        resultModel.setMsg("失败");
        return resultModel;
    }
    /**
     *
     * 返回失败的实例
     * @return
     */
    public static CommonResultModel newFailedInstance(String msg){
        CommonResultModel resultModel = new CommonResultModel();
        resultModel.setStatus("0000");
        resultModel.setMsg(msg);
        return resultModel;
    }
    /**
     * 返回成功的实例
     * @return
     */
    public static CommonResultModel newSuccessInstance(){
        CommonResultModel resultModel = new CommonResultModel();
        resultModel.setStatus("0001");
        resultModel.setMsg("成功");
        return resultModel;
    }
    /**
     * 返回成功的实例
     * @return
     */
    public static CommonResultModel newSuccessInstance(String msg, String redriectUrl){
        CommonResultModel resultModel = new CommonResultModel();
        resultModel.setStatus("0001");
        resultModel.setRedriectUrl(redriectUrl);
        resultModel.setMsg(msg);
        return resultModel;
    }

}

