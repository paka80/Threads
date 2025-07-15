#include <jni.h>

JNIEXPORT void JNICALL Java_SplitterConveyor_initializeHardwarePorts(JNIEnv* ignoreEnv, jclass ignorejClass) {
	initializeHardwarePorts();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1MoveForward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder1_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1MoveBackward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder1_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1Stop(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder1_stop();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2MoveForward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder2_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2MoveBackward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder2_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2Stop(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder2_stop();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_conveyorMove(JNIEnv* ignoreEnv, jclass ignorejClass) {
	conveyorMove();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_conveyorStop(JNIEnv* ignoreEnv, jclass ignorejClass) {
	conveyorstop();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartMoveForward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinderStart_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartMoveBackward(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinderStart_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartStop(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinderStart_stop();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_ledOn(JNIEnv* ignoreEnv, jclass ignorejClass) {
	ledOn();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_ledOff(JNIEnv* ignoreEnv, jclass ignorejClass) {
	ledOff();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_closeDock1(JNIEnv* ignoreEnv, jclass ignorejClass) {
	closeDock1();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_closeDock2(JNIEnv* ignoreEnv, jclass ignorejClass) {
	closeDock2();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_closeDockEnd(JNIEnv* ignoreEnv, jclass ignorejClass) {
	closeDockEnd();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_openDock1(JNIEnv* ignoreEnv, jclass ignorejClass) {
	openDock1();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_openDock2(JNIEnv* ignoreEnv, jclass ignorejClass) {
	openDock2();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_openDockEnd(JNIEnv* ignoreEnv, jclass ignorejClass) {
	openDockEnd();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinderStartGetPosition(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinderStart_getPosition();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinder1GetPosition(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder1_getPosition();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinder2GetPosition(JNIEnv* ignoreEnv, jclass ignorejClass) {
	cylinder2_getPosition();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_boxDetected1(JNIEnv* ignoreEnv, jclass ignorejClass) {
	boxDetected1();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_boxDetected2(JNIEnv* ignoreEnv, jclass ignorejClass) {
	boxDetected2();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_getIdentificationSensors(JNIEnv* ignoreEnv, jclass ignorejClass) {
	getIdentificationSensors();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isBoxAtDock1(JNIEnv* ignoreEnv, jclass ignorejClass) {
	isBoxAtDock1();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isBoxAtDock2(JNIEnv* ignoreEnv, jclass ignorejClass) {
	isBoxAtDock2();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isDock1Closed(JNIEnv* ignoreEnv, jclass ignorejClass) {
	isDock1Closed();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isDock2Closed(JNIEnv* ignoreEnv, jclass ignorejClass) {
	isDock2Closed();
}
JNIEXPORT jboolean JNICALL Java_SplitterConveyor_areDocksClosed(JNIEnv* ignoreEnv, jclass ignorejClass) {
	areDocksClosed();
}