package ie.gmit.sw;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Runnable
{

	public static void main(String[] args) throws Exception 
	{
		String st;
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Ross's four square cipher\n");
		System.out.println("======================================\n");


		JFileChooser jfc = new JFileChooser();
		jfc.showDialog(null,"Please Select the File");
		jfc.setVisible(true);
		File filename = jfc.getSelectedFile();

		BufferedReader br = new BufferedReader(new FileReader(filename));

		//Test to see if the file selects correctly
		/*
		while ((st = br.readLine()) != null)
			System.out.println(st);
			*/
		//end test
	}

}
