package ua.org.oa.ryhlyuk.vladimir;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class HemmingAlgo {

	public boolean HemmingAlgorithm(Double[] enterSymb, int index){
		ArrayList<Double> uVihZ = new ArrayList();
		ArrayList<Integer> indexU = new ArrayList();
		ArrayList<Double> uRezerv = new ArrayList();
		
		Double[]uVhZ = new Double[26];
	    Double m = (double)26/2; 
	    Arrays.fill(uVhZ, m);
	    Double epsilon = 1.0/26.0;// смещение
	    for(int i=0;i<26;i++){
	    	Double[] workAlphabet = Learning.vocabulary.get((char)(65+i));
	    	for(int j =0;j<25;j++)
	        {
	    		uVhZ[i]+=enterSymb[j]*workAlphabet[j];
	        }
	    	uVihZ.add(uVhZ[i]*0.1);
	        indexU.add(i);
	      }
	    Double sumOfU;
	    do{
	    	uRezerv.clear();
	     for(int i=0;i<uVihZ.size();i++)
	    	 uRezerv.add(uVihZ.get(i));
	         for(int j=0;j<uVihZ.size();j++)
	         	{
	        	 sumOfU = 0.0;
	        	 for(int i=0;i<uVihZ.size();i++)
	        	 	{
	        		 if(i!=j)
	        			 sumOfU+=uRezerv.get(i);
	        		 }
	        	 uVihZ.add(j,uVihZ.get(j)-epsilon*sumOfU);
	        	 if(uVihZ.get(j)<=0)
	        	 {
	        		 uVihZ.remove(j+1);
	        		 uVihZ.remove(j);
	        		 uRezerv.remove(j);
	        		 indexU.remove(j);
	        		 j--;
	        		 }
	        	 else
	        	 {
	        		 uVihZ.remove(j+1);
	        		 }
	             }
	     }
	    while (uVihZ.size()>1&&indexU.size()>1);
	    //pw.print(indexU);
	    if(indexU.get(0)==index)
	    	{
	    	switch(indexU.get(0)){
	    		case 0:Game.message="Correct! That was an Apple!";break;
	    		case 1:Game.message="Correct! That was a Bear!";break;
	    		case 2:Game.message="Correct! That was a Cat!";break;
	    		case 3:Game.message="Correct! That was a Dog!";break;
	    		case 4:Game.message="Correct! That was an Eagle!";break;
	    		case 5:Game.message="Correct! That was a Fox!";break;
	    		case 6:Game.message="Correct! That was a Goat!";break;
	    		case 7:Game.message="Correct! That was a Horse!";break;
	    		case 8:Game.message="Correct! That was an Ice Cream!";break;
	    		case 9:Game.message="Correct! That was a Jellyfish!";break;
	    		case 10:Game.message="Correct! That was a Kangaroo!";break;
	    		case 11:Game.message="Correct! That was a Lion!";break;
	    		case 12:Game.message="Correct! That was a Monkey!";break;
	    		case 13:Game.message="Correct! That was a Number Nine!";break;
	    		case 14:Game.message="Correct! That was an Owl!";break;
	        	case 15:Game.message="Correct! That was a Penguin!";break;
	        	case 16:Game.message="Correct! That was a Queen!";break;
	        	case 17:Game.message="Correct! That was a Rabbit!";break;
	        	case 18:Game.message="Correct! That was a Sheep!";break;
	        	case 19:Game.message="Correct! That was a Turtle!";break;
	        	case 20:Game.message="Correct! That was an Umbrella!";break;
	        	case 21:Game.message="Correct! That was a Violin!";break;
	        	case 22:Game.message="Correct! That was a Wheel!";break;
	        	case 23:Game.message="Correct! That was a X-Ray!";break;
	        	case 24:Game.message="Correct! That was an Yacht!";break;
	        	case 25:Game.message="Correct! That was a Zebra!";break;
	        	default:Game.message="Incorrect writting!";
	    		}
	    	}
	    else
	    	Game.message="Incorrect! The correct letter is "+Character.toString((char)(index+65))+" and You wrote "+Character.toString((char)(indexU.get(0)+65));
	    return true;
	}
}
