public class MultiThreading extends Thread{
@Override
public void run(){
for(int i=1;i<=5;i++){
System.out.print(i);
try {
Thread.sleep(1000);
}catch(InterruptedException e){
}}}}
