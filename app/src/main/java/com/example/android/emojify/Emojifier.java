package com.example.android.emojify;

// COMPLETE (1): Create a Java class called Emojifier
    // COMPLETE (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap) {
        // Create face detector to detect faces
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Create a frame instance from the bitmap to supply to the detector
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // The detector can be called synchronously with a frame to detect faces
        SparseArray<Face> faces = detector.detect(frame);

        int numberOfFaces = faces.size();

        if (numberOfFaces > 0) {
            Log.v(TAG, Integer.toString(numberOfFaces) + " faces detected");
            Toast.makeText(context, Integer.toString(numberOfFaces) + " faces detected", Toast.LENGTH_LONG).show();
        }
        else {
            Log.v(TAG, "No Faces Detected");
            Toast.makeText(context, "No Faces Detected", Toast.LENGTH_LONG).show();
        }

        detector.release();
    }
}
