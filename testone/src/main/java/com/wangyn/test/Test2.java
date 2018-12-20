package com.wangyn.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static  void main(String[] args){
        test4();
    }

    public static  void test4(){
        String sql = "INSERT INTO `pick_bill_detail`\n" +
                " ( `outbound_detail_id`, `sku_unit`, `biz_bill_no`, `ware_house_id`, `pick_qty`, `policy_type`, " +
                "`sku_name`, `sku_unit_desc`, `freeze_lock_qty`, `biz_bill_type`, `last_modify_by`, `pick_bill_no`, " +
                "\n" +
                "`order_qty`, `last_modify_time`, `create_time`, `istatus`, `area_code`, `location_code`, " +
                "`create_by`, \n" +
                "`origin_sku_qty`, `channel_id`, `origin_sku_code`, `delivery_times`, `base_sku_qty`, `sku_code`, " +
                "`area_set_code`, `outbound_bill_no`, `business_address`, `business_name`, `purchase_bill_no`, " +
                "`sku_brand`, `base_sku_unit` )\n" +
                " VALUES ( '#outbound_detail_id', '#sku_unit', 'THD20180820115449', '112', '0', '10', '#sku_name', '#sku_unit_desc', '0', '12', \n" +
                "'肖相', 'TGJ1122018082200014', '#order_qty', NOW(), NOW(), '1', '', '', '肖相', '0', '1001', '#origin_sku_code', " +
                "'05:00-07:00',\n" +
                " '0', '#sku_code', '', '#outbound_bill_no', '', '', '', '#sku_brand', '' );";

        String datastr = "C20180820002721#16135055#2#10058009#鲜 猪肝#袋#2斤/袋#无#C20180820002721#10058008," +
                "C20180820002721#16135058#24#10051722#鲜 肋排块#袋#5斤/袋#无#C20180820002721#10051721," +
                "C20180820002721#16135059#3#10052013#鲜 前蹄髈#袋#5斤/袋#无#C20180820002721#10052012" +
                ",C20180820002721#16135060#4#10058028#鲜 带皮下五花#袋#10斤/袋#无#C20180820002721#10058026," +
                "C20180820002721#16135062#2#10052017#鲜 开片猪爪#袋#5斤/袋#无#C20180820002721#10052016," +
                "C20180820002721#16135063#1#10050819#鲜 带颈前排#袋#5斤/袋#无#C20180820002721#10050818," +
                "C20180820002721#16135064#4#10050964#鲜 大排70-80g#袋#5斤/袋#无#C20180820002721#10050963," +
                "C20180820002721#16135065#12#10053524#冻 板油 10斤#袋#10斤/袋#无#C20180820002721#10053523," +
                "C20180820002721#16135066#20#10058022#鲜 带皮前腿#袋#10斤/袋#无#C20180820002721#10058020";

        String[] dataary = datastr.split(",");
        for (String data : dataary){
            String[] msgary = data.split("#");
            String newsql = sql.replace("#outbound_bill_no",msgary[0]).replace("#outbound_detail_id",msgary[1])
                    .replace("#order_qty",msgary[2])
                    .replace("#origin_sku_code",msgary[3])
                    .replace("#sku_name",msgary[4])
                    .replace("#sku_unit",msgary[5])
                    .replace("#sku_unit_desc",msgary[6])
                    .replace("#sku_brand",msgary[7])
                    .replace("#sku_code",msgary[9]);

            System.out.println(newsql);
        }
    }

    public static void test3(){
        String ids = "1,2,3,4,5,6,7,8,9,10,11,21,22,46,47,48,55,64,65,73,79,82,84,85,90,92,93,94,95,96,100,101,102," +
                "104,105,106,107,110,111,112,113,114,124,128,135,136,137,138,139,141,144,148,149,150,153,159,160,164," +
                "169,170,173,174,180,182";
        String idary[] = ids.split(",");
        String sql = "select * from outbound_bill where (outbound_bill_no like 'C201808%' or outbound_bill_no like 'C201807%' or outbound_bill_no like 'C201806%' or outbound_bill_no like 'C201805%')  and outbound_bill_status not in (1,2) and   cancel_status = 0 and istatus = 1 and ware_house_id = #id and  outbound_bill_type = 5 ;";
        for (String id : idary){
            System.out.println(sql.replace("#id",id));
        }
    }

    public static void test1(){
        String ids = "C20180820002721,C20180725014746,C20180628001758,C20180628001932,C20180628001966,C20180628010187,C20180628010193,C20180807001526, C20180821013775";
        String idary[] = ids.split(",");
        List<String> list =  Arrays.asList(idary).stream().distinct().collect(Collectors.toList());
        System.out.println(list.size());
        String str = "select * from pick_bill_detail where outbound_bill_no in ( ";
        for (String id : list){
            str += "'"+id.trim()+"',";
        }
        System.out.println(str);
    }

    public static void tes2(){
        String idstr = "THD2017121801219," +
                "THD2018012408069," +
                "THD2018032602764," +
                "THD2018032801764," +
                "THD2018040202909," +
                "THD2018042305710," +
                "THD2018042718158," +
                "THD2018050224164," +
                "THD2018050224164," +
                "THD2018061239758," +
                "THD2018061544559," +
                "THD2018062041179," +
                "THD2018062041179," +
                "THD2018062649080," +
                "THD2018062849365," +
                "THD2018070355520," +
                "THD2018070562011," +
                "THD2018070764228," +
                "THD2018071163776," +
                "THD2018071165821," +
                "THD2018071165821," +
                "THD2018071165821," +
                "THD2018071161236," +
                "THD2018071161236," +
                "THD2018071161236," +
                "THD2018071661715," +
                "THD2018071661715," +
                "THD2018071756137," +
                "THD2018071975161," +
                "THD2018071163744," +
                "THD2018071977252," +
                "THD2018072056448," +
                "THD2018072359579," +
                "THD2018072469888," +
                "THD2018072486127," +
                "THD2018072485273," +
                "THD2018072584388," +
                "THD2018072585397," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072582216," +
                "THD2018072684686," +
                "THD2018072989063," +
                "THD2018073081098," +
                "THD2018080188958," +
                "THD2018080394557," +
                "THD2018080494686," +
                "THD2018080480589," +
                "THD2018080491898," +
                "THD2018080494767," +
                "THD20180807110264," +
                "THD20180807110264," +
                "THD20180807110264," +
                "THD2018080899677," +
                "THD2018080899677," +
                "THD2018080899677," +
                "THD2018080899677," +
                "THD20180808102745," +
                "THD20180808102745," +
                "THD20180808102745," +
                "THD20180808108262," +
                "THD2018080999764," +
                "THD2018080999764," +
                "THD20180809112065," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112748," +
                "THD20180813112940," +
                "THD20180814121243," +
                "THD20180814105915," +
                "THD20180815119565," +
                "THD20180815123072," +
                "THD20180815109906," +
                "THD20180815109906," +
                "THD20180815109906," +
                "THD20180815109906," +
                "THD20180816123392," +
                "THD20180818122739," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820115449," +
                "THD20180820125964," +
                "THD20180820130111," +
                "THD20180820131076," +
                "THD20180820131079," +
                "THD20180821130389," +
                "THD20180821115683," +
                "THD20180821127556," +
                "THD20180822129028," +
                "THD20180823137347," +
                "THD20180823137347," +
                "THD20180823135198," +
                "THD20180823135198," +
                "THD20180823134222," +
                "THD20180823134222," +
                "THD20180824137602," +
                "THD20180824136981," +
                "THD20180827146085," +
                "THD20180828142628," +
                "THD20180828142628," +
                "THD20180828146582," +
                "THD20180828148371," +
                "THD20180829146849," +
                "THD20180829142951," +
                "THD20180829146861," +
                "THD20180829142965," +
                "THD20180829151024," +
                "THD20180830150112," +
                "THD20180830150112," +
                "THD20180830152165," +
                "THD20180830154172," +
                "THD20180830154172," +
                "THD20180830154172," +
                "THD20180831152611," +
                "THD20180831156544," +
                "THD20180831156544," +
                "THD20180831156544," +
                "THD20180831156544," +
                "THD20180831156544," +
                "THD20180831151697," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180831153520," +
                "THD20180903157189," +
                "THD20180903158160," +
                "THD20180903160559," +
                "THD20180903160649," +
                "THD20180903159328," +
                "THD20180903157465," +
                "THD20180903157465," +
                "THD20180903161261," +
                "THD20180903160658," +
                "THD20180903159331";
        String idary[] = idstr.split(",");
        List<String> list =  Arrays.asList(idary).stream().distinct().collect(Collectors.toList());
        System.out.println(list.size());

        for (int i =0;i<20;i++){
            List<String> list2 = null;
            if (i!=19){
                list2 = list.subList(i*5,(i+1)*5);
            }else {
                list2 = list.subList(i*5,95);
            }
            String str = "select * from outbound_bill where   outbound_bill_status not in (1,2) and   cancel_status = 0 and istatus = 1 and return_bill_no in ( ";
            for (String id : list2){
                str += "'"+id+"',";
            }
            str += ";";
            str = str.replace(",;",");");
            System.out.println(str);



        }

    }
}