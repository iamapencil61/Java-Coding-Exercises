public class Main {
    public static void main(String[] args) {
        // Don't modify these values!
        int age = 25;
        int time = 1430;    // 24-hour format
        boolean isHoliday = true;

        // Your code to determine ticket type and price
        String ticketType = "";
        int price = 0;

        if (age < 13) {
            ticketType = "CHILD";
            price = 8;
            if(isHoliday) {
                price += 2;
            }
        }

        else if (age >= 13 && age <= 17) {
            ticketType = "TEEN";
            price = 12;
            if(isHoliday) {
                price += 3;
            }
        }

        else if (age >= 18 && age <= 59) {
            ticketType = "ADULT";
            price = 15;
            if(isHoliday) {
                price += 5;
            }

            if (time < 1700) {
                price -= 3;
            }
        }

        else {
            ticketType = "SENIOR";
            price = 10;
            if (time < 1700) {
                price -= 2;
            }
        }


        // Don't modify the code below
        System.out.println("Customer Age: " + age);
        System.out.println("Show Time: " + time);
        System.out.println("Holiday? " + isHoliday);
        System.out.println("-------------------");
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Final Price: $" + price);
    }
}