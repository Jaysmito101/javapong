#include <bits/stdc++.h>
using namespace std;
int main ()
{
    string str = "java -jar JavaPong.jar";
    const char *command = str.c_str(); 
    cout << "Starting the Game!" << endl;
    system(command);
    return 0;
}