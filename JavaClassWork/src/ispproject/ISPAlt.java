package ispproject;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ISPAlt {

	//totalAmt represents the variable for total monthly charge for the customer
	private double totalAmt;
	private String pkgUsr;
	private double hrsUsr;
	private Scanner sc = new Scanner(System.in);
        private double A = 9.95;
        private double B = 14.95;
        private double C = 19.95;

	public ISPAlt() {
		totalAmt = 0;
	}

	// getting Package from the user
	private String getPackage() {

		System.out.println("Please enter the letter of your package (A, B or C)");
		// hasNext String with A, B, or C
		if (sc.hasNext("[ABC]")) {
			pkgUsr = sc.next();
		}
		// setting data to garbage for while loop
		else {
			pkgUsr = "ZX";
		}
		sc.nextLine();

		// while loop - checks that the user data is either A or B or C
		while ("ZX".equals(pkgUsr)) {
			System.out.println("Please enter a valid package (A, B or C): ");
			if (sc.hasNext("[ABC]")) {
				pkgUsr = sc.next();
			} else {
				pkgUsr = "ZX";
			}
			sc.nextLine();
		}
		return pkgUsr;
	}
        //method gets # of hours used
	private double getHours() {

		System.out.println("Please the number of hours used: ");
		if (sc.hasNextInt()) {
			hrsUsr = sc.nextInt();
		} else {
			hrsUsr = -1;
		}
		sc.nextLine();

		// if hours is -1 or greater than 744
		while ((hrsUsr < 0) || (hrsUsr > 744)) {
			System.out.println("Please enter a valid integer representing total hours used this month: ");
			if (sc.hasNextInt()) {
				hrsUsr = sc.nextInt();
			} else {
				hrsUsr = -1;
			}
			sc.nextLine();
		}
		return hrsUsr;
	}
        //this method uses pkgUsr as the switch variable and depending on the case, calculates totalAmt.
	private double hours() {

		switch (pkgUsr) {
		case "A":
			if (hrsUsr <= 10) {
				totalAmt = A;
			} else {
				totalAmt = (hrsUsr - 10.0) * 2 + A;
			}
			break;
		case "B":
			if (hrsUsr <= 20) {
				totalAmt = B;
			} else {
				totalAmt = (hrsUsr - 20) + B;
			}
			break;
		case "C":
			totalAmt = C;
		}
		return totalAmt;
	}


        //
	public void perform() {
		getPackage();
		getHours();
		hours();
		System.out.println("Your Total Amount: $" + totalAmt);

	}

        
        //Main method to call Perform, which calls the other methods used to get input and calculate totalAmt
	public static void main(String[] args) {
		// Instantiate the first or primary object
		ISPAlt myBasicClass = new ISPAlt();
		// Call the method that runs the show
		myBasicClass.perform();
		// End the program
		System.exit(0);
	}
}