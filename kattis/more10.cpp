#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

#define SINT(num) (scanf("%d", &num))
#define PINT(num) (printf("%d", (num)))
#define SSTR(str) (scanf("%s", &str))

#define FOR(num, lim) for (int num = 0; num < (lim); ++num)

class RG {
public:
	RG(RG* rg) {
		root = rg;
	}

	RG* Root() {
		if (root == nullptr) {
			return this;
		}
		else {
			root = root->Root();
			return root;
		}
	}

	RG* root;
};


int main() {
	vector<string> len1, len2, len3;

	vector<pair<string, string>> iss, nots;

	unordered_map<string, RG*> map;

	int N;
	SINT(N);

	FOR(outer, N) {
		string w1, rel, w2;
		cin >> w1 >> rel >> w2;
		//scanf("%s %s %s", &w1, &rel, &w1);
		
		if (rel[0] == 'n') {
			nots.push_back(make_pair(w1, w2));
		} else {
			iss.push_back(make_pair(w1, w2));
		}

		switch (w1.length()) {
		case 1:
			len1.push_back(w1);
			break;

		case 2:
			len2.push_back(w1);
			break;

		default:
			len3.push_back(w1);
			break;
		}
		switch (w2.length()) {
		case 1:
			len1.push_back(w2);
			break;

		case 2:
			len2.push_back(w2);
			break;

		default:
			len3.push_back(w2);
			break;
		}
	}

	while (!len1.empty()) {
		string str = len1.back();

		if (map.count(str) == 0) {
			RG* r = new RG(nullptr);
			map.insert(make_pair(str, r));
		}

		len1.pop_back();
	}

	while (!len2.empty()) {
		string str = len2.back();

		if (map.count(str) == 0) {
			RG* r = new RG(nullptr);

			if (map.count(str.substr(1, 1)) != 0) {
				r->root = map.at(str.substr(1, 1));
			}

			map.insert(make_pair(str, r));
		}

		len2.pop_back();
	}

	while (!len3.empty()) {
		string str = len3.back();

		if (map.count(str) == 0) {
			RG* r = new RG(nullptr);
			string substr1 = str.substr(str.size() - 1, 1);
			string substr2 = str.substr(str.size() - 2, 2);
			string substr3 = str.substr(str.size() - 3, 3);

			if (map.count(substr1) != 0) {
				r->root = map.at(substr1);
			}
			else if (map.count(substr2) != 0) {
				r->root = map.at(substr2);
			} 
			else if (map.count(substr3) != 0) {
				r->root = map.at(substr3);
			}
			else {
				map.insert(make_pair(substr3, r));
				r = new RG(r);
			}

			map.insert(make_pair(str, r));
		}

		len3.pop_back();
	}

	while (!iss.empty()) {
		pair<string, string> words;
		string w1, w2;
		RG *r1, *r2;

		words = iss.back();
		iss.pop_back();

		w1 = words.first;
		w2 = words.second;

		r1 = map.at(w1)->Root();
		r2 = map.at(w2)->Root();

		if (r1 != r2) {
			r1->root = r2;
		}
	}

	bool found = false;
	while (!nots.empty()) {
		pair<string, string> words;
		string w1, w2;
		RG *r1, *r2;

		words = nots.back();
		nots.pop_back();

		w1 = words.first;
		w2 = words.second;

		r1 = map.at(w1)->Root();
		r2 = map.at(w2)->Root();

		if (r1 == r2) {
			cout << "wait what?";
			found = true;
			break;
		}
	}

	if (!found) {
		cout << "yes";
	}



	return 0;
}

