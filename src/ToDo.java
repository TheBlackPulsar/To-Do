import java.util.Scanner;

public class ToDo {

	public static String [] [] todos = new String [10] [2]; //Zweidimensionales Array fuer Aufgabe und Datum
	public static String antwort = new String(); // Initialisierung antwort String
	public static boolean a = false; //Initialisierung bollean a
	
	public static void main(String[] args){
		
		programm();
		
	}

	public static void programm() {
		
		Scanner scanner = new Scanner(System.in); // Scanner fuer einzelne Eingaben
		Scanner scanner2 = new Scanner(System.in).useDelimiter("\n"); //Scanner fuer mehrere Woerter

				System.out.println("Willkommen in Ihrer To-Do-Liste, was moechten sie tun?");
				System.out.println();
				System.out.println("[1] To-Dos anzeigen");
				System.out.println("[2] Eintrag hinzufuegen");
				System.out.println("[3] Eintrag loeschen");
				System.out.println("[4] Programm beenden");
				System.out.println("[5] Eintrag bearbeiten");
				System.out.println("[6] Datum setzen");
				System.out.println("[7] To-Dos mit Datum anzeigen");
				System.out.println("[8] To-Dos sortieren");
				System.out.println();
				System.out.println("Geben Sie nun die Ziffer Ihrer Wahl ein:");
				System.out.println();
				
					String isNum = scanner.nextLine();
					a = isNumeric(isNum); // Uebergabe an Methode isNum und Rueckgabe eines boolean
					System.out.println();
				
					//Initialisierung mehrerer Strings fuer Eingaben
					
					String titel = new String();
					String altertitel = new String();
					String neuertitel = new String();
				
					// Switch-Case-Block fuer die Auswahl
					
						if(a) {
					
							switch(Integer.parseInt(isNum)) {
								case 1:
									listeAlleAufgaben();
									break;
								case 2:
									starteNeueAufgabe(titel);
									break;
								case 3:
									starteLoescheAufgabe(titel);
									break;
								case 4:
									scanner.close();
									scanner2.close();
									System.exit(0);	
									break;
								case 5:
									starteBearbeiteAufgabe(altertitel, neuertitel);
									break;
								case 6:
									starteSetzeDatum(titel);
									break;
								case 7:
									antwort = listeAlleAufgabenMitDatum();
									System.out.println(antwort);
									break;
								case 8:
									sortierung();
									break;
							}
				
							System.out.println();
						} else {
							System.out.println("Ihre Eingabe entspricht keiner der acht Zahlen.");
							System.out.println();
							programm();
						}
				programm();
	}
	public static boolean isNumeric(String isNum) {
		
		//Diese Methode ueberprueft ob es sich bei der Eingabe um eine gueltige Zahl handelt
		
	    	if (isNum == null) {
	    		return false;
	    	}else{
	    		try {
	    			double d = Double.parseDouble(isNum);	//Hier wird ueberprueft ob es sich bei der Eingabe um eine Zahl handelt
	    		}catch (Exception e) {
	    			return false;
	    		}
	    	}
	    int n = Integer.parseInt(isNum);
	    	if(n>0 && n<9) { 								// Hier wir ueberprueft ob die Zahl im erlaubten Rahmen liegt
	    		return true;
	    }else{
	    		return false;
	    }
	}
	
	public static void listeAlleAufgaben() {
		
		//Listet alle vorhandenen Aufgaben auf
		
		int pos = 10;
		for(int i=0;i<10;i++) {
			if (todos [i] [0] == null) {				//Erste Position mit Wert null wird ermittelt
				pos = i;
				i = 10;
			}
		}
		if(pos>0) {
			System.out.println("Ihre Aufgaben sind:");
			System.out.println();
			for(int i=0;i<pos;i++) {
				System.out.print(todos [i] [0] + "\n");;   	// Alle Aufgaben bis zur ersten Stelle mit Wert null werden aufgelistet
			} 
		} else {
			System.out.println("Es sind noch keine Aufgaben vorhanden.");
		}
		System.out.println();
		programm();
	}
	
