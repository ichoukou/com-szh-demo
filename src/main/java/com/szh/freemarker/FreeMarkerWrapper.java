package com.szh.freemarker;

import com.dajie.common.util.StringUtil;
import com.dajie.sms.model.DefaultTplKey;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FreeMarkerWrapper {
    private static Pattern shortUrlPattern = Pattern.compile("\\s*(http://)*d-j.me/[0-9a-zA-Z]{7}\\s*");

    private final Configuration cfg = new Configuration();
    private final StringTemplateLoader stringLoader = new StringTemplateLoader();
    private static RandomTemplateMethodModel RandomTemplateMethodModel = new FreeMarkerWrapper.RandomTemplateMethodModel();

    private static RandomTemplateMethodModel222 randomTemplateMethodModel222 = new FreeMarkerWrapper.RandomTemplateMethodModel222();
    private ConcurrentHashMap<Integer, Integer> tplStatus;

    private static FreeMarkerWrapper instance;

    private FreeMarkerWrapper() {
        tplStatus = new ConcurrentHashMap<Integer, Integer>();
        cfg.setTemplateLoader(stringLoader);
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        cfg.setLocale(java.util.Locale.SIMPLIFIED_CHINESE);
        cfg.setEncoding(java.util.Locale.SIMPLIFIED_CHINESE, "UTF-8");
    }

    public static void main(String[] args) {
        Map aaa = new HashMap();
        List<String> aab = new ArrayList<String>();
        aab.add("songzhihao");        aab.add("songzhihao");
        aab.add("test,nihao");

        aaa.put("sss", aab);
        aaa.put("zzz", "sdfsfd");

        HashMap aKeyMap = new HashMap();


        Configuration cfg = new Configuration();
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String templateContent = "欢迎：${name}," +
                "<#assign tt=RANDOM('http://m.dajie.com/invitation/unhandled/schedule?noAppTip=1&scheduleId=')/> ${RANDOM2(tt,' sb')}" +
                "${sss[0]},${sss[2]},${zzz}";
        stringLoader.putTemplate("myTemplate", templateContent);

        cfg.setTemplateLoader(stringLoader);

        try {
            aKeyMap.putAll(aaa);
            aKeyMap.put("RANDOM", RandomTemplateMethodModel);
            aKeyMap.put("RANDOM2", randomTemplateMethodModel222);
            Map mapp = randomTemplateMethodModel222.getMap();
            aKeyMap.putAll(mapp);
            Template template = cfg.getTemplate("myTemplate", "utf-8");
            aKeyMap.put("name", "宋志豪");

            StringWriter writer = new StringWriter();
            try {
                template.process(aKeyMap, writer);
                System.out.println(writer.toString());
            } catch (TemplateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static FreeMarkerWrapper getInstance() {
        if (instance == null) {
            synchronized (FreeMarkerWrapper.class) {
                if (instance == null) {
                    instance = new FreeMarkerWrapper();
                }
            }
        }
        return instance;
    }

    public static String readValue(String filePath, String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            String value = props.getProperty(key);
            // System.out.println(value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static class RandomTemplateMethodModel implements TemplateMethodModel {

        public Object exec(List list) throws TemplateModelException {
            return "test exec";
        }
    }

    static class RandomTemplateMethodModel222 implements TemplateMethodModel {
        Map map = new HashMap();

        public Object exec(List list) throws TemplateModelException {

            map.put("sss", list.get(0).toString());
            map.put("zzz", list.get(1).toString());
            return "szh";
        }

        public Map getMap() {
            return map;
        }
    }


    class ShortUrlTemplateMethodModel implements TemplateMethodModel {

        public Object exec(List list) throws TemplateModelException {
            String res = "";
            if (list == null || list.isEmpty()) {
                return "";
            }

            int uid = 0;
            if (list.size() >= 2) {
                uid = Integer.parseInt(list.get(1).toString());
            }

            return res;
        }
    }

    public String render(Map<String, String> userInfo, String tpl) throws IOException, TemplateException {
        HashMap aKeyMap = new HashMap();
        Template template = null;
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        String html = "";
        template = this.cfg.getTemplate(tpl);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String st = format.format(new Date());
        String mobile = userInfo.get("MOBILE");
        String uid = userInfo.get("UID");
        if (StringUtil.isEmpty(uid)) {
            uid = mobile;
        }

        FreeMarkerWrapper.RandomTemplateMethodModel randomTemplateMethodModel = new FreeMarkerWrapper.RandomTemplateMethodModel();
        aKeyMap.put("RANDOM", randomTemplateMethodModel);
        Iterator matcher = userInfo.keySet().iterator();

        while (matcher.hasNext()) {
            String key = (String) matcher.next();
            aKeyMap.put(key, userInfo.get(key));
        }

        template.process(aKeyMap, writer);
        html = stringWriter.toString();
        Matcher matcher1 = shortUrlPattern.matcher(html);
        if (matcher1.find()) {
            if (!html.contains("http")) {
                html = matcher1.replaceAll(" " + matcher1.group().trim() + " ");
            } else {
                String shortUrl = matcher1.group().trim();
                shortUrl = shortUrl.substring(shortUrl.indexOf("d-j.me")).trim();
                html = matcher1.replaceAll(" " + shortUrl + " ");
            }
        }
        writer.flush();
        writer.close();
        return html;
    }

    public String render(int uid, int tplId, Map<String, String> data) {

        String res = "";
        Template temp = null;
        try {
            temp = cfg.getTemplate(String.valueOf(tplId));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tempContent = temp.toString();
        Pattern linkPattern = Pattern.compile("\\$\\{([a-zA-Z_][0-9a-zA-Z_]*?)\\}",
                Pattern.CASE_INSENSITIVE);
        Matcher linkMatcher = linkPattern.matcher(tempContent);
        Set<String> tplKeys = new HashSet<String>();
        int end = 0;
        while (linkMatcher.find()) {
            if (linkMatcher.start() >= end) {
                String key = linkMatcher.group(0);
                key = key.substring(2, key.length() - 1);
                if (key.startsWith("t_")) {
                    continue;
                }
                tplKeys.add(key);
                end = linkMatcher.end();
            }
        }

        Set<String> defaultKeys = new HashSet<String>();
        for (String key : tplKeys) {
            if (!data.containsKey(key)) {
                if (!DefaultTplKey.KEY_SET.containsKey(key)) {
                    return "";
                } else {
                    if (uid <= 0) {
                        return "";
                    }
                    defaultKeys.add(key);
                }
            }
        }


        try {
            Map root = new HashMap();
            for (String k : data.keySet()) {
                root.put(k, data.get(k));
            }
            root.put("SHORT_URL", RandomTemplateMethodModel);

            StringWriter stringWriter = new StringWriter();
            BufferedWriter writer = new BufferedWriter(stringWriter);
            temp.process(root, writer);
            res = stringWriter.toString();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return res;
    }
}
