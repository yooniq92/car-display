package automechanicsmall;

public class PayRequested extends AbstractEvent {

    private Long id;
    private String rcptDate;
    private Integer rcptSeq;
    private Integer reprAmt;

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
    public Integer getReprAmt() {
        return reprAmt;
    }

    public void setReprAmt(Integer reprAmt) {
        this.reprAmt = reprAmt;
    }

}
