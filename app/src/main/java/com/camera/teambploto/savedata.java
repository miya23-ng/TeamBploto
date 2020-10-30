package com.camera.teambploto;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "save")
public class savedata {

    private String name;
    private String gend;
    private String skel;
    private String releasedate;

    @DynamoDBHashKey(attributeName = "name")
    public String getname() {return name; }
    public void setname(String name) { this.name = name; }

    @DynamoDBRangeKey(attributeName = "gend")
    public String getgend() {return gend; }
    public void setgend(String gend) { this.gend = gend; }

    @DynamoDBAttribute(attributeName = "skel")
    public String getskel() {return skel; }
    public void setskel(String skel) { this.skel = skel; }

    @DynamoDBAttribute(attributeName = "Releasedate")
    public String getReleasedate() {return releasedate; }
    public void setReleasedate(String releasedate) { this.releasedate = releasedate; }

}