public class Inter {
    private int interviewID;
    private int phone;
    private String IntMonth;
    private String position;
    private String result;

    public Inter(int interviewID,int phone,String intMonth,String position,String result){
        this.interviewID = interviewID;
        this.phone = phone;
        this.IntMonth = intMonth;
        this.position = position;
        this.result = result;
    }

    public Inter(){
    }

    public int getInterviewID() { return interviewID; }
    public void setInterviewID(int interviewID) { this.interviewID = interviewID; }

    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }

    public String getIntMonth() {return IntMonth;}
    public void setIntMonth(String IntMonth) { this.IntMonth = IntMonth; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
