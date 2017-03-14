package com.company;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by piumal on 11/4/16.
 */
public class WestminsterCarParkManager implements CarParkManager {


    //Creating 20 slots initialize as null
    static ArrayList<Vehicle> slots = new ArrayList<Vehicle>(Collections.nCopies(20,null));

    //Counter for Slots
    static int numVehicle = 0;
    static int carCount;
    static int vanCount;
    static int motorbikeCount;
    static int slotcounter;

    //Scanner to get Inputs
    Scanner sc = new Scanner(System.in);

    /* Static varibales to hold start and ed times of parking*/
    static String startDate, stopDateString, finalDate, stopTimeString, startTimeString;

    // Main Method
    public static void main(String[] args) {
        WestminsterCarParkManager wminCM = new WestminsterCarParkManager();
        wminCM.display();

    }

    /* Free Slot Search */
    @Override
    public void getFreeSlots() {
        slotcounter = 0;
        for (Vehicle vehicle : slots) {
            if (vehicle == null) {
                slotcounter++;
            }
        }

        if (slotcounter > 0) {
            System.err.println(" \n There are " + slotcounter + " free slots left. \n");
        } else {
            System.err.println("\n Sorry! There are no free slots left. \n");
        }
    }


    //Display Menu method
    @Override
    public void display() throws InputMismatchException {
        //variable to hold user choice
        int choice;

        //instance of WestminsterCarParkManager
        WestminsterCarParkManager wminCarParkManager = new WestminsterCarParkManager();

        try {

            //Menu Design
            System.out.println("\t \t \t \t \tW E L C O M E \t T O \t T H E");
            System.out.println();
            System.out.println("W E S T M I N S T E R \t C A R \t P A R K \t M A N A G E M E N T \t S Y S T E M ");
            System.out.println();
            System.out.println("- - - - - - - - - - - Main Menu- - - - - - - - - - - ");
            System.out.println();
            System.out.println("1. Add a new Vehicle");
            System.out.println("2. Remove a Vehicle");
            System.out.println("3. Show Percentage of parked Vehicles ");
            System.out.println("4. Display List of Current Parked Vehicle");
            System.out.println("5. Display Last Vehicle Parked in Car Park");
            System.out.println("6. Display longest parked Vehicle");
            System.out.println("7. Get the Stats for a date");
            System.out.println("8. Quit");
            System.out.println("");
            System.out.println("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //Redirecting to addVehicle Method
                    wminCarParkManager.addVehicle();
                    break;
                case 2:
                    wminCarParkManager.removeVehicle();
                    break;
                case 3:
                    wminCarParkManager.carParkPercentage();
                    break;
                case 4:
                    wminCarParkManager.displayListOfCurrentVehicles();
                    break;
                case 5:
                    wminCarParkManager.displayLastVehicle();
                    break;
                case 6:
                    wminCarParkManager.longestTimeAndLastVehicle();
                    break;
                case 7:
                    wminCarParkManager.displayListOfVehiclesForSpecifiedDay();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    display();

            }
        }catch(InputMismatchException e ){
            System.err.println("Sorry. Mis-matched choice. Please check and re-run");

        }

    }


