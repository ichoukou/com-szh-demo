/**
 * Created by zhihaosong on 16-5-17.
 */

import java.util.*;

public class RandomTest {
    static class SmsChannel {
        private int id;

        public SmsChannel(int weight, int id) {
            this.weight = weight;
            this.id = id;
        }

        private int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        List<SmsChannel> smsChannels = new ArrayList<SmsChannel>();
        smsChannels.add(new SmsChannel(30, 1));
        smsChannels.add(new SmsChannel(30, 2));
        smsChannels.add(new SmsChannel(40, 3));
        int i = 0;
        while (i < 1000) {
            int rand = new Random().nextInt(90);
            if (rand == 0) {
                System.out.println(rand + "\t" + rand);
            }

            int ranInt = new Random().nextInt(90) + 1;
            int start = 1;
            int end = 0;
            for (SmsChannel channel : smsChannels) {
                end = channel.getWeight() + start;
                if (ranInt >= start && ranInt < end)
                    if (!counts.containsKey(channel.getId())) {
                        counts.put(channel.getId(), 1);
                    } else {
                        int num = counts.get(channel.getId());
                        num++;
                        counts.put(channel.getId(), num);
                    }
                start = end;
            }
            i++;
        }
        System.out.println(counts.toString());

    }
}
