package testLIst;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhihaosong on 16-9-14.
 */
public class Main {
    private static Map<Serial, List<String>> serialInfoListGroup = new HashMap<Serial, List<String>>();

    public static void main(String[] args) {
        Serial key = new Serial(10, "test1");
        if (serialInfoListGroup.containsKey(key)) {
            serialInfoListGroup.get(key).add("demo1");
        } else {
            List<String> mergeSerialInfoList = new ArrayList<String>();
            serialInfoListGroup.put(key, mergeSerialInfoList);
        }
        System.out.println(serialInfoListGroup.keySet().toString());
        Serial key2 = new Serial(10, "test1");
        if (serialInfoListGroup.containsKey(key2)) {
            serialInfoListGroup.get(key2).add("demo2");
        } else {
            List<String> mergeSerialInfoList = new ArrayList<String>();
            serialInfoListGroup.put(key2, mergeSerialInfoList);
        }
        System.out.println(key.hashCode() + "\t" + key2.hashCode());

        System.out.println(serialInfoListGroup.keySet().toString());
        String[] fileNames = null;
        File dir = new File("target/classes/szh/condition");
        if (dir.isDirectory()) {
            // logger.info("DemandsManager:getFileNames " + dirName +
            // " is dir.");
            fileNames = dir.list();
            for (int i = 0; i < fileNames.length; i++) {
                System.out.println(fileNames[i]);
            }
        }

    }
}
