#include<iostream>
using namespace std;
class ATM{
    private:
        int balance;
    public :
        ATM(int bal){
            balance = bal;
        }
        int getbalance(){
            return balance;
        }
        int withdraw(int amount){
            if(amount > balance){
                return false;
            }
            balance = balance - amount;
            return true;
        }
        void depost(int amount){
            balance = balance + amount;
        }
};

main(){
    ATM atm(5000000);
    
    int choice,amount,success;
    char op;
    do{
    system("cls"); 
    cout<<"1. view balance"<<endl;
    cout<<"2. cash withdrawl"<<endl;
    cout<<"3. case deposite"<<endl;
    cout<<"4. exit "<<endl;
    cout<<" enter your choice :";
    cin>>choice;
    
    switch(choice){
    	case 1:
    		cout<<"your balance :"<<atm.getbalance();
    		break;
    		
    	case 2:
    		cout<<"your balance :"<<atm.getbalance();
    		cout<<"\n enter the amount to withdrawl :";
    		cin>>amount;
    		success = atm.withdraw(amount);
    		if(success){
    			cout<<"withdraw successfull..."<<endl;
			}
			else{
				cout<<"insufficiant balance..."<<endl;
			}
			break;
		
		case 3:	
			cout<<"enter the amount of deposite :";
			cin>>amount;
			atm.depost(amount);
			cout<<"deposite successfully..."<<endl;
			break;
			
		case 4: 
			cout<<"thanks for ATM"<<endl;
			break;
			default: 
			cout<<"invalid choice"<<endl;	
	}	
	cout<<"\n do you want to try another transaction[yes / no ] :";
	cin>>op;
	}while(op== 'y'||op == 'Y');
	
	
    
 
}