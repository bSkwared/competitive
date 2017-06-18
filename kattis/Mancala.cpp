// Problem statement: https://open.kattis.com/problems/mancala

#include <iostream>
#define FOR(i,n) for(int i = 0; i < (n); ++i)
using namespace std;

int dp[20000][80];
int* getBins(int n) {
    int* thisDP = dp[n-1];
    
    if (thisDP[0] != -1) {
        return thisDP;
    }

    
    int* prev = getBins(n-1);
    FOR(i,80) {
        thisDP[i] = prev[i];
    }


    int index = 0;
    while (prev[index] != 0 && prev[index] != -1) {
        ++index;
    }
    FOR(i,index) {
        thisDP[i]--;
        
    }
    thisDP[index] = index+1;
    /*if (index < 79) {
        thisDP[index+1] = -1;
    }*/


    return thisDP;
}

int main() {

        FOR(i,2000) {
        	FOR(j,80) {
            	dp[i][j] = -1;
        	}
        }

        dp[0][0] = 1;
        dp[0][1] = -1;
        
        dp[1][0] = 0;
        dp[1][1] = 2;
        dp[1][2] = -1;

        int cases;
        cin >> cases;

        FOR(asdfg,cases) {
                
                int junk;
                //cout << "HEY";
                cin >> junk;
                int n;
                cin >> n;

                cout << junk;
                int *ptr = getBins(n);
                
                int upper = 0;
                while (ptr[upper++] != -1 && upper < 80);
                cout << " " << upper-1 << endl;
                
                for (int k = 0;  ptr[k] != -1 && k < 80; ++k) {
                	if (k % 10 == 0) {
                		if (k != 0) cout << endl;
                		cout << ptr[k];
                	} else {
                		cout << " " << ptr[k];
                	}
                	
                	
                }
                
                
                cout << endl;
        }



        return 0;
}