	public static void starteNeueAufgabe(String titel) {
		
		//Enthaelt die Ein- und Ausgabe fuer neueAufgabe und ruft diese auf
		
		Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
	
		a = false;
		System.out.println("Bitte geben sie einen Titel ein:");
		System.out.println();
		titel = scanner2.nextLine();
		scanner2.close();
		System.out.println();
			
			int i = 10;
			int pos = 10;
				for(int j = 0;j<10; j++) {
					if (todos [j] [0] == null) {							//Erste Position mit Wert null wird ermittelt
						pos = j;
						j = 10;
					}
				}
			i = pos;
	
				if(pos<10) {
					a = neueAufgabe(titel, i);
						}
		if(a) {
			System.out.println("Die Aufgabe " + titel + " wurde hinzugefuegt.");
		}else{
			System.out.println("Die Aufgabe " + titel + " konnte nicht hinzugefuegt werden.");
		}
		System.out.println();
		programm();
	}
	
	public static boolean neueAufgabe(String titel, int i) {
		
		//Fuegt eine neue Aufgabe hinzu
		
		int z = 0;
		String pruef = new String();
			while(z<10) {
				pruef = todos [z] [0];
					if(titel.equals(pruef)) {							//Ueberpruefung auf bereits existierenden identischen Titel
						return false;
					}else{
						++z;
					}
			}
		todos [i] [0] = titel;											//Der neue Titel wird an der gefundenen freien Stelle eingefuegt
		todos [i] [1] = ("2020-12-23");									//Der neue Titel erhaelt das festgelegte default Datum
		return true;
	}	
	
	public static void starteLoescheAufgabe(String titel) {
		
		//Enthaelt die Ein- und Ausgabe fuer loescheAufgabe und ruft diese auf
		
		Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
		
		a = false;
		System.out.println("Bitte geben sie einen Titel ein:");
		System.out.println();
		titel = scanner2.nextLine();
		scanner2.close();
		a = loescheAufgabe(titel);
			if(a) {
				System.out.println("Die Aufgabe " + titel + " wurde geloescht.");
			}else{
				System.out.println("Die Aufgabe " + titel + " wurde nicht gefunden.");
			}
		System.out.println();
		programm();
	}
	
	public static boolean loescheAufgabe(String titel) {
		
		//loescht eine vorhandene Aufgabe aus der Liste
		
		int z = 0;
		int y = 10;
		String pruef = new String();
			while(z<10) {
				pruef = todos [z] [0];
					if(titel.equals(pruef)) {				//Eingegebener Titel wird gesucht
						todos [z] [0] = null;				//Titel wird auf default zurueckgesetzt
						todos [z] [1] = null;				//Datum wird auf default zurueckgesetzt
						y = z;
					}else{
						++z;
					}
			}
		System.out.println();
			if(y<10) {										//Alle anderen existierenden Titel+Datum werden um eine Stelle nachgerueckt
				String schieb = new String();
					while(y<9) {
						schieb = todos [y+1] [0];
						todos [y] [0] = schieb;
						schieb = todos [y+1] [1];
						todos [y] [1] = schieb;
						++y;
					}
					todos [9] [0] = null;					//An der letzten Array Stelle wird ein null eingefuegt
					todos [9] [1] = null;
					return true;
			}else{
				return false;
			}
	}
	
	public static void starteBearbeiteAufgabe(String altertitel, String neuertitel) {
		
		//Enthaelt die Ein- und Ausgabe fuer bearbeiteAufgabe und ruft diese auf
		
		Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
		
		a = false;
		System.out.println("Bitte geben sie einen Titel ein:");
		System.out.println();
		altertitel = scanner2.nextLine();
		System.out.println();
		System.out.println("Bitte geben sie einen neuen Titel ein:");
		System.out.println();
		neuertitel = scanner2.nextLine();
		scanner2.close();
		System.out.println();
		a = bearbeiteAufgabe(altertitel, neuertitel);
			if(a) {
				System.out.println("Die Aufgabe " + altertitel + " wurde umbenannt zu " + neuertitel +".");
			}else{
				System.out.println("Die Aufgabe " + altertitel + " konnte nicht umbenannt werden.");
			}
		System.out.println();
		programm();
	}
	
