/**
 * 	Author: Cesar Escalona
 * 	Sdev 301 - Systems Programming
 * 	3/3/21
 * 	This program will create ABCMachines and run each program and display what
 * 	is in the register and memory for Program1 and Program2
 */

package test;

import abc.*;

public class ABCDriver
{
	public static void main(String[] args)
	{
		//create a new ABCMachine and pass it to program #1 to run
		ABCMachine mach = new ABCMachine("programs/program1.abc");
		mach.runProgram();

		//create a new ABCMachine and pass it to program #2 to run
		ABCMachine mach2 = new ABCMachine("programs/program2.abc");
		mach2.runProgram();

		//print out the registers and memory after the program runs Program #1
		System.out.println("Register dump for Program #1:");
		mach.printRegisters();
		System.out.println("");
		System.out.println("Memory dump for Program #1:");
		mach.printMemory();

		// print out 3 lines of empty space for better visual of dumps
		System.out.println("");
		System.out.println("");
		System.out.println("");

		//print out the registers and memory after the program runs Program #2
		System.out.println("Register dump for Program #2:");
		mach2.printRegisters();
		System.out.println("");
		System.out.println("Memory dump for Program #2:");
		mach2.printMemory();
	}
}