import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebBaseResponse<T> {
    private static final long serialVersionUID = 4472769857279154680L;

    /** 返回码 */
    private String rspCd = "999999";

    /** 返回描述 */
    private String rspInf;

    private String rspType;

    private String responseTm;

    private List<T> rspData;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    /** 分页描述 */
    //private PageInfo<?> pageInfo;
    private String pageInfo;

    /** 额外返回参数 */
    private Map<String,Object> rspMap = new HashMap<String, Object>();

//    public PageInfo<?> getPageInfo() {
//        return pageInfo;
//    }
//
//    public void setPageInfo(PageInfo<?> pageInfo) {
//        this.pageInfo = pageInfo;
//    }

    public List<T> getRspData() {
        return rspData;
    }

    public void setRspData(List<T> rspData) {
        this.rspData = rspData;
    }

    public String getRspCd() {
        return rspCd;
    }

    public void setRspCd(String rspCd) {
        this.rspCd = rspCd;
    }

    public String getRspInf() {
        return rspInf;
    }

    public void setRspInf(String rspInf) {
        this.rspInf = rspInf;
    }

    public String getRspType() {
        return rspType;
    }

    public void setRspType(String rspType) {
        this.rspType = rspType;
    }

    public String getResponseTm() {
        return responseTm;
    }

    public void setResponseTm(String responseTm) {
        this.responseTm = responseTm;
    }

    public boolean isSuccess(){
//        if(SysCode.SUCCESS.equals(this.rspCd)){
//            return true;
//        }
        return false;
    }

    public Map<String, Object> getRspMap() {
        return rspMap;
    }

    public void setRspMap(Map<String, Object> rspMap) {
        this.rspMap.putAll(rspMap);
    }

    public void setRspVal(String key,Object val) {
        this.rspMap.put(key, val);
    }

    public WebBaseResponse(String rspCd, String rspInf){
        this.rspCd = rspCd;
        this.rspInf = rspInf;
    }

    public WebBaseResponse(){

    }

    public WebBaseResponse(String rspCd, String rspInf, String rspType, String responseTm) {
        this.rspCd = rspCd;
        this.rspInf = rspInf;
        this.rspType = rspType;
        this.responseTm = responseTm;
    }

    /**
     * set返回码
     * */
//    public void setMsgCode(MsgEnum msgCode){
//        this.setRspCd(msgCode.getMsgCode());
//        this.setRspInf(msgCode.getMsgInf());
//    }

    public static void main(String[] args) {
        WebBaseResponse<Map<String, Object>> response = new WebBaseResponse<Map<String, Object>>();
        response.setRspCd("000000");
        response.setRspInf("交易成功");

        Map<String, Object> rspMap = new HashMap<>();
        rspMap.put("NAME", "JasonMeng");
        rspMap.put("AGT" , "18");

        response.setRspMap(rspMap);

        System.out.println(response);
    }

//    @Override
//    public String toString() {
//        return YposToStringBuilder.toString(this);
//    }

    public String toStringTrue(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