	public static boolean bearbeiteAufgabe(String titel, String neuerTitel) {
		
		//Bearbeitet den Titel einer vorhandenen Aufgabe
		
		int z = 0;
		String pruef = new String();
			while(z<10) {
				pruef = todos [z] [0];
					if(titel.equals(pruef)) {							//Aufgabe mit angegebenem Titel wird gesucht
						todos [z] [0] = neuerTitel;						//Neuer Titel wird an der Stelle des alten eingefuegt
						return true;
					}else{
						++z;
					}
			}
		return false;
	}
	
	public static void starteSetzeDatum(String titel) {
		
		//Enthaelt die Ein- und Ausgabe fuer setzeDatum und ruft diese auf
		
		Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
		
		System.out.println("Bitte geben sie einen Titel ein:");
		System.out.println();
		titel = scanner2.nextLine();
		System.out.println();
		System.out.println("Bitte geben sie ein Datum (yyyy-mm-dd) ein:");
		System.out.println();
	    String datum = scanner2.nextLine();
		scanner2.close();
	    System.out.println();
	    int jahr = 0;
	    int monat = 0;
	    int tag = 0;
	    	try {																										//Eingabe des Datum und aufteilung in Jahr, Monat und Tag
	    		String [] geteilt = new String [2];
	    		geteilt = datum.split("-");
	    		a=isNumeric2(geteilt [0]);
	    			if(a) {
	    				jahr = Integer.parseInt(geteilt [0]);
	    			} else {
	    				System.out.println("Das Jahr entspricht keiner gueltigen Eingabe.");
	    				System.out.println();
	    				programm();
	    			}
	    		a=isNumeric3(geteilt [1]);
	    			if(a) {
	    				monat = Integer.parseInt(geteilt [1]);
	    			} else {
	    				System.out.println("Der Monat entspricht keiner gueltigen Eingabe.");
	    				System.out.println();
	    				programm();
	    			}
	    		a=isNumeric4(geteilt [2]);
	    			if(a) {
	    				tag = Integer.parseInt(geteilt [2]);
	    			} else {
	    				System.out.println("Das Tag entspricht keiner gueltigen Eingabe.");
	    				System.out.println();
	    				programm();
	    			}
	    		System.out.println();
	    	}catch (Exception f){
	    		System.out.println("Das Datum fuer " + titel + " konnte nicht gesetzt werden.");
	    		System.out.println();
	    		programm();
	    	}
	    a = setzeDatum(titel, jahr, monat, tag);
			if(a) {
				System.out.println("Die Aufgabe " + titel + " ist am " + datum + " faellig.");
			}else{
				System.out.println("Das Datum fuer " + titel + " konnte nicht gesetzt werden.");
			}
		System.out.println();
		programm();
	}
	
	public static boolean isNumeric2(String isNum2) {
		
		//Diese Methode ueberprueft ob es sich bei der Eingabe um eine gueltige Zahl handelt
		
	    if (isNum2 == null) {
	        return false;
	    }
	    	try {
	    		double d = Double.parseDouble(isNum2);			//Hier wird ueberprueft ob es sich bei der Eingabe um eine Zahl handelt
	    	}catch (Exception e){
	    		return false;
	    	}
	    int n = Integer.parseInt(isNum2);
	    	if(n>0) {									// Hier wir ueberprueft ob die Zahl im erlaubten Rahmen liegt
	    		return true;
	    	}else{
	    		return false;
	    	}
	}
	
