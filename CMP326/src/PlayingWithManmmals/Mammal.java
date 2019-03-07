package PlayingWithManmmals;

public class Mammal implements Greetings {// implements Comparable<Mammal>{
	
private String hairCol;
private int litterSize;
private double bodyTempF;

public Mammal(){
	hairCol ="blue";
	litterSize = 0;
	bodyTempF = 90;
}
public Mammal(String h, int lS, double btf){
	hairCol=h;
	litterSize = lS; //can also be written as	this.litterSize = lS;
	bodyTempF = btf;
	
}
public Mammal(String h){
	this();
	hairCol=h;
}

public Mammal(int litterSize){
	this();
	this.litterSize = litterSize;//must use keyword this to differentiate
}

public Mammal(double btf){
	this();
	bodyTempF = btf;
}

public Mammal(String h, int lS){
	this();
	hairCol = h;
	litterSize = lS;
}

public Mammal(String h, double btf)
{
	this();
	hairCol = h;
	bodyTempF = btf;
}
public void setHairColor(String hc){
	hairCol = hc;
}
public void setLitterSize(int ls){
	litterSize = ls;
}
public void setBodyTemp(double btf){
	bodyTempF = btf;
}
public String getHairColor(){
	return hairCol;
}
public int getLitterSize(){
	return litterSize;
}
public double getBodyTemp(){
	return bodyTempF;
}

public void speak(){
	System.out.println("I am a mammal HIII");
}
public String toString(){
	return "hair color: " + hairCol + 
			" litter size: " + litterSize +
			" body temp F: " + bodyTempF;
}


public int compareTo(Object otherObj){
	if(otherObj instanceof Mammal){
		Mammal otherMam = (Mammal) otherObj;
		if((this.bodyTempF<otherMam.bodyTempF)){
			return -1;
		}else if((this.bodyTempF>otherMam.bodyTempF)){
			return 1;
		}else return 0;
	}
		return -99;
		
}
@Override
public String goodmorning() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String goodeveing() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String goodnight() {
	// TODO Auto-generated method stub
	return null;
}

/**
@Override
public int compareTo(Mammal otherMam) {
	// TODO Auto-generated method stub
	if((this.bodyTempF<otherMam.bodyTempF)){
		return -1;
	}else if((this.bodyTempF>otherMam.bodyTempF)){
		return 1;
	}else return 0;
}
*/	
}
