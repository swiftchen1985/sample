package com.trevorbernard.disruptor.examples;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class Demo1 {  
    public static void main(String[] args) throws InterruptedException, ExecutionException {  
        int BUFFER_SIZE=1024;  
        int THREAD_NUMBERS=4;  
        /* 
         * createSingleProducer����һ���������ߵ�RingBuffer�� 
         * ��һ��������EventFactory���������������ǡ��¼�����������ʵ����ְ����ǲ����������RingBuffer�����顣 
         * �ڶ���������RingBuffer�Ĵ�С����������2��ָ���� Ŀ����Ϊ�˽���ģ����תΪ&�������Ч�� 
         * ������������RingBuffer����������û�п��������ʱ��(�����������ߣ�����˵���¼��������� ̫����)�ĵȴ����� 
         */  
        final RingBuffer<TradeTransaction> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<TradeTransaction>() {  
            public TradeTransaction newInstance() {  	
                return new TradeTransaction();  		
            }  	
        }, BUFFER_SIZE,new YieldingWaitStrategy());  
        //�����̳߳�  
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_NUMBERS);  
        //����SequenceBarrier  
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();  
          
        //������Ϣ������  
        BatchEventProcessor<TradeTransaction> transProcessor = new BatchEventProcessor<TradeTransaction>(  
                ringBuffer, sequenceBarrier, (EventHandler<TradeTransaction>) new TradeTransactionInDBHandler());  
          
        //��һ����Ŀ������RingBuffer���������ߵ�״̬    ���ֻ��һ�������ߵ��������ʡ��  
        ringBuffer.addGatingSequences(transProcessor.getSequence());  
          
        //����Ϣ�������ύ���̳߳�  
        executors.submit(transProcessor);  
        //�������������� ���ظ�ִ������3�д��� ��TradeTransactionInDBHandler����������������  
          
        Future<?> future=executors.submit(new Callable<Void>() {  
            public Void call() throws Exception {  
                long seq;  
                for(int i=0;i<1000;i++){  
                    seq=ringBuffer.next();//ռ���� --ringBufferһ����������  
                      
                    ringBuffer.get(seq).setPrice(Math.random()*9999);//������������ ����  ����˴�����⣬����RingBuffer�Ľṹͼ  
                      
                    ringBuffer.publish(seq);//����������������ʹhandler(consumer)�ɼ�  
                }  
                return null;  
            }  
        });  
        future.get();//�ȴ������߽���  
        Thread.sleep(1000);//����1�룬�����Ѷ��������  
        transProcessor.halt();//֪ͨ�¼�(����˵��Ϣ)������ ���Խ����ˣ����������Ͻ���!!!��  
        executors.shutdown();//��ֹ�߳�  
    }  
} 