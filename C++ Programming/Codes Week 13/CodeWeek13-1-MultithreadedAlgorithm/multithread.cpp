// mendemokan multithreading
// menggunakan 3 callable yang berbeda.
#include <iostream>
#include <thread>
using namespace std;

// fungsi dummy
void foo(int Z)
{
	for (int i = 0; i < Z; i++) {
		cout << "Thread menggunakan fungsi "
			" pointer sebagai callable\n";
	}
}

// objek callable
class thread_obj {
public:
	void operator()(int x)
	{
		for (int i = 0; i < x; i++)
			cout << "Thread menggunakan fungsi"
				" objek sebagai callable\n";
	}
};

int main()
{
	cout << "Threads 1,2 dan 3 "
		"beroperasi secara independen" << endl;

	// Thread ini diluncurkan dengan fungsi pointer sebagai callable
	thread th1(foo, 3);

	// Thread ini diluncurkan dengan fungsi objek sebagai callable
	thread th2(thread_obj(), 3);

	// definisi ekspresi lambda
	auto f = [](int x) {
		for (int i = 0; i < x; i++)
			cout << "Thread menggunakan ekspresi lambda"
			"sebagai callable\n";
	};

	// Thread ini diluncurkan dengan ekspresi lambda sebagai callable
	thread th3(f, 3);

	//menunggu thread t1 selesai 
	th1.join();

	//menunggu thread t2 selesai 
	th2.join();

	//menunggu thread t3 selesai 
	th3.join();

	return 0;
}
