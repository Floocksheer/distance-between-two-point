
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Point2D{
 int x;
 int y;
 public Point2D(int x, int y){
 this.x = x;
 this.y = y;
 }
 public int getX() {
 return x;
 }
 public int getY() {
 return y;
 }
}
public class h5 {
 public static void main(String[] args) {
 ArrayList<Point2D> cordinates = new ArrayList<Point2D>();
 Random rand = new Random();
 for (int j = 0; j < 6; j++) {
 int x = rand.nextInt(20);
 int y = rand.nextInt(20);
 Point2D point = new Point2D(x, y);
 cordinates.add(point);
 }
 try {
 ArrayList<Point2D> bruh = new ArrayList<Point2D>();
 PrintWriter pw = new PrintWriter("points.txt");
 for (int i = 0; i < cordinates.size(); i++) {
 Point2D point = cordinates.get(i);
 pw.println(point.getX()+"=x" + "," + point.getY()+"=y");
 }
 pw.flush();
 pw.close();
 
 Scanner scan =new Scanner(new File("points.txt"));
 while(scan.hasNextLine()) {
 String line= scan.nextLine();
 String pieces[]= line.split(",");
 String x[]=pieces[0].split("=");
 String y[]=pieces[1].split("=");
 Point2D p = new 
Point2D(Integer.parseInt(x[0]),Integer.parseInt(y[0]));
 bruh.add(p);
 }
 int minc=0;
 int mind=0;
 double min= 1000000;
 for(int d=0; d<bruh.size(); d++) {
 for(int c=0; c<bruh.size();c++) {
 double distance = 
Math.sqrt(Math.pow(bruh.get(d).getX() - bruh.get(c).getX(), 2) + 
Math.pow(bruh.get(d).getY() - bruh.get(c).getY(), 2));
 if(distance<min && d!=c) {
 min=distance;
 minc=c;
 mind=d;
 }
 }
 }
 
 System.out.printf("closest distance is %.1f closest points are %d,%d / %d,%d \n",min,bruh.get(mind).getX(),bruh.get(mind).getY(),bruh.get(minc).getX(),bruh.get(minc).getY());
 } catch (FileNotFoundException e1) {
 }
 ArrayList<Point2D> cordinatesbin = new ArrayList<Point2D>();
 for (int j = 0; j < 6; j++) {
 int x = rand.nextInt(20);
 int y = rand.nextInt(20);
 Point2D pointbin = new Point2D(x, y);
 cordinatesbin.add(pointbin);
 }
 try {
 DataOutputStream dos = new DataOutputStream(new 
FileOutputStream("points.bin"));
 for (int i = 0; i < cordinatesbin.size(); i++) {
 Point2D pointbin = cordinatesbin.get(i);
 dos.writeInt(pointbin.getX());
 dos.writeInt(pointbin.getY());
 }
 dos.flush();
 dos.close();
 }catch(IOException e) { 
 }
 try {
 ArrayList<Point2D> cordinatesbinbruh = new 
ArrayList<Point2D>();
 DataInputStream dosR = new DataInputStream(new 
FileInputStream("points.bin"));
 for (int i = 0; i < cordinatesbin.size(); i++) {
 Point2D pointbin = new 
Point2D(dosR.readInt(),dosR.readInt());
 cordinatesbinbruh.add(pointbin); 
 }
 
 int minc=0;
 int mind=0;
 double min= 1000000;
 for(int d=0; d<cordinatesbinbruh.size(); d++) {
 for(int c=0; c<cordinatesbinbruh.size();c++) {
 double distance = 
Math.sqrt(Math.pow(cordinatesbinbruh.get(d).getX() -
cordinatesbinbruh.get(c).getX(), 2) + 
Math.pow(cordinatesbinbruh.get(d).getY() -
cordinatesbinbruh.get(c).getY(), 2));
 if(distance<min && d!=c) {
 min=distance;
 minc=c;
 mind=d;
 }
 }
 }
 
 System.out.printf("closest distance is %.1f closest points are %d,%d / %d,%d",min,cordinatesbinbruh.get(mind).getX(),cordinatesbinbruh.get(mind).getY(),cordinatesbinbruh.get(minc).getX(),cordinatesbinbruh.get(minc).getY());
 dosR.close();
 
 }catch(IOException e2) {
 
 } 
 }
}