    /* Method for add any of three vehicle*/
    @Override
    public void addVehicle() {
        //Store the type of the Vehicle.
        int typeOfVehicle;

        System.out.println();
        System.out.println("- - - - - - - - - Add a new vehicle- - - - - - - - - \n ");

        //displays the number of free slots
        getFreeSlots();

        if (slotcounter > 0) {
            System.out.println("Please Select the vehicle type.");
            System.out.println("1. Car.");
            System.out.println("2. Van.");
            System.out.println("3. Motorbike.");
            System.out.println("9. Go back to Main Menu");

            typeOfVehicle = sc.nextInt();

            switch (typeOfVehicle) {
                case 1:
                    //create an object from Car class
                    Car car = new Car();

                    //create an instance from DateTime class
                    DateTime dateTime = new DateTime();

                    //set the vehicle Type
                    car.setVehicleType("Car");

                    System.out.println("Please Enter the Car ID Plate.");
                    //Get and Set ID Plate Details
                    car.setIdNumber(sc.next());

                    System.out.println("Please Enter the brand of the Car");
                    //Get and Set Brand Details
                    car.setBrand(sc.next());

                    //Varible to hole valid details about time and date
                    String[] timeArr;
                    String[] dateArr;

                    do {
                        System.out.println("Please enter the entrance Time (HH:MM)");
                        dateTime.setTimeString(sc.next());
                        //Validating Time
                        dateTime.isInvalidTime();

                        if (dateTime.isInvalidTime() == false) {
                            timeArr = dateTime.getTimeArray();
                            //setting the time
                            dateTime.setHour(timeArr[0]);
                            dateTime.setMinute(timeArr[1]);
                        }


                    } while (dateTime.isInvalidTime() == true);


                    do {
                        System.out.println("Please enter the enterance Date (YYYY-MM-DD)");
                        dateTime.setDateString(sc.next());
                        dateTime.isInvalidDate();


                        if (dateTime.isInvalidDate() == false) {
                            dateArr = dateTime.getDateArray();
                            //setting the date
                            dateTime.setYear(dateArr[0]);
                            dateTime.setMonth(dateArr[1]);
                            dateTime.setDay(dateArr[2]);
                        }
                    } while (dateTime.isInvalidDate() == true);

                    //Get and Set Other Car details
                    System.out.println("Please Enter the Number of Doors of the Car");
                    car.setNumberOfDoors(sc.next());

                    System.out.println("Please Enter the Colour of the Car");
                    car.setColour(sc.next());

                    //set Date & Time
                    car.setDateTime(dateTime);

                    //Adding car to a slot
                    slots.add(car);
                    carCount++;
                    numVehicle++;
                    System.out.println("Car added successfully");
                    break;

                /* Code to add a Van*/
                case 2:

                        //Create an instance of Van class
                        Van van = new Van();
                        //Create an instance of DateTime class
                        DateTime dateTime1 = new DateTime();

                        //set the vehicle Type
                        van.setVehicleType("Van");

                        System.out.println("Please enter the Van ID Plate number");
                        //Get and Set ID Plate Details
                        van.setIdNumber(sc.next());

                        System.out.println("Please Enter the Brand of the Van");
                        //Get and Set Brand Details
                        van.setBrand(sc.next());

                        //Variable to hold valid Time and Date data.
                        String[] timeArr2;
                        String[] dateArr2;


                        do {
                            System.out.println("Please enter the entrance Time (HH:MM)");
                            dateTime1.setTimeString(sc.next());

                            //Validating input
                            dateTime1.isInvalidTime();

                            //set time
                            if (dateTime1.isInvalidTime() == false) {
                                timeArr2 = dateTime1.getTimeArray();

                                //setting the time
                                dateTime1.setHour(timeArr2[0]);
                                dateTime1.setMinute(timeArr2[1]);
                            }

                        } while (dateTime1.isInvalidTime() == true);


                        do {
                            System.out.println("Please enter the enterance Date (YYYY-MM-DD)");
                            dateTime1.setDateString(sc.next());

                            //Validating input
                            dateTime1.isInvalidDate();
                            //Set date
                            if (dateTime1.isInvalidDate() == false) {
                                dateArr2 = dateTime1.getDateArray();
                                //setting the date
                                dateTime1.setYear(dateArr2[0]);
                                dateTime1.setDay(dateArr2[2]);
                                dateTime1.setMonth(dateArr2[1]);
                            }

                        } while (dateTime1.isInvalidDate() == true);

                        //Get and Set Other Van details
                        System.out.println("Please Enter Cargo Volume of the Van");
                        van.setCargoVolume(sc.next());

                        //set Date & Time
                        van.setDateTime(dateTime1);

                        //Adding van to a slot
                        slots.add(van);
                        slots.add(van);
                        vanCount += 2;
                        numVehicle++;
//                        System.out.println(slots.toString());
                        System.out.println("Van added successfully");
                        break;


                /* Code to add a Motorbike*/
                case 3:

                        //Create an instance of MotorBike class
                        Motorbike mbike = new Motorbike();
                        //Create an instance of DateTime class
                        DateTime dateTime2 = new DateTime();

                        //set the vehicle Type
                        mbike.setVehicleType("Motorbike");

                        System.out.println("Please enter the MotorBike ID Plate number:");
                        //Get and Set ID Plate Details
                        mbike.setIdNumber(sc.next());

                        System.out.println("Please Enter the Brand of the MotorBike:");
                        //Get and Set Brand Details
                        mbike.setBrand(sc.next());

                        //Varialbles to hold valid Time and Date data
                        String[] timeArr3;
                        String[] dateArr3;


                        do {
                            System.out.println("Please enter the entrance Time (HH:MM) : ");
                            dateTime2.setTimeString(sc.next());
                            dateTime2.isInvalidTime();

                            if (dateTime2.isInvalidTime() == false) {
                                timeArr3 = dateTime2.getTimeArray();
                                //setting the time
                                dateTime2.setHour(timeArr3[0]);
                                dateTime2.setMinute(timeArr3[1]);
                            }

                        } while (dateTime2.isInvalidTime() == true);


                        do {
                            System.out.println("Please enter the enterance Date (YYYY-MM-DD) : ");
                            dateTime2.setDateString(sc.next());
                            dateTime2.isInvalidDate();

                            if (dateTime2.isInvalidDate() == false) {
                                dateArr3 = dateTime2.getDateArray();
                                //setting the date
                                dateTime2.setYear(dateArr3[0]);
                                dateTime2.setMonth(dateArr3[1]);
                                dateTime2.setDay(dateArr3[2]);

                            }
                        }
                        while (dateTime2.isInvalidDate() == true);


                        //Get and Set Other MotorBike details
                        System.out.println("Please Enter Engine Capacity of the MotorBike:");
                        mbike.setEngineSize(sc.next());

                        //set Date & Time
                        mbike.setDateTime(dateTime2);

                        //Adding MotorBike to a slot
                        slots.add(mbike);
                        motorbikeCount++;
                        numVehicle++;
                        System.out.println("Motorbike added successfully");
                        display();
                        break;



//                /* Code for redirect to the main menu*/
                case 9:
                    display();
//                    System.exit(0);


            }
        } else {
            return;
        }

    }

