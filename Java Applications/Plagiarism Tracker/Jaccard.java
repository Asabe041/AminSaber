public class Jaccard implements Similarity{

public double score(WordMap a, WordMap b){
	String[] tableSA = a.keys();
	String[] tableSB = b.keys();
	LinkedList intersection = new LinkedList();

	
	for(int i=0;i<a.size();i++){
		for(int j =0;j<b.size();j++){
			if(tableSA[i].equals(tableSB[j])){
				intersection.addLast(tableSA[i]);
			}
		}
	}

	double length=a.size()+b.size();
	double result= intersection.size()/(length-intersection.size());
	
	return result;
}
}