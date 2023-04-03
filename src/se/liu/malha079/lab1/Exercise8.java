package se.liu.malha079.lab1;

import javax.swing.*;

public class Exercise8
{
    public static void main(String[] args) {
	while(true){
	    // If the first statement is false, this one will not ask the other question
	    if (askUser("Quit?") && askUser("Really quit?")){
		break;
	    }

	}
	while(true){
	    // This one will ask both even if it already know that the first answer makes statement false
	    if (askUser("Quit?") & askUser("Really quit?")){
		break;
	    }

	}
    }
    public static boolean askUser(String question){
	return JOptionPane.showConfirmDialog(null, question,"",
					     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