    /* Method for remove vehicle*/
    @Override
    public void removeVehicle()  {
        DateTime dateTimeDel = new DateTime();
        int vehiIndex = 0;
        boolean found = false;

        System.out.println("------Remove Vehicle-----");


        if(slotcounter==0){
            System.out.println("The Parking is empty at the moment !!");

        }else {
            System.out.println("List of Vehicles in the parking\n");
            for (Vehicle vehicle : slots) {
                String vehi = vehicle.getIdNumber();
                if (vehi != null)
                    System.out.println("\t" + vehi);
            }
            System.out.println("\nPlease select the vehicle.\n");
            try {
                System.out.println("\nEnter Vehicle ID Plate");
                String idPlate = sc.next();

                String leavingVehicle = slots.get(getIndexByProperty(idPlate)).getVehicleType();
                System.out.println("\n" + leavingVehicle + " is leaving the car park now!");
                if (leavingVehicle.equalsIgnoreCase("Car")) {
                    carCount--;
                    slotcounter--;
                } else if (leavingVehicle.equalsIgnoreCase("Van")) {
                    vanCount -= 2;
                    slotcounter -= 2;
                } else if (leavingVehicle.equalsIgnoreCase("MotorBike")) {
                    motorbikeCount--;
                    slotcounter--;
                }
                slots.remove(getIndexByProperty(idPlate));
                fileWriting(getIndexByProperty(idPlate));
                payment();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Somthings wrong.. Please re run the programme");
            }
        }
    }



/* Return the index of the desired vehicle */
    private int getIndexByProperty(String idPlate) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getIdNumber() != null && slots.get(i).getIdNumber().equalsIgnoreCase(idPlate)) {
                return i;
            }
        }
        return -1;
    }

/* Calculating the payments*/
    public void payment() {

        String dateStart = startDate;
        String dateStop = finalDate;

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat simpleformat = new SimpleDateFormat("YYYY-MM-DD HH:MM");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = simpleformat.parse(dateStart);
            d2 = simpleformat.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();


            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);


            long hour24 = diffDays * 24;

            long hour = hour24 + diffHours;

            if (hour > 3) {
                long nexthour = hour - 3;
                long price = nexthour + 9;
                System.out.println(price + "£ parking charge");
            } else if (hour == 24) {
                long price24H = 30;
                System.out.println(price24H + "£ parking charge");
            } else {
                long price2 = hour * 3;
                System.out.println(price2 + "£ parking charge");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Please Something went wrong! Try Again. ");
        }
        display();
    }

