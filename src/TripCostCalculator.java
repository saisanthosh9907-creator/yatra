public class TripCostCalculator {

    public static double calcDriving(double distance, double mileage, double fuelPrice,
                                     double tollPerKm, int travellers, double speed) {
        double fuelNeeded = distance / mileage;
        double fuelCost = fuelNeeded * fuelPrice;
        double tollCost = distance * tollPerKm;
        return fuelCost + tollCost;
    }

    public static double calcFlying(double distance, double farePerKm, int passengers, boolean isReturn) {
        int legs = isReturn ? 2 : 1;
        double perTicket = distance * farePerKm * legs;
        return perTicket * passengers;
    }

    public static double calcStay(int nights, double hotelRate, int travellers, int pplPerRoom) {
        if (nights <= 0 || hotelRate <= 0 || travellers <= 0) return 0;
        if (pplPerRoom <= 0) pplPerRoom = 2;
        int rooms = (int) Math.ceil(travellers / (double) pplPerRoom);
        return rooms * hotelRate * nights;
    }

    public static double calcFood(int nights, int travellers, double foodPerDay) {
        if (nights <= 0 || foodPerDay <= 0 || travellers <= 0) return 0;
        return nights * travellers * foodPerDay;
    }

    public static void main(String[] args) {
        double distance = 570.0;
        int travellers = 4;

        double transport = calcDriving(distance, 18, 110, 1.5, travellers, 60);
        double stay = calcStay(2, 1500, travellers, 2);
        double food = calcFood(2, travellers, 300);
        double extras = 1000;

        double total = transport + stay + food + extras;
        double perPerson = total / travellers;

        System.out.println("Total Trip Cost = ₹" + Math.round(total));
        System.out.println("Per Person Cost = ₹" + Math.round(perPerson));
    }
}
