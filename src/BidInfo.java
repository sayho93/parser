
public class BidInfo {

    public static final int KIND_GOOD = 1, KIND_CONS = 2, KIND_SERV = 3, KIND_NOT = 4;

    public BidInfo() {
    }

    public BidInfo(int type, String dataFrom, String url, String title, String term, String date) {
        this.type = type;
        this.dataFrom = dataFrom;
        this.url = url;
        this.title = title;
        this.term = term;
        this.date = date;
    }

    public BidInfo(int type, String dataFrom, String url, String title, String term, String bidNo, String bidType, String date, String expr, String dept, String charge, String chargePhone, String oppose, String opposeRepresent, String opposeAddress, String opposePhone) {
        this.type = type;
        this.dataFrom = dataFrom;
        this.url = url;
        this.title = title;
        this.term = term;
        this.bidNo = bidNo;
        this.bidType = bidType;
        this.date = date;
        this.expr = expr;
        this.dept = dept;
        this.charge = charge;
        this.chargePhone = chargePhone;
        this.oppose = oppose;
        this.opposeRepresent = opposeRepresent;
        this.opposeAddress = opposeAddress;
        this.opposePhone = opposePhone;
    }

    private int type = KIND_NOT; // 종류
    private String dataFrom = ""; // 자료출처
    private String url = ""; // URL
    private String title = ""; // 공고명
    private String term = ""; // 공고기간
    private String bidNo = ""; // 공고번호
    private String bidType = ""; // 입찰방식
    private String date = ""; // 게시 일자
    private String expr = ""; // 입찰 마감
    private String dept = ""; // 담당부서
    private String charge = ""; // 담당자
    private String chargePhone = ""; // 담당 전화번호
    private String oppose = ""; // 계약 상대 업체명
    private String opposeRepresent = ""; // 계약 상대 대표자
    private String opposeAddress = ""; // 계약 상대자 주소
    private String opposePhone = ""; // 계약 상대자 전화번호

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getBidNo() {
        return bidNo;
    }

    public void setBidNo(String bidNo) {
        this.bidNo = bidNo;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getChargePhone() {
        return chargePhone;
    }

    public void setChargePhone(String chargePhone) {
        this.chargePhone = chargePhone;
    }

    public String getOppose() {
        return oppose;
    }

    public void setOppose(String oppose) {
        this.oppose = oppose;
    }

    public String getOpposeRepresent() {
        return opposeRepresent;
    }

    public void setOpposeRepresent(String opposeRepresent) {
        this.opposeRepresent = opposeRepresent;
    }

    public String getOpposeAddress() {
        return opposeAddress;
    }

    public void setOpposeAddress(String opposeAddress) {
        this.opposeAddress = opposeAddress;
    }

    public String getOpposePhone() {
        return opposePhone;
    }

    public void setOpposePhone(String opposePhone) {
        this.opposePhone = opposePhone;
    }
}