//    //returns the index of the desired vehicle
//    private int getIndexByProperty(String yourString) {
//        for (int i = 0; i < slots.size(); i++) {
//            if (slots.get(i).getIdNumber() != null && slots.get(i).getIdNumber().equals(yourString)) {
//                //System.out.println(i);
//                return i;
//            } else {
//                System.out.println("\nSorry! There's no vehicle in the park with the specified ID plate.\n");
//            }
//        }
//        return -1;// not there is list
//    }

    /* Method to Calculate Charges for parked time*/
    public void carParkPercentage() {
        try {
            System.out.println("-------------------------------------------------------");
            System.out.println("\t\tDISPLAY CAR PARK PERCENTAGE\t\t");
            System.out.println("");

            //calculate percentage
            double carPercentage = (carCount * 100) / numVehicle;
            double vanPercentage = (vanCount * 100) / numVehicle;
            double motorbikePercentage = (motorbikeCount * 100) / numVehicle;

            System.out.println("Car Percentage: " + carPercentage +"%");
            System.out.println("Van Percentage: " + vanPercentage+"%");
            System.out.println("MotorBike Percentage: " + motorbikePercentage+"%");
            System.out.println("Available Cars in Car Park: " + carCount);
            System.out.println("Available Vans in Car Park: " + vanCount);
            System.out.println("Available MotorBikes in Car Park: " + motorbikeCount);
            display();
        } catch (Exception e) {

            System.out.println("\n\tCar Park Is Empty\t\n");
            System.out.println("");
        }
    }

    @Override
    public void displayListOfCurrentVehicles() {
        System.out.println("\n\t\tDISPLAY LIST OF CURRENT VEHICLES\t\t\n");
        System.out.println("-------------------------------------------------------");

        //sort the Arraylist
        for (int i = (slots.size() - 1); i >= 0; i--) {
            //display vehicle plate,date ,time and vehicle brand of all current vehicles
            System.out.println("");
            System.out.format("%s", slots.get(i).getIdNumber());
            System.out.format("\n%s", slots.get(i).getDateTime());
            System.out.format("\n%s", slots.get(i).getBrand());
            System.out.println("");
        }
    }

    @Override
    public void displayLastVehicle() {
        System.out.println("");
        System.out.println("\n\t\tDISPLAY LAST VEHICLE\t\t\n");
        System.out.println("");

        //get value in last element in the Arraylist and Display it.
        if (slots != null && !slots.isEmpty()) {
            System.out.println(slots.get(slots.size() - 1));
        }
    }

    @Override
    public void longestTimeAndLastVehicle() {
        System.out.println("\n\t\tDISPLAY LONGEST TIME AND LAST VEHICLE\t\t\n");
        System.out.println("");

        if (slots != null && !slots.isEmpty()) {
            //get value in last element in the Arraylist and Display it.
            System.out.print("Longest Time Vehicle In The Car Park: "+slots.get(slots.size()-1));
            System.out.println("");
            //get value in first element in the Arraylist and Display it.
            System.out.print("Last Vehicle That Enter To The Car Park: "+slots.get(0));

        } else {
            System.out.println("*******Car Park Is Already Empty*****");
            System.out.println("");
        }
    }

    @Override
    public void displayListOfVehiclesForSpecifiedDay() {
        //Store date
        int vehicleEnteredDay = 0;
        int vehicleEnteredMonth = 0;
        int vehicleEnteredYear = 0;

        System.out.println("\n\t\t DISPLAY LIST OF VEHICLES FOR SPECIFIED DATE \t\t\n");
        System.out.println("");

        System.out.print("Please Enter The Valid Specific Day - ");
        vehicleEnteredDay = sc.nextInt();

        if (vehicleEnteredDay <= 31) {
            System.out.print("Please Enter The Valid Specific Month - ");
            vehicleEnteredMonth = sc.nextInt();
            if (vehicleEnteredMonth <= 12) {
                System.out.print("Please Enter The Valid Specific Year - ");
                vehicleEnteredYear = sc.nextInt();
            } else {
                System.out.println("INVALID MONTH!!!");
                displayListOfVehiclesForSpecifiedDay();
            }
        } else {
            System.out.println("INVALID DAY!!!");
            displayListOfVehiclesForSpecifiedDay();
        }
        System.out.println("");

        String fileName = String.valueOf(vehicleEnteredYear) + "-" + String.valueOf(vehicleEnteredMonth) + "-" + String.valueOf(vehicleEnteredDay);
        fileReading(fileName);

    }



    public void fileWriting(int i) {

        try {
            int vehicleParkedYear = Integer.parseInt(slots.get(i).getDateTime().getYear());
            int vehicleParkedMonth = Integer.parseInt(slots.get(i).getDateTime().getMonth());
            int vehicleParkedDay = Integer.parseInt(slots.get(i).getDateTime().getDay());

            String fileName = String.valueOf(vehicleParkedYear) + "-" + String.valueOf(vehicleParkedMonth) + "-" + String.valueOf(vehicleParkedDay);

            File file = new File(fileName);

            //Creates the text file if doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(slots.get(i).toString());
            bufferedWriter.newLine();

            bufferedWriter.close();

            System.out.println("All The Data Was Successfully Saved To A Text File.");
            System.out.println("");

        } catch (IOException e) {
            System.out.println("Sorry! The Program Could Not Locate The Text File");


        }
    }

    public static void fileReading(String fileName) {

        //instance of the buffer reader
        BufferedReader br = null;
        try {
            //current line
            String line;
            br = new BufferedReader(new FileReader(fileName));

            System.out.println("======================= S Y S T E M   H I S T O R Y =====================");
            System.out.println("====ON " + fileName + " DAY                                              ====");
            System.out.println("================================         ================================");
            System.out.println("");

            while ((line = br.readLine()) != null) {
                System.out.println("\t" + line);
            }
            System.out.println("\nAll the data was successfully loaded from the text file. \n");
        } catch (IOException e) {
            System.out.println("\nSorry! The program could not locate the text file");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println("\nOops! Something went wrong.");
            }
        }
    }



}

