	public static boolean isNumeric3(String isNum2) {
		
		//Diese Methode ueberprueft ob es sich bei der Eingabe um eine gueltige Zahl handelt
		
	    if (isNum2 == null) {
	        return false;
	    }
	    	try {
	    		double d = Double.parseDouble(isNum2);			//Hier wird ueberprueft ob es sich bei der Eingabe um eine Zahl handelt
	    	}catch (Exception e){
	    		return false;
	    	}
	    int n = Integer.parseInt(isNum2);
	    	if(n>0 && n<13) {									// Hier wir ueberprueft ob die Zahl im erlaubten Rahmen liegt
	    		return true;
	    	}else{
	    		return false;
	    	}
	}
	
	public static boolean isNumeric4(String isNum2) {
		
		//Diese Methode ueberprueft ob es sich bei der Eingabe um eine gueltige Zahl handelt
		
	    if (isNum2 == null) {
	        return false;
	    }
	    	try {
	    		double d = Double.parseDouble(isNum2);			//Hier wird ueberprueft ob es sich bei der Eingabe um eine Zahl handelt
	    	}catch (Exception e){
	    		return false;
	    	}
	    int n = Integer.parseInt(isNum2);
	    	if(n>0 && n<31) {									// Hier wir ueberprueft ob die Zahl im erlaubten Rahmen liegt
	    		return true;
	    	}else{
	    		return false;
	    	}
	}
	
	public static boolean setzeDatum(String titel, int jahr, int monat, int tag) {
		
		//Setzen eines Datums fuer einen bestimmten Titel
		
		int z = 0;
		String pruef = new String();
			while(z<10) {
				pruef = todos [z] [0];
					if(titel.equals(pruef)) {
						todos [z] [1] = (String.format("%04d", jahr) + "-" + String.format("%02d", monat) + "-" + String.format("%02d", tag)); //Formatierung und Speicherung des Datums
						return true;
					}else{
						++z;
					}
			}
		return false;	
	}
	
	public static String listeAlleAufgabenMitDatum() {
		
		//Auflistung aller Aufgaben mit Datum
		
		int pos = 10;
			for(int j = 0;j<10; j++) {
				if (todos [j] [0] == null) {							//Erste Position mit Wert null wird ermittelt
					pos = j;
					j = 10;
				}
			}
			
		StringBuffer sb = new StringBuffer();													//Gemeinsame Bufferung der Titel und Daten und anschliessende Ausgabe
			if(pos>0) {
				for(int i=0;i<pos;i++) {
					sb.append(todos [i] [0] + ", ist faellig am " + todos [i] [1] + "\n");
				}
			} else {
				System.out.println("Es sind noch keine Aufgaben vorhanden.");
			}
		antwort = sb.toString();
		return antwort;
	}
	
	public static void sortierung() {
		
		//Enthaelt die Ein- und Ausgabe fuer die Sortierung und ruft die einzelnen Sortierungsmoeglichkeiten auf
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("[1] nach Titel aufsteigend");
		System.out.println("[2] nach Titel absteigend");
		System.out.println("[3] nach Datum aufsteigend");
		System.out.println("[4] nach Datum absteigend");
		System.out.println("");
		
		String isNum2 = scanner.next();
		System.out.println();
		a = isNumeric5(isNum2);
		
		String s = new String();
		
		scanner.close();
		
			if(a) {													//Switch-Case-Block fuer die Sortierungsmoeglichkeiten
				switch(Integer.parseInt(isNum2)) {
					case 1:
						s=nachTitelSortieren(true);
						System.out.println(s);
						break;
					case 2:
						s=nachTitelSortieren(false);
						System.out.println(s);
						break;
					case 3:
						s=nachDatumSortieren(true);
						System.out.println(s);
						break;
					case 4:
						s=nachDatumSortieren(false);
						System.out.println(s);
						break;
				}
			}else{
				System.out.println("Ihre Eingabe entspricht leider keiner der vier moeglichen Zahlen.");
				System.out.println();
				programm();
			}
		System.out.println();
		programm();
	}
	
