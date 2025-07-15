#include <stdio.h>
#include <conio.h>
#include <stdio.h>
#include <interface.h>

void setBitValue(uInt8* variable, int n_bit, int new_value_bit)
// given a byte value, set the n bit to value
{
	uInt8 mask_on = (uInt8)(1 << n_bit);
	uInt8 mask_off = ~mask_on;
	if (new_value_bit) *variable |= mask_on;
	else *variable &= mask_off;
}
int getBitValue(uInt8 value, uInt8 n_bit)
// given a byte value, returns the value of bit n
{
	return(value & (1 << n_bit));
}
void initializeHardwarePorts() {
	createDigitalInput(0);
	createDigitalInput(1);
	createDigitalOutput(2);
}

// Cylinder 1
int cylinder1_getPosition()
{
	int v = readDigitalU8(0);
	if (!getBitValue(v, 4))
		return 0;
	else if (!getBitValue(v, 3))
		return 1;
	return(-1);
}

void cylinder1_moveForward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 4, 1);
	setBitValue(&p, 3, 0);
	writeDigitalU8(2, p);
}
void cylinder1_moveBackward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 4, 0);
	setBitValue(&p, 3, 1);
	writeDigitalU8(2, p);
}
void cylinder1_stop()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 4, 0);
	setBitValue(&p, 3, 0);
	writeDigitalU8(2, p);
}

// Cylinder 2
void cylinder2_moveForward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 6, 1);
	setBitValue(&p, 5, 0);
	writeDigitalU8(2, p);
}
void cylinder2_moveBackward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 6, 0);
	setBitValue(&p, 5, 1);
	writeDigitalU8(2, p);
}
void cylinder2_stop()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 6, 0);
	setBitValue(&p, 5, 0);
	writeDigitalU8(2, p);
}

int cylinder2_getPosition()
{
	int v = readDigitalU8(0);
	if (!getBitValue(v, 2))
		return 0;
	else if (!getBitValue(v, 1))
		return 1;
	return(-1);
}

// Cylinder Start
void cylinderStart_moveForward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 1, 1);
	setBitValue(&p, 0, 0);
	writeDigitalU8(2, p);
}
void cylinderStart_moveBackward()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 1, 0);
	setBitValue(&p, 0, 1);
	writeDigitalU8(2, p);
}
void cylinderStart_stop()
{
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 1, 0);
	setBitValue(&p, 0, 0);
	writeDigitalU8(2, p);
}

int cylinderStart_getPosition()
{
	int v = readDigitalU8(0);
	if (getBitValue(v, 6))
		return 0;
	else if (getBitValue(v, 5))
		return 1;
	return(-1);
}

// Conveyor
void conveyorMove() {
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 2, 1);
	writeDigitalU8(2, p);
}

void conveyorstop() {
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 2, 0);
	writeDigitalU8(2, p);
}



int getIdentificationSensors() {
	uInt8 p = readDigitalU8(1);

	if (getBitValue(p, 5)) 
		return 1;
	else if (getBitValue(p, 6))
	return 2;
	else
		return 0;
}

void ledOn() {
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 7, 1);
	writeDigitalU8(2, p);
}

void ledOff() {
	uInt8 p = readDigitalU8(2);
	setBitValue(&p, 7, 0);
	writeDigitalU8(2, p);
}

// Dock1
bool isBoxAtDock1() {
	uInt8 p = readDigitalU8(0);

	if (getBitValue(p, 0))
		return true;
	else
		return false;
}
bool isDock1Closed() {
	uInt8 p = readDigitalU8(1);

	if (getBitValue(p, 4))
		return true;
	else
		return false;
}

// Dock2
bool isBoxAtDock2() {
	uInt8 p = readDigitalU8(1);

	if (getBitValue(p, 7))
		return true;
	else
		return false;
}

bool isDock2Closed() {
	uInt8 p = readDigitalU8(1);

	if (getBitValue(p, 3))
		return true;
	else
		return false;
}

bool areDocksClosed() {
	uInt8 p = readDigitalU8(1);

	if (getBitValue(p, 2))
		return true;
	else
		return false;
}

void closeDock1() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 4, 1);
	writeDigitalU8(1, p);
}

void openDock1() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 4, 0);
	writeDigitalU8(1, p);
}


void closeDock2() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 3, 1);
	writeDigitalU8(1, p);
}
void openDock2() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 4, 0);
	writeDigitalU8(1, p);
}

void closeDockEnd() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 2, 1);
	writeDigitalU8(1, p);
}

void openDockEnd() {
	uInt8 p = readDigitalU8(1);
	setBitValue(&p, 2, 0);
	writeDigitalU8(1, p);
}

/*
int posicaoPackageNoConvoyer() {
	uInt8 p = readDigitalU8(0);
	uInt8 p1 = readDigitalU8(1);
	uInt8 a = getBitValue(p, 0);
	uInt8 b = getBitValue(p1, 7);

	if (a == '1')
		return 1;
	else if (b == '1')
		return 2;
	else
		return -1;
}
*/

int boxDetected1() {
	int p = readDigitalU8(0);
	if (getBitValue(p, 0))
		return 1;
	return(-1);
}

int boxDetected2() {
	int p = readDigitalU8(1);
	if (getBitValue(p, 7))
		return 1;
	return(-1);
} 