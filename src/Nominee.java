import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String hsGradFrom;
    String name;
    String email;
    Double distanceToDrive;
    String phone;
    ArrayList<NomineeInfo> nominees = new ArrayList<>();
    String attendance;
    String contact;
    String position;
    String nomineeRelationship;


    public void creatingNominee() {
        isNomineeASenior();
        getPosition();
        getAttendance();
        getEmail();
        getPhone();
        findDistance();



        showNominee();

    }

    public void welcomeGreeting() {
        System.out.println("\n****2020 Base Camp Student nomination!****");
        System.out.print("\nTo get started hit ENTER ");
        while (true) {

            String goAhead = input.nextLine();
            if (goAhead.equals("")) {
                creatingNominee();
                break;
            }
            else {
                System.out.print("Go ahead and hit enter.");
            }

        }

    }

    public void getName() {
        System.out.print("Nominee's full name: ");
        String nameInput = input.nextLine();
        name = nameInput;
    }

    public void getEmail() {
        while (true) {
            System.out.print("Nominator's email: ");
            String emailInput = input.nextLine();
            if (isEmailValid(emailInput)) {
                email = emailInput;
                break;
            }
            else {
                System.out.println("Sorry, invalid email");
            }
        }

    }

    public void getPhone() {
        while (true) {
            System.out.print("Nominator's Phone Number: ");
            Long phoneInput = input.nextLong();



            try {
                if (isPhoneValid(phoneInput)) {
                    phone = String.valueOf(phoneInput).replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1)-$2-$3");
                    break;
                } else {
                    System.out.print("Sorry, invalid phone number");
                }
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }


        }
        getContact();

    }

    public boolean isPhoneValid(long phone) {
        String phoneReg = "\\d{10}";


        String  result = Long.toString(phone);
        Pattern p = Pattern.compile(phoneReg);
        return p.matcher(result).matches();
    }

    public void findDistance() {

        while (true) {
            System.out.print("Driving distance(miles)? ");
            double driveDis = input.nextDouble();
            if (driveDis > 150) {
                System.out.println("Might want to relocate closer.");
                distanceToDrive = driveDis;
                break;
            } else if (driveDis < 150){
                distanceToDrive = driveDis;
                break;
            } else {
                System.out.println("Please give a valid distance.");
                break;
            }

        }
    }

    public void getHS() {
        System.out.print("What high school is your nominee currently in? ");
        String hs = input.nextLine();
        hsGradFrom = hs;
        getName();

    }

    public void showNominee() {
        nominees.add(new NomineeInfo(name,email,isSenior, hsGradFrom, distanceToDrive, attendance, phone, contact, position, nomineeRelationship));
        for (var nominee : nominees) {
            System.out.print("\n");
            System.out.println(String.format("Name: %s", nominee.name));
            System.out.println(String.format("Nominator's Email: %s", nominee.email));
            System.out.println(String.format("Senior in Hs: %s", nominee.isSenior));
            System.out.println(String.format("High School: %s", nominee.hsGradFrom));
            System.out.println(String.format("Distance to Drive: %s miles", nominee.distanceToDrive));
            System.out.println(String.format("Total days missed: %s days", nominee.attendance));
            System.out.println(String.format("Nominee's Phone Number: %s", nominee.number));
            System.out.println(String.format("Preferred method of contact: %s", nominee.contactMethod));
            System.out.println(String.format("Nominator's Current Position: %s", nominee.position));
            System.out.println(String.format("Relationship to nominee:  %s", nominee.relationship));


        }
    }

    public boolean isEmailValid(String email) {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern p = Pattern.compile(emailReg);
        return p.matcher(email).matches();
    }

    public void isNomineeASenior() {
        System.out.print("Is your nominee currently a senior? ");
        String senior = input.nextLine();
        while (true) {
            if (senior.equals("yes")) {
                getHS();
                isSenior = "yes";

                break;



            } else {
                System.out.println("Sorry, you are currently not eligible.");
                isSenior = "no";
                System.exit(0);




            }
        }
    }

    public void getAttendance() {
        System.out.print("How many days has your nominee been absent? ");
        String nomineeAttendance = input.nextLine();


        attendance = nomineeAttendance;
        relationshipToNominee();

    }

    public void getContact() {
        System.out.print("How would you prefer to be contacted? ([1]Call, [2]Text or [3]Email) ");
        Integer contactMethod = input.nextInt();

        if (contactMethod.equals(1)) {
            contact = "Call";
        } else if (contactMethod.equals(2)) {
            contact = "Text";
        } else {
            contact = "Email";
        }


    }

    public void getPosition() {
        System.out.print("Your current position: ");
        String positionChoice = input.nextLine();

        position = positionChoice;


    }

    public void relationshipToNominee() {
        System.out.print("What is your relationship to " + name + "? ");
        String relationship = input.nextLine();

        nomineeRelationship = relationship;
    }


}