	public static boolean isNumeric5(String isNum2) {
		
		//Diese Methode ueberprueft ob es sich bei der Eingabe um eine gueltige Zahl handelt
		
	    if (isNum2 == null) {
	        return false;
	    }
	    	try {
	    		double d = Double.parseDouble(isNum2);			//Hier wird ueberprueft ob es sich bei der Eingabe um eine Zahl handelt
	    	}catch (Exception e){
	    		return false;
	    	}
	    int n = Integer.parseInt(isNum2);
	    	if(n>0 && n<5) {									// Hier wir ueberprueft ob die Zahl im erlaubten Rahmen liegt
	    		return true;
	    	}else{
	    		return false;
	    	}
	}
	
	public static String nachTitelSortieren(boolean aufsteigend) {
		
		//Sortiert nach Titel
		
		String[][] strings = new String [10] [2];
		
		int k = 10;
		int pos = 10;
			for(int j = 0;j<10; j++) {
				if (todos [j] [0] == null) {							//Erste Position mit Wert null wird ermittelt
					pos = j;
					j = 10;
				}
			}
			
		k = pos;
		
		for(int i=0;i<k; i++) {
			strings [i] [0] = todos [i] [0];
			strings [i] [1] = todos [i] [1];
		}
		
		StringBuffer sb = new StringBuffer();
			if(aufsteigend) {															//Sortiert die Titel von a nach x
				for(int i=0; i<k-1; i++) {
					for (int j = i+1; j<k; j++) {
						if(strings[i][0].compareTo(strings[j][0])>0) {
							String temp = strings[i][0];
							strings[i][0] = strings[j][0];
							strings[j] [0]= temp;
							temp = strings[i][1];
							strings[i][1] = strings[j][1];
							strings[j] [1]= temp;
						}
					}
				}
			}else {																		//Sortiert die Titel von x nach a
				for(int i= 0; i<k-1; i++) {
					for (int j = i+1; j<k; j++) {
						if(strings[i][0].compareTo(strings[j][0])<0) {
							String temp = strings[i][0];
							strings[i][0] = strings[j][0];
							strings[j] [0]= temp;
							temp = strings[i][1];
							strings[i][1] = strings[j][1];
							strings[j] [1]= temp;
						}
					}
				}
			}
		
		for(int i = 0;i<pos;i++) {														//Bufferung der sortierten Titel
			sb.append(strings [i] [0] + ", ist faellig am " + strings [i] [1] + "\n");
		}
		antwort = sb.toString();
		return antwort;
	}
	
	public static String nachDatumSortieren(boolean aufsteigend) {
		
		//Sortiert nach Datum

			String[][] strings = new String [10] [2];
			
			int k = 10;
			int pos = 10;
				for(int j = 0;j<10; j++) {
					if (todos [j] [0] == null) {							//Erste Position mit Wert null wird ermittelt
						pos = j;
						j = 10;
					}
				}
				
			k = pos;
			
			for(int i=0;i<k; i++) {
				strings [i] [0] = todos [i] [0];
				strings [i] [1] = todos [i] [1];
			}
			
			StringBuffer sb = new StringBuffer();
			
			if(aufsteigend) {															//Sortiert das Datum von fruehstem zu entferntestem
				for(int i= 0; i<k-1; i++) {
					for (int j = i+1; j<k; j++) {
						if(strings[i][1].compareTo(strings[j][1])>0) {		
							String temp = strings[i][1];
							strings[i][1] = strings[j][1];
							strings[j] [1]= temp;
							temp = strings[i][0];
							strings[i][0] = strings[j][0];
							strings[j] [0]= temp;
						}
					}
				}
			}else {																		//Sortiert das Datum von entferntestem zu fruehstem
				for(int i= 0; i<k-1; i++) {
					for (int j = i+1; j<k; j++) {
						if(strings[i][1].compareTo(strings[j][1])<0) {
							String temp = strings[i][1];
							strings[i][1] = strings[j][1];
							strings[j] [1]= temp;
							temp = strings[i][0];
							strings[i][0] = strings[j][0];
							strings[j] [0]= temp;
							}
						}
					}	
				}
				for(int i = 0;i<pos;i++) {
				sb.append(strings [i] [0] + ", ist faellig am " + strings [i] [1] + "\n");
			}
			antwort = sb.toString();
			return antwort;
		}	
}