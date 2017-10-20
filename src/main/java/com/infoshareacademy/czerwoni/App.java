package com.infoshareacademy.czerwoni;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

        public static void main(String[] args) {
            boolean onOff = true;
            printOut();

            while (onOff) {
                Scanner scanner = new Scanner(System.in);

                while (!scanner.hasNextInt()) {
                    System.out.println("int, please");
                    scanner.nextLine();
                }
                    int choice;
                    for (choice = scanner.nextInt(); choice < 1 || choice > 8; choice = scanner.nextInt()) {
                        System.out.println("INVALID VALUE! Pick valid number");
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("WORK IN PROGRESS");
                            break;
                        case 2:
                            System.out.println("WORK IN PROGRESS");
                            break;
                        case 3:
                            System.out.println("WORK IN PROGRESS");
                            break;
                        case 4:
                            System.out.println("WORK IN PROGRESS");
                            break;
                        case 5:
                            System.out.println("WORK IN PROGRESS");
                            break;
                        case 6:
                            System.out.println("WORK IN PROGRESS (JZ4CS-7)"); // TODO: JZ4CS-7
                            // final String fileName = "/home/mm/code-128_5900017043456.png";
                            // https://www.generatorkodowkreskowych.pl/code-128/, kod np. 5900017043456

                            System.out.println("Please enter path and filename: ");
                            Scanner pathScanner = new Scanner(System.in);
                            String fileName = pathScanner.nextLine();
                            // System.out.println("podano: " + fileName);
                            System.out.println("Found product: " + ProductProcessor.identifyProductFromImage(fileName));
                            // tu dac klase laczaca sie z API, ktora wewnatrz uzyje BarCodeReader.decodeBarcodeFromFile
                            // ze zwroconym kodem wysylamy zapytanie do API, i na podst odp. tworzymy new Product
                            // pathScanner.close();
                            break;
                        case 7:
                            printOut();
                            break;
                        case 8:
                            System.out.println("BYE BYE we hope to see You soon!");
                            onOff = false;
                            break;
                        default:
                            System.out.println("\nSOMETHING WENT WRONG TRY AGAIN\n");
                    }
                }
            }



        private static void printOut() {
            System.out.println("Welcome in What Do You Want app, pick your number please:");
            System.out.println("1: Our categories browser");
            System.out.println("2: Allegro categories");
            System.out.println("3: Ebay research");
            System.out.println("4: Allegro direct category picker");
            System.out.println("5: Check all WTUW categories tree");
            System.out.println("6: Identify product using barcode image");
            System.out.println("7: MENU");
            System.out.println("8: QUIT APP");
        }

    }
