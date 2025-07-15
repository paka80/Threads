// SplitterConveyor.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <stdio.h>
#include <conio.h>
#include <stdio.h>
extern "C" {
	// observe your project contents. We are mixing C files with cpp ones.
	// Therefore, inside cpp files, we need to tell which functions are written in C.
	// That is why we use extern "C" directive
#include <interface.h>
#include <SplitterConveyor.h>
}
int main()
{
	printf("Welcome to the Splitter Conveyor Application\n");

	initializeHardwarePorts();
	int t = -1;
	int posicao = 0;

	printf("\nPress: q, a z or 0 ");
	while (t != '0') {
		t = _getch();
		switch (t) {
		case 'i': initializeHardwarePorts(); break; // falta verificar
		case 'q': cylinder1_moveForward(); break;
		case 'a': cylinder1_moveBackward(); break;
		case 'z': cylinder1_stop(); break;
		case '1': { int posicao = cylinder1_getPosition(); printf("Posicao Cilindro1: %d\n", posicao); break; }
		case 'w': cylinder2_moveForward(); break;
		case 's': cylinder2_moveBackward(); break;
		case 'x': cylinder2_stop(); break;
		case '2': { int posicao = cylinder2_getPosition(); printf("Posicao Cilindro2: %d\n", posicao); break; }
		case 'e': cylinderStart_moveForward(); break;
		case 'd': cylinderStart_moveBackward(); break;
		case 'c': cylinderStart_stop(); break;
		case '3': { int posicao = cylinderStart_getPosition(); printf("Posicao CilindroStart: %d\n", posicao); break; }
		case 'r': conveyorMove(); break;
		case 'f': conveyorstop(); break;
		case 't': { int posicao = isBoxAtDock1(); printf("Box na posicao 1: %d\n", posicao); break; }
		case 'g': { int posicao = isBoxAtDock2(); printf("Box na posicao 2: %d\n", posicao); break; }
		case 'v': getIdentificationSensors(); break; // falta verificar
		case 'o': ledOn(); break;
		case 'p': ledOff(); break;
		}
	}

	writeDigitalU8(2, 0x00);
	closeChannels();
	return 0;
}