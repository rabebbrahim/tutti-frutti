package com.example.tuttifruitti;

import java.util.ArrayList;

public class DataSources {
    private String choix1,choix2,choix3,choix4;

    public DataSources(String choix1,String choix2,String choix3,String choix4){
        this.choix1=choix1;
        this.choix2=choix2;
        this.choix3=choix3;
        this.choix4=choix4;
    }



    public String getChoix1() {
        return choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public String getChoix3() {
        return choix3;
    }

    public String getChoix4() {
        return choix4;
    }
    private static int lastChoiceId = 0;

    public static ArrayList<DataSources> createsDataSourcesList(int choice){
        ArrayList<DataSources> myDatas = new ArrayList<DataSources>();
        for (int i = 1; i <= choice; i++) {
           myDatas.add(new DataSources( "mySpinner1","mySpinner2","mySpinner3","mySpinner3"));
        }
        return myDatas;
    }

}
