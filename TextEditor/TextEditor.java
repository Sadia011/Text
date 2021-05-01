

import java.util.Scanner;


public class TextEditor
{

  public static void main(String[] args)
	{
		Buffer textEditor = new Buffer();
		
		Scanner cmd = new Scanner(System.in);
		
		
		// Print instructions

		System.out.println("This is a simple text editor.\n\n"
				+ "\t- '•' represents the location of the cursor.\n"
				+ "\t- Type any character and press enter to add it to the stream.\n"
				+ "\nThe following is a list of commands. "
				+"\n\n        -----****************Commands******************-----"
				+ "\n\n\t+C\tAdd a special character (C) to the stream."
				+ "\n\t-\tRemove a character from the stream."
				+ "\n\t?\tGet information about the stream (i.e., the size)."
				+ "\n\t*\tQuit the text editor"
				+ "\n\t<#\tMove the cursor left by (#) number of places."
				+ "\n\t>#\tMove the cursor right by (#) number of places.\n\n");
		
		while(true)
		{
			System.out.println("\t" + textEditor);
			System.out.print(" > ");
			String command = cmd.nextLine();
			
			char query = command.isEmpty() ? '\0' : command.charAt(0);
			boolean negative = false;
			
			switch(query)
			{
			case '-':
				textEditor.delete();
				break;
			case '?':
				System.out.println("Number of characters: " + textEditor.size());
				break;
			case '*':
				System.out.println("Goodbye!");
				cmd.close();
				return;
			case '<':
				negative = true;
			case '>':
				int arg = new Integer(command.substring(1, command.length()));
				if(negative)
					textEditor.left(arg);
				else
					textEditor.right(arg);
				break;
			case '\0':
				break;
			case '+':
				query = command.charAt(1);
			default:
				textEditor.insert(query);
				break;
			}	
		}
		
	}
}