package com.ab.buscardsystem;

public class Starter {

    private static FactoryInput factoryInput = new FactoryInput();
    private static boolean isContinue;

    public static void main(String[] args){
        startScreen();
    }

    public static void startScreen(){
        while (true){
            System.out.println("1 -> CityCard Console");
            System.out.println("2 -> Center Console");
            System.out.println("3 -> Bus Console");
            System.out.println("0 -> Exit");
            System.out.print("Please choose one: ");
            int decision = factoryInput.inputIntegerId();
            switch (decision){
                case 1:
                    System.out.println("Welcome CityCard Console");
                    startCityCardConsole();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 2:
                    System.out.println("Welcome Center Console");
                    startCenterConsoleScreen();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\nWelcome Bus Console");
                    System.out.println("\n--------------------------------------\n");
                    startBusConsoleScreen();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 0:
                    System.out.println("\n--------------------------------------\n");
                    System.out.println("Exit process is done!");
                    return;
                default:
                    System.out.println("Invalid decision.Please try again.");
                    System.out.println("\n--------------------------------------\n");
                    break;
            }
        }
    }

    public static void startBusConsoleScreen() {
            WholeSystem start = new WholeSystem();
            while(true){
                isContinue = start.startDriverLogIn();
                if(isContinue == false){
                continue;
            }
            start.startTappingCard();
            }
    }

    public static void startCenterConsoleScreen() {
        WholeSystem start = new WholeSystem();
        while (true) {
            start.startAddingMoneyToCard();
        }
    }

    public static void startCityCardConsole(){
        WholeSystem start = new WholeSystem();
        while (true) {
            System.out.println("1 -> Add New Card");
            System.out.println("2 -> Add Money To Center");
            System.out.println("3 -> Add New Center");
            System.out.println("4 -> Delete Center");
            System.out.println("5 -> Add New Driver");
            System.out.println("6 -> Delete Driver");
            System.out.println("0 -> Exit");
            System.out.print("Please choose one: ");
            int decision = factoryInput.inputIntegerId();
            switch (decision) {
                case 1:
                    start.startAddingCard();
                    break;
                case 2:
                    start.startAddingMoneyToCenter();
                    break;
                case 3:
                    start.startAddingCenter();
                    break;
                case 4:
                    start.startRemovingCenter();
                    break;
                case 5:
                    start.startAddingDriver();
                    break;
                case 6:
                    start.startRemovingDriver();
                    break;
                case 0:
                    System.out.println("Exit process is done!");
                    return;
                default:
                    System.out.println("Invalid decision.Please try again.");
                    break;
            }
        }
    }

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }
}
