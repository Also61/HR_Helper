package mediasoft.javacourse.coursework;

//Модель таблицы собеседований для вывода
public class Inter {
    private int interviewID;
    private String phone;
    private String InterMonth;
    private String position;
    private String result;

    public Inter(int interviewID,String phone,String InterMonth,String position,String result){
        this.interviewID = interviewID;
        this.phone = phone;
        this.InterMonth = InterMonth;
        this.position = position;
        this.result = result;
    }

    public Inter(){
    }

    public int getInterviewID() { return interviewID; }
    public void setInterviewID(int interviewID) { this.interviewID = interviewID; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getInterMonth() {return InterMonth;}
    public void setInterMonth(String InterMonth) { this.InterMonth = InterMonth; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
