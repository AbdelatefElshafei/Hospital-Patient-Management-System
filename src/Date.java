public class Date
{
    private int month;
    private int day;

    public Date(int month, int day)
    {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31 || day < 1) {
                    System.out.println("choose another day");

                } else {
                    this.month = month;
                    this.day = day;
                }
                break;

            case 2:
                if (day > 28 || day < 1) {
                    System.out.println("choose another day");
                } else {
                    this.month = month;
                    this.day = day;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if(day>30||day<1){
                    System.out.println("choose another day");
                }
                else {
                    this.month = month;
                    this.day = day;
                }
                break;
        }
        if(month>12||month<1){
            System.out.println("choose another month");
        }
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public void display()
    {
        System.out.print(day + "/" + month);
    }

    public static class Time
    {
        private int hour;
        private int minute;
        public Time(int hour, int minute)
        {
            if(hour>12||hour<1)
            {
                System.out.println("choose another hour");
            }
            else {
                this.hour=hour;
            }
            if (minute>59||minute<0){
                System.out.println("choose another min");
            }
            else {
                this.minute=minute;
            }
        }

        public int getHour()
        {
            return hour;
        }

        public void setHour(int hour)
        {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public void display()
        {
            System.out.println(hour + ":" + minute);
        }
    }
}

