// Autor = Alain Samen Wangueu
// Erstellt = 29.04.2019
// Version = 00

package de.alain.DateinMove;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestReportingFeature {

	public static void main(String[] args) throws IOException {
		ErgebnisDokumentieren("D:\\_SeleniumWebDriver\\TestOrdner1\\testDatein.txt",
				"D:\\_SeleniumWebDriver\\TestOrdner1\\Testdatei.txt",
				"D:\\_SeleniumWebDriver\\TestOrdner2\\testDatein2.txt");

	}

	public static void ErgebnisDokumentieren(String Pfad, String Destination, String ss) throws IOException {

		File file = new File(Pfad);
		if (file.exists() && file.isFile()) {
			System.out.println("Pfad exist");
			if (file.getName().contains(".txt")) {

				System.out.println("File ist ein Text Datei");
				if (file.length() > 0) {
					System.out.println("File ist nicht leer. Der Anzahl an Zeichen betraegt : " + file.length());

					// erste Schritt Pafd kopieren
					copyFileToNewDestination(Pfad, Destination);
					moveFileToDestination(Destination, ss);
				} else {
					System.out.println("File nicht leer-> Länge gleich " + file.length());
				}
			} else {
				System.out.println("File ist kein Text Datei");
			}
		} else {
			System.out.println("Pfad nicht existiert!");
		}
	}

	public static void copyFileToNewDestination(String source, String destination) throws IOException {
		/*
		 * Autor: Alain Samen Wangueu Erstellt: 29.04.2017 version: 00
		 * 
		 * Mit dieser Methode wird ein existierte Pfad kopiert und in einem anderen Name
		 * eingefügt.
		 * 
		 */

		Path filesource = Paths.get(source);
		Path filedestination = Paths.get(destination);
		try {
			Files.copy(filesource, filedestination, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void moveFileToDestination(String sourceFile, String moveDestinationFile) throws IOException {
		/*
		 * Autor: Alain Samen Wangueu Erstellt: 29.04.2017 version: 00
		 * 
		 * Diese Methode ermöglicht die Verschiebung einer Datei von einem Pfad zu einem
		 * Pfad.
		 * 
		 * wichtig ist:
		 * 
		 * Es wird zuerst geprüft, ob der neue Zielordner existiert. Falls schon
		 * vorhanden, dann wird ein anderes Ziel-Pfad automatisch generieren und wieder
		 * geprüft, ob es existiert. Wenn das Ziel-Pfad bzw.File-Name einzigartig ist,
		 * dann erfolgt das Move.
		 *
		 */

		File destfinal = new File(moveDestinationFile);

		if (destfinal.exists()) {

			System.out.println("Bitte ändern Sie den File Name");
			int numberFileInMoveDestinantion = 0;
			Boolean checkMoveDestinationFileExist = false;
			String newmoveDestinationFile = "";
			// andere moveDestinantionFile erzeugen
			do {
				numberFileInMoveDestinantion++;
				String numBerGenerieren = Integer.toString(numberFileInMoveDestinantion);
				newmoveDestinationFile = "D:\\_SeleniumWebDriver\\TestOrdner2\\testDatein" + numBerGenerieren + ".txt";
				File destfinalnew = new File(newmoveDestinationFile);
				checkMoveDestinationFileExist = destfinalnew.exists();
			} while (checkMoveDestinationFileExist);
			Path temp = Files.move(Paths.get(sourceFile), Paths.get(newmoveDestinationFile));
			if (temp != null) {
				System.out.println("File renamed and moved successfully");
			} else {
				System.out.println("Failed to move the file");
			}
		} else {
			Path temp = Files.move(Paths.get(sourceFile), Paths.get(moveDestinationFile));

			if (temp != null) {
				System.out.println("File renamed and moved successfully");
			} else {
				System.out.println("Failed to move the file");
			}
		}
	}
}
