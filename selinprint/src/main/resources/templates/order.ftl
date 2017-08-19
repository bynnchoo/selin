<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title>订货单</title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }
    </style>
</head>
<body>
<!--第一页开始-->
<div class="page" >
	<table class="t1" style="border:1px;cellspacing:0">
		<tbody>
			<tr class="r1">
				<td class="c1" colspan="9">订 货 单</td>
			</tr>
			<tr class="r2">
				<td class="c2" style="border:1px;cellspacing:0">订单编号</td>
				<td class="c2" style="border:1px;cellspacing:0">${order_num}</td>
				<td class="c2" style="border:1px;cellspacing:0">下单日期</td>
				<td class="c2" style="border:1px;cellspacing:0">${create_date}</td>
				<td class="c2" colspan="2" style="border:1px;cellspacing:0">预交货日期</td>
				<td class="c2" colspan="3" style="border:1px;cellspacing:0">${ex_date}</td>
			</tr>
			<tr class="r2">
				<td class="c2" style="border:1px;cellspacing:0">客户名称</td>
				<td class="c2" colspan="3" style="border:1px;cellspacing:0">${cus_name}</td>
				<td class="c2" colspan="2" style="border:1px;cellspacing:0">联系人</td>
				<td class="c2" colspan="3" style="border:1px;cellspacing:0">${receive_name}</td>
			</tr>
			<tr class="r2">
				<td class="c2" style="border:1px;cellspacing:0">收货地址</td>
				<td class="c2" colspan="3" style="border:1px;cellspacing:0">${address}</td>
				<td class="c2" colspan="2" style="border:1px;cellspacing:0">联系电话</td>
				<td class="c2" colspan="3" style="border:1px;cellspacing:0">${tel}</td>
			</tr>
			<tr class="r3">
				<td class="c3" colspan="9" style="border:1px;cellspacing:0">商 品 明 细</td>
			</tr>
			<tr class="r2">
				<td class="c2" style="width:55" style="border:1px;cellspacing:0">序号</td>
				<td class="c2" style="width:135" style="border:1px;cellspacing:0">商品编码</td>
				<td class="c2" style="width:100" style="border:1px;cellspacing:0">商品名称</td>
				<td class="c2" style="width:140" style="border:1px;cellspacing:0">商品规格</td>
				<td class="c2" style="width:45" style="border:1px;cellspacing:0">单价(元)</td>
				<td class="c2" style="width:45" style="border:1px;cellspacing:0">数量</td>
				<td class="c2" style="width:45" style="border:1px;cellspacing:0">计量单位</td>
				<td class="c2" style="width:75"style="border:1px;cellspacing:0">金额小计(元)</td>
				<td class="c2" style="width:65" style="border:1px;cellspacing:0">备注</td>
			</tr>
			
			<#list pros as item>
		        <tr class="r2">
					<td class="c4" style="border:1px;cellspacing:0">${item_index}</td>
					<td class="c2" style="border:1px;cellspacing:0">${item.pro_code}</td>
					<td class="c2" style="border:1px;cellspacing:0">${item.pro_name}</td>
					<td class="c2" style="border:1px;cellspacing:0">${item.pro_norms_name}</td>
					<td class="c4" style="border:1px;cellspacing:0">${item.price}</td>
					<td class="c4" style="border:1px;cellspacing:0">${item.num}</td>
					<td class="c2" style="border:1px;cellspacing:0">${item.unit}</td>
					<td class="c4" style="border:1px;cellspacing:0">${item.amount}</td>
					<td class="c2" style="border:1px;cellspacing:0">${item.remark}</td>
				</tr>
		    </#list>
			<tr class="r2">
				<td class="c5" colspan="5" style="border:1px;cellspacing:0">合计：</td>
				<td class="c2" style="border:1px;cellspacing:0">${numCount}</td>
				<td class="c2" style="border:1px;cellspacing:0">&nbsp;</td>
				<td class="c4" style="border:1px;cellspacing:0">${amount}</td>
				<td class="c2" style="border:1px;cellspacing:0">&nbsp;</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>