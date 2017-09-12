package com.future;

import java.util.concurrent.Callable;

public class RealData implements Callable<MarkTag> {

	private MarkTag markTag;
	
	public RealData(MarkTag markTag) {
		this.markTag = markTag;
	}
	
	@Override
	public MarkTag call() throws Exception {
		 //利用sleep方法来表示真是业务是非常缓慢的
        try {
            Thread.sleep(10000);
            markTag.setName("demo01");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return markTag;
	}

}
