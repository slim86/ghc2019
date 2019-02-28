package fr.soprasteria.hashcode.indigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import fr.soprasteria.hashcode.asteam.model.Ride;
import fr.soprasteria.hashcode.asteam.model.RideStatus;
import fr.soprasteria.hashcode.asteam.model.Vehicule;

public class Reader {

	static String BASENAME = "C:/projects/prj-asip-sante/workspace/workspace_GHC/ghc2019/";
	static String FILENAME = BASENAME + "src/main/resources/2019/a_example.txt";
	static String example = "a_example";
	static String FILENAME_IN = BASENAME + "src/main/resources/2019/" + example +".txt";
	static String FILENAME_OUT = BASENAME + "2019/out/" + example +".out";	
	private int totalRows;
	
	public static void main(String[] args) {
		
		Reader r = new Reader();
		
		r.read(FILENAME_IN);

	}

private void read(String fileName) {
		
		List<String> lines;

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			// line 0
			lines = br.lines().collect(Collectors.toList());

			String[] infosFirstLine = lines.get(0).split(" ");
			totalRows = Integer.parseInt(infosFirstLine[0]);

			System.out.println("Nombre d'images : " + Integer.parseInt(infosFirstLine[0]));
			
//			System.out.println(String.format("%d rows, %d columns, %d vehicles, %d rides, %d bonus and %d steps",
//					totalRows, totalColumns, totalVehicules, totalRides, bonus, totalSteps));
			
			// read lines
			for(int i=1; i<=totalRows; i++) {
				final String[] infosRideLine = lines.get(i).split(" ");
				System.out.println("*******ID " + i + "**********");
				System.out.println("Position=" + infosRideLine[0]);
				final int nbTag = Integer.parseInt(infosRideLine[1]);
				System.out.println("Nombre de tag=" + nbTag);
				for (int j=0; j<nbTag; j++) {
					System.out.println("Tag=" + infosRideLine[j+1]);
				}
				
			}

						
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
