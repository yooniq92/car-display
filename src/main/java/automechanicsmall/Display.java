package automechanicsmall;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Display_table")
public class Display {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String resvDate;
    private String resvTime;
    private String vehiNo;
    private String resvStat;
    private String rcptDate;
    private Integer rcptSeq;
    private String rcptStat;
    private Integer reprAmt;
    private Integer rcptAmt;
    private Integer payAmt;
    private String payStat;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getVehiNo() {
        return vehiNo;
    }

    public void setVehiNo(String vehiNo) {
        this.vehiNo = vehiNo;
    }
    public String getResvStat() {
        return resvStat;
    }

    public void setResvStat(String resvStat) {
        this.resvStat = resvStat;
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
    public String getRcptStat() {
        return rcptStat;
    }

    public void setRcptStat(String rcptStat) {
        this.rcptStat = rcptStat;
    }
    public Integer getReprAmt() {
        return reprAmt;
    }

    public void setReprAmt(Integer reprAmt) {
        this.reprAmt = reprAmt;
    }
    public Integer getRcptAmt() {
        return rcptAmt;
    }

    public void setRcptAmt(Integer rcptAmt) {
        this.rcptAmt = rcptAmt;
    }
    public Integer getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(Integer payAmt) {
        this.payAmt = payAmt;
    }
    public String getPayStat() {
        return payStat;
    }

    public void setPayStat(String payStat) {
        this.payStat = payStat;
    }

}
