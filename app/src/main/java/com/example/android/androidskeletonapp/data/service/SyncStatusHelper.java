package com.example.android.androidskeletonapp.data.service;

import com.example.android.androidskeletonapp.data.Sdk;

import org.hisp.dhis.android.core.common.State;

public class SyncStatusHelper {

    public static int programCount() {
        return Sdk.d2().programModule().programs.count();
    }

    public static int dataSetCount() {
        return Sdk.d2().dataSetModule().dataSets.count();
    }

    public static int trackedEntityInstanceCount() {
        return Sdk.d2().trackedEntityModule().trackedEntityInstances.byState().neq(State.RELATIONSHIP).count();
    }

    public static int singleEventCount() {
        return Sdk.d2().eventModule().events.byEnrollmentUid().isNull().count();
    }

    public static int dataValueCount() {
        return Sdk.d2().dataValueModule().dataValues.count();
    }

    public static boolean isThereDataToUpload() {
        //  Logic to know if there is data to upload

        int size= Sdk.d2().trackedEntityModule().trackedEntityInstances.byState()
                .in(State.TO_DELETE,State.TO_POST,State.TO_UPDATE)
                .get()
                .size();
        if (size==0)
        return false;
        else return true;
    }
}
