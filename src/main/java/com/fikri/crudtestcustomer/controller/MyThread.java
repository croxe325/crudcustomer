package com.fikri.crudtestcustomer.controller;

public class MyThread extends Thread {

    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Simpan Berhasil");
        Thread.interrupted();
    }
}