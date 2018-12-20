package com.wangyn.test;

public class TestString {
    public static void main(String[] args) {
//        String originalSql = "SELECT count(1) FROM outbound_bill o LEFT JOIN outbound_bill_extra o_b_e ON o.outbound_bill_no = o_b_e.outbound_bill_no WHERE o.outbound_bill_status = 2 AND o.complete_time BETWEEN ? AND ? AND o.ware_house_id = ? AND (o_b_e.return_supply_type <> ? OR o_b_e.return_supply_type IS NULL) AND o.outbound_bill_type IN (?, ?, ?) AND (o.channel_id = 1001) AND (o_b_e.channel_id = 1001)";
//        String modifysql = originalSql.replaceAll("\\(o_b_e.channel_id.*\\)", "1=1");
//        System.out.println(modifysql);

        String str = "C20181018006708,C20181020000048,C20181025015070,C20181030027449,C20181030027750," +
                "C20181030028013,C20181105003818,C20181105004021,C20181105004187,C20181105006905,C20181105028994," +
                "C20181109025725,C20181112024696,C20181115028602,C20181119027216,C20181119027634,C20181120030927," +
                "C20181120031044,C20181120058830,C20181121004908,C20181121006693,C20181121009760,C20181122003693," +
                "C20181122004444,C20181122013218,C20181125025697,C20181126004404,C20181126028905,C20181126029757," +
                "C20181127022494,C20181128007290,C20181203027417,C20181203028146,C20181203032152,C20181205035546," +
                "C20181211030476";
        String[] strary = str.split(",");
        String sd = "";
        for (String s : strary){
            sd += "'" + s + "',";
        }
        System.out.println(sd);
    }

}
