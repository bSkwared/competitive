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
    while (prev[index] != 0) {
        ++index;
    }
    FOR(i,index) {
        thisDP[i]--;
        
    }
    thisDP[index] = index+1;
    if (index < 79) {
        thisDP[index+1] = -1;
    }


    return thisDP;
}

int main() {

        FOR(i,2000) {
            dp[i][0] = -1;
        }

        dp[0][0] = 1;
        dp[0][1] = -1;
        
        dp[1][0] = 0;
        dp[1][1] = 2;
        dp[1][2] = -1;

        int cases;
        cin >> cases;

        FOR(asdfg,cases) {
                int studs[20];
                int newOrd[20];
                int ctr = 0;
                int junk;
                //cout << "HEY";
                cin >> junk;

                FOR(i,20) {
                        cin >> studs[i];
                }
                FOR(i,20) {
                        int j;
                        for (j = 0; j < i; ++j) {
                                if (studs[i] < newOrd[j]) break;
                        }
                        for (int k = i; k > j; --k) {
                                newOrd[k] = newOrd[k-1];
                                ++ctr;
                        }
                        newOrd[j] = studs[i];
//                        FOR(hey,i) cout << " " << newOrd[hey];
  //                      cout << endl;
                }


                cout << 1+asdfg << " " << ctr << endl;
        }



        return 0;
}
