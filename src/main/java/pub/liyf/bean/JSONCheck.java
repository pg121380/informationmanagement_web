package pub.liyf.bean;

public class JSONCheck {
    private String selectId;
    private String checkId;

    public JSONCheck(String selectId, String checkId) {
        this.selectId = selectId;
        this.checkId = checkId;
    }

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }
}
