package jcip.chap3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import jcip.Immutable;

@Immutable
public final class ThreadStoooges {
	private final Set<String> stooges = new HashSet<>();
	
	public ThreadStoooges(){
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}
	
	public boolean isStooges(String name){
		return stooges.contains(name);
	}
	
	public String getStoogeNames() {
        List<String> stooges = new Vector<String>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }

	public static void main(String[] args) {
		ThreadStoooges ts = new ThreadStoooges();
		ts.isStooges("Moe");
	}
}
