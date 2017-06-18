// Problem statement: https://open.kattis.com/problems/height

#include <iostream>
#define FOR(i,n) for(int i = 0; i < (n); ++i)
using namespace std;

int main() {

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
