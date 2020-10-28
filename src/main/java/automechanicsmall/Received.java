package automechanicsmall;

public class Received extends AbstractEvent {

    private Long id;
    private String rcptDate;
    private Integer rcptSeq;
    private String vehiNo;
    private String stat;
    private String resvDate;
    private String resvTime;
    private Integer reprAmt;
    private Integer acptAmt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRcptDate() {
        return rcptDate;
    }

    public void setRcptDate(String rcptDate) {
        this.rcptDate = rcptDate;
    }
    public Integer getRcptSeq() {
        return rcptSeq;
    }

    public void setRcptSeq(Integer rcptSeq) {
        this.rcptSeq = rcptSeq;
    }

    public String getVehiNo() {
        return vehiNo;
    }

    public void setVehiNo(String vehiNo) {
        this.vehiNo = vehiNo;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    public String getResvDate() {
        return resvDate;
    }

    public void setResvDate(String resvDate) {
        this.resvDate = resvDate;
    }
    public String getResvTime() {
        return resvTime;
    }

    public void setResvTime(String resvTime) {
        this.resvTime = resvTime;
    }
    public Integer getReprAmt() {
        return reprAmt;
    }

    public void setReprAmt(Integer reprAmt) {
        this.reprAmt = reprAmt;
    }
    public Integer getAcptAmt() {
        return acptAmt;
    }

    public void setAcptAmt(Integer acptAmt) {
        this.acptAmt = acptAmt;
    }
}
