package com.czw.base.thread;

/**
 * 数据库多线程的交替备份方式
 * @author ZeviChen 2016/10/14 10:39
 */
public class AlternateBackups {
    public static void main(String[] args){
        readyBackUp();
    }

    public static void readyBackUp(){
        DBtools t = new DBtools();
        for(int i = 0;i < 10;i++){
            new BackupA(t).start();
            new BackupB(t).start();
        }
    }

}
class BackupA extends Thread{
    private DBtools t;
    BackupA(DBtools t){
        this.t = t;
    }

    @Override
    public void run() {
        t.backupA();
    }
}
class BackupB extends Thread{
    private DBtools t;
    BackupB(DBtools t){
        this.t = t;
    }

    @Override
    public void run() {
        t.backupB();
    }
}

class DBtools{
    private volatile boolean isBackupA = true;

    public synchronized void backupA(){
        try{
            while(!isBackupA){
                wait();
            }
            for(int i = 0;i<4;i++){
                System.out.println("backups ADB ||");
            }
            isBackupA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void backupB(){
        try{
            while(isBackupA){
                wait();
            }
            for(int i = 0;i<4;i++){
                System.out.println("backups BDB ==");
            }
            isBackupA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
