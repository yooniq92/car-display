package automechanicsmall;

public class Reserved extends AbstractEvent {

    private Long id;
    private String resvDate;
    private String resvTime;
    private String vehiNo;
    private String stat;

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
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}