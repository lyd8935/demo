package jcip.chap3;

import java.math.BigInteger;

import jcip.ThreadSafe;

@ThreadSafe
public class VolatileCachedFactorizer {
	private volatile OneValueCache cache = new OneValueCache(null, null);
	
	public void service() {
		BigInteger i = this.getNumber();
		BigInteger[] factors = cache.getFactorys(i);
		if(factors == null){
			factors = this.factor(i);
			cache = new OneValueCache(i, factors);
		}
	}
	
	BigInteger getNumber(){
		return BigInteger.valueOf(7);
	}
	
	BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

}
