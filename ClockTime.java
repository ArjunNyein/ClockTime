
/**
 * This ClockTime class contains methods that give precise tracking of hours, minutes in seconds for 
 * 24 hour or 12 hour format and also allow you to modify the time.
 * 
 * @Arjun Nyein (your name)
 * @Assignment 9 Clock Time Class(a version number or a date)
 */
public class ClockTime
{
    //declare the instance variables 
    private int hour;
    private int minute;
    private int second;

    //constructor that sets all the variables to zero.
    public ClockTime(){
        hour = 0;
        minute = 0;
        second = 0;
    }

    //constructor that accpets three integer variables and checks for error.
    public ClockTime(int hour,int minute,int second){
        // Error checking for seconds
        if (second > 59) {
            second %= 60;
            minute += second / 60;
        } else if (second < 0) {
            second = 0;
        }

        // Error checking for minutes
        if (minute > 59) {
            minute %= 60;
            hour += minute / 60;
        } else if (minute < 0) {
            minute = 0;
        }

        // Error checking for hours
        if (hour > 23) {
            hour %= 24;
        } else if (hour < 0) {
            hour = 0;
        }
        //sets the variables
        this.minute = minute;
        this.hour = hour;
        this.second = second;

    }
    //getting hour
    public int getHour(){
        return hour;
    }
    //getting minutes
    public int getMinute(){
        return minute;
    }
    //getting seconds
    public int getSecond(){
        return second;
    }

    //setting hour if the conditons are met.
    public void setHour(int hour){

        //checks if hour is between 0 and 24.
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;

            //checks if hour is less than zero.
        } else if (hour < 0) {
            this.hour = 0;

            //making hour less than 24
        } else {
            this.hour = hour % 24;
        }
    }

    //setting the minute if conditions are met.
    public void setMinute(int minute){

        //checks if minutes is between 0 and 60
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;

            //checks if minute if less than 0.
        } else if (minute < 0) {
            this.minute = 0;

            //sets the extra minutes to the total hour.
        } else {
            this.minute = minute % 60;
            this.hour += minute / 60;
            setHour(this.hour);
        }
    }

    //setting the second if the conditions are met.
    public void setSecond(int second){

        //checking if second is between 0 and 60
        if (second >= 0 && second <= 59) {
            this.second = second;

            //checking if second is less than 0.
        } else if (second < 0) {
            this.second = 0;

            //sets the extra second to the total minute.
        } else {
            this.second = second % 60;
            this.minute += second / 60;
            setMinute(this.minute);
        }
    }

    //toString() method returns the hour, minute and second in a nice 24 hour format.
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    //toString12() method returns the hour, minute and second in a nice 12 hour format.
    public String toString12() {

        //checking the condition for if hour is over 12
        int displayHour = (hour % 12 == 0) ? hour : hour % 12;

        //checking if its am or pm
        String amPm = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", displayHour, minute, second, amPm);
    }

    //advance method allows you to modify the time.
    public void advance(int seconds){
        //checks if seconds is greater than 0
        if(seconds>0){
            //calculate total seconds 
            int totalSeconds = hour * 3600 + minute * 60 + second + seconds;

            // Calculate hours, minutes, and seconds
            this.hour = (totalSeconds / 3600) % 24;
            this.minute = (totalSeconds % 3600) / 60;
            this.second = totalSeconds % 60;

        }  
    }

    //checks if the the clocks have the same time.
    public boolean equals(ClockTime clockTime){
        //check if the conditions are met
        if((clockTime.getHour() == hour && clockTime.getMinute() == minute) && clockTime.getSecond() == second)
            return true;
        else
            return false;
    }

}
