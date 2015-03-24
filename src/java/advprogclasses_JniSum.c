#include <jni.h>
#include <omp.h>
#include "advprogclasses_JniSum.h"

#pragma omp parallel for
JNIEXPORT jobjectArray JNICALL Java_advprogclasses_JniSum_calculateSum
  (JNIEnv *env, jobject obj, jobjectArray matrix1, jobjectArray matrix2){
  	 
	 jarray results; //matrix to be returned
	 jsize row = (*env)->GetArrayLength(env,matrix1); //length of array
	 jclass dblArrCls = (*env)->FindClass(env, "[D");
	 results = (*env)->NewObjectArray(env,row,dblArrCls,NULL);
	 int i;
	 for(i =0; i < row;i++){
	 	 int j;
	 	 jdoubleArray matrixRowsArr1 =(*env)->GetObjectArrayElement(env,matrix1,i);//gets the arrays per rows in matrix1
	 	 jdoubleArray matrixRowsArr2 = (*env)->GetObjectArrayElement(env,matrix2,i);//gets the arrays per rows in matrix2
	 	 jdouble* matrix1RowElements =(*env)->GetDoubleArrayElements(env,matrixRowsArr1,NULL);//sets a pointer to the element values of eachrow
	 	 jdouble* matrix2RowElements =(*env)->GetDoubleArrayElements(env,matrixRowsArr2,NULL);//sets a pointer to the element values
	 	 jsize col = (*env)->GetArrayLength(env,matrix1);
	 	 jdouble sum[256];
	 	 jdoubleArray sumArr = (*env)->NewDoubleArray(env,col); //array to hold sum values;
		 for(j = 0;j< col;j++){
		  	sum[j] = matrix1RowElements[j] + matrix2RowElements[j];
		 }
		 (*env)->SetDoubleArrayRegion(env, sumArr, 0, col, sum);//sets sum values to sumArr
		 (*env)->SetObjectArrayElement(env, results, i, sumArr);//set array row to results 
		 (*env)->DeleteLocalRef(env, sumArr);//deletes references
		 (*env)->ReleaseDoubleArrayElements(env,matrixRowsArr1,matrix1RowElements,0);
		 (*env)->ReleaseDoubleArrayElements(env,matrixRowsArr2,matrix2RowElements,0); //deletes pointers references
	 }
	 return results;
	 
}
  
