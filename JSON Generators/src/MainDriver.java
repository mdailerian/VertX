/**
 * Created by MMAA-local on 5/22/2016.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MainDriver {

    public static void main(String[] args) {

        //
        // create context list - Array
        // create

        JSONObject obj = new JSONObject();
        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.println(obj);

        JSONObject jo = new JSONObject();
        jo.put("firstName", "John");
        jo.put("lastName", "Doe");

        JSONArray ja = new JSONArray();
        ja.add(jo);

        JSONObject mainObj = new JSONObject();
        mainObj.put("employees", ja);
        mainObj.put("KARATE BELT", "PURPLE");
        System.out.println(mainObj);
        //////////////////////////////////////
        JSONObject context = new JSONObject();
        context.put("identityId", "SOME USERNAME");
        context.put("identityToken", "COOKIE");

        JSONArray contextList = new JSONArray();
        JSONObject contextDetails = new JSONObject();

        contextDetails.put("name", "append");
        JSONArray values = new JSONArray();
        JSONArray valuesJSON = new JSONArray();
        valuesJSON.add("true");
        values.add(valuesJSON);

        contextDetails.put("values", values);
        contextList.add(contextDetails);
        context.put("contextList", contextList);
        System.out.println(context);

        ////////////
        JSONArray documents = new JSONArray();
        JSONObject document= new JSONObject();
        /// put stuff here
        document.put( "content", "SOME CONTENT");
        document.put( "domain", "www.permissioned.site");
        document.put( "filename", "xyz.json");
        document.put( "parentDocType", "Plain text");
        document.put( "status", "active");
        document.put( "user", "someone");

        // specific fields
        /*
        JSONObject fields = new JSONObject();
        fields.put("name", "collection");
fields.put( "values", new JSONArray());

        fields.put("name", "docPublishedStatus_s");
        document.put("fields", fields);
*/
        JSONArray fields = new JSONArray();

        // each field combination goes below
        // 1 handle collection
        JSONObject name = new JSONObject();
        name.put("name", "collection");
        fields.add(name);
        JSONArray valuesOfCollection = new JSONArray();
        valuesOfCollection.add("collection name");
        JSONObject valueMapOfCollection = new JSONObject();
        valueMapOfCollection.put("values", valuesOfCollection);
        fields.add(valueMapOfCollection);

        // 2 handle published status
        // HOW CAN I HAVE MORE THAN ONE FIELD WITH THR SAME NAME e.g. "NAME" ???
        JSONObject nameStatus = new JSONObject();
        name.put("name", "publishedStatus");
        fields.add(nameStatus);


        document.put("fields", fields);

        // tie it all together
        documents.add(document);
        // the top level document
        JSONObject topLevelDocument= new JSONObject();
        topLevelDocument.put("context", context);
        topLevelDocument.put("documents", documents);
        System.out.println(topLevelDocument);
    }
}