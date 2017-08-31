package com.io;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedBiggerFileReader {
    private MappedByteBuffer[] mappedBufArray;
    private int count = 0;
    private int number;
    private FileInputStream fileIn;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public MappedBiggerFileReader(String fileName, int arraySize) throws IOException {
        this.fileIn = new FileInputStream(fileName);
        FileChannel fileChannel = fileIn.getChannel();
        this.fileLength = fileChannel.size();
        this.number = (int) Math.ceil((double) fileLength / (double) Integer.MAX_VALUE);
        this.mappedBufArray = new MappedByteBuffer[number];// �ڴ��ļ�ӳ������
        long preLength = 0;
        long regionSize = (long) Integer.MAX_VALUE;// ӳ������Ĵ�С
        for (int i = 0; i < number; i++) {// ���ļ�����������ӳ�䵽�ڴ��ļ�ӳ��������
            if (fileLength - preLength < (long) Integer.MAX_VALUE) {
                regionSize = fileLength - preLength;// ���һƬ����Ĵ�С
            }
            mappedBufArray[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, preLength, regionSize);
            preLength += regionSize;// ��һƬ����Ŀ�ʼ
        }
        this.arraySize = arraySize;
    }

    public int read() throws IOException {
        if (count >= number) {
            return -1;
        }
        int limit = mappedBufArray[count].limit();
        int position = mappedBufArray[count].position();
        if (limit - position > arraySize) {
            array = new byte[arraySize];
            mappedBufArray[count].get(array);
            return arraySize;
        } else {// ���ڴ��ļ�ӳ�����һ�ζ�ȡ����
            array = new byte[limit - position];
            mappedBufArray[count].get(array);
            if (count < number) {
                count++;// ת������һ���ڴ��ļ�ӳ��
            }
            return limit - position;
        }
    }

    public void close() throws IOException {
        fileIn.close();
        array = null;
    }

    public byte[] getArray() {
        return array;
    }

    public long getFileLength() {
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        MappedBiggerFileReader reader = new MappedBiggerFileReader("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1) ;
        long end = System.nanoTime();
        reader.close();
        System.out.println("MappedBiggerFileReader: " + (end - start));
    }
}