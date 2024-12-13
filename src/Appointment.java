
public class Appointment
{
    private int appointmentID;
    private Patient patient;
    private Date date;
    private Date.Time time;
    private String status;
    private String date1;
    private String time2;

    public Appointment(int appointmentID, Patient patient, String date, String time)
    {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.date1 = date;
        this.time2 = time;
        this.status = "Scheduled";
        System.out.println("Appointment scheduled successfully.");
        System.out.println();
    }
    public Appointment(int appointmentID, Patient patient, Date date, Date.Time time)
    {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.status = "Scheduled";
        System.out.println("Appointment scheduled successfully.");
        System.out.println();
    }

    public int getAppointmentID()
    {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID)
    {
        this.appointmentID = appointmentID;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Date.Time getTime() {
        return time;
    }

    public void setTime(Date.Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void schedule()
    {
        setStatus("scheduled");
    }


    public void cancel()
    {
        setStatus("canceled");
    }

    public void reschedule(int month, int day, int hour, int minute)
    {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31 || day < 1 || hour>12||hour<1 && minute>59||minute<0) {
                    System.out.println("choose another date");
                    System.out.println();
                } else {
                    this.date.setMonth(month);
                    this.date.setDay(day);
                    this.time.setHour(hour);
                    this.time.setMinute(minute);
                    setStatus("reschedule");
                }
                break;

            case 2:
                if (day > 28 || day < 1 || hour>12||hour<1 && minute>59||minute<0) {
                    System.out.println("choose another date");
                    System.out.println();
                } else {
                    this.date.setMonth(month);
                    this.date.setDay(day);
                    this.time.setHour(hour);
                    this.time.setMinute(minute);
                    setStatus("reschedule");
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if(day>30||day<1 || hour>12||hour<1 && minute>59||minute<0){
                    System.out.println("choose another date");
                    System.out.println();
                }
                else {
                    this.date.setMonth(month);
                    this.date.setDay(day);
                    this.time.setHour(hour);
                    this.time.setMinute(minute);
                    setStatus("reschedule");
                }
                break;
        }

        if(month>12||month<1){
            System.out.println("choose another month");
            System.out.println();
        }

    }




    public String toString()
    {

        return "Appointment ID: " + getAppointmentID() + "\n" + "Patient ID: " + patient.getPatientID() + "\n" + "Date : " + date.getMonth() + "/" + date.getDay() + " " + time.getHour() + ":" + time.getMinute() + "\n" + "Status: " + getStatus() ;

    }

    public Patient getPatient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPatient'");
    }
}
