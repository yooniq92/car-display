
package automechanicsmall;

public class PaymentApproved extends AbstractEvent {

    private Long id;
    private String rcptDate;
    private String rcptSeq;
    private String amt;

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
    public String getRcptSeq() {
        return rcptSeq;
    }

    public void setRcptSeq(String rcptSeq) {
        this.rcptSeq = rcptSeq;
    }
    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
}
