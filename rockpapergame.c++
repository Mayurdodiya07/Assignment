
#include <cstdlib> 
#include <ctime> 
#include <iostream> 
using namespace std; 

 
char getComputerMove() 
{ 
	int move; 
	
	srand(time(NULL)); 
	move = rand() % 3; 

	
	if (move == 0) { 
		return 'p'; 
	} 
	else if (move == 1) { 
		return 's'; 
	} 
	return 'r'; 
} 


int getResults(char Mayur, char  Param) 
{ 

	if (Mayur == Param) { 
		return 0; 
	} 

	
	if (Mayur == 's' && Param == 'p') { 
		return 1; 
	} 
	if (Mayur == 's' && Param == 'r') { 
		return -1; 
	} 
	if (Mayur == 'p' && Param == 'r') { 
		return 1; 
	} 
	if (Mayur == 'p' && Param == 's') { 
		return -1; 
	} 
	if (Mayur == 'r' && Param == 'p') { 
		return -1; 
	} 
	if (Mayur == 'r' && Param == 's') { 
		return 1; 
	} 
	
	return 0; 
} 


int main() 
{ 

	char Mayur; 

	cout << "\n\n\n\t\t\t Welcome to Stone Paper Scissor "
			"Game\n"; 

	cout << "\n\t\tEnter r for ROCK, p for PAPER, and s "
			"for SCISSOR\n\t\t\t\t\t"; 

	
	while(1) { 
		cin >> Mayur; 
		if (Mayur == 'p' || Mayur == 'r' || Mayur == 's') { 
			break; 
		} 
		else { 
			cout << "\t\t\tInvalid Player Move!!! Please Try Again." << endl; 
		} 
	} 
	

	char Param = getComputerMove(); 

	int result = getResults(Mayur, Param); 

	
	if (result == 0) { 
		cout << "\n\t\t\tGame Draw!\n"; 
	} 
	else if (result == 1) { 
		cout << "\n\t\t\tCongratulations!Mayur  won the "
				"game!\n"; 
	} 
	else { 
		cout << "\n\t\t\tOh! Param won the game!\n"; 
	} 

	
	cout << "\t\t\tYour Move: " << Mayur << endl; 
	cout << "\t\t\tComputer's Move: " << Param << endl; 

	return 0; 
}
