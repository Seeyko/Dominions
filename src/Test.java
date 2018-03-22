import java.awt.List;
import java.util.ArrayList;


public class Test {

	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] tab = {1,2,3,4};
		for(int i = tab[3]; i < 4; i++){
			list.add(tab[i]);
		}
		for(int i = 0; i < 3; i++){
			list.add(tab[i]);
		}
		
		System.out.println(list);
	}
}
