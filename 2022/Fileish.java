import java.util.*;
import java.io.*;

public class Fileish{
		public int size;
		public String name;
		public Fileish parent;
		public HashMap <Fileish, Integer> storage = new HashMap<Fileish, Integer>();

		public Fileish( String name, Fileish parent, int size){
			this.name = name;
			this.parent  = parent;
			this.size = size;
			this.storage = null;
		}

		public Fileish(String name, Fileish parent){
			this.name = name;
			this.parent = parent;
			this.size = -1;
			this.storage = new HashMap<Fileish, Integer>();
		}

		public void printMap(int tabs){
			for (int i = 0; i < tabs; i++){
				System.out.print("\t");
			}
			System.out.println(this.name + ": " + this.size);
			if (this.storage != null){
				for (Fileish x : this.storage.keySet()){
					x.printMap(tabs + 1);
				}
			}	
		}

		public int fillIn(){
			if ( this.size == -1){
				int total = 0;
				for (Fileish x : this.storage.keySet()){
					if (x.size == -1){
						total += x.fillIn();
					}
					else{ total += x.size;}
				}
				this.size = total;
				return total;
			}
			return this.size;
		}

		public int sumLess(){
			int total = 0;
			if (this.storage != null){
				if (this.size < 100000){total += this.size;}
				for (Fileish x: this.storage.keySet()){ total += x.sumLess();}				
			}
			return total;
		}

		public int maxLess(int target){
			int total = Integer.MAX_VALUE;
			if (this.storage != null){
				if (this.size > target){total = Math.min(total, this.size);}
				for (Fileish x: this.storage.keySet()){ total = Math.min(total, x.maxLess(target));}				
			}
			return total;
		}
}