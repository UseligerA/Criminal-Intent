package com.example.criminal_intent;

import android.content.Context;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
       private List<Crime> mCrimes;
       private Map<UUID, Crime> mMapCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return  sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mMapCrimes = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i%3==0);
            mCrimes.add(crime);
            mMapCrimes.put(crime.getmId(),crime);
        }
    }

    public List<Crime> getCrimes(){
        return  mCrimes;
    }

    public Crime getCrime(UUID id){
       return mMapCrimes.get(id);
    }
}
