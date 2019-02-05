public class NomineeInfo {
    String name;
    String email;
    String isSenior;
    String hsGradFrom;
    Double distanceToDrive;
    String attendance;
    String number;
    String contactMethod;
    String position;
    String relationship;

    public NomineeInfo(String name, String email, String isSenior, String hsGradFrom, Double distanceToDrive, String attendance, String number, String contactMethod, String position, String relationship) {
        this.name = name;
        this.email = email;
        this.isSenior = isSenior;
        this.hsGradFrom = hsGradFrom;
        this.distanceToDrive = distanceToDrive;
        this.attendance = attendance;
        this.number = number;
        this.contactMethod = contactMethod;
        this.position = position;
        this.relationship = relationship;
    }
}
