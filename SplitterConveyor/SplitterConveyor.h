#pragma once

#include <interface.h>

void initializeHardwarePorts();
void setBitValue(uInt8* variable, int n_bit, int new_value_bit);
int getBitValue(uInt8 value, uInt8 n_bit);
int cylinder1_getPosition();
void cylinder1_moveForward();
void cylinder1_moveBackward();
void cylinder1_stop();
int cylinder2_getPosition();
void cylinder2_moveForward();
void cylinder2_moveBackward();
void cylinder2_stop();
int cylinderStart_getPosition();
void cylinderStart_moveForward();
void cylinderStart_moveBackward();
void cylinderStart_stop();
void conveyorMove();
void conveyorstop();
bool isBoxAtDock1();
bool isBoxAtDock2();
bool isDock1Closed();
bool isDock2Closed();
bool areDocksClosed();
int getIdentificationSensors();
void ledOn();
void ledOff();
void closeDock1();
void closeDock2();
void closeDockEnd();
void openDock1();
void openDock2();
void openDockEnd();
//int posicaoPackageNoConvoyer();
int boxDetected1();
int boxDetected2();