//Модель таблицы анкет для вывода
public class Prof {

   private int phone;
    private String secondName;
    private String name;
    private  String middleName;
    private  String position;
    private  String adress;
    private  String citizenship;
    private  String skills;
    private   String education;
    private   int passport;
    private   String experience;
    private   String other;

    public Prof(int phone, String secondName, String name, String middleName,String position,
                String adress, String citizenship, String skills, String education, int passport,
                String experience, String other) {
        this.phone = phone;
        this.secondName = secondName;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.adress = adress;
        this.citizenship = citizenship;
        this.skills = skills;
        this.education = education;
        this.passport = passport;
        this.experience = experience;
        this.other = other;
    }

    public Prof(){
    }



    public int getPhone(){
    return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }



    public String getSecondName(){
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }




    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public String getMiddleName(){
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;}


    public String getPosition(){
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }



    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }



    public String getCitizenship(){
        return citizenship;
    }
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }


    public String getSkills(){
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }



    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }


    public int getPassport(){
        return passport;
    }
    public void setPassport(int passport) {
        this.passport = passport;
    }



    public String getExperience(){
        return experience;
    }
    public void setExperience(String experience) {this.experience = experience;
    }



    public  String getOther(){
        return other;
    }
    public void setOther(String other) {this.other = other;}
}
